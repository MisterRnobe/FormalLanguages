// Generated from Lang.g4 by ANTLR 4.7
package main.language;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
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
}