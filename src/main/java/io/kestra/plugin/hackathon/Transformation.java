package io.kestra.plugin.hackathon;

import com.google.common.base.Stopwatch;
import io.kestra.core.models.annotations.Example;
import io.kestra.core.models.annotations.Plugin;
import io.kestra.core.models.annotations.PluginProperty;
import io.kestra.core.models.executions.metrics.Timer;
import io.kestra.core.models.tasks.RunnableTask;
import io.kestra.core.models.tasks.Task;
import io.kestra.core.runners.RunContext;
import io.kestra.plugin.hackathon.model.DynamicTable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.slf4j.Logger;
import software.amazon.ion.IonReader;
import software.amazon.ion.IonType;
import software.amazon.ion.system.IonReaderBuilder;

import java.io.InputStream;
import java.net.URI;

@SuperBuilder
@ToString
@EqualsAndHashCode
@Getter
@NoArgsConstructor
@Plugin(
        examples = @Example(
                full = true,
                title = "Hackathon transformation",
                code = {
                        "  - id: transformFile",
                        "    type: io.kestra.plugin.hackathon.Transformation",
                        "    from: {{ outputs.csvReader.uri }}"
                }
        )
)
public class Transformation extends Task implements RunnableTask<Transformation.Output> {
    @PluginProperty(dynamic = true)
    private String from;

    @Override
    public Output run(RunContext runContext) throws Exception {
        Stopwatch sw = Stopwatch.createStarted();
        Logger logger = runContext.logger();
        String inputFile = runContext.render(this.from);
        final URI from = new URI(inputFile);
        final InputStream inputStream = runContext.uriToInputStream(from);
        IonReaderBuilder readerBuilder = IonReaderBuilder.standard();
        try (IonReader reader = readerBuilder.build(inputStream)) {
            IonType type = reader.next();
            DynamicTable table = new DynamicTable(logger);
            while (type != null) {
                table.appendRow();
                reader.stepIn();
                IonType fieldType = reader.next();
                while (fieldType != null) {
                    fieldType = reader.next();
                    table.appendCell(reader.getFieldName(), getValue(fieldType, reader));
                }
                reader.stepOut();
                type = reader.next();
            }
        }
        publishMetric(sw);
        return Output.builder().uri(inputFile).build();
    }

    private Object getValue(IonType fieldType, IonReader reader) {
        if (fieldType == IonType.STRING) return reader.stringValue();
        if (fieldType == IonType.INT) return reader.intValue();
        // TODO: support more ion type.
        return null;
    }

    private void publishMetric(Stopwatch sw) {
        Timer.of("total.elapsed", sw.elapsed(), "tag1", "value1");
    }

    @Builder
    @Getter
    public static class Output implements io.kestra.core.models.tasks.Output {
        @Schema(
                title = "ion file",
                description = "Transformed file with ion format"
        )
        private final String uri;
    }
}
