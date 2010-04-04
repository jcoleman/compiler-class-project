package cps450;

public class VariableDeclaration extends Declaration {
	
	Integer argumentPosition;
	Integer localPosition;
	
	public VariableDeclaration(Type _type, String _location) {
		super(_type, _location);
	}
	
	public void setArgumentPosition(Integer argPos) {
		argumentPosition = argPos;
	}
	
	public void setLocalPosition(Integer localPos) {
		localPosition = localPos;
	}
	
	public Integer getStackOffset() {
		if (argumentPosition != null) {
			return argumentPosition * 4 + 8; 
		} else if (localPosition != null) {
			// Local variable
			return localPosition * -4;
		}
		return null;
	}
	
}
