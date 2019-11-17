package ru.ralnik.entities;

public class Catalog {
	private String name;
	private String url;
	private String price;
	
	public Catalog(String name, String url, String price) {
		this.name = name;
		this.url = url;
		this.price = price;
	}
	
	public Catalog() {}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}

	public String getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String toStringTitle() {
		return "name;url;price";	
	}
	@Override
	public String toString() {
		return this.name + ";" + this.url + ";" + this.price;
	}
}
