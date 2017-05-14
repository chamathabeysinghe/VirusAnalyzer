/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer.processanalyze;

import com.jezhumble.javasysmon.OsProcess;

/**
 *
 * @author Chamath Abeysinghe
 */
public class Snapshot {
    
    private OsProcess processTree;
    
    public Snapshot(OsProcess processTree){
        this.processTree = processTree;
    }
    
    public OsProcess getProcessTree(){
        return this.processTree;
    }
    
    public OsProcess getProcessTree(int pid){
        return this.processTree.find(pid);
    }
}
