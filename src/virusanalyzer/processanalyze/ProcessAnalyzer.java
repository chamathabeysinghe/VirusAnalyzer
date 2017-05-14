/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer.processanalyze;

import com.jezhumble.javasysmon.JavaSysMon;
import com.jezhumble.javasysmon.OsProcess;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chamath Abeysinghe
 */


public class ProcessAnalyzer extends Thread{

    private JavaSysMon systemMonitor;
    
    private List<Snapshot> snapshots;
    
    private int pid;
    
    public ProcessAnalyzer(){
        super();
        this.systemMonitor = new JavaSysMon();
        this.snapshots = new ArrayList();
    }
    
    
    @Override
    public void run() {
        
        this.pid = this.systemMonitor.currentPid();
        
        while(true){
            try {
                this.snapshots.add(new Snapshot(this.systemMonitor.processTree()));
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProcessAnalyzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Snapshot> getSnapshots(){
        return this.snapshots;
    }
    
    public int getPid(){
        return this.pid;
    }
}

