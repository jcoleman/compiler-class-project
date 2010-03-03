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
		for (int i = symbols.size() - 1; i >= 0; i--) {
			symbol = symbols.get(i);
			if (symbol.getScope().equals(this.getScope())) {
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
		for (int i = symbols.size() - 1; i >= 0; i--) {
			symbol = symbols.get(i);
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
		for (int i = symbols.size() - 1; i >= 0; i--) {
			Symbol symbol = symbols.get(i);
			if (symbol.getScope().equals(this.getScope())) {
				symbols.remove(i);
			} else {
				break;
			}
		}
		level -= 1;
	}
	
	Integer getScope() {
		return level;
	}
	
}
