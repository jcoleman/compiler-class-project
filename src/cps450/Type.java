package cps450;

import java.util.Hashtable;

public class Type {
	
	private String id;
	private Boolean primitive;
	
	private static Hashtable<String, Type> types;
	
	public static void intialize() {
		if (types == null) {
			types = new Hashtable<String, Type>();
		}
	}
	
	private Type(String _id, Boolean _primitive) {
		id = _id;
		primitive = _primitive;
	}
	
	public static Type getType(String id) {
		if (id.equals("string")) {
			id = "String"; // Always use the class String
		}
		
		if (types.containsKey(id)) {
			return types.get(id);
		} else {
			Type type = new Type(id, id.equals("int") || id.equals("boolean"));
			types.put(id, type);
			return type;
		}
	}
	
	public String getName() {
		return id;
	}
	
	public Boolean isPrimitive() {
		return primitive;
	}
	
	public Boolean compatibleWith(Type type) {
		if (this.isPrimitive()) {
			return this == type;
		} else {
			return this == type || type.id.equals("null");
		}
	}
	
}
