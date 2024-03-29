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
	ArrayList<String> lines = null;
	
	protected SourceHolder(ArrayList<String> _filenames) {
		filenames = _filenames;
	}
	
	public static void instantiate(ArrayList<String> _filenames) {
		instance = new SourceHolder(_filenames);
	}
	
	public static SourceHolder instance() {
		return instance;
	}
	
	public String getLine(int index) {
		return this.lines.get(index);
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
    	File f = new File(this.filenames.get(this.filenames.size() - 1));
    	return f.getName();
    }
    
    // Converts multiple files into one file for parsing
    // Also stores the line number translation information
    public File concatenateFiles() throws IOException {
    	// setup for our line indexing
   		linesFileIndex = new ArrayList<Integer>();
    	linesCorrectLineIndex = new ArrayList<Integer>();
    	lines = new ArrayList<String>();
   		
    	BufferedWriter writer = null;
    	File tmp = null;
    	
    	try {
    		// create new temporary file
        	tmp = File.createTempFile("oodle-compiler", ".ood");
        	writer = new BufferedWriter( new FileWriter(tmp) );
            
            for (int i = 0; i < Options.instance().files.size(); ++i) {
            	// open each file
            	BufferedReader rd = new BufferedReader( new FileReader( Options.instance().files.get(i) ) );
            	
            	int lineCount = 0;
            	String line;
            	while ( (line = rd.readLine()) != null ) {
            		lineCount++;
            		
            		lines.add(line);
            		
           			// write its output to the temporary file
               		writer.write(line, 0, line.length());
               		writer.newLine();
           			
               		// setup line numbering mapping
           			linesFileIndex.add(i);
           			linesCorrectLineIndex.add(lineCount);
           		}
           		
           	}
    	} catch (Exception e) {
    		System.err.println("Error reading source file");
    	} finally {
    		if (writer != null) {
    			writer.close();
    		}
    	}
       	
       	return tmp;
    }
	
}
