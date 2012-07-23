package compiler;

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import antlr.output.ifgrammarLexer;
import antlr.output.ifgrammarParser;

class Main {
    public static void main(String[] args) throws Exception {
		String prelude, protocole;
		if (args.length >= 1) {
			protocole = args[0];

			String outString = protocole.replaceAll(".if", ".tim");
			
			CharStream input = new ANTLRFileStream("Protocols/prelude.if2tim");
			ifgrammarLexer lexer = new ifgrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ifgrammarParser parser = new ifgrammarParser(tokens);
			
			if (args.length>=2) {
				for(int i=1; i<args.length; i++){
					if(args[i].startsWith("--")){
						if(args[i].equals("--linear")){
							parser.getCompiler().setLinearTRS(Integer.parseInt(args[i+1]));
							i++;
						}
						else if(args[i].equals("--checkFalse")){
							parser.getCompiler().setCheckFalse(true);
						}
					}
					else{
						outString = args[i];
					}
				}
			}
			
			parser.tim_prelude();
			
			input = new ANTLRFileStream(protocole);
			lexer.setCharStream(input);// = new ifgrammarLexer(input);
			tokens.setTokenSource(lexer);// = new CommonTokenStream(lexer);
			parser.setTokenStream(tokens);// = new ifgrammarParser(tokens);
			
			parser.if_File();
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outString)));
			parser.getCompiler().doOutput(out);
		}
    }
}