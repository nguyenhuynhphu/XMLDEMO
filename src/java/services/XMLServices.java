/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Administrator
 */
public class XMLServices implements Serializable{
    public static boolean parseFileToSax(String filePath, DefaultHandler handler) throws SAXException, IOException, ParserConfigurationException {
        if (handler == null) {
            return false;
        }
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser sax = factory.newSAXParser();
        sax.parse(filePath, handler);
        return true;
    }
    public static Document parseFileToDom(String filePath) throws SAXException, IOException, ParserConfigurationException{
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.parse(filePath);
        return doc;
    }
    
    public static void transformDOMToFile(Node node, String filePath) throws TransformerConfigurationException, TransformerException{
        Source src = new DOMSource(node);
        
        File file = new File(filePath);
        Result result = new StreamResult(file);
        
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer trans = factory.newTransformer();
        
        trans.transform(src, result);
    }
    public static Element createElement(Document doc, String name, String value, Map<String, String> atts){
        if(doc != null){
            Element ele = doc.createElement(name);
            if(value != null){
                ele.setTextContent(value);
            }
            if(atts != null){
                if (!atts.isEmpty()) {
                    for (Map.Entry<String, String> x : atts.entrySet()) {
                        ele.setAttribute(x.getKey(), x.getValue());
                    }
                }
            }
            return ele;
        }
        return null;
    }
    
}
