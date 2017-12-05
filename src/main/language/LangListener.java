// Generated from Lang.g4 by ANTLR 4.7
package main.language;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#vars}.
	 * @param ctx the parse tree
	 */
	void enterVars(LangParser.VarsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#vars}.
	 * @param ctx the parse tree
	 */
	void exitVars(LangParser.VarsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#func_call}.
	 * @param ctx the parse tree
	 */
	void enterFunc_call(LangParser.Func_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#func_call}.
	 * @param ctx the parse tree
	 */
	void exitFunc_call(LangParser.Func_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#if_block}.
	 * @param ctx the parse tree
	 */
	void enterIf_block(LangParser.If_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#if_block}.
	 * @param ctx the parse tree
	 */
	void exitIf_block(LangParser.If_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#add}.
	 * @param ctx the parse tree
	 */
	void enterAdd(LangParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#add}.
	 * @param ctx the parse tree
	 */
	void exitAdd(LangParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#mul}.
	 * @param ctx the parse tree
	 */
	void enterMul(LangParser.MulContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#mul}.
	 * @param ctx the parse tree
	 */
	void exitMul(LangParser.MulContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LangParser.ProgramContext ctx);
}