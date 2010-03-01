package cps450;

import java.util.ArrayList;

public class MethodDeclaration extends Declaration {
	
	ArrayList<Type> argumentTypes;
	
	public MethodDeclaration(Type _type, String _location, ArrayList<Type> _argumentTypes) {
		super(_type, _location);
		argumentTypes = _argumentTypes;
	}
	
}
