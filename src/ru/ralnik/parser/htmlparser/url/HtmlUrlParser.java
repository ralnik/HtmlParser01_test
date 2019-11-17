package ru.ralnik.parser.htmlparser.url;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import ru.ralnik.entities.Catalog;
import ru.ralnik.parser.htmlparser.Parser;

public class HtmlUrlParser extends Parser {
	private String browser = Browsers.CHROME;
	private String refferer = "http://www.google.com";
	

	public HtmlUrlParser(String source) {
		super(source);		
	}
	
	public void setBrowser(String typeOfBrowser) {
		this.browser = typeOfBrowser;
	}
	
	public void setRefferer(String refferer) {
		this.refferer = refferer;
	}

	@Override
	public void run() { 
		Document document;
      try {
          document = Jsoup.connect(this. getSource())
        		  .userAgent(this.browser)
                  .referrer(this.refferer)
                  .get();
      Elements lists = document.getElementsByAttributeValue("class", "product");
      for(Element products : lists) { 
    	  Catalog item = new Catalog();
    	  Element name = products.getElementsByAttributeValue("class", "ec-price-item-link").first();	
    	  item.setName(name.text());
    	  item.setUrl(name.attr("href"));
//    	  System.out.println("name: " + name.text()) ;
//    	  System.out.println("link: " + name.attr("href"));
    	  
    	  Element price = products.getElementsByAttributeValue("data-of", "price-total").first();
    	  item.setPrice(price.text());
//    	  System.out.println("price: " + price.text());
//    	  System.out.println("***************************");
    	  super.list.add(item); 
      }
      } catch (IOException e) {
          e.printStackTrace();
      }
      System.out.println("parsering complete!!!" );	
	}

	@Override
	public void exportToCsv(String filename) {
		FileWriter writer = null;
		try {			
			writer = new FileWriter(new File(filename));
			writer.write(new Catalog().toStringTitle() + "\n");
			for(Catalog item : this.list) {
				writer.write(item.toString() + "\n");
				writer.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
