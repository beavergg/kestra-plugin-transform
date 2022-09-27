package io.kestra.plugin.hackathon.rule;

import io.kestra.plugin.hackathon.model.AdaptContext;
import io.kestra.plugin.hackathon.model.BeanFactory;
import io.kestra.plugin.hackathon.model.Getter;
import io.kestra.plugin.hackathon.model.RowMap;
import io.kestra.plugin.hackathon.rule.engine.HackathonBaseListener;
import io.kestra.plugin.hackathon.rule.engine.HackathonLexer;
import io.kestra.plugin.hackathon.rule.engine.HackathonParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.slf4j.Logger;
import software.amazon.ion.IonReader;

import java.util.Deque;
import java.util.LinkedList;

public class HackathonRuleResolve extends HackathonBaseListener {
    private final Logger logger;
    private final String ruleText;
    private final Deque<Object> stack = new LinkedList<>();

    public HackathonRuleResolve(Logger logger, String ruleText) {
        this.logger = logger;
        this.ruleText = ruleText;
    }

    public void dryRun() {
        CharStream inputStream = CharStreams.fromString(ruleText);
        HackathonLexer cookieLexer = new HackathonLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(cookieLexer);
        HackathonParser parser = new HackathonParser(commonTokenStream);
        ParseTreeWalker.DEFAULT.walk(this, parser.file());
    }

    public void resolveIonFile(IonReader reader) {
        stack.clear();

    }

    @Override
    public void enterFile(HackathonParser.FileContext ctx) {
        logger.info("enter file " + ctx.getText());
    }

    @Override
    public void exitFile(HackathonParser.FileContext ctx) {
        logger.info("exit file " + ctx.getText());
    }

    @Override
    public void enterRule(HackathonParser.RuleContext ctx) {
        logger.info("enter rule " + ctx.getText());
    }

    @Override
    public void exitRule(HackathonParser.RuleContext ctx) {
        logger.info("exit rule " + ctx.getText());
    }

    @Override
    public void enterTypeMap(HackathonParser.TypeMapContext ctx) {
        logger.info("enter map " + ctx.getText());
    }

    @Override
    public void exitTypeMap(HackathonParser.TypeMapContext ctx) {
        logger.info("exit map " + ctx.getText());
    }

    @Override
    public void enterTypeFilter(HackathonParser.TypeFilterContext ctx) {
        logger.info("enter filter rule " + ctx.getText());
    }

    @Override
    public void exitTypeFilter(HackathonParser.TypeFilterContext ctx) {
        logger.info("exit filter rule " + ctx.getText());
    }

    @Override
    public void exitExpr(HackathonParser.ExprContext ctx) {
        // Skip comments
        if (ctx.COMMENTS() != null) return;
        else if (ctx.INT() != null) {
            int value = Integer.parseInt(ctx.INT().getText());
            stack.push(value);
        } else if (ctx.DOUBLE() != null) {
            double value = Double.parseDouble(ctx.DOUBLE().getText());
            stack.push(value);
        } else if (ctx.STRING() != null) {
            stack.push(ctx.STRING().getText());
        }
    }

    @Override
    public void exitPut(HackathonParser.PutContext ctx) {
        Object value = stack.pop();
        Object field = stack.pop();
        AdaptContext context = BeanFactory.getAdaptContext(logger, ctx);
        Getter valueGetter = BeanFactory.convertToGetter(context, value);
        Getter fieldGetter = BeanFactory.convertToGetter(context, field);
        RowMap putMap = BeanFactory.getPutRowMap(context, fieldGetter, valueGetter);
        stack.push(putMap);
    }

    @Override
    public void exitRemove(HackathonParser.RemoveContext ctx) {
        Object value = stack.pop();
        AdaptContext context = BeanFactory.getAdaptContext(logger, ctx);
        Getter fieldGetter = BeanFactory.convertToGetter(context, value);
        RowMap removeMap = BeanFactory.getRemoveRowMap(context, fieldGetter);
        stack.push(removeMap);
    }

    @Override
    public void exitRename(HackathonParser.RenameContext ctx) {
        Object oldField = stack.pop();
        Object newField = stack.pop();
        AdaptContext context = BeanFactory.getAdaptContext(logger, ctx);
        Getter oldFieldGetter = BeanFactory.convertToGetter(context, oldField);
        Getter newFieldGetter = BeanFactory.convertToGetter(context, newField);
        RowMap removeMap = BeanFactory.getRenameMap(context, oldFieldGetter, newFieldGetter);
        stack.push(removeMap);
    }

    @Override
    public void exitGetfield(HackathonParser.GetfieldContext ctx) {
        Object field = stack.pop();
        AdaptContext context = BeanFactory.getAdaptContext(logger, ctx);
        Getter getter = BeanFactory.convertToGetter(context, field);
        Getter fieldGetter = BeanFactory.getFieldGetter(context, getter);
        stack.push(fieldGetter);
    }

    @Override
    public void exitConcat(HackathonParser.ConcatContext ctx) {
//        String str2 = popString();
//        String str1 = popString();
//        String result = Strings.nullToEmpty(str1) + Strings.nullToEmpty(str2);
//        stack.push(result);
//        logger.info("Concat: " + str1 + " + " + str2);
    }

    @Override
    public void exitIndex(HackathonParser.IndexContext ctx) {
        logger.info("exit index " + ctx.getText());
    }

    @Override
    public void exitLen(HackathonParser.LenContext ctx) {
        logger.info("exit len " + ctx.getText());
    }

    @Override
    public void exitLastindexof(HackathonParser.LastindexofContext ctx) {
        logger.info("exit last Indexof " + ctx.getText());
    }

    @Override
    public void enterSubstring(HackathonParser.SubstringContext ctx) {
        logger.info("enter substring " + ctx.getText());
    }

    @Override
    public void exitSubstring(HackathonParser.SubstringContext ctx) {
        logger.info("exit substring " + ctx.getText());
    }

    @Override
    public void exitDoubeparse(HackathonParser.DoubeparseContext ctx) {
        logger.info("exit doubleparse " + ctx.getText());
    }

    @Override
    public void exitDateformat(HackathonParser.DateformatContext ctx) {
        logger.info("exit date format " + ctx.getText());
    }

    @Override
    public void exitLookup(HackathonParser.LookupContext ctx) {
        logger.info("exit lookup " + ctx.getText());
    }

    @Override
    public void exitFilter(HackathonParser.FilterContext ctx) {
        logger.info("exit filter " + ctx.getText());
    }

    @Override
    public void exitIf(HackathonParser.IfContext ctx) {
        logger.info("exit if " + ctx.getText());
    }

    @Override
    public void exitPredicate(HackathonParser.PredicateContext ctx) {
        logger.info("exit predicate " + ctx.getText());
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        logger.info("visit error node " + node.getText());
    }

}
