package io.kestra.plugin.hackathon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;

@Getter
@AllArgsConstructor
public class AdaptContext {
    private Logger logger;
    private ParserRuleContext context;
}
