/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

import java.util.ArrayList;

/**
 *
 * @author 72873486
 */
public class RubricaXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String fileName = "xmlTest.xml";
		//change here!
		String path = "C:/Users/72873486/Desktop/";
		XmlWriter xmlWriter = new XmlWriter();
		XmlReader xmlReader = new XmlReader();
		
		ArrayList<Student> students = new ArrayList<>();
		//creating studants
		Student student1 = new Student("Paulo", 25, false, "03011111");
		Student student2 = new Student("Jessica", 25, true, "0302222");
		Student student3 = new Student("Icaro", 19 , false, "0303333333");
		Student student4 = new Student("Ana", 67, true, "030444444");
                Student student5 = new Student("Pezzott", 67, true, "030444444");
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
                students.add(student5);
		
		//Serializer the list of studants in xml
		xmlWriter.serializerStudents(path, fileName, students);
		//Read and print the Xml
		xmlReader.readXml(path,fileName);
		//Deserializer as a Students List
		students.clear();
		students = xmlReader.deserializerStudent(path, fileName);
		Student novo = students.get(0);
		
		System.out.println(novo.getName());
    }
    
}
