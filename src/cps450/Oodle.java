// Oodle.java
// James Coleman, 2010
// Primary file containing the main function for the Oodle compiler

package cps450;
import cps450.oodle.node.*;
import cps450.oodle.parser.Parser;
import cps450.oodle.parser.ParserException;

import cps450.oodle.lexer.*;

import java.io.*;
import java.util.Hashtable;

public class Oodle
{
	
	public static int errorCount = 0;
	
	/*
	 * Run the Oodle compile.
	 * Process arguments, semantically check the code, generate assembly code, and assemble it.
	 */
    public static void main(String[] arguments) throws IOException, ParserException, LexerException {
        if(!(arguments.length >= 1)) {
            System.out.println("usage:");
            System.out.println("  java Oodle filename");
            System.exit(1);
        }
        
        Options.instance().addFile("stdlib.ood");
        Options.instance().parseArgumentArray(arguments);

        System.out.println();
        
        SourceHolder.instantiate(Options.instance().files);
        File input = SourceHolder.instance().concatenateFiles();
        
        MyLexer lexer = new MyLexer(
            new PushbackReader(
            new BufferedReader(
            new FileReader(input)), 1024));
        
        Parser parser = new Parser(lexer);
        
        Node startNode = null;
        try {
        	startNode = parser.parse();
        } catch (ParserException e) {
        	errorCount++;
        	String errorText = e.getMessage();
        	errorText = errorText.substring(errorText.indexOf(']') + 2);
        	Token t = e.getToken();
			System.out.println(SourceHolder.instance().getFilenameFor(t) + ":" + SourceHolder.instance().getLineNumberFor(t) + "," + t.getPos() + ":" + errorText);
        }
        
        Hashtable<Node, Type> typeDecorations = new Hashtable<Node, Type>();
        Hashtable<String, ClassDeclaration> classTable = new Hashtable<String, ClassDeclaration>();
        
        SemanticChecker semanticChecker = new SemanticChecker(classTable, typeDecorations);
        startNode.apply(semanticChecker);
        
        Integer totalErrorCount = lexer.errorCount + errorCount + semanticChecker.getErrorCount();
        System.out.println("" + totalErrorCount +  " errors found");
        
        if (totalErrorCount == 0) {
        	String primaryFilename = SourceHolder.instance().getPrimaryFilename();
            String outputName = primaryFilename.substring(0, primaryFilename.lastIndexOf(".ood"));
            
            PrintWriter writer = new PrintWriter(new FileWriter(outputName + ".s"));
            CodeGenerator codeGenerator = new CodeGenerator(writer, classTable, typeDecorations);
            startNode.apply(codeGenerator);
            writer.flush();
            writer.close();
            
            if (!Options.instance().assembleOnly) {
    			assemble(outputName);
    		}
        }
        
    }
    
    
    /**
     * Run GCC to assemble the generated source code.
     * @param outputName
     * @throws IOException
     */
    private static void assemble(String outputName) throws IOException {
    	// Call GCC
    	Process p = Runtime.getRuntime().exec("gcc -g " + outputName + ".s stdlib.o -o" + outputName);
    	BufferedReader stdInput = new BufferedReader(new 
        InputStreamReader(p.getInputStream()));

        BufferedReader stdError = new BufferedReader(new 
        InputStreamReader(p.getErrorStream()));

        // read the output from the command
        String s;
        while ((s = stdInput.readLine()) != null) {
            System.out.println(s);
        }
        
        // read any errors from the attempted command
        while ((s = stdError.readLine()) != null) {
           System.out.println(s);
        }
    	
    	// Delete the temp assembly file
    	(new File(outputName + ".s")).delete();
    }

}

