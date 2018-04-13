/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.util.ArrayList;
import vue.AffichageConsole;
import controleur.JavaApplication7;
import Modèle.Connexion;
import Modèle.Recherche;
import java.sql.SQLException;
import vue.FenetreJp;
/**
 *
 * @author solen
 */
public class Recherche {
    
     private FenetreJp fen=new FenetreJp();
    public Recherche() throws SQLException, ClassNotFoundException
    {
          
    }
    
    public void rechercher() throws SQLException, ClassNotFoundException{
      Connexion conloc;
     conloc=new Connexion("hopital","root","");
    // Connexion conece;
     //conece = new Connexion("sl152003", "attelage1OO."," sl152003-rw","4muIKuY8" );
        
        String mutuelle="LMDE";
      String requete ="SELECT nom,prenom FROM MALADE WHERE mutuelle='"+mutuelle+ "'";
                   conloc.ajouterRequete(requete);
                 
                       ArrayList<String> liste;
        liste = new ArrayList<String>();
       liste=conloc.remplirChampsRequete(requete);
         //AffichageConsole interfaceC=new AffichageConsole();
         //interfaceC.affichageRequete(liste);
      
        

    }
    
    
    
}
