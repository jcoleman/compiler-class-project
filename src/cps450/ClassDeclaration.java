package cps450;

import java.util.Hashtable;

public class ClassDeclaration extends Declaration {
	
	Hashtable<String, VariableDeclaration> variables;
	Hashtable<String, MethodDeclaration> methods;
	
	String name;
	
	ClassDeclaration parent = null;
	
	public ClassDeclaration(Type _type, String _location, String _name) {
		super(_type, _location);
		variables = new Hashtable<String, VariableDeclaration>();
		methods = new Hashtable<String, MethodDeclaration>();
		name = _name;
	}
	
	public void inheritFrom(ClassDeclaration _parent) {
		parent = _parent;
		
	}
	
	private Boolean isDescendantOf(ClassDeclaration ancestor) {
		if (ancestor == this) {
			return true;
		} else if (ancestor.parent == null) {
			return false;
		} else {
			return this.isDescendantOf(ancestor.parent);
		}
	}
	
	public Boolean compatibleWith(ClassDeclaration klass) {
		if (klass == null) {
			return true;
		} else {
			return this == klass || this.isDescendantOf(klass) || klass.isDescendantOf(this);
		}
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
	
	public Integer getInstanceVariableCount() {
		return variables.size();
	}
	
}
