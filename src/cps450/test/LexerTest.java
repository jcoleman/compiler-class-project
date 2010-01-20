package cps450.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;

import cps450.oodle.lexer.Lexer;
import cps450.oodle.lexer.LexerException;
import cps450.oodle.node.*;

import junit.framework.TestCase;


public class LexerTest extends TestCase {
	Lexer lex;

	public void testSuccessfulScan() throws IOException, LexerException {
		lex = new Lexer(new PushbackReader(new InputStreamReader(getClass().getResourceAsStream(
				"lexertest.jub"))));

		assertNextToken(TGtOp.class);
		assertNextToken(TLPar.class);
		assertNextToken(TRPar.class);
		assertNextToken(TComma.class);
		assertNextToken(TPlusOp.class);
		assertNextToken(TMinusOp.class);
		assertNextToken(TMultOp.class);
		assertNextToken(TDivOp.class);
		assertNextToken(TBang.class);
		assertNextToken(TStrlit.class, "\"Fred\"");
		assertNextToken(TIntlit.class, "326");
		assertNextToken(TId.class, "fred");
		assertNextToken(TBlank.class);
		assertNextToken(TEol.class);
		
		assertNextToken(TComment.class);
		assertNextToken(TEol.class);
		
		assertNextToken(TIf.class);
		assertNextToken(TBlank.class);
		assertNextToken(TWhile.class);
		assertNextToken(EOF.class);

	}

	private void assertNextToken(Class type, String value) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(tok);
		assertTrue(tok.getClass() == type);
		assertTrue(tok.getText().equals(value));
		
	}

	private void assertNextToken(Class type) throws LexerException, IOException {
		Token tok = lex.next();
		System.err.println(tok);
		assertTrue(tok.getClass() == type);	
	}
}
