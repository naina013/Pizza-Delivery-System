package question5;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.*;

public class ParseModules {
	boolean inPizzas = false;    
	boolean inpizza = false;
	boolean inId = false;
	boolean inName = false;
	boolean inBase = false;
	boolean inTopping = false;
	
	Pizza currentModule = new Pizza();
	List<Pizza> currentModuleList = new ArrayList<Pizza>();
	
	public List<Pizza> doParseModules(String s) {
		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			XmlPullParser pullParser = factory.newPullParser();
			pullParser.setInput(new StringReader(s));
			processDocument(pullParser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentModuleList;
	}
	
	public void processDocument(XmlPullParser pullParser) throws XmlPullParserException, IOException {
		int eventType = pullParser.getEventType();
		do {
			if (eventType == XmlPullParser.START_DOCUMENT) {
				System.out.println("Start Document");
			} 
			else if (eventType == XmlPullParser.END_DOCUMENT) {
				System.out.println("End Document");
			} 
			else if (eventType == XmlPullParser.START_TAG) {
				processStartElement(pullParser);
			} 
			else if (eventType == XmlPullParser.END_TAG) {
				processEndElement(pullParser);
			} 
			else if (eventType == XmlPullParser.TEXT) {
				processText(pullParser);
			}
			eventType = pullParser.next();
		} while (eventType != XmlPullParser.END_DOCUMENT);
	}
	
	public void processStartElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("pizzas")) {
			inPizzas = true;
			currentModuleList = new ArrayList<Pizza>();
		}
		else if (name.equals("Pizza")) {
			inpizza = true;
			currentModule = new Pizza();
		} 
		else if (name.equals("id")) {
			inId = true;
		} 
		else if (name.equals("name")) {
			inName = true;
		} 
		else if (name.equals("base")) {
			inBase = true;
		} 
		else if (name.equals("topping")) {
			inTopping = true;
		}
	}
	
	public void processEndElement(XmlPullParser event) {
		String name = event.getName();
		if (name.equals("pizzas")) {
			inPizzas = false;
		}
		else if (name.equals("Pizza")) {
			inpizza = false;
			currentModuleList.add(currentModule);
			
		} 
		
		else if (name.equals("id")) {
			inId = false;
		} 
		else if (name.equals("name")) {
			inName = false;
		} 
		else if (name.equals("base")) {
			inBase = false;
		} 
		else if (name.equals("topping")) {
			inTopping = false;
		}
	}

	public void processText(XmlPullParser event) throws XmlPullParserException {
		if(inId) {
			String s = event.getText();
			currentModule.setId(Integer.parseInt(s));
		}
		if(inName) {
			String s = event.getText();
			currentModule.setName(s);;
		}
		if(inBase) {
			String s = event.getText();
			currentModule.setBase(s);
		}
		if(inTopping) {
			String s = event.getText();
			currentModule.setTopping(s);
		}
	}
}
