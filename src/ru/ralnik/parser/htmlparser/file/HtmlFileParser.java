package ru.ralnik.parser.htmlparser.file;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.ralnik.parser.htmlparser.Parser;

public class HtmlFileParser extends Parser{

	public HtmlFileParser(String source) {
		super(source);
	}

	@Override
	public void run() {		
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File(this.getSource()), "ISO-8859-1");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // right
        String title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);
        
        
        Elements  form = htmlFile.getElementsByTag("form");
        System.out.println("test: "+ form.text());
        for(Element input: form.select("input")) {
        	System.out.println(input.attr("id"));
        }
	}

	@Override
	public void exportToCsv(String filename) {
		
	}

}
