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
		T__9=10, T__10=11, NUMBER=12, STRING=13, WHITESPACE=14, ADD=15, SUB=16, 
		MUL=17, DIV=18, MOD=19, FUNC_DEC=20, IF=21, ELSE=22, END=23, WHILE=24, 
		NAME=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "NUMBER", "STRING", "WHITESPACE", "ADD", "SUB", "MUL", 
		"DIV", "MOD", "FUNC_DEC", "IF", "ELSE", "END", "WHILE", "NAME"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u00a0\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\6"+
		"\rT\n\r\r\r\16\rU\3\r\3\r\7\rZ\n\r\f\r\16\r]\13\r\5\r_\n\r\3\r\3\r\6\r"+
		"c\n\r\r\r\16\rd\5\rg\n\r\3\16\3\16\7\16k\n\16\f\16\16\16n\13\16\3\16\3"+
		"\16\3\17\6\17s\n\17\r\17\16\17t\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\7\32\u009c\n\32\f\32\16\32\u009f\13\32\2\2\33\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\3\2\7\3\2\62;\7\2\"\"//\62;C\\c|\5\2\13"+
		"\f\17\17\"\"\4\2C\\c|\5\2\62;C\\c|\2\u00a7\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\rD\3\2\2"+
		"\2\17F\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31f\3\2"+
		"\2\2\33h\3\2\2\2\35r\3\2\2\2\37x\3\2\2\2!z\3\2\2\2#|\3\2\2\2%~\3\2\2\2"+
		"\'\u0080\3\2\2\2)\u0082\3\2\2\2+\u0087\3\2\2\2-\u008a\3\2\2\2/\u008f\3"+
		"\2\2\2\61\u0093\3\2\2\2\63\u0099\3\2\2\2\65\66\7.\2\2\66\4\3\2\2\2\67"+
		"8\7*\2\28\6\3\2\2\29:\7+\2\2:\b\3\2\2\2;<\7<\2\2<\n\3\2\2\2=>\7t\2\2>"+
		"?\7g\2\2?@\7v\2\2@A\7w\2\2AB\7t\2\2BC\7p\2\2C\f\3\2\2\2DE\7=\2\2E\16\3"+
		"\2\2\2FG\7?\2\2GH\7?\2\2H\20\3\2\2\2IJ\7@\2\2J\22\3\2\2\2KL\7>\2\2L\24"+
		"\3\2\2\2MN\7(\2\2N\26\3\2\2\2OP\7<\2\2PQ\7?\2\2Q\30\3\2\2\2RT\t\2\2\2"+
		"SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V^\3\2\2\2W[\7\60\2\2XZ\t\2\2"+
		"\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\_\3\2\2\2][\3\2\2\2^W\3\2"+
		"\2\2^_\3\2\2\2_g\3\2\2\2`b\7\60\2\2ac\t\2\2\2ba\3\2\2\2cd\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2eg\3\2\2\2fS\3\2\2\2f`\3\2\2\2g\32\3\2\2\2hl\7$\2\2ik"+
		"\t\3\2\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2o"+
		"p\7$\2\2p\34\3\2\2\2qs\t\4\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2"+
		"uv\3\2\2\2vw\b\17\2\2w\36\3\2\2\2xy\7-\2\2y \3\2\2\2z{\7/\2\2{\"\3\2\2"+
		"\2|}\7,\2\2}$\3\2\2\2~\177\7\61\2\2\177&\3\2\2\2\u0080\u0081\7\'\2\2\u0081"+
		"(\3\2\2\2\u0082\u0083\7h\2\2\u0083\u0084\7w\2\2\u0084\u0085\7p\2\2\u0085"+
		"\u0086\7e\2\2\u0086*\3\2\2\2\u0087\u0088\7k\2\2\u0088\u0089\7h\2\2\u0089"+
		",\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7g\2\2\u008e.\3\2\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7f\2\2\u0092\60\3\2\2\2\u0093\u0094\7y\2\2\u0094\u0095\7j\2\2\u0095"+
		"\u0096\7k\2\2\u0096\u0097\7n\2\2\u0097\u0098\7g\2\2\u0098\62\3\2\2\2\u0099"+
		"\u009d\t\5\2\2\u009a\u009c\t\6\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\64\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\13\2U[^dflt\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}