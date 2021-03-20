// Generated from MicroC.g4 by ANTLR 4.8

package compiler;
import java.util.List;
import java.util.LinkedList;
import ast.*;
import compiler.Scope.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, IDENTIFIER=33, INT_LITERAL=34, FLOAT_LITERAL=35, STR_LITERAL=36, 
		COMMENT=37, WS=38;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_var_decls = 2, RULE_id = 3, RULE_var_decl = 4, 
		RULE_str_decl = 5, RULE_type = 6, RULE_base_type = 7, RULE_func_type = 8, 
		RULE_func_decl = 9, RULE_functions = 10, RULE_function = 11, RULE_params = 12, 
		RULE_params_rest = 13, RULE_param = 14, RULE_statements = 15, RULE_statement = 16, 
		RULE_base_stmt = 17, RULE_read_stmt = 18, RULE_print_stmt = 19, RULE_return_stmt = 20, 
		RULE_assign_stmt = 21, RULE_lhs = 22, RULE_if_stmt = 23, RULE_while_stmt = 24, 
		RULE_lval = 25, RULE_primary = 26, RULE_unaryminus_expr = 27, RULE_cast_expr = 28, 
		RULE_ptr_expr = 29, RULE_addr_of_expr = 30, RULE_array_idx_2 = 31, RULE_array_idx_1 = 32, 
		RULE_array_multi = 33, RULE_array_expr = 34, RULE_call_expr = 35, RULE_arg_list = 36, 
		RULE_args_rest = 37, RULE_expr = 38, RULE_term = 39, RULE_cond = 40, RULE_cmpop = 41, 
		RULE_mulop = 42, RULE_addop = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "var_decls", "id", "var_decl", "str_decl", "type", 
			"base_type", "func_type", "func_decl", "functions", "function", "params", 
			"params_rest", "param", "statements", "statement", "base_stmt", "read_stmt", 
			"print_stmt", "return_stmt", "assign_stmt", "lhs", "if_stmt", "while_stmt", 
			"lval", "primary", "unaryminus_expr", "cast_expr", "ptr_expr", "addr_of_expr", 
			"array_idx_2", "array_idx_1", "array_multi", "array_expr", "call_expr", 
			"arg_list", "args_rest", "expr", "term", "cond", "cmpop", "mulop", "addop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'string'", "'='", "'*'", "'int'", "'float'", "'void'", 
			"'('", "')'", "'{'", "'}'", "','", "'read'", "'print'", "'return'", "'if'", 
			"'else'", "'while'", "'-'", "'&'", "'['", "']'", "'malloc'", "'free'", 
			"'<'", "'<='", "'>='", "'=='", "'!='", "'>'", "'/'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IDENTIFIER", "INT_LITERAL", 
			"FLOAT_LITERAL", "STR_LITERAL", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	     private SymbolTable st; //Symbol table for the program
	     private ASTNode ast; //AST for the program
	     public void setSymbolTable(SymbolTable st) {
	          this.st = st;
	     }

	     public SymbolTable getSymbolTable() {
	          return st;
	     }

	     public ASTNode getAST() {
	          return ast;
	     }

	     private void addParams(List<Scope.Type> types, List<String> names) {
	          /* Add parameters in reverse order so everything matches correctly */
	          for (int i = types.size() - 1; i >= 0; --i) {
	               st.addArgument(types.get(i), names.get(i));
	          }
	     }

	public MicroCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public FunctionsContext functions;
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			decls();
			setState(89);
			((ProgramContext)_localctx).functions = functions();
			ast = ((ProgramContext)_localctx).functions.node;
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

	public static class DeclsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public Str_declContext str_decl() {
			return getRuleContext(Str_declContext.class,0);
		}
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitDecls(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				var_decl();
				setState(93);
				decls();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				str_decl();
				setState(96);
				decls();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				func_decl();
				setState(99);
				decls();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				}
				break;
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

	public static class Var_declsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public Var_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterVar_decls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitVar_decls(this);
		}
	}

	public final Var_declsContext var_decls() throws RecognitionException {
		Var_declsContext _localctx = new Var_declsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decls);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				var_decl();
				setState(105);
				var_decls();
				}
				break;
			case T__3:
			case T__10:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__22:
			case T__23:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(IDENTIFIER);
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

	public static class Var_declContext extends ParserRuleContext {
		public TypeContext type;
		public IdContext id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			((Var_declContext)_localctx).type = type(0);
			setState(113);
			((Var_declContext)_localctx).id = id();
			setState(114);
			match(T__0);
			st.addVariable(((Var_declContext)_localctx).type.t, (((Var_declContext)_localctx).id!=null?_input.getText(((Var_declContext)_localctx).id.start,((Var_declContext)_localctx).id.stop):null));
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

	public static class Str_declContext extends ParserRuleContext {
		public IdContext id;
		public Token val;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STR_LITERAL() { return getToken(MicroCParser.STR_LITERAL, 0); }
		public Str_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStr_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStr_decl(this);
		}
	}

	public final Str_declContext str_decl() throws RecognitionException {
		Str_declContext _localctx = new Str_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_str_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__1);
			setState(118);
			((Str_declContext)_localctx).id = id();
			setState(119);
			match(T__2);
			setState(120);
			((Str_declContext)_localctx).val = match(STR_LITERAL);
			setState(121);
			match(T__0);
			st.addVariable(new Scope.Type(Scope.InnerType.STRING), (((Str_declContext)_localctx).id!=null?_input.getText(((Str_declContext)_localctx).id.start,((Str_declContext)_localctx).id.stop):null), (((Str_declContext)_localctx).val!=null?((Str_declContext)_localctx).val.getText():null));
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

	public static class TypeContext extends ParserRuleContext {
		public Scope.Type t;
		public TypeContext t1;
		public Base_typeContext base_type;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(125);
			((TypeContext)_localctx).base_type = base_type();
			((TypeContext)_localctx).t =  ((TypeContext)_localctx).base_type.t;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(128);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(129);
					match(T__3);
					((TypeContext)_localctx).t =  Scope.Type.pointerToType(((TypeContext)_localctx).t1.t);
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public Scope.Type t;
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_base_type);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(T__4);
				((Base_typeContext)_localctx).t =  new Scope.Type(Scope.InnerType.INT);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(T__5);
				((Base_typeContext)_localctx).t =  new Scope.Type(Scope.InnerType.FLOAT);
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

	public static class Func_typeContext extends ParserRuleContext {
		public Scope.Type t;
		public TypeContext type;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFunc_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFunc_type(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_func_type);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				((Func_typeContext)_localctx).type = type(0);
				((Func_typeContext)_localctx).t =  ((Func_typeContext)_localctx).type.t;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__6);
				((Func_typeContext)_localctx).t =  new Scope.Type(Scope.InnerType.VOID);
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

	public static class Func_declContext extends ParserRuleContext {
		public Func_typeContext func_type;
		public IdContext id;
		public ParamsContext params;
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFunc_decl(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((Func_declContext)_localctx).func_type = func_type();
			setState(150);
			((Func_declContext)_localctx).id = id();
			setState(151);
			match(T__7);
			setState(152);
			((Func_declContext)_localctx).params = params();
			setState(153);
			match(T__8);
			setState(154);
			match(T__0);
			st.addFunction(((Func_declContext)_localctx).func_type.t, (((Func_declContext)_localctx).id!=null?_input.getText(((Func_declContext)_localctx).id.start,((Func_declContext)_localctx).id.stop):null), ((Func_declContext)_localctx).params.types);
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

	public static class FunctionsContext extends ParserRuleContext {
		public FunctionListNode node;
		public FunctionContext function;
		public FunctionsContext functions;
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFunctions(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functions);
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				((FunctionsContext)_localctx).function = function();
				setState(158);
				((FunctionsContext)_localctx).functions = functions();
				((FunctionsContext)_localctx).node =  new FunctionListNode(((FunctionsContext)_localctx).function.node, ((FunctionsContext)_localctx).functions.node);
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				((FunctionsContext)_localctx).node =  new FunctionListNode();
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

	public static class FunctionContext extends ParserRuleContext {
		public FunctionNode node;
		public Func_typeContext func_type;
		public IdContext id;
		public ParamsContext params;
		public StatementsContext statements;
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			((FunctionContext)_localctx).func_type = func_type();
			setState(165);
			((FunctionContext)_localctx).id = id();
			setState(166);
			match(T__7);
			setState(167);
			((FunctionContext)_localctx).params = params();
			setState(168);
			match(T__8);

			           /* Add FunctionSymbolTable entry to global scope */
			          FunctionSymbolTableEntry ste = (FunctionSymbolTableEntry) st.getSymbolTableEntry((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			          if ((ste == null) || !ste.isDefined()) {
			               st.addFunction(((FunctionContext)_localctx).func_type.t, (((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null), ((FunctionContext)_localctx).params.types);          
			               ste = (FunctionSymbolTableEntry) st.getSymbolTableEntry((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			               ste.setDefined(true);
			          } else {
			               throw new Error("Function already defined");
			          }
			           st.pushScope((((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null));
			           addParams(((FunctionContext)_localctx).params.types, ((FunctionContext)_localctx).params.names);
			      
			setState(170);
			match(T__9);
			setState(171);
			var_decls();
			setState(172);
			((FunctionContext)_localctx).statements = statements();
			setState(173);
			match(T__10);

			          /* Create FunctionNode */
			          LocalScope funcScope = (LocalScope) st.currentScope();
			          ((FunctionContext)_localctx).node =  new FunctionNode(((FunctionContext)_localctx).statements.node, (((FunctionContext)_localctx).id!=null?_input.getText(((FunctionContext)_localctx).id.start,((FunctionContext)_localctx).id.stop):null), funcScope);
			          /* Done with this scope, so pop the scope */
			          st.popScope();
			     
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

	public static class ParamsContext extends ParserRuleContext {
		public LinkedList<String> names;
		public LinkedList<Scope.Type> types;
		public ParamContext param;
		public Params_restContext params_rest;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Params_restContext params_rest() {
			return getRuleContext(Params_restContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_params);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				((ParamsContext)_localctx).param = param();
				setState(177);
				((ParamsContext)_localctx).params_rest = params_rest();

				               ((ParamsContext)_localctx).names =  new LinkedList<String>();
				               ((ParamsContext)_localctx).types =  new LinkedList<Scope.Type>();
				               _localctx.names.add(((ParamsContext)_localctx).param.name); _localctx.names.addAll(((ParamsContext)_localctx).params_rest.names);
				               _localctx.types.add(((ParamsContext)_localctx).param.param_type); _localctx.types.addAll(((ParamsContext)_localctx).params_rest.types);
				          
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((ParamsContext)_localctx).names =  new LinkedList<String>(); ((ParamsContext)_localctx).types =  new LinkedList<Scope.Type>();
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

	public static class Params_restContext extends ParserRuleContext {
		public LinkedList<String> names;
		public LinkedList<Scope.Type> types;
		public ParamContext param;
		public Params_restContext params_rest;
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Params_restContext params_rest() {
			return getRuleContext(Params_restContext.class,0);
		}
		public Params_restContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterParams_rest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitParams_rest(this);
		}
	}

	public final Params_restContext params_rest() throws RecognitionException {
		Params_restContext _localctx = new Params_restContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_params_rest);
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(T__11);
				setState(184);
				((Params_restContext)_localctx).param = param();
				setState(185);
				((Params_restContext)_localctx).params_rest = params_rest();

				               ((Params_restContext)_localctx).names =  new LinkedList<String>();
				               ((Params_restContext)_localctx).types =  new LinkedList<Scope.Type>();
				               _localctx.names.add(((Params_restContext)_localctx).param.name); _localctx.names.addAll(((Params_restContext)_localctx).params_rest.names);
				               _localctx.types.add(((Params_restContext)_localctx).param.param_type); _localctx.types.addAll(((Params_restContext)_localctx).params_rest.types);
				          
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((Params_restContext)_localctx).names =  new LinkedList<String>(); ((Params_restContext)_localctx).types =  new LinkedList<Scope.Type>();
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

	public static class ParamContext extends ParserRuleContext {
		public String name;
		public Scope.Type param_type;
		public TypeContext type;
		public IdContext id;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			((ParamContext)_localctx).type = type(0);
			setState(192);
			((ParamContext)_localctx).id = id();
			((ParamContext)_localctx).name =  (((ParamContext)_localctx).id!=null?_input.getText(((ParamContext)_localctx).id.start,((ParamContext)_localctx).id.stop):null); ((ParamContext)_localctx).param_type =  ((ParamContext)_localctx).type.t;
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

	public static class StatementsContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementContext statement;
		public StatementsContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_statements);
		try {
			setState(200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__22:
			case T__23:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				((StatementsContext)_localctx).statement = statement();
				setState(196);
				((StatementsContext)_localctx).s = statements();
				((StatementsContext)_localctx).node =  new StatementListNode(((StatementsContext)_localctx).statement.node, ((StatementsContext)_localctx).s.node);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				((StatementsContext)_localctx).node =  new StatementListNode();
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

	public static class StatementContext extends ParserRuleContext {
		public StatementNode node;
		public Base_stmtContext base_stmt;
		public If_stmtContext if_stmt;
		public While_stmtContext while_stmt;
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		try {
			setState(212);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__12:
			case T__13:
			case T__14:
			case T__22:
			case T__23:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				((StatementContext)_localctx).base_stmt = base_stmt();
				setState(203);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).base_stmt.node;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				((StatementContext)_localctx).if_stmt = if_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).if_stmt.node;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				((StatementContext)_localctx).while_stmt = while_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).while_stmt.node;
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

	public static class Base_stmtContext extends ParserRuleContext {
		public StatementNode node;
		public Assign_stmtContext assign_stmt;
		public Read_stmtContext read_stmt;
		public Print_stmtContext print_stmt;
		public Return_stmtContext return_stmt;
		public Call_exprContext call_expr;
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBase_stmt(this);
		}
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_base_stmt);
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				((Base_stmtContext)_localctx).assign_stmt = assign_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).assign_stmt.node;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				((Base_stmtContext)_localctx).read_stmt = read_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).read_stmt.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				((Base_stmtContext)_localctx).print_stmt = print_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).print_stmt.node;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				((Base_stmtContext)_localctx).return_stmt = return_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).return_stmt.node;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				((Base_stmtContext)_localctx).call_expr = call_expr();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).call_expr.node;
				}
				break;
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

	public static class Read_stmtContext extends ParserRuleContext {
		public ReadNode node;
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitRead_stmt(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__12);
			setState(232);
			match(T__7);
			setState(233);
			((Read_stmtContext)_localctx).id = id();
			setState(234);
			match(T__8);
			((Read_stmtContext)_localctx).node =  new ReadNode(new VarNode((((Read_stmtContext)_localctx).id!=null?_input.getText(((Read_stmtContext)_localctx).id.start,((Read_stmtContext)_localctx).id.stop):null)));
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

	public static class Print_stmtContext extends ParserRuleContext {
		public WriteNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterPrint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitPrint_stmt(this);
		}
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__13);
			setState(238);
			match(T__7);
			setState(239);
			((Print_stmtContext)_localctx).expr = expr(0);
			setState(240);
			match(T__8);
			((Print_stmtContext)_localctx).node =  new WriteNode(((Print_stmtContext)_localctx).expr.node);
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

	public static class Return_stmtContext extends ParserRuleContext {
		public ReturnNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_return_stmt);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(T__14);
				setState(244);
				((Return_stmtContext)_localctx).expr = expr(0);
				((Return_stmtContext)_localctx).node =  new ReturnNode(((Return_stmtContext)_localctx).expr.node, st.getFunctionSymbol(st.currentScope().getName()));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(T__14);
				((Return_stmtContext)_localctx).node =  new ReturnNode(null, st.getFunctionSymbol(st.currentScope().getName()));
				}
				break;
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public AssignNode node;
		public LhsContext lhs;
		public ExprContext expr;
		public LhsContext lhs() {
			return getRuleContext(LhsContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			((Assign_stmtContext)_localctx).lhs = lhs();
			setState(252);
			match(T__2);
			setState(253);
			((Assign_stmtContext)_localctx).expr = expr(0);
			((Assign_stmtContext)_localctx).node =  new AssignNode(((Assign_stmtContext)_localctx).lhs.node, ((Assign_stmtContext)_localctx).expr.node);
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

	public static class LhsContext extends ParserRuleContext {
		public ExpressionNode node;
		public LvalContext lval;
		public Array_exprContext array_expr;
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public LhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterLhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitLhs(this);
		}
	}

	public final LhsContext lhs() throws RecognitionException {
		LhsContext _localctx = new LhsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lhs);
		try {
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(256);
				((LhsContext)_localctx).lval = lval();
				((LhsContext)_localctx).node =  ((LhsContext)_localctx).lval.node;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				((LhsContext)_localctx).array_expr = array_expr();
				((LhsContext)_localctx).node =  ((LhsContext)_localctx).array_expr.node;
				}
				break;
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

	public static class If_stmtContext extends ParserRuleContext {
		public IfStatementNode node;
		public CondContext cond;
		public StatementsContext statements;
		public StatementsContext s1;
		public StatementsContext s2;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_if_stmt);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				match(T__15);
				setState(265);
				match(T__7);
				setState(266);
				((If_stmtContext)_localctx).cond = cond();
				setState(267);
				match(T__8);
				setState(268);
				match(T__9);
				setState(269);
				((If_stmtContext)_localctx).statements = statements();
				setState(270);
				match(T__10);
				((If_stmtContext)_localctx).node =  new IfStatementNode(((If_stmtContext)_localctx).cond.node, ((If_stmtContext)_localctx).statements.node, null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(T__15);
				setState(274);
				match(T__7);
				setState(275);
				((If_stmtContext)_localctx).cond = cond();
				setState(276);
				match(T__8);
				setState(277);
				match(T__9);
				setState(278);
				((If_stmtContext)_localctx).s1 = statements();
				setState(279);
				match(T__10);
				setState(280);
				match(T__16);
				setState(281);
				match(T__9);
				setState(282);
				((If_stmtContext)_localctx).s2 = statements();
				setState(283);
				match(T__10);
				((If_stmtContext)_localctx).node =  new IfStatementNode(((If_stmtContext)_localctx).cond.node, ((If_stmtContext)_localctx).s1.node, ((If_stmtContext)_localctx).s2.node);
				}
				break;
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

	public static class While_stmtContext extends ParserRuleContext {
		public WhileNode node;
		public CondContext cond;
		public StatementsContext statements;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__17);
			setState(289);
			match(T__7);
			setState(290);
			((While_stmtContext)_localctx).cond = cond();
			setState(291);
			match(T__8);
			setState(292);
			match(T__9);
			setState(293);
			((While_stmtContext)_localctx).statements = statements();
			setState(294);
			match(T__10);
			((While_stmtContext)_localctx).node =  new WhileNode(((While_stmtContext)_localctx).cond.node, ((While_stmtContext)_localctx).statements.node);
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

	public static class LvalContext extends ParserRuleContext {
		public ExpressionNode node;
		public IdContext id;
		public Ptr_exprContext ptr_expr;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Ptr_exprContext ptr_expr() {
			return getRuleContext(Ptr_exprContext.class,0);
		}
		public LvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterLval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitLval(this);
		}
	}

	public final LvalContext lval() throws RecognitionException {
		LvalContext _localctx = new LvalContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_lval);
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				((LvalContext)_localctx).id = id();
				((LvalContext)_localctx).node =  new VarNode((((LvalContext)_localctx).id!=null?_input.getText(((LvalContext)_localctx).id.start,((LvalContext)_localctx).id.stop):null));
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				((LvalContext)_localctx).ptr_expr = ptr_expr();
				((LvalContext)_localctx).node =  ((LvalContext)_localctx).ptr_expr.node;
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

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionNode node;
		public LvalContext lval;
		public Addr_of_exprContext addr_of_expr;
		public ExprContext expr;
		public Unaryminus_exprContext unaryminus_expr;
		public Call_exprContext call_expr;
		public Array_exprContext array_expr;
		public Token il;
		public Token fl;
		public Cast_exprContext cast_expr;
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public Addr_of_exprContext addr_of_expr() {
			return getRuleContext(Addr_of_exprContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unaryminus_exprContext unaryminus_expr() {
			return getRuleContext(Unaryminus_exprContext.class,0);
		}
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(MicroCParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(MicroCParser.FLOAT_LITERAL, 0); }
		public Cast_exprContext cast_expr() {
			return getRuleContext(Cast_exprContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				((PrimaryContext)_localctx).lval = lval();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).lval.node;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				((PrimaryContext)_localctx).addr_of_expr = addr_of_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).addr_of_expr.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				match(T__7);
				setState(312);
				((PrimaryContext)_localctx).expr = expr(0);
				setState(313);
				match(T__8);
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).expr.node;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				((PrimaryContext)_localctx).unaryminus_expr = unaryminus_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).unaryminus_expr.node;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(319);
				((PrimaryContext)_localctx).call_expr = call_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).call_expr.node;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(322);
				((PrimaryContext)_localctx).array_expr = array_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).array_expr.node;
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(325);
				((PrimaryContext)_localctx).il = match(INT_LITERAL);
				((PrimaryContext)_localctx).node =  new IntLitNode((((PrimaryContext)_localctx).il!=null?((PrimaryContext)_localctx).il.getText():null));
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(327);
				((PrimaryContext)_localctx).fl = match(FLOAT_LITERAL);
				((PrimaryContext)_localctx).node =  new FloatLitNode((((PrimaryContext)_localctx).fl!=null?((PrimaryContext)_localctx).fl.getText():null));
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(329);
				((PrimaryContext)_localctx).cast_expr = cast_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).cast_expr.node;
				}
				break;
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

	public static class Unaryminus_exprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unaryminus_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryminus_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterUnaryminus_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitUnaryminus_expr(this);
		}
	}

	public final Unaryminus_exprContext unaryminus_expr() throws RecognitionException {
		Unaryminus_exprContext _localctx = new Unaryminus_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unaryminus_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(T__18);
			setState(335);
			((Unaryminus_exprContext)_localctx).expr = expr(0);
			((Unaryminus_exprContext)_localctx).node =  new UnaryOpNode(((Unaryminus_exprContext)_localctx).expr.node, "-");
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

	public static class Cast_exprContext extends ParserRuleContext {
		public ExpressionNode node;
		public TypeContext type;
		public PrimaryContext primary;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Cast_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCast_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCast_expr(this);
		}
	}

	public final Cast_exprContext cast_expr() throws RecognitionException {
		Cast_exprContext _localctx = new Cast_exprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cast_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(T__7);
			setState(339);
			((Cast_exprContext)_localctx).type = type(0);
			setState(340);
			match(T__8);
			setState(341);
			((Cast_exprContext)_localctx).primary = primary();
			((Cast_exprContext)_localctx).node =  new CastNode(((Cast_exprContext)_localctx).primary.node, ((Cast_exprContext)_localctx).type.t);
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

	public static class Ptr_exprContext extends ParserRuleContext {
		public PtrDerefNode node;
		public PrimaryContext primary;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Ptr_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptr_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterPtr_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitPtr_expr(this);
		}
	}

	public final Ptr_exprContext ptr_expr() throws RecognitionException {
		Ptr_exprContext _localctx = new Ptr_exprContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_ptr_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__3);
			setState(345);
			((Ptr_exprContext)_localctx).primary = primary();
			((Ptr_exprContext)_localctx).node =  new PtrDerefNode(((Ptr_exprContext)_localctx).primary.node);
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

	public static class Addr_of_exprContext extends ParserRuleContext {
		public AddrOfNode node;
		public LvalContext lval;
		public Array_exprContext array_expr;
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public Array_exprContext array_expr() {
			return getRuleContext(Array_exprContext.class,0);
		}
		public Addr_of_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addr_of_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAddr_of_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAddr_of_expr(this);
		}
	}

	public final Addr_of_exprContext addr_of_expr() throws RecognitionException {
		Addr_of_exprContext _localctx = new Addr_of_exprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_addr_of_expr);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				match(T__19);
				setState(349);
				((Addr_of_exprContext)_localctx).lval = lval();
				((Addr_of_exprContext)_localctx).node =  new AddrOfNode(((Addr_of_exprContext)_localctx).lval.node);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(T__19);
				setState(353);
				((Addr_of_exprContext)_localctx).array_expr = array_expr();
				((Addr_of_exprContext)_localctx).node =  new AddrOfNode(((Addr_of_exprContext)_localctx).array_expr.node);
				}
				break;
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

	public static class Array_idx_2Context extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_idx_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_idx_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray_idx_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray_idx_2(this);
		}
	}

	public final Array_idx_2Context array_idx_2() throws RecognitionException {
		Array_idx_2Context _localctx = new Array_idx_2Context(_ctx, getState());
		enterRule(_localctx, 62, RULE_array_idx_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			((Array_idx_2Context)_localctx).expr = expr(0);
			((Array_idx_2Context)_localctx).node =  new BinaryOpNode(((Array_idx_2Context)_localctx).expr.node , new IntLitNode("4"), "*");
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

	public static class Array_idx_1Context extends ParserRuleContext {
		public ExpressionNode node;
		public LvalContext lval;
		public Array_idx_2Context array_idx_2;
		public LvalContext lval() {
			return getRuleContext(LvalContext.class,0);
		}
		public Array_idx_2Context array_idx_2() {
			return getRuleContext(Array_idx_2Context.class,0);
		}
		public Array_idx_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_idx_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray_idx_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray_idx_1(this);
		}
	}

	public final Array_idx_1Context array_idx_1() throws RecognitionException {
		Array_idx_1Context _localctx = new Array_idx_1Context(_ctx, getState());
		enterRule(_localctx, 64, RULE_array_idx_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			((Array_idx_1Context)_localctx).lval = lval();
			setState(362);
			match(T__20);
			setState(363);
			((Array_idx_1Context)_localctx).array_idx_2 = array_idx_2();
			setState(364);
			match(T__21);
			((Array_idx_1Context)_localctx).node =  new BinaryOpNode(((Array_idx_1Context)_localctx).lval.node , ((Array_idx_1Context)_localctx).array_idx_2.node, "+");
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

	public static class Array_multiContext extends ParserRuleContext {
		public ExpressionNode node;
		public Array_idx_1Context array_idx_1;
		public Array_idx_2Context array_idx_2;
		public Array_idx_1Context array_idx_1() {
			return getRuleContext(Array_idx_1Context.class,0);
		}
		public Array_idx_2Context array_idx_2() {
			return getRuleContext(Array_idx_2Context.class,0);
		}
		public Array_multiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_multi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray_multi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray_multi(this);
		}
	}

	public final Array_multiContext array_multi() throws RecognitionException {
		Array_multiContext _localctx = new Array_multiContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_array_multi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			((Array_multiContext)_localctx).array_idx_1 = array_idx_1();
			setState(368);
			match(T__20);
			setState(369);
			((Array_multiContext)_localctx).array_idx_2 = array_idx_2();
			setState(370);
			match(T__21);
			((Array_multiContext)_localctx).node =  new BinaryOpNode(((Array_multiContext)_localctx).array_idx_1.node , ((Array_multiContext)_localctx).array_idx_2.node, "+");
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

	public static class Array_exprContext extends ParserRuleContext {
		public PtrDerefNode node;
		public Array_idx_1Context array_idx_1;
		public Array_multiContext array_multi;
		public Array_idx_1Context array_idx_1() {
			return getRuleContext(Array_idx_1Context.class,0);
		}
		public Array_multiContext array_multi() {
			return getRuleContext(Array_multiContext.class,0);
		}
		public Array_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray_expr(this);
		}
	}

	public final Array_exprContext array_expr() throws RecognitionException {
		Array_exprContext _localctx = new Array_exprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_array_expr);
		try {
			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				((Array_exprContext)_localctx).array_idx_1 = array_idx_1();
				((Array_exprContext)_localctx).node =  new PtrDerefNode(((Array_exprContext)_localctx).array_idx_1.node);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				((Array_exprContext)_localctx).array_multi = array_multi();
				((Array_exprContext)_localctx).node =  new PtrDerefNode(((Array_exprContext)_localctx).array_multi.node);
				}
				break;
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

	public static class Call_exprContext extends ParserRuleContext {
		public AbstractCallNode node;
		public ExprContext expr;
		public IdContext id;
		public Arg_listContext arg_list;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Arg_listContext arg_list() {
			return getRuleContext(Arg_listContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCall_expr(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_call_expr);
		try {
			setState(399);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				match(T__22);
				setState(382);
				match(T__7);
				setState(383);
				((Call_exprContext)_localctx).expr = expr(0);
				setState(384);
				match(T__8);
				((Call_exprContext)_localctx).node =  new MallocNode(((Call_exprContext)_localctx).expr.node);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(T__23);
				setState(388);
				match(T__7);
				setState(389);
				((Call_exprContext)_localctx).expr = expr(0);
				setState(390);
				match(T__8);
				((Call_exprContext)_localctx).node =  new FreeNode(((Call_exprContext)_localctx).expr.node);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(393);
				((Call_exprContext)_localctx).id = id();
				setState(394);
				match(T__7);
				setState(395);
				((Call_exprContext)_localctx).arg_list = arg_list();
				setState(396);
				match(T__8);
				((Call_exprContext)_localctx).node =  new CallNode((((Call_exprContext)_localctx).id!=null?_input.getText(((Call_exprContext)_localctx).id.start,((Call_exprContext)_localctx).id.stop):null), ((Call_exprContext)_localctx).arg_list.args);
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

	public static class Arg_listContext extends ParserRuleContext {
		public List<ExpressionNode> args;
		public ExprContext expr;
		public Args_restContext args_rest;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Args_restContext args_rest() {
			return getRuleContext(Args_restContext.class,0);
		}
		public Arg_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArg_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArg_list(this);
		}
	}

	public final Arg_listContext arg_list() throws RecognitionException {
		Arg_listContext _localctx = new Arg_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_arg_list);
		try {
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__7:
			case T__18:
			case T__19:
			case T__22:
			case T__23:
			case IDENTIFIER:
			case INT_LITERAL:
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(401);
				((Arg_listContext)_localctx).expr = expr(0);
				setState(402);
				((Arg_listContext)_localctx).args_rest = args_rest();
				((Arg_listContext)_localctx).args =  new LinkedList<ExpressionNode>(); _localctx.args.add(((Arg_listContext)_localctx).expr.node); _localctx.args.addAll(((Arg_listContext)_localctx).args_rest.args);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((Arg_listContext)_localctx).args =  new LinkedList<ExpressionNode>();
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

	public static class Args_restContext extends ParserRuleContext {
		public List<ExpressionNode> args;
		public ExprContext expr;
		public Args_restContext args_rest;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Args_restContext args_rest() {
			return getRuleContext(Args_restContext.class,0);
		}
		public Args_restContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArgs_rest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArgs_rest(this);
		}
	}

	public final Args_restContext args_rest() throws RecognitionException {
		Args_restContext _localctx = new Args_restContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_args_rest);
		try {
			setState(414);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(T__11);
				setState(409);
				((Args_restContext)_localctx).expr = expr(0);
				setState(410);
				((Args_restContext)_localctx).args_rest = args_rest();
				((Args_restContext)_localctx).args =  new LinkedList<ExpressionNode>(); _localctx.args.add(((Args_restContext)_localctx).expr.node); _localctx.args.addAll(((Args_restContext)_localctx).args_rest.args);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((Args_restContext)_localctx).args =  new LinkedList<ExpressionNode>();
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

	public static class ExprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext e1;
		public TermContext term;
		public AddopContext addop;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(417);
			((ExprContext)_localctx).term = term(0);
			((ExprContext)_localctx).node =  ((ExprContext)_localctx).term.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(427);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(420);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(421);
					((ExprContext)_localctx).addop = addop();
					setState(422);
					((ExprContext)_localctx).term = term(0);
					((ExprContext)_localctx).node =  new BinaryOpNode(((ExprContext)_localctx).e1.node, ((ExprContext)_localctx).term.node, (((ExprContext)_localctx).addop!=null?_input.getText(((ExprContext)_localctx).addop.start,((ExprContext)_localctx).addop.stop):null));
					}
					} 
				}
				setState(429);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ExpressionNode node;
		public TermContext t1;
		public PrimaryContext primary;
		public MulopContext mulop;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(431);
			((TermContext)_localctx).primary = primary();
			((TermContext)_localctx).node =  ((TermContext)_localctx).primary.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(441);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(434);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(435);
					((TermContext)_localctx).mulop = mulop();
					setState(436);
					((TermContext)_localctx).primary = primary();
					((TermContext)_localctx).node =  new BinaryOpNode(((TermContext)_localctx).t1.node, ((TermContext)_localctx).primary.node, (((TermContext)_localctx).mulop!=null?_input.getText(((TermContext)_localctx).mulop.start,((TermContext)_localctx).mulop.stop):null));
					}
					} 
				}
				setState(443);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public CondNode node;
		public ExprContext e1;
		public CmpopContext cmpop;
		public ExprContext e2;
		public CmpopContext cmpop() {
			return getRuleContext(CmpopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			((CondContext)_localctx).e1 = expr(0);
			setState(445);
			((CondContext)_localctx).cmpop = cmpop();
			setState(446);
			((CondContext)_localctx).e2 = expr(0);
			((CondContext)_localctx).node =  new CondNode(((CondContext)_localctx).e1.node, ((CondContext)_localctx).e2.node, (((CondContext)_localctx).cmpop!=null?_input.getText(((CondContext)_localctx).cmpop.start,((CondContext)_localctx).cmpop.stop):null));
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

	public static class CmpopContext extends ParserRuleContext {
		public CmpopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCmpop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCmpop(this);
		}
	}

	public final CmpopContext cmpop() throws RecognitionException {
		CmpopContext _localctx = new CmpopContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__30) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAddop(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_la = _input.LA(1);
			if ( !(_la==T__18 || _la==T__31) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 38:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 39:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u01ca\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"i\n\3\3\4\3\4\3\4\3\4\5\4o\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0086\n\b\f\b\16\b\u0089"+
		"\13\b\3\t\3\t\3\t\3\t\5\t\u008f\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u0096\n\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00a5"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\5\16\u00b8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c0\n\17"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\5\21\u00cb\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00d7\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00e8"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00fc\n\26\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u0109\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u0121\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0132\n\33\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u014f\n\34\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3 \5 \u0167\n \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3$\3$\3$\3$\3$\3$\5$\u017e\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3"+
		"%\3%\3%\3%\3%\3%\3%\5%\u0192\n%\3&\3&\3&\3&\3&\5&\u0199\n&\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\5\'\u01a1\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u01ac\n(\f(\16"+
		"(\u01af\13(\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u01ba\n)\f)\16)\u01bd\13)\3"+
		"*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\2\5\16NP.\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX\2\5\3\2\33 \4\2\6\6"+
		"!!\4\2\25\25\"\"\2\u01c2\2Z\3\2\2\2\4h\3\2\2\2\6n\3\2\2\2\bp\3\2\2\2\n"+
		"r\3\2\2\2\fw\3\2\2\2\16~\3\2\2\2\20\u008e\3\2\2\2\22\u0095\3\2\2\2\24"+
		"\u0097\3\2\2\2\26\u00a4\3\2\2\2\30\u00a6\3\2\2\2\32\u00b7\3\2\2\2\34\u00bf"+
		"\3\2\2\2\36\u00c1\3\2\2\2 \u00ca\3\2\2\2\"\u00d6\3\2\2\2$\u00e7\3\2\2"+
		"\2&\u00e9\3\2\2\2(\u00ef\3\2\2\2*\u00fb\3\2\2\2,\u00fd\3\2\2\2.\u0108"+
		"\3\2\2\2\60\u0120\3\2\2\2\62\u0122\3\2\2\2\64\u0131\3\2\2\2\66\u014e\3"+
		"\2\2\28\u0150\3\2\2\2:\u0154\3\2\2\2<\u015a\3\2\2\2>\u0166\3\2\2\2@\u0168"+
		"\3\2\2\2B\u016b\3\2\2\2D\u0171\3\2\2\2F\u017d\3\2\2\2H\u0191\3\2\2\2J"+
		"\u0198\3\2\2\2L\u01a0\3\2\2\2N\u01a2\3\2\2\2P\u01b0\3\2\2\2R\u01be\3\2"+
		"\2\2T\u01c3\3\2\2\2V\u01c5\3\2\2\2X\u01c7\3\2\2\2Z[\5\4\3\2[\\\5\26\f"+
		"\2\\]\b\2\1\2]\3\3\2\2\2^_\5\n\6\2_`\5\4\3\2`i\3\2\2\2ab\5\f\7\2bc\5\4"+
		"\3\2ci\3\2\2\2de\5\24\13\2ef\5\4\3\2fi\3\2\2\2gi\3\2\2\2h^\3\2\2\2ha\3"+
		"\2\2\2hd\3\2\2\2hg\3\2\2\2i\5\3\2\2\2jk\5\n\6\2kl\5\6\4\2lo\3\2\2\2mo"+
		"\3\2\2\2nj\3\2\2\2nm\3\2\2\2o\7\3\2\2\2pq\7#\2\2q\t\3\2\2\2rs\5\16\b\2"+
		"st\5\b\5\2tu\7\3\2\2uv\b\6\1\2v\13\3\2\2\2wx\7\4\2\2xy\5\b\5\2yz\7\5\2"+
		"\2z{\7&\2\2{|\7\3\2\2|}\b\7\1\2}\r\3\2\2\2~\177\b\b\1\2\177\u0080\5\20"+
		"\t\2\u0080\u0081\b\b\1\2\u0081\u0087\3\2\2\2\u0082\u0083\f\3\2\2\u0083"+
		"\u0084\7\6\2\2\u0084\u0086\b\b\1\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2"+
		"\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\17\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u008a\u008b\7\7\2\2\u008b\u008f\b\t\1\2\u008c\u008d\7\b\2\2\u008d"+
		"\u008f\b\t\1\2\u008e\u008a\3\2\2\2\u008e\u008c\3\2\2\2\u008f\21\3\2\2"+
		"\2\u0090\u0091\5\16\b\2\u0091\u0092\b\n\1\2\u0092\u0096\3\2\2\2\u0093"+
		"\u0094\7\t\2\2\u0094\u0096\b\n\1\2\u0095\u0090\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0096\23\3\2\2\2\u0097\u0098\5\22\n\2\u0098\u0099\5\b\5\2\u0099\u009a"+
		"\7\n\2\2\u009a\u009b\5\32\16\2\u009b\u009c\7\13\2\2\u009c\u009d\7\3\2"+
		"\2\u009d\u009e\b\13\1\2\u009e\25\3\2\2\2\u009f\u00a0\5\30\r\2\u00a0\u00a1"+
		"\5\26\f\2\u00a1\u00a2\b\f\1\2\u00a2\u00a5\3\2\2\2\u00a3\u00a5\b\f\1\2"+
		"\u00a4\u009f\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5\27\3\2\2\2\u00a6\u00a7"+
		"\5\22\n\2\u00a7\u00a8\5\b\5\2\u00a8\u00a9\7\n\2\2\u00a9\u00aa\5\32\16"+
		"\2\u00aa\u00ab\7\13\2\2\u00ab\u00ac\b\r\1\2\u00ac\u00ad\7\f\2\2\u00ad"+
		"\u00ae\5\6\4\2\u00ae\u00af\5 \21\2\u00af\u00b0\7\r\2\2\u00b0\u00b1\b\r"+
		"\1\2\u00b1\31\3\2\2\2\u00b2\u00b3\5\36\20\2\u00b3\u00b4\5\34\17\2\u00b4"+
		"\u00b5\b\16\1\2\u00b5\u00b8\3\2\2\2\u00b6\u00b8\b\16\1\2\u00b7\u00b2\3"+
		"\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\33\3\2\2\2\u00b9\u00ba\7\16\2\2\u00ba"+
		"\u00bb\5\36\20\2\u00bb\u00bc\5\34\17\2\u00bc\u00bd\b\17\1\2\u00bd\u00c0"+
		"\3\2\2\2\u00be\u00c0\b\17\1\2\u00bf\u00b9\3\2\2\2\u00bf\u00be\3\2\2\2"+
		"\u00c0\35\3\2\2\2\u00c1\u00c2\5\16\b\2\u00c2\u00c3\5\b\5\2\u00c3\u00c4"+
		"\b\20\1\2\u00c4\37\3\2\2\2\u00c5\u00c6\5\"\22\2\u00c6\u00c7\5 \21\2\u00c7"+
		"\u00c8\b\21\1\2\u00c8\u00cb\3\2\2\2\u00c9\u00cb\b\21\1\2\u00ca\u00c5\3"+
		"\2\2\2\u00ca\u00c9\3\2\2\2\u00cb!\3\2\2\2\u00cc\u00cd\5$\23\2\u00cd\u00ce"+
		"\7\3\2\2\u00ce\u00cf\b\22\1\2\u00cf\u00d7\3\2\2\2\u00d0\u00d1\5\60\31"+
		"\2\u00d1\u00d2\b\22\1\2\u00d2\u00d7\3\2\2\2\u00d3\u00d4\5\62\32\2\u00d4"+
		"\u00d5\b\22\1\2\u00d5\u00d7\3\2\2\2\u00d6\u00cc\3\2\2\2\u00d6\u00d0\3"+
		"\2\2\2\u00d6\u00d3\3\2\2\2\u00d7#\3\2\2\2\u00d8\u00d9\5,\27\2\u00d9\u00da"+
		"\b\23\1\2\u00da\u00e8\3\2\2\2\u00db\u00dc\5&\24\2\u00dc\u00dd\b\23\1\2"+
		"\u00dd\u00e8\3\2\2\2\u00de\u00df\5(\25\2\u00df\u00e0\b\23\1\2\u00e0\u00e8"+
		"\3\2\2\2\u00e1\u00e2\5*\26\2\u00e2\u00e3\b\23\1\2\u00e3\u00e8\3\2\2\2"+
		"\u00e4\u00e5\5H%\2\u00e5\u00e6\b\23\1\2\u00e6\u00e8\3\2\2\2\u00e7\u00d8"+
		"\3\2\2\2\u00e7\u00db\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7"+
		"\u00e4\3\2\2\2\u00e8%\3\2\2\2\u00e9\u00ea\7\17\2\2\u00ea\u00eb\7\n\2\2"+
		"\u00eb\u00ec\5\b\5\2\u00ec\u00ed\7\13\2\2\u00ed\u00ee\b\24\1\2\u00ee\'"+
		"\3\2\2\2\u00ef\u00f0\7\20\2\2\u00f0\u00f1\7\n\2\2\u00f1\u00f2\5N(\2\u00f2"+
		"\u00f3\7\13\2\2\u00f3\u00f4\b\25\1\2\u00f4)\3\2\2\2\u00f5\u00f6\7\21\2"+
		"\2\u00f6\u00f7\5N(\2\u00f7\u00f8\b\26\1\2\u00f8\u00fc\3\2\2\2\u00f9\u00fa"+
		"\7\21\2\2\u00fa\u00fc\b\26\1\2\u00fb\u00f5\3\2\2\2\u00fb\u00f9\3\2\2\2"+
		"\u00fc+\3\2\2\2\u00fd\u00fe\5.\30\2\u00fe\u00ff\7\5\2\2\u00ff\u0100\5"+
		"N(\2\u0100\u0101\b\27\1\2\u0101-\3\2\2\2\u0102\u0103\5\64\33\2\u0103\u0104"+
		"\b\30\1\2\u0104\u0109\3\2\2\2\u0105\u0106\5F$\2\u0106\u0107\b\30\1\2\u0107"+
		"\u0109\3\2\2\2\u0108\u0102\3\2\2\2\u0108\u0105\3\2\2\2\u0109/\3\2\2\2"+
		"\u010a\u010b\7\22\2\2\u010b\u010c\7\n\2\2\u010c\u010d\5R*\2\u010d\u010e"+
		"\7\13\2\2\u010e\u010f\7\f\2\2\u010f\u0110\5 \21\2\u0110\u0111\7\r\2\2"+
		"\u0111\u0112\b\31\1\2\u0112\u0121\3\2\2\2\u0113\u0114\7\22\2\2\u0114\u0115"+
		"\7\n\2\2\u0115\u0116\5R*\2\u0116\u0117\7\13\2\2\u0117\u0118\7\f\2\2\u0118"+
		"\u0119\5 \21\2\u0119\u011a\7\r\2\2\u011a\u011b\7\23\2\2\u011b\u011c\7"+
		"\f\2\2\u011c\u011d\5 \21\2\u011d\u011e\7\r\2\2\u011e\u011f\b\31\1\2\u011f"+
		"\u0121\3\2\2\2\u0120\u010a\3\2\2\2\u0120\u0113\3\2\2\2\u0121\61\3\2\2"+
		"\2\u0122\u0123\7\24\2\2\u0123\u0124\7\n\2\2\u0124\u0125\5R*\2\u0125\u0126"+
		"\7\13\2\2\u0126\u0127\7\f\2\2\u0127\u0128\5 \21\2\u0128\u0129\7\r\2\2"+
		"\u0129\u012a\b\32\1\2\u012a\63\3\2\2\2\u012b\u012c\5\b\5\2\u012c\u012d"+
		"\b\33\1\2\u012d\u0132\3\2\2\2\u012e\u012f\5<\37\2\u012f\u0130\b\33\1\2"+
		"\u0130\u0132\3\2\2\2\u0131\u012b\3\2\2\2\u0131\u012e\3\2\2\2\u0132\65"+
		"\3\2\2\2\u0133\u0134\5\64\33\2\u0134\u0135\b\34\1\2\u0135\u014f\3\2\2"+
		"\2\u0136\u0137\5> \2\u0137\u0138\b\34\1\2\u0138\u014f\3\2\2\2\u0139\u013a"+
		"\7\n\2\2\u013a\u013b\5N(\2\u013b\u013c\7\13\2\2\u013c\u013d\b\34\1\2\u013d"+
		"\u014f\3\2\2\2\u013e\u013f\58\35\2\u013f\u0140\b\34\1\2\u0140\u014f\3"+
		"\2\2\2\u0141\u0142\5H%\2\u0142\u0143\b\34\1\2\u0143\u014f\3\2\2\2\u0144"+
		"\u0145\5F$\2\u0145\u0146\b\34\1\2\u0146\u014f\3\2\2\2\u0147\u0148\7$\2"+
		"\2\u0148\u014f\b\34\1\2\u0149\u014a\7%\2\2\u014a\u014f\b\34\1\2\u014b"+
		"\u014c\5:\36\2\u014c\u014d\b\34\1\2\u014d\u014f\3\2\2\2\u014e\u0133\3"+
		"\2\2\2\u014e\u0136\3\2\2\2\u014e\u0139\3\2\2\2\u014e\u013e\3\2\2\2\u014e"+
		"\u0141\3\2\2\2\u014e\u0144\3\2\2\2\u014e\u0147\3\2\2\2\u014e\u0149\3\2"+
		"\2\2\u014e\u014b\3\2\2\2\u014f\67\3\2\2\2\u0150\u0151\7\25\2\2\u0151\u0152"+
		"\5N(\2\u0152\u0153\b\35\1\2\u01539\3\2\2\2\u0154\u0155\7\n\2\2\u0155\u0156"+
		"\5\16\b\2\u0156\u0157\7\13\2\2\u0157\u0158\5\66\34\2\u0158\u0159\b\36"+
		"\1\2\u0159;\3\2\2\2\u015a\u015b\7\6\2\2\u015b\u015c\5\66\34\2\u015c\u015d"+
		"\b\37\1\2\u015d=\3\2\2\2\u015e\u015f\7\26\2\2\u015f\u0160\5\64\33\2\u0160"+
		"\u0161\b \1\2\u0161\u0167\3\2\2\2\u0162\u0163\7\26\2\2\u0163\u0164\5F"+
		"$\2\u0164\u0165\b \1\2\u0165\u0167\3\2\2\2\u0166\u015e\3\2\2\2\u0166\u0162"+
		"\3\2\2\2\u0167?\3\2\2\2\u0168\u0169\5N(\2\u0169\u016a\b!\1\2\u016aA\3"+
		"\2\2\2\u016b\u016c\5\64\33\2\u016c\u016d\7\27\2\2\u016d\u016e\5@!\2\u016e"+
		"\u016f\7\30\2\2\u016f\u0170\b\"\1\2\u0170C\3\2\2\2\u0171\u0172\5B\"\2"+
		"\u0172\u0173\7\27\2\2\u0173\u0174\5@!\2\u0174\u0175\7\30\2\2\u0175\u0176"+
		"\b#\1\2\u0176E\3\2\2\2\u0177\u0178\5B\"\2\u0178\u0179\b$\1\2\u0179\u017e"+
		"\3\2\2\2\u017a\u017b\5D#\2\u017b\u017c\b$\1\2\u017c\u017e\3\2\2\2\u017d"+
		"\u0177\3\2\2\2\u017d\u017a\3\2\2\2\u017eG\3\2\2\2\u017f\u0180\7\31\2\2"+
		"\u0180\u0181\7\n\2\2\u0181\u0182\5N(\2\u0182\u0183\7\13\2\2\u0183\u0184"+
		"\b%\1\2\u0184\u0192\3\2\2\2\u0185\u0186\7\32\2\2\u0186\u0187\7\n\2\2\u0187"+
		"\u0188\5N(\2\u0188\u0189\7\13\2\2\u0189\u018a\b%\1\2\u018a\u0192\3\2\2"+
		"\2\u018b\u018c\5\b\5\2\u018c\u018d\7\n\2\2\u018d\u018e\5J&\2\u018e\u018f"+
		"\7\13\2\2\u018f\u0190\b%\1\2\u0190\u0192\3\2\2\2\u0191\u017f\3\2\2\2\u0191"+
		"\u0185\3\2\2\2\u0191\u018b\3\2\2\2\u0192I\3\2\2\2\u0193\u0194\5N(\2\u0194"+
		"\u0195\5L\'\2\u0195\u0196\b&\1\2\u0196\u0199\3\2\2\2\u0197\u0199\b&\1"+
		"\2\u0198\u0193\3\2\2\2\u0198\u0197\3\2\2\2\u0199K\3\2\2\2\u019a\u019b"+
		"\7\16\2\2\u019b\u019c\5N(\2\u019c\u019d\5L\'\2\u019d\u019e\b\'\1\2\u019e"+
		"\u01a1\3\2\2\2\u019f\u01a1\b\'\1\2\u01a0\u019a\3\2\2\2\u01a0\u019f\3\2"+
		"\2\2\u01a1M\3\2\2\2\u01a2\u01a3\b(\1\2\u01a3\u01a4\5P)\2\u01a4\u01a5\b"+
		"(\1\2\u01a5\u01ad\3\2\2\2\u01a6\u01a7\f\3\2\2\u01a7\u01a8\5X-\2\u01a8"+
		"\u01a9\5P)\2\u01a9\u01aa\b(\1\2\u01aa\u01ac\3\2\2\2\u01ab\u01a6\3\2\2"+
		"\2\u01ac\u01af\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ad\u01ae\3\2\2\2\u01aeO"+
		"\3\2\2\2\u01af\u01ad\3\2\2\2\u01b0\u01b1\b)\1\2\u01b1\u01b2\5\66\34\2"+
		"\u01b2\u01b3\b)\1\2\u01b3\u01bb\3\2\2\2\u01b4\u01b5\f\3\2\2\u01b5\u01b6"+
		"\5V,\2\u01b6\u01b7\5\66\34\2\u01b7\u01b8\b)\1\2\u01b8\u01ba\3\2\2\2\u01b9"+
		"\u01b4\3\2\2\2\u01ba\u01bd\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01bc\3\2"+
		"\2\2\u01bcQ\3\2\2\2\u01bd\u01bb\3\2\2\2\u01be\u01bf\5N(\2\u01bf\u01c0"+
		"\5T+\2\u01c0\u01c1\5N(\2\u01c1\u01c2\b*\1\2\u01c2S\3\2\2\2\u01c3\u01c4"+
		"\t\2\2\2\u01c4U\3\2\2\2\u01c5\u01c6\t\3\2\2\u01c6W\3\2\2\2\u01c7\u01c8"+
		"\t\4\2\2\u01c8Y\3\2\2\2\31hn\u0087\u008e\u0095\u00a4\u00b7\u00bf\u00ca"+
		"\u00d6\u00e7\u00fb\u0108\u0120\u0131\u014e\u0166\u017d\u0191\u0198\u01a0"+
		"\u01ad\u01bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}