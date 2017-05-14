/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer.processanalyze;

import com.jezhumble.javasysmon.OsProcess;
import com.jezhumble.javasysmon.ProcessVisitor;
import virusanalyzer.Manager;

/**
 *
 * @author Chamath Abeysinghe
 */
public class Visitor implements ProcessVisitor {

    @Override
    public boolean visit(OsProcess proc, int i) {
        Manager.getManager().getReport().addString("Parent : "+ proc.processInfo().getParentPid()+" current : "+ proc.processInfo().getPid(), "");
        Manager.getManager().getReport().addString("Children : "+ proc.children().size(), "");
        for(Object child: proc.children()){
            if(child != null){
                Manager.getManager().getReport().addString("parent ID : "+ ((OsProcess)child).processInfo().getParentPid(), "");
                Manager.getManager().getReport().addString("name : "+ ((OsProcess)child).processInfo().getName(),"");
                Manager.getManager().getReport().addString("command : "+ ((OsProcess)child).processInfo().getCommand(), "");
                Manager.getManager().getReport().addString("Process Id : " + ((OsProcess)child).processInfo().getPid(), "");

            }
        }
        return false;
    }
}
