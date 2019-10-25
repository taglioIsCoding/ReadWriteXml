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
public class eliminaFattura {
    Scanner s = new Scanner(System. in);
    
    public void modificaFattura() {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();


            deleteElement(doc);

            writeXMLFile(doc);
            
            // Operazione eseguita con successo
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

 
    private static void deleteElement(Document doc) {
        String nomeMod;
        String nuovoDat;
        
        JFrame4 pannello4 = new JFrame4();
            pannello4.setVisible(true);
            do{
            nomeMod=pannello4.nomeModifica();
            nuovoDat=pannello4.nuovoDato();
            }while(pannello4.contatore==0);
        pannello4.setVisible(false);
        
        
        NodeList users = doc.getElementsByTagName(nomeMod);
        Element user = null;
        // loop
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            Node emailNode = user.getElementsByTagName(nuovoDat).item(0);
            user.removeChild(emailNode);
        }

    }

}


