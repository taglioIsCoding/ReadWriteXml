/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author 72873486
 */
public class XmlWriter {
   
    
    public void serializerStudents(String path, String fileName, ArrayList<Student> listStudents){
		String filePath = path+fileName;
		Document dom;
		Element element = null;
		//creat a DocumentBuilderFactoy instance
		DocumentBuilderFactory dBFactory = DocumentBuilderFactory.newInstance();
		try {
			
			DocumentBuilder dBuilder = dBFactory.newDocumentBuilder();
			dom = dBuilder.newDocument();
			//creating the root element whith name Students
			Element rootElement = dom.createElement("Students");
			
			for (Student student : listStudents) {
				//Create a new element called Student
				element =dom.createElement("Student");
				//call the metod to parse a Student class to elements
				element = addNewStudent(student, element, dom);
				//add to root element a new element
				rootElement.appendChild(element);
			}
			//add to document all elements creating above
			dom.appendChild(rootElement);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			//transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "elementos.dtd");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(new DOMSource(dom), new StreamResult(new FileOutputStream(filePath)));
			
		} catch (ParserConfigurationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (TransformerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Serialize the class student in elements
	private Element addNewStudent (Student student, Element currentElement,Document dom){
		Element element = null;
		if(student !=null){
			//creating a new Element called Name
			element = dom.createElement("Name");
			element.appendChild(dom.createTextNode(student.getName()));
                        currentElement.appendChild(element);
                        
			//made this new element be an child element of current element
                        element = dom.createElement("Cognome");
			element.appendChild(dom.createTextNode(student.getCognome()));
			currentElement.appendChild(element);
			element =dom.createElement("Age");
			element.appendChild(dom.createTextNode(Integer.toString(student.getAge())));
			currentElement.appendChild(element);
			element = dom.createElement("Sex");
			element.appendChild(dom.createTextNode(Boolean.toString(student.isSex())));
                        currentElement.appendChild(element);
                        element = dom.createElement("Number");
			element.appendChild(dom.createTextNode(student.getTelNumber()));
			currentElement.appendChild(element);
		}
                System.out.println(currentElement);
		return currentElement;
	}
}
