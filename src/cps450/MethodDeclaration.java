package cps450;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import cps450.oodle.node.PExpression;

public class MethodDeclaration extends Declaration {
	
	ArrayList<Type> argumentTypes;
	Hashtable<String, VariableDeclaration> variables;
	Integer localVariableCount = 0;
	ClassDeclaration klass;
	String name;
	Integer offset;
	
	public MethodDeclaration(Type _type, String _location, ArrayList<Type> _argumentTypes, ClassDeclaration _klass, String _name) {
		super(_type, _location);
		argumentTypes = _argumentTypes;
		variables = new Hashtable<String, VariableDeclaration>();
		klass = _klass;
		name = _name;
	}
	
	/*
	 * Return the total number of arguments currently defined for this method.
	 */
	public Integer getArgumentCount() {
		return this.argumentTypes.size();
	}
	
	/*
	 * Get the list of arguments.
	 */
	public ArrayList<Type> getArgumentTypes() {
		return this.argumentTypes;
	}
	
	/*
	 * Add a new variable.
	 */
	public void addVariable(String name, VariableDeclaration decl) {
		variables.put(name, decl);
	}
	
	/*
	 * Get a local variable designated by <name>.
	 */
	public VariableDeclaration getVariable(String name) {
		return variables.get(name);
	}
	
	/*
	 * Inform the method object that it has had a new local variable added.
	 */
	public void incrementLocalCount() {
		localVariableCount += 1;
	}
	
	/*
	 * Return the current number of local variables.
	 */
	public Integer getLocalCount() {
		return localVariableCount;
	}
	
	public String getMethodLabel() {
		return klass.name + "_" + name;
	}
	
	/*
	 * Return the class in which this method is defined.
	 */
	public ClassDeclaration getKlass() {
		return klass;
	}
	
	/*
	 * Get the offset of this method's function pointer in the class's virtual function table.
	 */
	public Integer getOffset() {
		return offset;
	}
	
	/*
	 * Set the offset of this method's function pointer in the class's virtual function table.
	 */
	public void setOffset(Integer methodOffset) {
		offset = methodOffset;
	}
	
	/*
	 * Helper to check and see if another method has the same signature.
	 * Helpful for determine if a subclass's method should override or mask
	 * an inherited method.
	 */
	public Boolean hasIdenticalSignature(MethodDeclaration otherMethod) {
		if (this.getArgumentCount() != otherMethod.getArgumentCount() || this.getType() != otherMethod.getType()) {
			return false;
		} else {
			// Size is correct, check types
			for (int i = 0; i < this.getArgumentCount(); ++i) {
				if (this.argumentTypes.get(i) != otherMethod.argumentTypes.get(i)) {
					return false;
				}
			}
			return true;
		}
	}
	
}
