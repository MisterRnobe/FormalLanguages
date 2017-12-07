// Generated from Lang.g4 by ANTLR 4.7
package main.language;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NUMBER=12, STRING=13, WHITESPACE=14, ADD=15, SUB=16, 
		MUL=17, DIV=18, MOD=19, FUNC_DEC=20, IF=21, ELSE=22, END=23, WHILE=24, 
		NAME=25;
	public static final int
		RULE_vars = 0, RULE_function = 1, RULE_func_call = 2, RULE_condition = 3, 
		RULE_if_block = 4, RULE_while_block = 5, RULE_expr = 6, RULE_add = 7, 
		RULE_mul = 8, RULE_assignment = 9, RULE_statement = 10, RULE_program = 11;
	public static final String[] ruleNames = {
		"vars", "function", "func_call", "condition", "if_block", "while_block", 
		"expr", "add", "mul", "assignment", "statement", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "')'", "':'", "'return'", "';'", "'=='", "'>'", "'<'", 
		"'&'", "':='", null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'func'", 
		"'if'", "'else'", "'end'", "'while'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"NUMBER", "STRING", "WHITESPACE", "ADD", "SUB", "MUL", "DIV", "MOD", "FUNC_DEC", 
		"IF", "ELSE", "END", "WHILE", "NAME"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class VarsContext extends ParserRuleContext {
		public Token var1;
		public Token NAME;
		public List<Token> var = new ArrayList<Token>();
		public List<TerminalNode> NAME() { return getTokens(LangParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(LangParser.NAME, i);
		}
		public VarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitVars(this);
		}
	}

	public final VarsContext vars() throws RecognitionException {
		VarsContext _localctx = new VarsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_vars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(24);
				((VarsContext)_localctx).var1 = match(NAME);
				}
			}

			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(27);
				match(T__0);
				setState(28);
				((VarsContext)_localctx).NAME = match(NAME);
				((VarsContext)_localctx).var.add(((VarsContext)_localctx).NAME);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public VarsContext v;
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public ExprContext ret;
		public TerminalNode FUNC_DEC() { return getToken(LangParser.FUNC_DEC, 0); }
		public VarsContext vars() {
			return getRuleContext(VarsContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(FUNC_DEC);
			{
			setState(35);
			((FunctionContext)_localctx).name = match(NAME);
			}
			setState(36);
			match(T__1);
			setState(37);
			((FunctionContext)_localctx).v = vars();
			setState(38);
			match(T__2);
			setState(39);
			match(T__3);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IF) | (1L << WHILE) | (1L << NAME))) != 0)) {
				{
				{
				setState(40);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).st.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(T__4);
			{
			setState(47);
			((FunctionContext)_localctx).ret = expr();
			}
			setState(48);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public Token n;
		public ExprContext e1;
		public ExprContext expr;
		public List<ExprContext> exs = new ArrayList<ExprContext>();
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitFunc_call(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_func_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			((Func_callContext)_localctx).n = match(NAME);
			setState(51);
			match(T__1);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__9) | (1L << NUMBER) | (1L << STRING) | (1L << SUB) | (1L << MUL) | (1L << NAME))) != 0)) {
				{
				setState(52);
				((Func_callContext)_localctx).e1 = expr();
				}
			}

			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(55);
				match(T__0);
				setState(56);
				((Func_callContext)_localctx).expr = expr();
				((Func_callContext)_localctx).exs.add(((Func_callContext)_localctx).expr);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ExprContext left;
		public Token t;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(T__1);
			setState(65);
			((ConditionContext)_localctx).left = expr();
			{
			setState(66);
			((ConditionContext)_localctx).t = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
				((ConditionContext)_localctx).t = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			setState(67);
			((ConditionContext)_localctx).right = expr();
			setState(68);
			match(T__2);
			setState(69);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_blockContext extends ParserRuleContext {
		public ConditionContext cond;
		public StatementContext statement;
		public List<StatementContext> if_st = new ArrayList<StatementContext>();
		public List<StatementContext> else_st = new ArrayList<StatementContext>();
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public List<TerminalNode> END() { return getTokens(LangParser.END); }
		public TerminalNode END(int i) {
			return getToken(LangParser.END, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(LangParser.ELSE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public If_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterIf_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitIf_block(this);
		}
	}

	public final If_blockContext if_block() throws RecognitionException {
		If_blockContext _localctx = new If_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_if_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(IF);
			{
			setState(72);
			((If_blockContext)_localctx).cond = condition();
			}
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(73);
				((If_blockContext)_localctx).statement = statement();
				((If_blockContext)_localctx).if_st.add(((If_blockContext)_localctx).statement);
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IF) | (1L << WHILE) | (1L << NAME))) != 0) );
			setState(78);
			match(END);
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(79);
				match(T__5);
				setState(80);
				match(ELSE);
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(81);
					((If_blockContext)_localctx).statement = statement();
					((If_blockContext)_localctx).else_st.add(((If_blockContext)_localctx).statement);
					}
					}
					setState(84); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IF) | (1L << WHILE) | (1L << NAME))) != 0) );
				setState(86);
				match(END);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_blockContext extends ParserRuleContext {
		public ConditionContext cond;
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public TerminalNode WHILE() { return getToken(LangParser.WHILE, 0); }
		public TerminalNode END() { return getToken(LangParser.END, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public While_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterWhile_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitWhile_block(this);
		}
	}

	public final While_blockContext while_block() throws RecognitionException {
		While_blockContext _localctx = new While_blockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_while_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(WHILE);
			{
			setState(91);
			((While_blockContext)_localctx).cond = condition();
			}
			setState(93); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(92);
				((While_blockContext)_localctx).statement = statement();
				((While_blockContext)_localctx).st.add(((While_blockContext)_localctx).statement);
				}
				}
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IF) | (1L << WHILE) | (1L << NAME))) != 0) );
			setState(97);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AddContext left;
		public Token s15;
		public List<Token> op = new ArrayList<Token>();
		public Token s16;
		public Token _tset247;
		public AddContext add;
		public List<AddContext> right = new ArrayList<AddContext>();
		public List<AddContext> add() {
			return getRuleContexts(AddContext.class);
		}
		public AddContext add(int i) {
			return getRuleContext(AddContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((ExprContext)_localctx).left = add();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(100);
				((ExprContext)_localctx)._tset247 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx)._tset247 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ExprContext)_localctx).op.add(((ExprContext)_localctx)._tset247);
				setState(101);
				((ExprContext)_localctx).add = add();
				((ExprContext)_localctx).right.add(((ExprContext)_localctx).add);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddContext extends ParserRuleContext {
		public MulContext left;
		public Token MUL;
		public List<Token> op = new ArrayList<Token>();
		public Token DIV;
		public Token MOD;
		public Token _tset269;
		public MulContext mul;
		public List<MulContext> right = new ArrayList<MulContext>();
		public List<MulContext> mul() {
			return getRuleContexts(MulContext.class);
		}
		public MulContext mul(int i) {
			return getRuleContext(MulContext.class,i);
		}
		public List<TerminalNode> MUL() { return getTokens(LangParser.MUL); }
		public TerminalNode MUL(int i) {
			return getToken(LangParser.MUL, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LangParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(LangParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(LangParser.MOD, i);
		}
		public AddContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_add; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAdd(this);
		}
	}

	public final AddContext add() throws RecognitionException {
		AddContext _localctx = new AddContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(107);
			((AddContext)_localctx).left = mul();
			}
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) {
				{
				{
				setState(108);
				((AddContext)_localctx)._tset269 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					((AddContext)_localctx)._tset269 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AddContext)_localctx).op.add(((AddContext)_localctx)._tset269);
				setState(109);
				((AddContext)_localctx).mul = mul();
				((AddContext)_localctx).right.add(((AddContext)_localctx).mul);
				}
				}
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulContext extends ParserRuleContext {
		public Token op;
		public Func_callContext fun;
		public Token pointer;
		public Token var;
		public Token lit;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(LangParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public MulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mul; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitMul(this);
		}
	}

	public final MulContext mul() throws RecognitionException {
		MulContext _localctx = new MulContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB || _la==MUL) {
				{
				setState(115);
				((MulContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==SUB || _la==MUL) ) {
					((MulContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(118);
				match(T__1);
				setState(119);
				expr();
				setState(120);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(122);
				((MulContext)_localctx).fun = func_call();
				}
				break;
			case 3:
				{
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__9) {
					{
					setState(123);
					((MulContext)_localctx).pointer = match(T__9);
					}
				}

				setState(126);
				((MulContext)_localctx).var = match(NAME);
				}
				break;
			case 4:
				{
				setState(127);
				((MulContext)_localctx).lit = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==STRING) ) {
					((MulContext)_localctx).lit = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public Token var;
		public Token p;
		public ExprContext e;
		public Token op;
		public ExprContext ex;
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(130);
				((AssignmentContext)_localctx).var = match(NAME);
				}
				break;
			case MUL:
				{
				setState(131);
				((AssignmentContext)_localctx).p = match(MUL);
				setState(132);
				((AssignmentContext)_localctx).e = expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(135);
			((AssignmentContext)_localctx).op = match(T__10);
			{
			setState(136);
			((AssignmentContext)_localctx).ex = expr();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assign;
		public Func_callContext func;
		public If_blockContext ifbl;
		public While_blockContext whbl;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public If_blockContext if_block() {
			return getRuleContext(If_blockContext.class,0);
		}
		public While_blockContext while_block() {
			return getRuleContext(While_blockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(138);
				((StatementContext)_localctx).assign = assignment();
				}
				break;
			case 2:
				{
				setState(139);
				((StatementContext)_localctx).func = func_call();
				}
				break;
			case 3:
				{
				setState(140);
				((StatementContext)_localctx).ifbl = if_block();
				}
				break;
			case 4:
				{
				setState(141);
				((StatementContext)_localctx).whbl = while_block();
				}
				break;
			}
			setState(144);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public FunctionContext function;
		public List<FunctionContext> f = new ArrayList<FunctionContext>();
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LangListener ) ((LangListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_DEC) {
				{
				{
				setState(146);
				((ProgramContext)_localctx).function = function();
				((ProgramContext)_localctx).f.add(((ProgramContext)_localctx).function);
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(152);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).st.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(155); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << IF) | (1L << WHILE) | (1L << NAME))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\5\2\34\n\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3,\n\3\f\3\16\3/\13\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\5\48\n\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\6\6M\n\6\r\6\16\6N\3\6\3\6\3\6\3\6\6\6U\n"+
		"\6\r\6\16\6V\3\6\3\6\5\6[\n\6\3\7\3\7\3\7\6\7`\n\7\r\7\16\7a\3\7\3\7\3"+
		"\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\t\3\t\3\t\7\tq\n\t\f\t\16\tt\13\t"+
		"\3\n\5\nw\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\177\n\n\3\n\3\n\5\n\u0083\n"+
		"\n\3\13\3\13\3\13\5\13\u0088\n\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0091"+
		"\n\f\3\f\3\f\3\r\7\r\u0096\n\r\f\r\16\r\u0099\13\r\3\r\6\r\u009c\n\r\r"+
		"\r\16\r\u009d\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\7\3\2\t\13\3"+
		"\2\21\22\3\2\23\25\3\2\22\23\3\2\16\17\2\u00a9\2\33\3\2\2\2\4$\3\2\2\2"+
		"\6\64\3\2\2\2\bB\3\2\2\2\nI\3\2\2\2\f\\\3\2\2\2\16e\3\2\2\2\20m\3\2\2"+
		"\2\22v\3\2\2\2\24\u0087\3\2\2\2\26\u0090\3\2\2\2\30\u0097\3\2\2\2\32\34"+
		"\7\33\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35\36\7\3\2\2\36 \7"+
		"\33\2\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3"+
		"\2\2\2$%\7\26\2\2%&\7\33\2\2&\'\7\4\2\2\'(\5\2\2\2()\7\5\2\2)-\7\6\2\2"+
		"*,\5\26\f\2+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2"+
		"\2\2\60\61\7\7\2\2\61\62\5\16\b\2\62\63\7\b\2\2\63\5\3\2\2\2\64\65\7\33"+
		"\2\2\65\67\7\4\2\2\668\5\16\b\2\67\66\3\2\2\2\678\3\2\2\28=\3\2\2\29:"+
		"\7\3\2\2:<\5\16\b\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2"+
		"?=\3\2\2\2@A\7\5\2\2A\7\3\2\2\2BC\7\4\2\2CD\5\16\b\2DE\t\2\2\2EF\5\16"+
		"\b\2FG\7\5\2\2GH\7\6\2\2H\t\3\2\2\2IJ\7\27\2\2JL\5\b\5\2KM\5\26\f\2LK"+
		"\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2\2\2PZ\7\31\2\2QR\7\b\2\2"+
		"RT\7\30\2\2SU\5\26\f\2TS\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2\2\2WX\3\2\2"+
		"\2XY\7\31\2\2Y[\3\2\2\2ZQ\3\2\2\2Z[\3\2\2\2[\13\3\2\2\2\\]\7\32\2\2]_"+
		"\5\b\5\2^`\5\26\f\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2"+
		"cd\7\31\2\2d\r\3\2\2\2ej\5\20\t\2fg\t\3\2\2gi\5\20\t\2hf\3\2\2\2il\3\2"+
		"\2\2jh\3\2\2\2jk\3\2\2\2k\17\3\2\2\2lj\3\2\2\2mr\5\22\n\2no\t\4\2\2oq"+
		"\5\22\n\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2s\21\3\2\2\2tr\3\2\2"+
		"\2uw\t\5\2\2vu\3\2\2\2vw\3\2\2\2w\u0082\3\2\2\2xy\7\4\2\2yz\5\16\b\2z"+
		"{\7\5\2\2{\u0083\3\2\2\2|\u0083\5\6\4\2}\177\7\f\2\2~}\3\2\2\2~\177\3"+
		"\2\2\2\177\u0080\3\2\2\2\u0080\u0083\7\33\2\2\u0081\u0083\t\6\2\2\u0082"+
		"x\3\2\2\2\u0082|\3\2\2\2\u0082~\3\2\2\2\u0082\u0081\3\2\2\2\u0083\23\3"+
		"\2\2\2\u0084\u0088\7\33\2\2\u0085\u0086\7\23\2\2\u0086\u0088\5\16\b\2"+
		"\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a"+
		"\7\r\2\2\u008a\u008b\5\16\b\2\u008b\25\3\2\2\2\u008c\u0091\5\24\13\2\u008d"+
		"\u0091\5\6\4\2\u008e\u0091\5\n\6\2\u008f\u0091\5\f\7\2\u0090\u008c\3\2"+
		"\2\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\7\b\2\2\u0093\27\3\2\2\2\u0094\u0096\5\4\3"+
		"\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009c\5\26\f\2"+
		"\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e"+
		"\3\2\2\2\u009e\31\3\2\2\2\24\33!-\67=NVZajrv~\u0082\u0087\u0090\u0097"+
		"\u009d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}