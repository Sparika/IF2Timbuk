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
			
			//Compiler compiler = new Compiler();
			
			CharStream input = new ANTLRFileStream("prelude.if2tim");
			ifgrammarLexer lexer = new ifgrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ifgrammarParser parser = new ifgrammarParser(tokens);
			
			parser.tim_prelude();
			
			input = new ANTLRFileStream(protocole);
			lexer.setCharStream(input);// = new ifgrammarLexer(input);
			tokens.setTokenSource(lexer);// = new CommonTokenStream(lexer);
			parser.setTokenStream(tokens);// = new ifgrammarParser(tokens);
			
			parser.if_File();
			PrintWriter out;
			if (args.length>=2) {
				out = new PrintWriter(new BufferedWriter(new FileWriter(args[1])));
			}
			else{
				out = new PrintWriter(new BufferedWriter(new FileWriter(protocole.replaceAll(".if", ".tim"))));
				    
			}
			parser.getCompiler().doOutput(out);
		}
    }
}