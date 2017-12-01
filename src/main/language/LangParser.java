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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, NUMBER=8, WHITESPACE=9, 
		ADD=10, SUB=11, MUL=12, DIV=13, FUNC_DEC=14, NAME=15;
	public static final int
		RULE_vars = 0, RULE_function = 1, RULE_func_call = 2, RULE_expr = 3, RULE_add = 4, 
		RULE_mul = 5, RULE_assignment = 6, RULE_statement = 7, RULE_program = 8;
	public static final String[] ruleNames = {
		"vars", "function", "func_call", "expr", "add", "mul", "assignment", "statement", 
		"program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'('", "'):'", "'return'", "';'", "')'", "':='", null, null, 
		"'+'", "'-'", "'*'", "'/'", "'func'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "NUMBER", "WHITESPACE", 
		"ADD", "SUB", "MUL", "DIV", "FUNC_DEC", "NAME"
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
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME) {
				{
				setState(18);
				((VarsContext)_localctx).var1 = match(NAME);
				}
			}

			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(21);
				match(T__0);
				setState(22);
				((VarsContext)_localctx).NAME = match(NAME);
				((VarsContext)_localctx).var.add(((VarsContext)_localctx).NAME);
				}
				}
				setState(27);
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
			setState(28);
			match(FUNC_DEC);
			{
			setState(29);
			((FunctionContext)_localctx).name = match(NAME);
			}
			setState(30);
			match(T__1);
			setState(31);
			((FunctionContext)_localctx).v = vars();
			setState(32);
			match(T__2);
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(33);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).st.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			match(T__3);
			{
			setState(40);
			((FunctionContext)_localctx).ret = expr();
			}
			setState(41);
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
			setState(43);
			((Func_callContext)_localctx).n = match(NAME);
			setState(44);
			match(T__1);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << NUMBER) | (1L << SUB) | (1L << NAME))) != 0)) {
				{
				setState(45);
				((Func_callContext)_localctx).e1 = expr();
				}
			}

			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(48);
				match(T__0);
				setState(49);
				((Func_callContext)_localctx).expr = expr();
				((Func_callContext)_localctx).exs.add(((Func_callContext)_localctx).expr);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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

	public static class ExprContext extends ParserRuleContext {
		public AddContext left;
		public Token s10;
		public List<Token> op = new ArrayList<Token>();
		public Token s11;
		public Token _tset133;
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
		enterRule(_localctx, 6, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			((ExprContext)_localctx).left = add();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(58);
				((ExprContext)_localctx)._tset133 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx)._tset133 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ExprContext)_localctx).op.add(((ExprContext)_localctx)._tset133);
				setState(59);
				((ExprContext)_localctx).add = add();
				((ExprContext)_localctx).right.add(((ExprContext)_localctx).add);
				}
				}
				setState(64);
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
		public Token s12;
		public List<Token> op = new ArrayList<Token>();
		public Token s13;
		public Token _tset153;
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
		enterRule(_localctx, 8, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			((AddContext)_localctx).left = mul();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL || _la==DIV) {
				{
				{
				setState(66);
				((AddContext)_localctx)._tset153 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((AddContext)_localctx)._tset153 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AddContext)_localctx).op.add(((AddContext)_localctx)._tset153);
				setState(67);
				((AddContext)_localctx).mul = mul();
				((AddContext)_localctx).right.add(((AddContext)_localctx).mul);
				}
				}
				setState(72);
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
		enterRule(_localctx, 10, RULE_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(73);
				((MulContext)_localctx).neg = match(SUB);
				}
			}

			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(76);
				((MulContext)_localctx).num = match(NUMBER);
				}
				break;
			case 2:
				{
				setState(77);
				match(T__1);
				setState(78);
				expr();
				setState(79);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(81);
				((MulContext)_localctx).fun = func_call();
				}
				break;
			case 4:
				{
				setState(82);
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
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(85);
			((AssignmentContext)_localctx).var = match(NAME);
			}
			setState(86);
			((AssignmentContext)_localctx).op = match(T__6);
			{
			setState(87);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
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
		enterRule(_localctx, 14, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(89);
				((StatementContext)_localctx).assign = assignment();
				}
				break;
			case 2:
				{
				setState(90);
				((StatementContext)_localctx).func = func_call();
				}
				break;
			}
			setState(93);
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
		enterRule(_localctx, 16, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_DEC) {
				{
				{
				setState(95);
				((ProgramContext)_localctx).function = function();
				((ProgramContext)_localctx).f.add(((ProgramContext)_localctx).function);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).st.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21m\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\5\2\26"+
		"\n\2\3\2\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3%"+
		"\n\3\f\3\16\3(\13\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\7\4"+
		"\65\n\4\f\4\16\48\13\4\3\4\3\4\3\5\3\5\3\5\7\5?\n\5\f\5\16\5B\13\5\3\6"+
		"\3\6\3\6\7\6G\n\6\f\6\16\6J\13\6\3\7\5\7M\n\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7V\n\7\3\b\3\b\3\b\3\b\3\t\3\t\5\t^\n\t\3\t\3\t\3\n\7\nc\n\n\f"+
		"\n\16\nf\13\n\3\n\6\ni\n\n\r\n\16\nj\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2"+
		"\4\3\2\f\r\3\2\16\17\2q\2\25\3\2\2\2\4\36\3\2\2\2\6-\3\2\2\2\b;\3\2\2"+
		"\2\nC\3\2\2\2\fL\3\2\2\2\16W\3\2\2\2\20]\3\2\2\2\22d\3\2\2\2\24\26\7\21"+
		"\2\2\25\24\3\2\2\2\25\26\3\2\2\2\26\33\3\2\2\2\27\30\7\3\2\2\30\32\7\21"+
		"\2\2\31\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2"+
		"\2\2\35\33\3\2\2\2\36\37\7\20\2\2\37 \7\21\2\2 !\7\4\2\2!\"\5\2\2\2\""+
		"&\7\5\2\2#%\5\20\t\2$#\3\2\2\2%(\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\')\3\2\2"+
		"\2(&\3\2\2\2)*\7\6\2\2*+\5\b\5\2+,\7\7\2\2,\5\3\2\2\2-.\7\21\2\2.\60\7"+
		"\4\2\2/\61\5\b\5\2\60/\3\2\2\2\60\61\3\2\2\2\61\66\3\2\2\2\62\63\7\3\2"+
		"\2\63\65\5\b\5\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2"+
		"\679\3\2\2\28\66\3\2\2\29:\7\b\2\2:\7\3\2\2\2;@\5\n\6\2<=\t\2\2\2=?\5"+
		"\n\6\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\t\3\2\2\2B@\3\2\2\2CH"+
		"\5\f\7\2DE\t\3\2\2EG\5\f\7\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I"+
		"\13\3\2\2\2JH\3\2\2\2KM\7\r\2\2LK\3\2\2\2LM\3\2\2\2MU\3\2\2\2NV\7\n\2"+
		"\2OP\7\4\2\2PQ\5\b\5\2QR\7\b\2\2RV\3\2\2\2SV\5\6\4\2TV\7\21\2\2UN\3\2"+
		"\2\2UO\3\2\2\2US\3\2\2\2UT\3\2\2\2V\r\3\2\2\2WX\7\21\2\2XY\7\t\2\2YZ\5"+
		"\b\5\2Z\17\3\2\2\2[^\5\16\b\2\\^\5\6\4\2][\3\2\2\2]\\\3\2\2\2^_\3\2\2"+
		"\2_`\7\7\2\2`\21\3\2\2\2ac\5\4\3\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2"+
		"\2\2eh\3\2\2\2fd\3\2\2\2gi\5\20\t\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3"+
		"\2\2\2k\23\3\2\2\2\16\25\33&\60\66@HLU]dj";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}