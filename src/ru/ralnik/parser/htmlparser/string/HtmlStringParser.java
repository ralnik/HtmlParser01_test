package ru.ralnik.parser.htmlparser.string;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import ru.ralnik.parser.htmlparser.Parser;

public class HtmlStringParser extends Parser{

	public HtmlStringParser(String source) {
		super(source);
	}

	@Override
	public void run() {
		Document html = Jsoup.parse(this.getSource());
        String title = html.title();
        String h1 = html.body().getElementsByTag("h1").text();
        
        System.out.println("Input HTML String to JSoup :" + this.getSource());
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);
	}

	@Override
	public void exportToCsv(String filename) {
		
	}
	
	
}
