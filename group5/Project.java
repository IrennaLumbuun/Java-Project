package group5;

import javax.swing.JFrame;

/**
 * Main class that launches the GUI.
 *
 * @author group5
 * @version 12/2/2018
 */
public class Project {

    /**
     *  Main method that launches the GUI.
     * 
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        LibraryGui view = new LibraryGui("Library");
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        view.pack(); //makes JFrame as small as possible
        view.setVisible(true);
    }
       
        
 }
    

