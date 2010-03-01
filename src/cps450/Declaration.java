package cps450;

public class Declaration {
	
	Type type;
	String location;
	
	public Declaration(Type _type, String _location) {
		type = _type;
		location = _location;
	}
	
	public String getLocation() {
		return this.location;
	}

}
