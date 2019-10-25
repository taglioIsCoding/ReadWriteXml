/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatturaxml;

import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.exists;

/**
 *
 * @author 75844087
 */
public class funzioni {
    
    public int controlloEsistenza(){
        File temp;
        int esiste=0;
        boolean exists = false;
        
        try
        {
        temp = File.createTempFile("fattura", ".xml");
          
        exists = temp.exists();
          
        System.out.println("Temp file exists : " + exists);
        } catch (IOException e)
        {
         e.printStackTrace();
        }
        if (exists==true){
            esiste=1;
        }
        
        return esiste;
}
    
}
