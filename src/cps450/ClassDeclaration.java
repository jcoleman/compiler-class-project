package cps450;

import java.util.ArrayList;
import java.util.Hashtable;

public class ClassDeclaration extends Declaration {
	
	Hashtable<String, VariableDeclaration> variables;
	Hashtable<String, MethodDeclaration> methods;
	Integer currentMethodOffset = 0;
	
	String name;
	
	ClassDeclaration parent = null;
	
	public ClassDeclaration(Type _type, String _location, String _name) {
		super(_type, _location);
		variables = new Hashtable<String, VariableDeclaration>();
		methods = new Hashtable<String, MethodDeclaration>();
		name = _name;
	}
	
	public void inheritFrom(ClassDeclaration _parent) {
		if (_parent != null) {
			// Link to the parent
			parent = _parent;
			
			// Copy over inherited instance variables and methods
			variables.putAll(parent.variables);
			methods.putAll(parent.methods);
			
			currentMethodOffset = parent.currentMethodOffset;
		}
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
		MethodDeclaration oldMethod = methods.get(name);
		if (oldMethod != null && decl.hasIdenticalSignature(oldMethod)) {
			// Methods have the same signature, override.
			decl.setOffset(oldMethod.getOffset());
		} else {
			// Methods have different signatures, mask.
			decl.setOffset(currentMethodOffset);
			currentMethodOffset += 1;
		}
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
	
	public ArrayList<MethodDeclaration> getMethodList() {
		ArrayList<MethodDeclaration> methodList = new ArrayList<MethodDeclaration>(methods.size());
		
		// Setup initial list size
		for (int i = 0; i < methods.size(); ++i) {
			methodList.add(null);
		}
		
		// Create a list of method declarations ordered by their offset
		for (MethodDeclaration method : methods.values()) {
			methodList.set(method.getOffset(), method);
		}
		return methodList;
	}
	
	public String getVirtualFunctionTableLabel() {
		return "__" + name + "__" + "VFT__";
	}

	public ClassDeclaration getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}
	
}
