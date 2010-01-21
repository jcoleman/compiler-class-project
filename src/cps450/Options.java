// Options.java
// Implements in the singleton pattern CLI arguments parser and options storage.
// James Coleman, 2010

package cps450;

import java.util.ArrayList;

public class Options {
	
	static Options instance;
	
	// Options
	public Boolean debugTokens = false;
	public ArrayList<String> files;
	
	private Options() {
		files = new ArrayList<String>();
	}
	
	public static Options instance() {
		if (instance == null) {
			instance = new Options();
		}
		return instance;
	}
	
	// Takes the argument array and parses it into a set of applicable options 
	public void parseArgumentArray(String[] args) {
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				processArgument(arg);
			} else {
				files.add(arg);
			}
		}
	}
	
	// Processes a flag argument and sets the correct flag
	public void processArgument(String arg) {
		if (arg.equals("-ds")) {
			debugTokens = true;
		}
	}
	
}
