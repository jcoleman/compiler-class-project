package cps450;

import java.util.ArrayList;
import java.util.Hashtable;

public class MethodDeclaration extends Declaration {
	
	ArrayList<Type> argumentTypes;
	Hashtable<String, VariableDeclaration> variables;
	Integer localVariableCount = 0;
	
	public MethodDeclaration(Type _type, String _location, ArrayList<Type> _argumentTypes) {
		super(_type, _location);
		argumentTypes = _argumentTypes;
		variables = new Hashtable<String, VariableDeclaration>();
	}
	
	public Integer getArgumentCount() {
		return this.argumentTypes.size();
	}
	
	public ArrayList<Type> getArgumentTypes() {
		return this.argumentTypes;
	}
	
	public void addVariable(String name, VariableDeclaration decl) {
		variables.put(name, decl);
	}
	
	public VariableDeclaration getVariable(String name) {
		return variables.get(name);
	}
	
	public void incrementLocalCount() {
		localVariableCount += 1;
	}
	
	public Integer getLocalCount() {
		return localVariableCount;
	}
	
}
