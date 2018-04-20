/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import Modèle.Connexion;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.sql.SQLException;


/**
 *
 * @author solen
 */
public class AffichageGraphique {
        private int choix;
        private Fenetre fenetre1;
        private Connexion conloc;

   public AffichageGraphique() throws SQLException, ClassNotFoundException
   {
       
        conloc=new Connexion("hopital","root","");
         fenetre1=new Fenetre();
   
   }
    public void affichageMenu() throws SQLException, ClassNotFoundException
    {  
           fenetre1.menu();
           
           
    
    }
        


}

