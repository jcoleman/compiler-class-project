// SourceHolder.java
// Implements in a singleton pattern the functionality for parsing multiple source files
// James Coleman, 2010

package cps450;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import cps450.oodle.node.Token;

public class SourceHolder {
	
	static SourceHolder instance;
	
	ArrayList<String> filenames;
	ArrayList<Integer> linesFileIndex = null;
	ArrayList<Integer> linesCorrectLineIndex = null;
	
	protected SourceHolder(ArrayList<String> _filenames) {
		filenames = _filenames;
	}
	
	public static void instantiate(ArrayList<String> _filenames) {
		instance = new SourceHolder(_filenames);
	}
	
	public static SourceHolder instance() {
		return instance;
	}
	
	// Interpret the line number from a token
	// (if the line is in the temporary file, we want to know the line in the original)
	public Integer getLineNumberFor(Token t) {
    	if (linesCorrectLineIndex == null) {
    		return t.getLine();
    	} else {
    		return linesCorrectLineIndex.get(t.getLine() - 1);
    	}
    }
    
	// Determines (even if part of a temporary file) what file a token is a part of
    public String getFilenameFor(Token t) {
    	if (linesFileIndex == null) {
    		return Options.instance().files.get(0);
    	} else {
    		return Options.instance().files.get( linesFileIndex.get(t.getLine() - 1) );
    	}
    }
    
    public String getPrimaryFilename() {
    	return this.filenames.get(0);
    }
    
    // Converts multiple files into one file for parsing
    // Also stores the line number translation information
    public File concatenateFiles() throws IOException {	
    	if (Options.instance().files.size() > 1) {
    		// setup for our line indexing
    		linesFileIndex = new ArrayList<Integer>();
    		linesCorrectLineIndex = new ArrayList<Integer>();
    		
    		// create new temporary file
    		File tmp = File.createTempFile("oodle-compiler", ".ood");
    		BufferedWriter writer = new BufferedWriter( new FileWriter(tmp) );
        	
        	for (int i = 0; i < Options.instance().files.size(); ++i) {
        		// open each file
        		BufferedReader rd = new BufferedReader( new FileReader( Options.instance().files.get(i) ) );
        		
        		int lineCount = 0;
        		String line;
        		while ( (line = rd.readLine()) != null ) {
        			lineCount++;
        			
        			// write its output to the temporary file
            		writer.write(line, 0, line.length());
            		writer.newLine();
        			
            		// setup line numbering mapping
        			linesFileIndex.add(i);
        			linesCorrectLineIndex.add(lineCount);
        		}
        		
        	}
        	writer.close();
        	return tmp;
    	} else {
    		return new File( Options.instance().files.get(0) );
    	}
    	
    }
	
}
