/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import virusanalyzer.processanalyze.ProcessAnalyzer;
import virusanalyzer.processanalyze.Snapshot;
import virusanalyzer.processanalyze.Visitor;

/**
 *
 * @author Chamath Abeysinghe
 */
public class ProcessMatch {

    public void runProcess(String path) {
        try {
            ProcessAnalyzer da = new ProcessAnalyzer();
            da.start();
            
            Process process = Runtime.getRuntime().exec(path);
            InputStream is = process.getErrorStream();
            
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            
//            System.out.printf("Output of running %s is:", Arrays.toString(args));
            
            int i=0;
            while(i<10){
                i+=1;
                try {
                    Thread.sleep(100);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProcessMatch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }
            
            da.stop();
            
            process.destroy();
            Snapshot s=da.getSnapshots().get(da.getSnapshots().size()-1);
            Manager.getManager().getReport().addString("", "=== Process Treee ===");
            s.getProcessTree(da.getPid()).accept(new Visitor(), 0);
            
        } catch (IOException ex) {
            Manager.getManager().getReport().addString("", "=== Not a executable file ===");

        }
    }

}
