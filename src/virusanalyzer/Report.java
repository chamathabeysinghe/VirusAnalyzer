/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virusanalyzer;

import java.util.ArrayList;

/**
 *
 * @author Chamath Abeysinghe
 */
public class Report {
    private ArrayList<String> results=new ArrayList<String>();
    private ArrayList<String> topic=new ArrayList<>();
    public void addString(String s,String t){
        results.add(s);
        topic.add(t);
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public ArrayList<String> getTopic() {
        return topic;
    }
    
}
