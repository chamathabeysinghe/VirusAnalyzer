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
    
    private Manager(){
        manager=new Manager();
        report=new Report();
        hashMatch=new HashMatch();
        fileMatch=new FileMatch();
    }
    
    public static Manager getManager(){
        if(manager==null){
            manager=new Manager();
        }
        return manager;
    }
    
    
}
