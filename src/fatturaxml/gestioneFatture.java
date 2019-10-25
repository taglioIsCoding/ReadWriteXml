/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatturaxml;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import static fatturaxml.FatturaXML.xmlFilePath;
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
public class gestioneFatture {

    
    public void gestioneFatture() throws InterruptedException, IOException {
 
        System.out.println("Benvenuto");
        int continua=0;
        int finito=0;
        int scelta=3;
        


        // Schermata iniziale
        do{
        Inizio1 menu = new Inizio1();
        menu.setVisible(true);
        
            do{
            scelta=menu.scelta();            
            }while(scelta==3);
        
        finito++;
        menu.setVisible(false);
        }while(finito!=1);
        //menu.setVisible(false);
        
        int hey = 0;
        if (finito==1){
        if (scelta==0) {
        CreazioneFattura fattura = new CreazioneFattura();
        hey=fattura.creazioneNuovaFatturaXML();
        
        }
        
        if (hey==1){
      
        // Menu
        
        scelta=10;
        do {
        Inizio menu2 = new Inizio();
        menu2.setVisible(true);
        do{
            scelta=menu2.scelta();            
        }while(scelta==10);
        
        menu2.setVisible(false);
        
        switch (scelta){
            
            case 1:
            CreazioneFattura fattura = new CreazioneFattura();
            fattura.creazioneNuovaFatturaXML(); 
            apriFile();
            break;
            case 2:
            continua=1;
            menu2.setVisible(false);
            apriFile();
            break; 
            case 3:
            eliminaFattura fatturaNuova = new eliminaFattura();
            fatturaNuova.modificaFattura();
            apriFile();
            break; 
            case 0:
            modificaFattura nuovaFattura =new modificaFattura();
            nuovaFattura.modificaFattura();
            apriFile();
            
        }

        
        if (continua==0) {
        Continua scegli = new Continua();
        int scelta3=3;
        scegli.setVisible(true);
        do{
            scelta3=scegli.scelta();            
            }while(scelta3==3);
        continua = scegli.scelta();
        scegli.setVisible(false);
        }
        
        } while(continua==0);    
       
        }
        }
    }
    public void apriFile(){
            File file = new File(xmlFilePath);

        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        
        
    
}

