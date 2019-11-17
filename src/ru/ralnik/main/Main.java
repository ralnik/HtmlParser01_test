package ru.ralnik.main;

import ru.ralnik.entities.Catalog;
import ru.ralnik.parser.htmlparser.file.HtmlFileParser;
import ru.ralnik.parser.htmlparser.string.HtmlStringParser;
import ru.ralnik.parser.htmlparser.url.HtmlUrlParser;

public class Main {

	public static void main(String[] args) {
//		������ �� URL-�
		HtmlUrlParser parser = new HtmlUrlParser("https://www.dns-shop.ru/catalog/markdown/");
		parser.run();
		parser.exportToCsv("c:\\temp\\temp.csv");

//		������ �� ������
//		String htmlString = "<!DOCTYPE html>"
//                + "<html>"
//                + "<head>"
//                + "<title>JSoup Example</title>"
//                + "</head>"
//                + "<body>"
//                + "<table><tr><td><h1>HelloWorld</h1></tr>"
//                + "</table>"
//                + "</body>"
//                + "</html>";
//		
//	
//		HtmlStringParser parser = new HtmlStringParser(htmlString);
//		parser.run();
		
//		������ �� �����
//		HtmlFileParser parser = new HtmlFileParser("index.html");
//		parser.run();
	}

}
