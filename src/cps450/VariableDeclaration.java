package cps450;

public class VariableDeclaration extends Declaration {
	
	Integer instancePosition;
	Integer argumentPosition;
	Integer localPosition;
	ClassDeclaration declaringKlass;
	
	public VariableDeclaration(Type _type, String _location) {
		super(_type, _location);
	}
	
	public void setDeclaringKlass(ClassDeclaration _klass) {
		declaringKlass = _klass;
	}
	
	/*
	 * Return the class in which this variable is contained (if an instance variable at least).
	 */
	public ClassDeclaration getDeclaringKlass() {
		return declaringKlass;
	}
	
	public void setArgumentPosition(Integer argPos) {
		argumentPosition = argPos;
	}
	
	public void setLocalPosition(Integer localPos) {
		localPosition = localPos;
	}
	
	public void setInstancePosition(Integer instPos) {
		instancePosition = instPos;
	}
	
	/*
	 * Helper to test if the variable is an instance variable.
	 */
	public Boolean isInstanceVariable() {
		return instancePosition != null;
	}
	
	/*
	 * Helper to check if the variable is a local variable.
	 */
	public Boolean isLocalVariable() {
		return argumentPosition != null || localPosition != null;
	}
	
	/*
	 * Calculate the variable's offset into the object storage space.
	 */
	public Integer getInstanceOffset() {
		if (instancePosition != null) {
			return instancePosition * 4 + 8;
		} else {
			return null;
		}
	}
	
	/*
	 * Calculate the variable's offset into the stack if it is an argument or a local variable.
	 */
	public Integer getStackOffset() {
		if (argumentPosition != null) {
			return argumentPosition * 4 + 8; // Offset for saved copy of EBP and return address 
		} else if (localPosition != null) {
			// Local variable
			return localPosition * -4;
		}
		return null;
	}
	
}
