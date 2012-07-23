package compiler;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;

public class Automata {
	private Hashtable<String,State> statesTable;
	private LinkedList<Transition> transitions;
	private int stateNumber = 1;
	private FinalState qnet;
	private State qfact, qknowledge;
	public Automata(){
		statesTable = new Hashtable<String, State>();
		transitions = new LinkedList<Transition>();		
		
		qnet = addFinalState("qnet");
		qfact = addState("qfact");
		qknowledge = addState("qknowledge");
	}
	
	public void init(Compiler compiler){

		Cons consk = new Cons("knowledge", new Untyped("nullType"));
		Cons net = new Cons("timNetwork", new Untyped("nullType"));
		try {
			compiler.addSymbole(consk);
			compiler.addSymbole(net);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Transition trans = new Transition(consk,new LinkedList<State>(), qknowledge);
		Transition trans2 = new Transition(net,new LinkedList<State>(), qfact);
		transitions.add(trans);
		transitions.add(trans2);
		LinkedList<State> list = new LinkedList<State>();
		list.add(qfact);
		list.add(qfact);
		trans = new Transition(compiler.getSymbolesTable().get("u"),list,qnet);
		transitions.add(trans);
	}
	
	public String print(){
		String state="States ", finalState="Final States ", trans="Transitions";
		Enumeration<State> e = statesTable.elements();
		while(e.hasMoreElements()){
			State s = e.nextElement();
			state = state+" "+s.toString();
			if(s.getClass().equals(FinalState.class))
				finalState = finalState+" "+s.toString();
		}
		for(Transition t:transitions){
			trans = trans+"\n"+t.print();
		}	
		return("Automaton AInit\n"+state+"\n"+finalState+"\n"+trans+"\n");
	}
	
	public void addTerm(Term t){
		LinkedList<State> left = new LinkedList<State>();
		for (Term t2:t.getSons()){
			left.add(addTransition(t2));
		}
		addTransition(new Transition(t.getO(),left,qfact));
	}
	
	public State addTransition(Term t){
		LinkedList<State> left = new LinkedList<State>();
		State right = null;
		if(t.getO().getClass().equals(Cons.class)){
			right = addState("q"+t.getO().toString());
		}
		else{
			for (Term t2:t.getSons()){
				left.add(addTransition(t2));
				right = addState();
			}
		}
		addTransition(new Transition(t.getO(),left,right));
		//if a type is enclosing the term
		if(!t.getO().getType().isVoidType()){
			left = new LinkedList<State>();
			left.add(right);
			right = addState();
			addTransition(new Transition(t.getO().getType(),left,right));
		}
		
		return right;
	}
	
	public void addTransition(Transition trans){
		Boolean alreadyD = false;
		for(Transition t:transitions){
			if(trans.equals(t))
				alreadyD = true;
		}
		if(!alreadyD)
			transitions.add(trans);
	}
	
	public State addState(){
		int i =0;
		State state = new State("q"+stateNumber);
		if(!statesTable.containsKey(stateNumber+"")){
			statesTable.put(stateNumber+"", state);
			stateNumber++;
		}
		return state;
	}
	public FinalState addFinalState(){
		FinalState state = new FinalState("q"+stateNumber);
		if(!statesTable.containsKey(stateNumber+"")){
			statesTable.put(stateNumber+"", state);
			stateNumber++;
		}
		return state;
	}
	public State addState(String s){
		State state = new State(s);
		if(!statesTable.containsKey(s))
			statesTable.put(s, state);
			stateNumber++;
		return state;
	}
	public FinalState addFinalState(String s){
		FinalState state = new FinalState(s);
		if(!statesTable.containsKey(s))
			statesTable.put(s, state);
		return state;
	}
}
