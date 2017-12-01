// Generated from Lang.g4 by ANTLR 4.7
package main.language;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NUMBER=7, WHITESPACE=8, 
		ADD=9, SUB=10, MUL=11, DIV=12, VAR=13, FUNC_DEC=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NUMBER", "WHITESPACE", 
		"ADD", "SUB", "MUL", "DIV", "VAR", "FUNC_DEC"
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


	public LangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20d\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\6\b\65\n\b\r\b"+
		"\16\b\66\3\b\3\b\7\b;\n\b\f\b\16\b>\13\b\5\b@\n\b\3\b\3\b\6\bD\n\b\r\b"+
		"\16\bE\5\bH\n\b\3\t\6\tK\n\t\r\t\16\tL\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\7\16[\n\16\f\16\16\16^\13\16\3\17\3\17\3\17\3\17"+
		"\3\17\2\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\3\2\6\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\c|\5\2\62;C\\c|\2"+
		"j\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7$\3\2"+
		"\2\2\t,\3\2\2\2\13.\3\2\2\2\r\61\3\2\2\2\17G\3\2\2\2\21J\3\2\2\2\23P\3"+
		"\2\2\2\25R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35_\3\2\2\2\37"+
		" \7*\2\2 \4\3\2\2\2!\"\7+\2\2\"#\7<\2\2#\6\3\2\2\2$%\7t\2\2%&\7g\2\2&"+
		"\'\7v\2\2\'(\7w\2\2()\7t\2\2)*\7p\2\2*+\7\"\2\2+\b\3\2\2\2,-\7=\2\2-\n"+
		"\3\2\2\2./\7<\2\2/\60\7?\2\2\60\f\3\2\2\2\61\62\7+\2\2\62\16\3\2\2\2\63"+
		"\65\t\2\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67"+
		"?\3\2\2\28<\7\60\2\29;\t\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2"+
		"=@\3\2\2\2><\3\2\2\2?8\3\2\2\2?@\3\2\2\2@H\3\2\2\2AC\7\60\2\2BD\t\2\2"+
		"\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FH\3\2\2\2G\64\3\2\2\2GA\3\2"+
		"\2\2H\20\3\2\2\2IK\t\3\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MN\3"+
		"\2\2\2NO\b\t\2\2O\22\3\2\2\2PQ\7-\2\2Q\24\3\2\2\2RS\7/\2\2S\26\3\2\2\2"+
		"TU\7,\2\2U\30\3\2\2\2VW\7\61\2\2W\32\3\2\2\2X\\\t\4\2\2Y[\t\5\2\2ZY\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\34\3\2\2\2^\\\3\2\2\2_`\7h\2\2"+
		"`a\7w\2\2ab\7p\2\2bc\7e\2\2c\36\3\2\2\2\n\2\66<?EGL\\\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}