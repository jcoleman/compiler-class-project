package cps450;

import java.util.Hashtable;

public class Type {
	
	private String id;
	
	private static Hashtable<String, Type> types;
	
	public static void intialize() {
		if (types == null) {
			types = new Hashtable<String, Type>();
		}
	}
	
	private Type(String _id) {
		id = _id;
	}
	
	public static Type getType(String id) {
		if (types.containsKey(id)) {
			return types.get(id);
		} else {
			Type type = new Type(id);
			types.put(id, type);
			return type;
		}
	}
	
	public String getName() {
		return id;
	}
	
}
