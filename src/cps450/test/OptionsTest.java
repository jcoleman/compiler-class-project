package cps450.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import cps450.Options;

public class OptionsTest extends TestCase {
	
	public void testSetsDebugTokensFlag() {
		String[] options = {"-ds"};
		Options.instance().parseArgumentArray( options );
		assertTrue(Options.instance().debugTokens);
	}
	
	public void testAddFilesToProcessingList() {
		String[] options = {"test.java", "test2.java"};
		Options.instance().parseArgumentArray( options );
		ArrayList<String> files = new ArrayList<String>();
		files.add("test.java");
		files.add("test2.java");
		assertTrue(Options.instance().files.equals(files));
	}
	
}
