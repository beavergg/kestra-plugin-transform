package io.kestra.plugin.hackathon.rule;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeoutException;

@MicronautTest
class HackathonRuleResolveTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test() throws TimeoutException {
        Logger logger = LoggerFactory.getLogger("unittest");
        String ruleText = "put(f(\"field1\"), \"value1\");\n\n"
                + "put(\"field2\", concat(f(\"field1\"), \"_postfix\"));\n"
                + "remove(\"field3\");\n"
                + "rename(\"field1\", subString(f(\"field1\"), 0, 4));\n"
                + "put(f(\"field5\"), dateFormat(f(\"field2\"), \"MM/dd/uuuu\", \"uuuu-MM-dd\"));";
        HackathonRuleResolve resolve = new HackathonRuleResolve(logger, ruleText);
        resolve.dryRun();
    }
}