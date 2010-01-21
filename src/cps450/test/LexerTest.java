package cps450.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

import cps450.MyLexer;
import cps450.oodle.lexer.Lexer;
import cps450.oodle.lexer.LexerException;
import cps450.oodle.node.*;

import junit.framework.TestCase;


public class LexerTest extends TestCase {
	Lexer lex;
	
	public void testOperatorTokens() throws IOException, LexerException {
		setupLexerWithFile("operators.ood");
			
		assertNextToken(TConcatOp.class);
		assertNextToken(TPlusOp.class);
		assertNextToken(TMinusOp.class);
		assertNextToken(TMultOp.class);
		assertNextToken(TDivOp.class);
		assertNextToken(TGtOp.class);
		assertNextToken(TGteOp.class);
		assertNextToken(TEqOp.class);
	}
	
	public void testNewlinesAndContinuations() throws IOException, LexerException {
		setupLexerWithFile("newlines.ood");
		
		assertNextToken(TEol.class);
		// The continuation is ignored by the scanner in MyLexer
		assertNextToken(TContinuation.class);
		assertNextToken(TEol.class);
	}
	
	public void testComments() throws IOException, LexerException {
		setupLexerWithFile("comments.ood");
		// The comment is ignored by the scanner in MyLexer
		assertNextToken(TComment.class);
		assertNextToken(TEol.class);
		assertNextToken(TId.class);
		// The comment and blank is ignored by the scanner in MyLexer
		assertNextToken(TBlank.class);
		assertNextToken(TComment.class);
		assertNextToken(TEol.class);
	}
	
	public void testWhiteSpace() throws IOException, LexerException {
		setupLexerWithFile("whitespace.ood");
		assertNextToken(TBlank.class);
		assertNextToken(TComment.class);
		assertNextToken(TEol.class);
		assertNextToken(TBlank.class);
		assertNextToken(TComment.class);
		assertNextToken(TEol.class);
		assertNextToken(TBlank.class);
		assertNextToken(TComment.class);
	}
	
	public void testKeywords() throws IOException, LexerException {
		setupLexerWithFile("keywords.ood");
		
		assertNextToken(TBoolean.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TBegin.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TKlass.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TElse.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TEnd.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TFalse.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TFrom.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TIf.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TInherits.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TInt.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TIs.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TLoop.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TMe.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TNew.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TNot.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TNull.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TString.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TThen.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TTrue.class);
		assertNextToken(TBlank.class);
		
		assertNextToken(TWhile.class);
	}

	public void testStrings() throws IOException, LexerException {
		setupLexerWithFile("strings.ood");
		
		assertNextToken(TUnterminatedString.class);
		assertNextToken(TEol.class);
		
		assertNextToken(TStrlit.class);
		assertNextToken(TEol.class);
		
		assertNextToken(TStrlit.class);
		assertNextToken(TEol.class);
		
		assertNextToken(TIllegalString.class);
		assertNextToken(TEol.class);
	}
	
	public void testMiscelaneousTokens() throws IOException, LexerException {
		setupLexerWithFile("misctokens.ood");
		
		assertNextToken(TAssignmentOp.class);
		assertNextToken(TLPar.class);
		assertNextToken(TRPar.class);
		assertNextToken(TLBracket.class);
		assertNextToken(TRBracket.class);
		assertNextToken(TComma.class);
		assertNextToken(TSemicolon.class);
		assertNextToken(TColon.class);
		assertNextToken(TPeriod.class);
	}
	
	public void testIntLits() throws IOException, LexerException {
		setupLexerWithFile("intlits.ood");
		
		assertNextToken(TIntlit.class);
		assertNextToken(TEol.class);
		assertNextToken(TIntlit.class);
		assertNextToken(TEol.class);
	}
	
	public void testIdentifiers() throws IOException, LexerException {
		setupLexerWithFile("identifiers.ood");
		
		assertNextToken(TId.class);
		assertNextToken(TEol.class);
		assertNextToken(TId.class);
		assertNextToken(TEol.class);
	}
	
	
	
	private void assertNextToken(Class type, String value) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(tok);
		assertTrue(tok.getClass() == type);
		assertTrue(tok.getText().equals(value));
		
	}

	private void assertNextToken(Class type) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(type);
		System.err.println(tok);
		assertTrue(tok.getClass() == type);	
	}
	
	private void setupLexerWithFile(String filename) {
		lex = new Lexer( new PushbackReader( new InputStreamReader( getClass().getResourceAsStream("oodle_files/".concat(filename)) ) ) );
	}
}
