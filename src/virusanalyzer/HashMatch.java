/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chamath Abeysinghe
 */
public class HashMatch {
    private ArrayList<String> hashList=new ArrayList<String>();
    
    HashMatch(){
        try (
            BufferedReader br = new BufferedReader(new FileReader(new File("VirusShare_00000.md5.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
               // process the line.
               hashList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(HashMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String findHash(String path){
        try {
            FileInputStream fis = new FileInputStream(new File(path));
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(fis);
            System.out.println(md5);
            fis.close();
            return md5;
            
        } catch (IOException ex) {
            Logger.getLogger(HashMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean isMatch(String path){
        String hash=findHash(path);
        boolean status= hashList.contains(hash);
        if(status){
            Manager.getManager().getReport().addString("File is detected as a virus", "Status : ");
            Manager.getManager().getReport().addString(hash, "MD5 Signature : ");
        
        }
        else{
            Manager.getManager().getReport().addString("File is not a virus", "Status : ");
            Manager.getManager().getReport().addString(hash, "MD5 Signature : ");
        }
            
        return status;
                
    }
}
