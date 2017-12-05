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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, NUMBER=11, WHITESPACE=12, ADD=13, SUB=14, MUL=15, DIV=16, FUNC_DEC=17, 
		IF=18, END=19, NAME=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "NUMBER", "WHITESPACE", "ADD", "SUB", "MUL", "DIV", "FUNC_DEC", 
		"IF", "END", "NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\6\fI\n\f\r\f\16\fJ\3\f\3\f\7\fO\n\f\f\f\16\fR\13\f\5\fT\n\f"+
		"\3\f\3\f\6\fX\n\f\r\f\16\fY\5\f\\\n\f\3\r\6\r_\n\r\r\r\16\r`\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\7\25{\n\25\f\25\16\25~\13\25\2"+
		"\2\26\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26\3\2\6\3\2\62;\5\2\13\f\17\17\"\"\4\2C\\"+
		"c|\5\2\62;C\\c|\2\u0085\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2"+
		"\2\5-\3\2\2\2\7/\3\2\2\2\t\62\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2"+
		"\2\21@\3\2\2\2\23B\3\2\2\2\25D\3\2\2\2\27[\3\2\2\2\31^\3\2\2\2\33d\3\2"+
		"\2\2\35f\3\2\2\2\37h\3\2\2\2!j\3\2\2\2#l\3\2\2\2%q\3\2\2\2\'t\3\2\2\2"+
		")x\3\2\2\2+,\7.\2\2,\4\3\2\2\2-.\7*\2\2.\6\3\2\2\2/\60\7+\2\2\60\61\7"+
		"<\2\2\61\b\3\2\2\2\62\63\7t\2\2\63\64\7g\2\2\64\65\7v\2\2\65\66\7w\2\2"+
		"\66\67\7t\2\2\678\7p\2\28\n\3\2\2\29:\7=\2\2:\f\3\2\2\2;<\7+\2\2<\16\3"+
		"\2\2\2=>\7?\2\2>?\7?\2\2?\20\3\2\2\2@A\7@\2\2A\22\3\2\2\2BC\7>\2\2C\24"+
		"\3\2\2\2DE\7<\2\2EF\7?\2\2F\26\3\2\2\2GI\t\2\2\2HG\3\2\2\2IJ\3\2\2\2J"+
		"H\3\2\2\2JK\3\2\2\2KS\3\2\2\2LP\7\60\2\2MO\t\2\2\2NM\3\2\2\2OR\3\2\2\2"+
		"PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2SL\3\2\2\2ST\3\2\2\2T\\\3\2\2"+
		"\2UW\7\60\2\2VX\t\2\2\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2"+
		"\2\2[H\3\2\2\2[U\3\2\2\2\\\30\3\2\2\2]_\t\3\2\2^]\3\2\2\2_`\3\2\2\2`^"+
		"\3\2\2\2`a\3\2\2\2ab\3\2\2\2bc\b\r\2\2c\32\3\2\2\2de\7-\2\2e\34\3\2\2"+
		"\2fg\7/\2\2g\36\3\2\2\2hi\7,\2\2i \3\2\2\2jk\7\61\2\2k\"\3\2\2\2lm\7h"+
		"\2\2mn\7w\2\2no\7p\2\2op\7e\2\2p$\3\2\2\2qr\7k\2\2rs\7h\2\2s&\3\2\2\2"+
		"tu\7g\2\2uv\7p\2\2vw\7f\2\2w(\3\2\2\2x|\t\4\2\2y{\t\5\2\2zy\3\2\2\2{~"+
		"\3\2\2\2|z\3\2\2\2|}\3\2\2\2}*\3\2\2\2~|\3\2\2\2\n\2JPSY[`|\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}