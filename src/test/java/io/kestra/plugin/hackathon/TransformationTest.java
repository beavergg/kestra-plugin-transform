package io.kestra.plugin.hackathon;

import com.google.common.collect.ImmutableMap;
import io.kestra.core.runners.RunContext;
import io.kestra.core.runners.RunContextFactory;
import io.kestra.core.storages.StorageInterface;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@MicronautTest
class TransformationTest {
    @Inject
    private RunContextFactory runContextFactory;
    @Inject
    StorageInterface storageInterface;

    @Test
    void run() throws Exception {
        RunContext runContext = runContextFactory.of(ImmutableMap.of("variable", "John Doe"));
        URI uri = storageInterface.put(URI.create("/basic.ion"), new FileInputStream("src/test/resources/testdata/basic.ion"));
        Transformation task = Transformation.builder()
                .from(uri.toString())
                .build();

        Transformation.Output runOutput = task.run(runContext);

        assertThat(runOutput.getUri(), is(uri.toString()));
    }
}