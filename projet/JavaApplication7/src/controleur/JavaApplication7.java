/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modèle.Connexion;
import Modèle.Recherche;
import Modèle.Statistiques;
import vue.AffichageConsole;
import vue.AffichageGraphique;
import vue.FenetreJp;

/**
 *
 * @author solen
 */
public class JavaApplication7 {
   /* private static final String USERNAME="sl152003-rw";
        private static final String PASSWORD="EWvHCReg";
            private static final String CONN_STRING="jdbc:mysql://localhost:3305";*/
             private static final String USERNAME="root";
        private static final String PASSWORD="";
            private static final String CONN_STRING="jdbc:mysql://localhost:3306/hopital";
            private static Connexion conloc;
            private static Connexion conece;
            
            public JavaApplication7() throws SQLException, ClassNotFoundException
            {
                  conloc=new Connexion("hopital",USERNAME,PASSWORD);
         // conece = new Connexion("sl152003", "attelage1OO."," sl152003-rw","4muIKuY8" );
            }
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(java.lang.String[] args) throws ClassNotFoundException, SQLException  {
        
        
        
        
        
        ///Bonjour j'ai bien été changé
           
                     //   Connection con=null;
                        // Connexion  conece;
                   
                 //    JavaApplication7 test= new JavaApplication7();
                     /*
                      Statement statement = null;
    ResultSet resultat = null;
                      try{
                     con = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD );
                     System.out.println("Connected");
                      statement = con.createStatement();
                     resultat = statement.executeQuery( "SELECT * FROM chambre;" );
                     
                       Récupération des données du résultat de la requête de lecture 
        while ( resultat.next() ) {
            int num = resultat.getInt( "surveillant" );
        
            /* Formatage des données pour affichage dans la JSP finale. 
            System.out.println( "Données retournées par la requête : surveillant = " +num);
        }
                     } catch(SQLException e){
                     System.err.println("e");
                    */
                     
                     
            //       System.out.println("Connected");
             /*      String requete ="SELECT * FROM CHAMBRE ";
                   conloc.ajouterRequete(requete);
                  
                           ArrayList<String> liste;
        liste = new ArrayList<String>();
        liste=conloc.remplirChampsRequete(requete);
         AffichageConsole interfaceC=new AffichageConsole();
         interfaceC.affichageRequete(liste);*/
             
             AffichageGraphique testAffich=new AffichageGraphique();
             testAffich.affichageMenu();
   
      
       
         //fen.remplirTables();
         //fen.remplirRequetes();
        // fen.afficherRequetes();
       //  conloc.afficherCamembert2();
         //conloc.afficherCamembert1();
         
         /*Statistiques stat=new Statistiques();
         stat.aficherCamembert();*/
         
        
                  //conloc.executeUpdate(requete);
                  
                     
                     
         /*try{
                     conece = new Connexion("sl152003", "attelage1OO."," sl152003-rw","4muIKuY8" );
         }catch(SQLException e){
                     System.err.println("e");*/
    }
    
    
    public Connexion getConnexion()
    {
        return JavaApplication7.conloc;
    }
}
