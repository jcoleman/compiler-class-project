// Oodle.java

package cps450;
import cps450.oodle.node.*;

import cps450.oodle.lexer.*;
import java.io.*;

public class Oodle
{
    public static void main(String[] arguments) throws IOException {
        if(arguments.length != 1)
        {
            System.out.println("usage:");
            System.out.println("  java Oodle filename");
            System.exit(1);
        }

        System.out.println();

        Lexer lexer = new Lexer(
            new PushbackReader(
            new BufferedReader(
            new FileReader(arguments[0])), 1024));

        Token t = getNextToken(lexer);
        while (! (t instanceof EOF)) {
          System.out.println(arguments[0] + ":" + t.getLine() + ":" + t.getText());
          t = getNextToken(lexer);

        }


    }

    static Token getNextToken(Lexer l) throws IOException {
      Token t = null;
      try {
        t = l.next();
      } catch (LexerException e) {
            System.out.println(e);

      }
      return t;
    }

}

