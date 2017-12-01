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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, WHITESPACE=8, 
		ADD=9, SUB=10, MUL=11, DIV=12, VAR=13, FUNC_DEC=14;
	public static final int
		RULE_function = 0, RULE_expr = 1, RULE_add = 2, RULE_mul = 3, RULE_assignment = 4, 
		RULE_statement = 5, RULE_program = 6;
	public static final String[] ruleNames = {
		"function", "expr", "add", "mul", "assignment", "statement", "program"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "'):'", "'return '", "';'", "':='", "')'", null, null, "'+'", 
		"'-'", "'*'", "'/'", null, "'func'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NUMBER", "WHITESPACE", "ADD", 
		"SUB", "MUL", "DIV", "VAR", "FUNC_DEC"
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
	public static class FunctionContext extends ParserRuleContext {
		public Token name;
		public Token var1;
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public ExprContext ret;
		public TerminalNode FUNC_DEC() { return getToken(LangParser.FUNC_DEC, 0); }
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
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
		enterRule(_localctx, 0, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(FUNC_DEC);
			{
			setState(15);
			((FunctionContext)_localctx).name = match(VAR);
			}
			setState(16);
			match(T__0);
			setState(17);
			((FunctionContext)_localctx).var1 = match(VAR);
			setState(18);
			match(T__1);
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(19);
				((FunctionContext)_localctx).statement = statement();
				((FunctionContext)_localctx).st.add(((FunctionContext)_localctx).statement);
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR );
			setState(24);
			match(T__2);
			{
			setState(25);
			((FunctionContext)_localctx).ret = expr();
			}
			setState(26);
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

	public static class ExprContext extends ParserRuleContext {
		public AddContext left;
		public Token s9;
		public List<Token> op = new ArrayList<Token>();
		public Token s10;
		public Token _tset98;
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
		enterRule(_localctx, 2, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((ExprContext)_localctx).left = add();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD || _la==SUB) {
				{
				{
				setState(29);
				((ExprContext)_localctx)._tset98 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx)._tset98 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ExprContext)_localctx).op.add(((ExprContext)_localctx)._tset98);
				setState(30);
				((ExprContext)_localctx).add = add();
				((ExprContext)_localctx).right.add(((ExprContext)_localctx).add);
				}
				}
				setState(35);
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
		public Token s11;
		public List<Token> op = new ArrayList<Token>();
		public Token s12;
		public Token s5;
		public Token _tset118;
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
		enterRule(_localctx, 4, RULE_add);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((AddContext)_localctx).left = mul();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << MUL) | (1L << DIV))) != 0)) {
				{
				{
				setState(37);
				((AddContext)_localctx)._tset118 = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << MUL) | (1L << DIV))) != 0)) ) {
					((AddContext)_localctx)._tset118 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((AddContext)_localctx).op.add(((AddContext)_localctx)._tset118);
				setState(38);
				((AddContext)_localctx).mul = mul();
				((AddContext)_localctx).right.add(((AddContext)_localctx).mul);
				}
				}
				setState(43);
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
		public Token var;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(LangParser.NUMBER, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
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
		enterRule(_localctx, 6, RULE_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SUB) {
				{
				setState(44);
				((MulContext)_localctx).neg = match(SUB);
				}
			}

			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(47);
				((MulContext)_localctx).num = match(NUMBER);
				}
				break;
			case T__0:
				{
				setState(48);
				match(T__0);
				setState(49);
				expr();
				setState(50);
				match(T__5);
				}
				break;
			case VAR:
				{
				setState(52);
				((MulContext)_localctx).var = match(VAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
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
		enterRule(_localctx, 8, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(55);
			((AssignmentContext)_localctx).var = match(VAR);
			}
			setState(56);
			((AssignmentContext)_localctx).op = match(T__4);
			{
			setState(57);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
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
		enterRule(_localctx, 10, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(59);
			((StatementContext)_localctx).assign = assignment();
			}
			setState(60);
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

	public static class ProgramContext extends ParserRuleContext {
		public FunctionContext function;
		public List<FunctionContext> f = new ArrayList<FunctionContext>();
		public StatementContext statement;
		public List<StatementContext> st = new ArrayList<StatementContext>();
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
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
		enterRule(_localctx, 12, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC_DEC) {
				{
				{
				setState(62);
				((ProgramContext)_localctx).function = function();
				((ProgramContext)_localctx).f.add(((ProgramContext)_localctx).function);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			{
			setState(68);
			((ProgramContext)_localctx).statement = statement();
			((ProgramContext)_localctx).st.add(((ProgramContext)_localctx).statement);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2\6\2"+
		"\27\n\2\r\2\16\2\30\3\2\3\2\3\2\3\2\3\3\3\3\3\3\7\3\"\n\3\f\3\16\3%\13"+
		"\3\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\5\5\60\n\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\7\bB\n\b\f\b\16\bE\13"+
		"\b\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\4\3\2\13\f\4\2\7\7\r\16\2H\2\20"+
		"\3\2\2\2\4\36\3\2\2\2\6&\3\2\2\2\b/\3\2\2\2\n9\3\2\2\2\f=\3\2\2\2\16C"+
		"\3\2\2\2\20\21\7\20\2\2\21\22\7\17\2\2\22\23\7\3\2\2\23\24\7\17\2\2\24"+
		"\26\7\4\2\2\25\27\5\f\7\2\26\25\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30"+
		"\31\3\2\2\2\31\32\3\2\2\2\32\33\7\5\2\2\33\34\5\4\3\2\34\35\7\6\2\2\35"+
		"\3\3\2\2\2\36#\5\6\4\2\37 \t\2\2\2 \"\5\6\4\2!\37\3\2\2\2\"%\3\2\2\2#"+
		"!\3\2\2\2#$\3\2\2\2$\5\3\2\2\2%#\3\2\2\2&+\5\b\5\2\'(\t\3\2\2(*\5\b\5"+
		"\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\7\3\2\2\2-+\3\2\2\2.\60\7"+
		"\f\2\2/.\3\2\2\2/\60\3\2\2\2\60\67\3\2\2\2\618\7\t\2\2\62\63\7\3\2\2\63"+
		"\64\5\4\3\2\64\65\7\b\2\2\658\3\2\2\2\668\7\17\2\2\67\61\3\2\2\2\67\62"+
		"\3\2\2\2\67\66\3\2\2\28\t\3\2\2\29:\7\17\2\2:;\7\7\2\2;<\5\4\3\2<\13\3"+
		"\2\2\2=>\5\n\6\2>?\7\6\2\2?\r\3\2\2\2@B\5\2\2\2A@\3\2\2\2BE\3\2\2\2CA"+
		"\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\5\f\7\2G\17\3\2\2\2\b\30#+/\67"+
		"C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}