package ru.ralnik.main;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
	
    public HtmlParser() {

        // Parse HTML String using JSoup library
        String HTMLSTring = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<title>JSoup Example</title>"
                + "</head>"
                + "<body>"
                + "<table><tr><td><h1>HelloWorld</h1></tr>"
                + "</table>"
                + "</body>"
                + "</html>";

        Document html = Jsoup.parse(HTMLSTring);
        String title = html.title();
        String h1 = html.body().getElementsByTag("h1").text();

        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);

        // JSoup Example 2 - Reading HTML page from URL
//        Document doc;
//        try {
//            doc = Jsoup.connect("http://google.com/").get();
//            title = doc.title();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Jsoup Can read HTML page from URL, title : " + title);

        // JSoup Example 3 - Parsing an HTML file in Java
        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("index.html"), "ISO-8859-1");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // right
        title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);
        
        
        Elements  form = htmlFile.getElementsByTag("form");
        System.out.println("ewrwer: "+ form.text());
        for(Element input: form.select("input")) {
        	System.out.println(input.attr("id"));
        }
    }
}
