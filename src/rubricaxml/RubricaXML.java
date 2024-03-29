/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubricaxml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
		String path = "./";
                
                //start GUI
                GUI gui = new GUI();
                gui.doAll();
                
                
		//controllo se esiste il file
                File f = new File(fileName+path);
                if(!f.exists()){
                    System.out.println("Non c'e'");
                    gui.createAllert();
                }
                
                XmlWriter xmlWriter = new XmlWriter();
		XmlReader xmlReader = new XmlReader();
		
                
                
                
		ArrayList<Student> students = new ArrayList<>();
		//creating studants
		Student student1 = new Student("Paulo","Bello", 25, false, "03011111");
		Student student2 = new Student("Jessica","Tranqillo", 25, true, "0302222");
		Student student3 = new Student("Icaro", "Rossi",19 , false, "0303333333");
		Student student4 = new Student("Ana","Bianchi", 67, true, "030444444");
                Student student5 = new Student("Pezzott", "Verdi",67, true, "030444444");
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
