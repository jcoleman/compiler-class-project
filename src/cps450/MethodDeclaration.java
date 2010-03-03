package cps450;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration {
	
	ArrayList<Type> argumentTypes;
	
	public MethodDeclaration(Type _type, String _location, ArrayList<Type> _argumentTypes) {
		super(_type, _location);
		argumentTypes = _argumentTypes;
	}
	
	public Integer getArgumentCount() {
		return this.argumentTypes.size();
	}
	
	public ArrayList<Type> getArgumentTypes() {
		return this.argumentTypes;
	}
	
}
