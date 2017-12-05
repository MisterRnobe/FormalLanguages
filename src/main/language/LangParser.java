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
		T__9=10, NUMBER=11, WHITESPACE=12, ADD=13, SUB=14, MUL=15, DIV=16, FUNC_DEC=17, 
		IF=18, END=19, NAME=20;
	public static final int
		RULE_vars = 0, RULE_function = 1, RULE_func_call = 2, RULE_if_block = 3, 
		RULE_expr = 4, RULE_add = 5, RULE_mul = 6, RULE_assignment = 7, RULE_statement = 8, 
		RULE_program = 9;
	public static final String[] ruleNames = {
		"vars", "function", "func_call", "if_block", "expr", "add", "mul", "assignment", 
		"statement", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "'):'", "'return'", "';'", "')'", "'=='", "'>'", "'<'", 
		"':='", null, null, "'+'", "'-'", "'*'", "'/'", "'func'", "'if'", "'end'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "NUMBER", 
		"WHITESPACE", "ADD", "SUB", "MUL", "DIV", "FUNC_DEC", "IF", "END", "NAME"
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
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(20);
				((VarsContext)_localctx).var1 = match(NAME);
				}
			}

			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(23);
				match(T__0);
				setState(24);
				((VarsContext)_localctx).NAME = match(NAME);
				((VarsContext)_localctx).var.add(((VarsContext)_localctx).NAME);
				}
				}
				setState(29);
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
			setState(30);
			match(FUNC_DEC);
			{
			setState(31);
			((FunctionContext)_localctx).name = match(NAME);
			}
			setState(32);
			match(T__1);
			setState(33);
			((FunctionContext)_localctx).v = vars();
			setState(34);
			match(T__2);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF || _la==NAME) {
				{
				{
				setState(35);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).st.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(T__3);
			{
			setState(42);
			((FunctionContext)_localctx).ret = expr();
			}
			setState(43);
			match(T__4);
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
			setState(45);
			((Func_callContext)_localctx).n = match(NAME);
			setState(46);
			match(T__1);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << NUMBER) | (1L << SUB) | (1L << NAME))) != 0)) {
				{
				setState(47);
				((Func_callContext)_localctx).e1 = expr();
				}
			}

			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(50);
				match(T__0);
				setState(51);
				((Func_callContext)_localctx).expr = expr();
				((Func_callContext)_localctx).exs.add(((Func_callContext)_localctx).expr);
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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

	public static class If_blockContext extends ParserRuleContext {
		public Token var;
		public Token eq;
		public Token more;
		public Token less;
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END() { return getToken(LangParser.END, 0); }
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
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
		enterRule(_localctx, 6, RULE_if_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IF);
			setState(60);
			match(T__1);
			setState(61);
			((If_blockContext)_localctx).var = match(NAME);
			setState(65);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(62);
				((If_blockContext)_localctx).eq = match(T__6);
				}
				break;
			case T__7:
				{
				setState(63);
				((If_blockContext)_localctx).more = match(T__7);
				}
				break;
			case T__8:
				{
				setState(64);
				((If_blockContext)_localctx).less = match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(67);
			expr();
			setState(68);
			match(T__5);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF || _la==NAME) {
				{
				{
				setState(69);
				((If_blockContext)_localctx).statement = statement();
				((If_blockContext)_localctx).st.add(((If_blockContext)_localctx).statement);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(END);
			setState(76);
			match(T__4);
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
		public Token s13;
		public List<Token> op = new ArrayList<Token>();
		public Token s14;
		public Token _tset177;
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
		enterRule(_localctx, 8, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			((ExprContext)_localctx).left = add();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(79);
				((ExprContext)_localctx)._tset177 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx)._tset177 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ExprContext)_localctx).op.add(((ExprContext)_localctx)._tset177);
				setState(80);
				((ExprContext)_localctx).add = add();
				((ExprContext)_localctx).right.add(((ExprContext)_localctx).add);
				}
				}
				setState(85);
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
		public Token s15;
		public List<Token> op = new ArrayList<Token>();
		public Token s16;
		public Token _tset197;
		public MulContext mul;
		public List<MulContext> right = new ArrayList<MulContext>();
		public List<MulContext> mul() {
			return getRuleContexts(MulContext.class);
		}
		public MulContext mul(int i) {
			return getRuleContext(MulContext.class,i);
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
		enterRule(_localctx, 10, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			((AddContext)_localctx).left = mul();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(87);
				((AddContext)_localctx)._tset197 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((AddContext)_localctx)._tset197 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AddContext)_localctx).op.add(((AddContext)_localctx)._tset197);
				setState(88);
				((AddContext)_localctx).mul = mul();
				((AddContext)_localctx).right.add(((AddContext)_localctx).mul);
				}
				}
				setState(93);
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
		public Token neg;
		public Token num;
		public Func_callContext fun;
		public Token var;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
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
		enterRule(_localctx, 12, RULE_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(94);
				((MulContext)_localctx).neg = match(SUB);
				}
			}

			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(97);
				((MulContext)_localctx).num = match(NUMBER);
				}
				break;
			case 2:
				{
				setState(98);
				match(T__1);
				setState(99);
				expr();
				setState(100);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(102);
				((MulContext)_localctx).fun = func_call();
				}
				break;
			case 4:
				{
				setState(103);
				((MulContext)_localctx).var = match(NAME);
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
		public Token op;
		public ExprContext ex;
		public TerminalNode NAME() { return getToken(LangParser.NAME, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 14, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(106);
			((AssignmentContext)_localctx).var = match(NAME);
			}
			setState(107);
			((AssignmentContext)_localctx).op = match(T__9);
			{
			setState(108);
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
		public If_blockContext if;
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public If_blockContext if_block() {
			return getRuleContext(If_blockContext.class,0);
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
		enterRule(_localctx, 16, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(110);
				((StatementContext)_localctx).assign = assignment();
				}
				break;
			case 2:
				{
				setState(111);
				((StatementContext)_localctx).func = func_call();
				}
				break;
			case 3:
				{
				setState(112);
				((StatementContext)_localctx).if = if_block();
				}
				break;
			}
			setState(115);
			match(T__4);
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
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
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
		enterRule(_localctx, 18, RULE_program);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNC_DEC:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(117);
				((ProgramContext)_localctx).function = function();
				((ProgramContext)_localctx).f.add(((ProgramContext)_localctx).function);
				}
				}
				break;
			case IF:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					((ProgramContext)_localctx).statement = statement();
					((ProgramContext)_localctx).st.add(((ProgramContext)_localctx).statement);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IF || _la==NAME );
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u0080\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\5\2\30\n\2\3\2\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\63"+
		"\n\4\3\4\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5D\n\5\3\5\3\5\3\5\7\5I\n\5\f\5\16\5L\13\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\7\6T\n\6\f\6\16\6W\13\6\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\5\b"+
		"b\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\5\nt\n\n\3\n\3\n\3\13\3\13\6\13z\n\13\r\13\16\13{\5\13~\n\13\3\13\2\2"+
		"\f\2\4\6\b\n\f\16\20\22\24\2\4\3\2\17\20\3\2\21\22\2\u0087\2\27\3\2\2"+
		"\2\4 \3\2\2\2\6/\3\2\2\2\b=\3\2\2\2\nP\3\2\2\2\fX\3\2\2\2\16a\3\2\2\2"+
		"\20l\3\2\2\2\22s\3\2\2\2\24}\3\2\2\2\26\30\7\26\2\2\27\26\3\2\2\2\27\30"+
		"\3\2\2\2\30\35\3\2\2\2\31\32\7\3\2\2\32\34\7\26\2\2\33\31\3\2\2\2\34\37"+
		"\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 !\7\23"+
		"\2\2!\"\7\26\2\2\"#\7\4\2\2#$\5\2\2\2$(\7\5\2\2%\'\5\22\n\2&%\3\2\2\2"+
		"\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\6\2\2,-\5\n\6"+
		"\2-.\7\7\2\2.\5\3\2\2\2/\60\7\26\2\2\60\62\7\4\2\2\61\63\5\n\6\2\62\61"+
		"\3\2\2\2\62\63\3\2\2\2\638\3\2\2\2\64\65\7\3\2\2\65\67\5\n\6\2\66\64\3"+
		"\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\b\2\2"+
		"<\7\3\2\2\2=>\7\24\2\2>?\7\4\2\2?C\7\26\2\2@D\7\t\2\2AD\7\n\2\2BD\7\13"+
		"\2\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2DE\3\2\2\2EF\5\n\6\2FJ\7\b\2\2GI\5\22"+
		"\n\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2\2\2MN\7\25"+
		"\2\2NO\7\7\2\2O\t\3\2\2\2PU\5\f\7\2QR\t\2\2\2RT\5\f\7\2SQ\3\2\2\2TW\3"+
		"\2\2\2US\3\2\2\2UV\3\2\2\2V\13\3\2\2\2WU\3\2\2\2X]\5\16\b\2YZ\t\3\2\2"+
		"Z\\\5\16\b\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_]\3\2"+
		"\2\2`b\7\20\2\2a`\3\2\2\2ab\3\2\2\2bj\3\2\2\2ck\7\r\2\2de\7\4\2\2ef\5"+
		"\n\6\2fg\7\b\2\2gk\3\2\2\2hk\5\6\4\2ik\7\26\2\2jc\3\2\2\2jd\3\2\2\2jh"+
		"\3\2\2\2ji\3\2\2\2k\17\3\2\2\2lm\7\26\2\2mn\7\f\2\2no\5\n\6\2o\21\3\2"+
		"\2\2pt\5\20\t\2qt\5\6\4\2rt\5\b\5\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2tu\3"+
		"\2\2\2uv\7\7\2\2v\23\3\2\2\2w~\5\4\3\2xz\5\22\n\2yx\3\2\2\2z{\3\2\2\2"+
		"{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}w\3\2\2\2}y\3\2\2\2~\25\3\2\2\2\20\27\35"+
		"(\628CJU]ajs{}";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}