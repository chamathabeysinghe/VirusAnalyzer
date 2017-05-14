/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Chamath Abeysinghe
 */
public class FileMatch {
    
    public void findFileType(String pathStr){
        
        File f=new File(pathStr);
        Manager.getManager().getReport().addString(f.getName(), "File Name : ");
        
        try {
            Path path=FileSystems.getDefault().getPath(pathStr);
            String contentType=Files.probeContentType(path);
            Manager.getManager().getReport().addString(contentType, "ContentType : ");
        } catch (IOException ex) {
            Logger.getLogger(FileMatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ext1 = FilenameUtils.getExtension(pathStr); // returns "txt"
        Manager.getManager().getReport().addString(ext1, "Extension : ");
    }
}
