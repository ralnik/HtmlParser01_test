package ru.ralnik.parser.htmlparser;

import java.util.ArrayList;

import ru.ralnik.entities.Catalog;

public abstract class Parser {	
	private String source;
	public ArrayList<Catalog> list;

	public Parser(String source) {
		this.source = source;
		this.list = new ArrayList<>();
	}
			
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}	

	public ArrayList<Catalog> getList() {
		return list;
	}

	public abstract void run();
	public abstract void exportToCsv(String filename);

}
