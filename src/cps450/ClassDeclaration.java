package cps450;

import java.util.Hashtable;

public class ClassDeclaration extends Declaration {
	
	Hashtable<String, VariableDeclaration> variables;
	Hashtable<String, MethodDeclaration> methods;
	
	public ClassDeclaration(Type _type, String _location) {
		super(_type, _location);
		variables = new Hashtable<String, VariableDeclaration>();
		methods = new Hashtable<String, MethodDeclaration>();
	}
	
	public void addMethod(String name, MethodDeclaration decl) {
		methods.put(name, decl);
	}
	
	public MethodDeclaration getMethod(String name) {
		return methods.get(name);
	}
	
	public void addVariable(String name, VariableDeclaration decl) {
		variables.put(name, decl);
	}
	
	public VariableDeclaration getVariable(String name) {
		return variables.get(name);
	}
	
}
