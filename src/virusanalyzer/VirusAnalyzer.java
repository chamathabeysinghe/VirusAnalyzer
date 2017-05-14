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
public class VirusAnalyzer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMatch h=new HashMatch();
        boolean b=h.isMatch("C:\\Projects\\VirusAnalyzer\\build.xml");
//        System.out.println(b);
    }
    
}
