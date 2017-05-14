/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer;

/**
 *
 * @author Chamath Abeysinghe
 */
public class Manager {
    
    private static Manager manager;
    private Report report;
    private HashMatch hashMatch;
    private FileMatch fileMatch;
    private ProcessMatch processMatch;
    
    private Manager(){
        report=new Report();
        hashMatch=new HashMatch();
        fileMatch=new FileMatch();
        processMatch=new ProcessMatch();
    }
    
    public static Manager getManager(){
        if(manager==null){
            manager=new Manager();
        }
        return manager;
    }
    
    public Report getReport(){
        return report;
    }
    
    public void checkFile(String path){
        hashMatch.isMatch(path);
        fileMatch.findFileType(path);
        processMatch.runProcess(path);
    }
    
}
