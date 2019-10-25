package fatturaxml;

import static fatturaxml.FatturaXML.xmlFilePath;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/**
 *
 * @author Cagni Lorenzo
 */
public class CreazioneFattura {
    Scanner s = new Scanner(System. in);
    String xml;
    // persona
        public int creazioneNuovaFatturaXML() throws InterruptedException{
            
        // Creazione fattura nuova
            int numeroPersone=0;
            JFrame pannello = new JFrame();
            pannello.setVisible(true);
            do{
            numeroPersone=pannello.prova();
            }while(numeroPersone==0);
            pannello.setVisible(false);
           
                        
            Element persona[] = new Element[numeroPersone];
            String nomi[] = new String[numeroPersone];
            String cognomi[] = new String[numeroPersone];
            String telefoni_casa[] = new String[numeroPersone];
            String telefoni_lavoro[] = new String[numeroPersone];
            String indirizzi_email[] = new String[numeroPersone];
        
            
        // creazione persone e assegnazione variabili
            for(int i=0;i<numeroPersone;i++){
            persona[i] = new Element() {
            @Override
            public String getTagName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getAttribute(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setAttribute(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeAttribute(String string) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Attr getAttributeNode(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Attr setAttributeNode(Attr attr) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Attr removeAttributeNode(Attr attr) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public NodeList getElementsByTagName(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getAttributeNS(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setAttributeNS(String string, String string1, String string2) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeAttributeNS(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Attr getAttributeNodeNS(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Attr setAttributeNodeNS(Attr attr) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public NodeList getElementsByTagNameNS(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean hasAttribute(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean hasAttributeNS(String string, String string1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public TypeInfo getSchemaTypeInfo() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setIdAttribute(String string, boolean bln) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setIdAttributeNS(String string, String string1, boolean bln) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setIdAttributeNode(Attr attr, boolean bln) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getNodeName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getNodeValue() throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setNodeValue(String string) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public short getNodeType() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node getParentNode() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public NodeList getChildNodes() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node getFirstChild() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node getLastChild() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node getPreviousSibling() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node getNextSibling() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public NamedNodeMap getAttributes() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Document getOwnerDocument() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node insertBefore(Node node, Node node1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node replaceChild(Node node, Node node1) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node removeChild(Node node) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node appendChild(Node node) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean hasChildNodes() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Node cloneNode(boolean bln) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void normalize() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isSupported(String string, String string1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getNamespaceURI() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getPrefix() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setPrefix(String string) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getLocalName() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean hasAttributes() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getBaseURI() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public short compareDocumentPosition(Node node) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getTextContent() throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void setTextContent(String string) throws DOMException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isSameNode(Node node) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String lookupPrefix(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isDefaultNamespace(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String lookupNamespaceURI(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEqualNode(Node node) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object getFeature(String string, String string1) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object setUserData(String string, Object o, UserDataHandler udh) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object getUserData(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
            
            nomi[i]= new String();
            cognomi[i] = new String();
            telefoni_casa[i]= new String();
            telefoni_lavoro[i]= new String();
            indirizzi_email[i]= new String(); 
        }    
        
        for(int i=0;i<numeroPersone;i++){
            JFrame2 pannello2 = new JFrame2();
            pannello2.setVisible(true);
            do{
            nomi[i]=pannello2.nome();
            cognomi[i]=pannello2.cognome();
            telefoni_casa[i]=pannello2.telefono_casa();
            telefoni_lavoro[i]=pannello2.telefono_lavoro();
            indirizzi_email[i]=pannello2.email();            
            }while(pannello2.contatore==0);
            pannello2.setVisible(false);
            
            //System.out.println("Inserisci il nome della persona numero "+(i+1)+" che vuoi aggiungere in rubrica.");
            //    nomi[i]= s.next();
                nomi[i] = nomi[i].replaceAll("\\s+","");
            //System.out.println("Inserisci il cognome della persona numero "+(i+1)+" che vuoi aggiungere in rubrica.");
            //    cognomi[i] = s.next();
                cognomi[i] = cognomi[i].replaceAll("\\s+","");
            //System.out.println("Inserisci il telefono di casa della persona numero "+(i+1)+" che vuoi aggiungere in rubrica.");
            //    telefoni_casa[i] = s.next();
                telefoni_casa[i] = telefoni_casa[i].replaceAll("\\s+","");
            //System.out.println("Inserisci il telefono di lavoro della persona numero "+(i+1)+" che vuoi aggiungere in rubrica.");
            //    telefoni_lavoro[i] = s.next();
                telefoni_lavoro[i] = telefoni_lavoro[i].replaceAll("\\s+","");
            //System.out.println("Inserisci l'indirizzo email della persona numero "+(i+1)+" che vuoi aggiungere in rubrica.");
            //    indirizzi_email[i] = s.next();
                indirizzi_email[i] = indirizzi_email[i].replaceAll("\\s+","");
                    
        }   

            
            
        try {
 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            

            Element rubrica = document.createElement("rubrica");
            document.appendChild(rubrica);

           
            // ciclo for per le persone
            for(int i=0;i<numeroPersone;i++){
            
            persona[i] = document.createElement("persona");
            rubrica.appendChild(persona[i]); 
 
            Element nome = document.createElement("nome");
            nome.appendChild(document.createTextNode(nomi[i]));
            persona[i].appendChild(nome);
 
            Element cognome = document.createElement("cognome");
            cognome.appendChild(document.createTextNode(cognomi[i]));
            persona[i].appendChild(cognome);
 
            Element telefono_casa = document.createElement("telefono_casa");
            telefono_casa.appendChild(document.createTextNode(telefoni_casa[i]));
            persona[i].appendChild(telefono_casa);
 
            Element telefono_lavoro = document.createElement("telefono_lavoro");
            telefono_lavoro.appendChild(document.createTextNode(telefoni_lavoro[i]));
            persona[i].appendChild(telefono_lavoro);
            
            Element indirizzo_email = document.createElement("indirizzo_email");
            indirizzo_email.appendChild(document.createTextNode(indirizzi_email[i]));
            persona[i].appendChild(indirizzo_email);
            
            }
            
 
            // creazione file xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
  
            transformer.transform(domSource, streamResult);
 
            System.out.println("Fattura XML creata con successo.");
            
            } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        
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
        
        return finito;

        }
            
        
    
}
