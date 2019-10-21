/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 72873486
 */
public class XmlReader {
    public void readXml(String path, String fileName){
		File file = new File(path + fileName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			
			//obtain a list with all nodes called "Student"
			NodeList nList = doc.getElementsByTagName("Student");
			Node nNode =null;
			//walks the node list 
			for(int i = 0; i < nList.getLength(); i++){
				nNode = nList.item(i);
				System.out.println("\n Current Element " + nNode.getNodeName() + " " + i);
                       
				if(nNode.getNodeType()== Node.ELEMENT_NODE){
					Element element = (Element) nNode; // convert the node to element
                                        System.out.println(element);
					System.out.println("name: " + element.getElementsByTagName("Name").item(0).getTextContent());
                                        System.out.println("Cognome: " + element.getElementsByTagName("Cognome").item(0).getTextContent());
					System.out.println("Age: " + element.getElementsByTagName("Age").item(0).getTextContent());
					System.out.println("Sex: " + element.getElementsByTagName("Sex").item(0).getTextContent());
                                        System.out.println("Number: " + element.getElementsByTagName("Number").item(0).getTextContent());
				}
			}
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Deserializer the xml in Student
	public ArrayList<Student> deserializerStudent(String path, String fileName){
		//the paht where the file will be store
		String filePath = path+fileName;
                
		//Pull the file from the path and store him 
		File file = new File(filePath);
                
                
                
		ArrayList<Student>students=new ArrayList<>();
		Student student = null;
		//creating a new intance of Document Build Factory
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		
		try {
			
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//read the xml and store in dom 
			Document dom = dBuilder.parse(file);
			dom.getDocumentElement().normalize();
			//find all nodes with tag Student and store in Node List
			NodeList nList = dom.getElementsByTagName("Student");
			Node node = null;
			
			for(int i = 0; i < nList.getLength(); i++){
				//recive the current node
				node = nList.item(i);
				// if the node is an element ?
				if(node.getNodeType() == Node.ELEMENT_NODE){
					//convert the node to element
					Element element = (Element)node;
					//creating a new student
					student = new Student();
					//fill the student attributes
					//syntax: get the element by his tag to return the text content
					student.setName(element.getElementsByTagName("Name").item(0).getTextContent());
                                        student.setCognome(element.getElementsByTagName("Cognome").item(0).getTextContent());
					student.setAge(Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent()) );
					student.setSex(Boolean.parseBoolean(element.getElementsByTagName("Sex").item(0).getTextContent()));
                                        student.setTelNumber(element.getElementsByTagName("Number").item(0).getTextContent());
				}
				//add the student to list of Student
				students.add(student);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return students;
	}
}
