// Generated from java-escape by ANTLR 4.11.1

    package io.kestra.plugin.hackathon.rule.engine;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HackathonParser}.
 */
public interface HackathonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HackathonParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(HackathonParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(HackathonParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(HackathonParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(HackathonParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#typeMap}.
	 * @param ctx the parse tree
	 */
	void enterTypeMap(HackathonParser.TypeMapContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#typeMap}.
	 * @param ctx the parse tree
	 */
	void exitTypeMap(HackathonParser.TypeMapContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#typeFilter}.
	 * @param ctx the parse tree
	 */
	void enterTypeFilter(HackathonParser.TypeFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#typeFilter}.
	 * @param ctx the parse tree
	 */
	void exitTypeFilter(HackathonParser.TypeFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(HackathonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(HackathonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(HackathonParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(HackathonParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#put}.
	 * @param ctx the parse tree
	 */
	void enterPut(HackathonParser.PutContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#put}.
	 * @param ctx the parse tree
	 */
	void exitPut(HackathonParser.PutContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#remove}.
	 * @param ctx the parse tree
	 */
	void enterRemove(HackathonParser.RemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#remove}.
	 * @param ctx the parse tree
	 */
	void exitRemove(HackathonParser.RemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#rename}.
	 * @param ctx the parse tree
	 */
	void enterRename(HackathonParser.RenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#rename}.
	 * @param ctx the parse tree
	 */
	void exitRename(HackathonParser.RenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#getfield}.
	 * @param ctx the parse tree
	 */
	void enterGetfield(HackathonParser.GetfieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#getfield}.
	 * @param ctx the parse tree
	 */
	void exitGetfield(HackathonParser.GetfieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#concat}.
	 * @param ctx the parse tree
	 */
	void enterConcat(HackathonParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#concat}.
	 * @param ctx the parse tree
	 */
	void exitConcat(HackathonParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#index}.
	 * @param ctx the parse tree
	 */
	void enterIndex(HackathonParser.IndexContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#index}.
	 * @param ctx the parse tree
	 */
	void exitIndex(HackathonParser.IndexContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#len}.
	 * @param ctx the parse tree
	 */
	void enterLen(HackathonParser.LenContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#len}.
	 * @param ctx the parse tree
	 */
	void exitLen(HackathonParser.LenContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#lastindexof}.
	 * @param ctx the parse tree
	 */
	void enterLastindexof(HackathonParser.LastindexofContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#lastindexof}.
	 * @param ctx the parse tree
	 */
	void exitLastindexof(HackathonParser.LastindexofContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#substring}.
	 * @param ctx the parse tree
	 */
	void enterSubstring(HackathonParser.SubstringContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#substring}.
	 * @param ctx the parse tree
	 */
	void exitSubstring(HackathonParser.SubstringContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#doubeparse}.
	 * @param ctx the parse tree
	 */
	void enterDoubeparse(HackathonParser.DoubeparseContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#doubeparse}.
	 * @param ctx the parse tree
	 */
	void exitDoubeparse(HackathonParser.DoubeparseContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#dateformat}.
	 * @param ctx the parse tree
	 */
	void enterDateformat(HackathonParser.DateformatContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#dateformat}.
	 * @param ctx the parse tree
	 */
	void exitDateformat(HackathonParser.DateformatContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#lookup}.
	 * @param ctx the parse tree
	 */
	void enterLookup(HackathonParser.LookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#lookup}.
	 * @param ctx the parse tree
	 */
	void exitLookup(HackathonParser.LookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#noop}.
	 * @param ctx the parse tree
	 */
	void enterNoop(HackathonParser.NoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#noop}.
	 * @param ctx the parse tree
	 */
	void exitNoop(HackathonParser.NoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(HackathonParser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(HackathonParser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(HackathonParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(HackathonParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(HackathonParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(HackathonParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link HackathonParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(HackathonParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HackathonParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(HackathonParser.OperatorContext ctx);
}