package cps450;

import java.util.Iterator;
import java.util.Stack;

public class SymbolTable {
	
	Stack<Symbol> symbols;
	Integer level;
	
	public SymbolTable() {
		symbols = new Stack<Symbol>();
		level = 0;
	}
	
	Symbol push(String name, Declaration decl) {
		Symbol symbol = new Symbol(name, getScope(), decl);
		symbols.push(symbol);
		return symbol;
	}
	
	Symbol scopeContains(String name) {
		Symbol symbol = null;
		for (Iterator<Symbol> i = symbols.iterator(); i.hasNext();) {
			symbol = i.next();
			if (symbol.getScope() == this.getScope()) {
				if (symbol.getName().equals(name)) {
					return symbol;
				}
			} else {
				break;
			}
		}
		return null;
	}
	
	Symbol lookup(String name) {
		Symbol symbol = null;
		for (Iterator<Symbol> i = symbols.iterator(); i.hasNext();) {
			symbol = i.next();
			if (symbol.getName().equals(name)) {
				return symbol;
			}
		}
		return null;
	}
	
	void beginScope() {
		level += 1;
	}
	
	void endScope() {
		level -= 1;
	}
	
	Integer getScope() {
		return level;
	}
	
}
