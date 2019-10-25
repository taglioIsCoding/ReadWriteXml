package fatturaxml;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.lang.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Cagni Lorenzo
 */
public class FatturaXML {

    public static final String xmlFilePath = "fattura.xml";
    
    public static void main(String argv[]) throws InterruptedException, IOException {
 
        funzioni controllo = new  funzioni();
        int esiste=controllo.controlloEsistenza();
        
        
        if (esiste==1){
            int finito=0;
            int scelta=3;
            fileEsistenteAvviso avviso = new fileEsistenteAvviso();
            avviso.setVisible(true);
                do{        
                    do{
                    scelta=avviso.scelta();            
            }while(scelta==3);
        
            finito=1;        
            }while(finito==0);
            System.out.println(finito);
            
            if (finito==1){
            avviso.setVisible(false);
            File file = new File(xmlFilePath);

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        }

        
        gestioneFatture fatturaNuova = new  gestioneFatture();
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
        
        
            fatturaNuova.gestioneFatture();

        
    }
        
        
    
}
