package br.com.pacdev.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlUtils {
	private static XmlUtils INSTANCE;
	public static XmlUtils getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new XmlUtils();
			INSTANCE.setFactory(XPathFactory.newInstance());
			INSTANCE.setxPath(INSTANCE.getFactory().newXPath());
		}
		return INSTANCE;
	}
	private XPathFactory factory = null;
    private XPath xPath = null;
	
	public Document string2xml(String xmlString){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		DocumentBuilder builder = null;
		Document document = null;
		try  
		{  
			builder = factory.newDocumentBuilder();  
			document = builder.parse( new InputSource( new StringReader( xmlString ) ) );  
		} catch (Exception e) {  
			e.printStackTrace();  
		} 
		return document;
	}

	public NodeList getElementByXPath(Document d, String stringXPath){
		NodeList ret = null;
	    try {
	    	ret = (NodeList) xPath.evaluate(stringXPath,d,XPathConstants.NODESET);
		} catch (Exception e2) { 
			ret = null;
		}
	    return ret;
	}
	public NodeList getNodeListByXPath(Document d, String stringXPath){
		NodeList ret = null;
	    try {
	    	ret = (NodeList) xPath.evaluate(stringXPath,d,XPathConstants.NODESET);
		} catch (Exception e2) { 
			ret = null;
		}
	    return ret;
	}
	public NodeList getNodeListByXPath(Element e, String stringXPath){
		NodeList ret = null;
	    try {
	    	ret = (NodeList) xPath.evaluate(stringXPath,e,XPathConstants.NODESET);
		} catch (Exception e2) { 
			ret = null;
		}
	    return ret;
	}
	
	public String getStringByXPath(Element e, String stringXPath){
		String ret = null;

	    try {
	    	ret = xPath.evaluate(stringXPath, e);
		} catch (Exception e2) { 
			ret = "";
		}
	    return ret;
	}

	public XPathFactory getFactory() {
		return factory;
	}

	public void setFactory(XPathFactory factory) {
		this.factory = factory;
	}

	public XPath getxPath() {
		return xPath;
	}

	public void setxPath(XPath xPath) {
		this.xPath = xPath;
	}
}
