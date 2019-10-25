package fatturaxml;
import static fatturaxml.FatturaXML.xmlFilePath;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Cagni Lorenzo
 */
public class modificaFattura {
    Scanner s = new Scanner(System. in);
    
    public void modificaFattura() {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            addElement(doc);

            writeXMLFile(doc);
        int finito=0;
        int scelta=3;
        Avviso dialogo = new Avviso();
        dialogo.setVisible(true);
        do{        
            do{
            scelta=dialogo.scelta();            
            }while(scelta==3);
        
        finito=1;        
        }while(finito==0);
        System.out.println(finito);
        
        if (finito==1){
        dialogo.setVisible(false);
        }

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }

    private static void writeXMLFile(Document doc)
    throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        doc.getDocumentElement().normalize();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(xmlFilePath));
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source, result);
        System.out.println("XML modificato con successo.");
    }


    private static void addElement(Document doc) {
        
        String nomeMod;
        String nuovoDat;
        String nuovoVal;
        
        JFrame3 pannello3 = new JFrame3();
            pannello3.setVisible(true);
            do{
            nomeMod=pannello3.nomeModifica();
            nuovoDat=pannello3.nuovoDato();
            nuovoVal=pannello3.nuovoValore();        
            }while(pannello3.contatore==0);
        pannello3.setVisible(false);
        
        
        NodeList users = doc.getElementsByTagName(nomeMod);
        Element emp = null;

        for (int i = 0; i < users.getLength(); i++) {
            emp = (Element) users.item(i);
            Element salaryElement = doc.createElement(nuovoDat);
            salaryElement.appendChild(doc.createTextNode(nuovoVal));
            emp.appendChild(salaryElement);
        }
    }

}


