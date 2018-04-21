/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
//
/**
 *
 * @author Jean-Pierre Segado
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*
 * 
 * Librairies importées
 */
import Modèle.Connexion;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Affiche dans la fenetre graphique les champs de tables et les requetes de la
 * BDD
 *
 * @author segado
 */
public class FenetreJp extends JFrame implements ActionListener, ItemListener {
    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */

    private Connexion maconnexion;
    
    private final JLabel tab, req, lignes;
    private final JLabel nameECE, passwdECE, loginBDD, passwdBDD, nameBDD, nomTab,num_docteur, specialiteDocteur;
    private final JTextField  nameECETexte, loginBDDTexte, requeteTexte, nameBDDTexte, selectionTexte, selectionSpecialite;
    private final JPasswordField passwdECETexte, passwdBDDTexte;
    private final JButton connect, exec, local;
    private final java.awt.List listeDeTables, listeDeRequetes;
    private final JTextArea fenetreLignes, fenetreRes;
    private final JPanel p0, p1, nord, p2, p3, p4;
    private final JComboBox combo1,combo2,combo3;
    
    // EMPLOYE
    private final JLabel num_employe,nom_employe,prenom_employe,adresse_employe,tel_employe, suppr_employe;
    private final JTextField selecNum_employe,selecNom_employe,selecPrenom_employe,selecAdresse_employe,selecTel_employe,selecSuppr_employe;

    // SOIGNE
    private final JLabel num_malade, suppr_soigne;
    private final JTextField selecNum_docteur,selecNum_malade, selecSuppr_soigne;
    
    // HOSPITALISATION
    private final JLabel code_service,num_chambre,num_lit;
    private final JTextField selecCode_service,selecNum_chambre,selecNum_lit;   
    
    // CHAMBRE
    private final JLabel num_surveillant,nb_lit;
    private final JTextField selecNum_surveillant,selecNb_lit;
    
    // INFIRMIER
    private final JLabel num_infirmier,rotation,salaire, suppr_infirmier;
    private final JTextField selecNum_infirmier,selecRotation,selecSalaire, selecSuppr_infirmier;  
    
    // SERVICE
    private final JLabel nom_service,batiment,directeur, suppr_service;
    private final JTextField selecNom_service,selecBatiment,selecDirecteur, selecSuppr_service;
    
    // MALADE
    private final JLabel nom_malade,prenom_malade,adresse_malade,tel_malade;
    private final JTextField selecNom_malade,selecPrenom_malade,selecAdresse_malade,selecTel_malade;



    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public FenetreJp() throws SQLException, ClassNotFoundException { 
        

        // creation par heritage de la fenetre
        super("Projet d'utilisation de JDBC dans MySQL");
        maconnexion = new Connexion("hopital","root","");

        // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setResizable(true);

        // creation des boutons
        connect = new JButton("Connexion ECE");
        local = new JButton("Connexion locale");
        exec = new JButton("Executer");

        // creation des listes pour les tables et les requetes
        listeDeTables = new java.awt.List(10, false);
        listeDeRequetes = new java.awt.List(10, false);
//                listeDeRequetesMaj = new java.awt.List(10, false);


        // creation des textes
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);
        nameBDDTexte = new JTextField();
        fenetreLignes = new JTextArea();
        fenetreRes = new JTextArea();
        requeteTexte = new JTextField();
        
        // DOCTEUR
        selectionTexte=new JTextField();
        selectionSpecialite= new JTextField();
        
        // EMPLOYE
        selecNum_employe=new JTextField();
        selecNom_employe= new JTextField();
        selecPrenom_employe= new JTextField();
        selecAdresse_employe= new JTextField();
        selecTel_employe= new JTextField();
        selecSuppr_employe=new JTextField();
        
        // SOIGNE
        selecNum_docteur=new JTextField();
        selecNum_malade= new JTextField();
        selecSuppr_soigne=new JTextField();
        
        // HOSPITALISATION
        selecCode_service = new JTextField();
        selecNum_chambre=new JTextField();
        selecNum_lit= new JTextField();
        
        // CHAMBRE
        selecNum_surveillant=new JTextField();
        selecNb_lit=new JTextField();
        
        // INFIRMIER
        selecNum_infirmier=new JTextField();
        selecRotation=new JTextField();
        selecSalaire=new JTextField();
        selecSuppr_infirmier=new JTextField();
        
        // SERVICE
        selecNom_service=new JTextField();
        selecBatiment=new JTextField();
        selecDirecteur=new JTextField();
        selecSuppr_service=new JTextField();
        
        // MALADE
        selecNom_malade= new JTextField();
        selecPrenom_malade= new JTextField();
        selecAdresse_malade= new JTextField();
        selecTel_malade= new JTextField();

        // creation des labels
        nomTab=new JLabel("Nom de la table", JLabel.CENTER);
        
        // DOCTEUR
        num_docteur=new JLabel("Numero du docteur", JLabel.CENTER);
        specialiteDocteur=new JLabel("Specialite du docteur", JLabel.CENTER );
        
        // EMPLOYE
        num_employe=new JLabel("Numero de l'employe", JLabel.CENTER);
        nom_employe=new JLabel("Nom de l'employe", JLabel.CENTER );
        prenom_employe=new JLabel("Prenom de l'employe", JLabel.CENTER );
        adresse_employe=new JLabel("Adresse de l'employe", JLabel.CENTER );
        tel_employe=new JLabel("Tel de l'employe", JLabel.CENTER );
        
        suppr_employe=new JLabel("Numero de l'employe à supprimer", JLabel.CENTER );
        
        // SOIGNE
        num_malade=new JLabel("Numero du malade", JLabel.CENTER );
        suppr_soigne=new JLabel("Numero du malade à supprimer", JLabel.CENTER );
        
        // HOSPITALISATION
        code_service= new JLabel("Code service", JLabel.CENTER);
        num_chambre = new JLabel("Numero de la chambre", JLabel.CENTER);
        num_lit = new JLabel("Numero du lit", JLabel.CENTER);
        
        // CHAMBRE
        num_surveillant=new JLabel("Numero du surveillant", JLabel.CENTER);
        nb_lit=new JLabel("Nombre de lits", JLabel.CENTER);

        // INFIRMIER
        num_infirmier=new JLabel("Numero de l'infirmier", JLabel.CENTER);
        rotation =new JLabel("Rotation", JLabel.CENTER);
        salaire=new JLabel("Salaire", JLabel.CENTER);
        suppr_infirmier=new JLabel("Numero de l'infirmier à supprimer", JLabel.CENTER);
        
        // SERVICE
        nom_service=new JLabel("Nom du service", JLabel.CENTER);
        batiment=new JLabel("Batiment", JLabel.CENTER);
        directeur=new JLabel("Nom du directeur", JLabel.CENTER);
        suppr_service=new JLabel("Nom du service à supprimer", JLabel.CENTER);
        
        // MALADE
        nom_malade=new JLabel("Nom du malade", JLabel.CENTER );
        prenom_malade=new JLabel("Prenom du malade", JLabel.CENTER );
        adresse_malade=new JLabel("Adresse du malade", JLabel.CENTER );
        tel_malade=new JLabel("Tel du malade", JLabel.CENTER );

        
        tab = new JLabel("Tables", JLabel.CENTER);
        lignes = new JLabel("Lignes", JLabel.CENTER);
        req = new JLabel("Requetes de sélection", JLabel.CENTER);
        nameECE = new JLabel("login ECE :", JLabel.CENTER);
        passwdECE = new JLabel("password ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login base :", JLabel.CENTER);
        passwdBDD = new JLabel("password base :", JLabel.CENTER);
        nameBDD = new JLabel("nom base :", JLabel.CENTER);
      
        combo1= new JComboBox();
          combo1.setPreferredSize(new Dimension(100, 20));
    combo1.addItem("DOCTEUR");
    combo1.addItem("EMPLOYE");
    combo1.addItem("SOIGNE");
    combo1.addItem("HOSPITALISATION");
    combo1.addItem("CHAMBRE");
    combo1.addItem("INFIRMIER");
    combo1.addItem("SERVICE");
    combo1.addItem("MALADE");
    
    
    combo2= new JComboBox();
    combo2.setPreferredSize(new Dimension(100, 20));
    combo2.addItem("Cardiologue");
    combo2.addItem("Anesthesiste");
    combo2.addItem("Generaliste");
    combo2.addItem("Orthopédiste");
    
    combo3= new JComboBox();
    combo2.setPreferredSize(new Dimension(100, 20));
    combo2.addItem("JOUR");
    combo2.addItem("NUIT");


        // creation des panneaux
        p0 = new JPanel();
        p1 = new JPanel();
        nord = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        // mise en page des panneaux
        p0.setLayout(new GridLayout(1, 11));
        p1.setLayout(new GridLayout(1, 4));
        nord.setLayout(new GridLayout(2, 1));
        p2.setLayout(new GridLayout(1, 4));
        p3.setLayout(new GridLayout(1, 3));

        // ajout des objets graphqiues dans les panneaux
        p0.add(nameECE);
        p0.add(nameECETexte);
        p0.add(passwdECE);
        p0.add(passwdECETexte);
        p0.add(loginBDD);
        p0.add(loginBDDTexte);
        p0.add(passwdBDD);
        p0.add(passwdBDDTexte);
        p0.add(connect);
        p0.add(nameBDD);
        p0.add(nameBDDTexte);
        p0.add(local);
        p1.add(tab);
        p1.add(lignes);
        p1.add(req);
       
        nord.add("North", p0);
        nord.add("North", p1);
        p2.add(listeDeTables);
        p2.add(fenetreLignes);
        p2.add(listeDeRequetes);
        p3.add(nomTab);
        p3.add(combo1);
        
        ///////////////////////// DOCTEUR ///////////////////////////////
        ///////////////////////// DOCTEUR ///////////////////////////////
        
        p3.add(combo2);
        p3.add(num_docteur);
        p3.add(selectionTexte);  
        p3.add(specialiteDocteur);
        p3.add(selectionSpecialite);
        p3.add(exec);
        
        ///////////////////////// DOCTEUR ///////////////////////////////
        ///////////////////////// DOCTEUR ///////////////////////////////
        
        
        
        /////////////////////// J'ai tout mis dans p3 parce que j'avais peur de prendre des initiatives sur l'interface :p 
        
        
        
        ///////////////////////// EMPLOYE ///////////////////////////////
        ///////////////////////// EMPLOYE ///////////////////////////////
        
        p3.add(num_employe);
        p3.add(nom_employe);
        p3.add(prenom_employe);
        p3.add(adresse_employe);
        p3.add(tel_employe);
        p3.add(exec);
        
        // Suppression
        p4.add(suppr_employe);
        p4.add(selecSuppr_employe);
        p4.add(exec);
        
        
        ///////////////////////// EMPLOYE ///////////////////////////////
        ///////////////////////// EMPLOYE ///////////////////////////////
        
        ///////////////////////// SOIGNE ///////////////////////////////
        ///////////////////////// SOIGNE ///////////////////////////////
        
        p3.add(num_docteur);
        p3.add(num_malade);
        p3.add(selecNum_docteur);
        p3.add(selecNum_malade);
        p3.add(exec);
        
        // Supression
        p4.add(suppr_soigne);
        p4.add(selecSuppr_soigne);
        p4.add(exec);
        
        ///////////////////////// SOIGNE ///////////////////////////////
        ///////////////////////// SOIGNE ///////////////////////////////
        
        ///////////////////////// HOSPITALISATION ///////////////////////////////
        ///////////////////////// HOSPITALISATION ///////////////////////////////
        
        p3.add(num_malade);
        p3.add(code_service);
        p3.add(num_chambre);
        p3.add(num_lit);
        p3.add(selecNum_malade);
        p3.add(selecCode_service);
        p3.add(selecNum_chambre);
        p3.add(selecNum_lit);
        p3.add(exec);
        
        ///////////////////////// HOSPITALISATION ///////////////////////////////
        ///////////////////////// HOSPITALISATION ///////////////////////////////
        
        
        ///////////////////////// CHAMBRE ///////////////////////////////
        ///////////////////////// CHAMBRE ///////////////////////////////
        
        p3.add(code_service);
        p3.add(num_chambre);
        p3.add(num_surveillant);
        p3.add(nb_lit);
        p3.add(selecCode_service);
        p3.add(selecNum_chambre);
        p3.add(selecNum_surveillant);
        p3.add(selecNb_lit);
        p3.add(exec);
        
        ///////////////////////// CHAMBRE ///////////////////////////////
        ///////////////////////// CHAMBRE ///////////////////////////////
        
        ///////////////////////// INFIRMIER ///////////////////////////////
        ///////////////////////// INFIRMIER ///////////////////////////////
        
        p3.add(num_infirmier);
        p3.add(code_service);
        p3.add(rotation);
        p3.add(salaire);
        p3.add(selecNum_infirmier);
        p3.add(selecCode_service);
        p3.add(selecRotation);
        p3.add(selecSalaire);
        p3.add(exec);
        
        // Supression
        p4.add(suppr_infirmier);
        p4.add(selecSuppr_infirmier);
        p4.add(exec);

        ///////////////////////// INFIRMIER ///////////////////////////////
        ///////////////////////// INFIRMIER ///////////////////////////////
        
        ///////////////////////// SERVICE ///////////////////////////////
        ///////////////////////// SERVICE ///////////////////////////////
        
        p3.add(code_service);
        p3.add(nom_service);
        p3.add(batiment);
        p3.add(directeur);
        p3.add(selecCode_service);
        p3.add(selecNom_service);
        p3.add(selecBatiment);
        p3.add(selecDirecteur);
        p3.add(exec);
        
        // Suppression
        p4.add(suppr_service);
        p4.add(selecSuppr_service);
        p4.add(exec);
        
        ///////////////////////// SERVICE ///////////////////////////////
        ///////////////////////// SERVICE ///////////////////////////////
        
        
        
        ///////////////////////// MALADE ///////////////////////////////
        ///////////////////////// MALADE ///////////////////////////////
        
        p3.add(num_malade);
        p3.add(nom_malade);
        p3.add(prenom_malade);
        p3.add(adresse_malade);
        p3.add(tel_malade);
        p3.add(exec);
        
        p4.add(suppr_soigne);
        p4.add(selecSuppr_soigne);
        p4.add(exec);
        
        ///////////////////////// MALADE ///////////////////////////////
        ///////////////////////// MALADE ///////////////////////////////

        
        
        // ajout des listeners
        connect.addActionListener(this);
        exec.addActionListener(this);
        local.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        listeDeTables.addItemListener(this);
        listeDeRequetes.addItemListener(this);
        selectionTexte.addActionListener(this);

        // couleurs des objets graphiques
        tab.setBackground(Color.MAGENTA);
        lignes.setBackground(Color.MAGENTA);
        req.setBackground(Color.MAGENTA);
        listeDeTables.setBackground(Color.CYAN);
        fenetreLignes.setBackground(Color.WHITE);
        listeDeRequetes.setBackground(Color.GREEN);
        fenetreRes.setBackground(Color.WHITE);
        p1.setBackground(Color.LIGHT_GRAY);

        // disposition geographique des panneaux
        add("North", nord);
        add("Center", p2);
        add("South", p3);
                setVisible(true);




        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });
    }

    /**
     * Méthode privée qui initialise la liste des tables
     */
    public void remplirTables() {
        maconnexion.ajouterTable("CHAMBRE");
        maconnexion.ajouterTable("MALADE");
        maconnexion.ajouterTable("DOCTEUR");
           maconnexion.ajouterTable("EMPLOYE");
        maconnexion.ajouterTable("INFIRMIER");
        maconnexion.ajouterTable("HOSPITALISATION");
                   maconnexion.ajouterTable("SERVICE");
        maconnexion.ajouterTable("SOIGNE");
 

    }

    /**
     * Méthode privée qui initialise la liste des requetes de selection
     */
    public void remplirRequetes() {
     maconnexion.ajouterRequete("SELECT nom, prenom FROM malade WHERE mutuelle='MAAF';"); //R1
     maconnexion.ajouterRequete("SELECT nom, prenom FROM employe WHERE numero IN (SELECT numero FROM infirmier WHERE rotation='NUIT')"); //R2
     maconnexion.ajouterRequete("SELECT service.nom AS serv, batiment, prenom, employe.nom AS noom, specialite FROM service INNER JOIN employe ON service.directeur = employe.numero INNER JOIN docteur ON  docteur.numero = employe.numero"); //R3
     maconnexion.ajouterRequete("SELECT nom, prenom, mutuelle FROM malade WHERE mutuelle LIKE 'MN%' IN SELECT no_chambre, lit, code_service FROM hospitalisation WHERE code_service='REA'"); //R4
     maconnexion.ajouterRequete("SELECT code_service, AVG(salaire) FROM infirmier GROUP BY code_service"); //R5
     maconnexion.ajouterRequete("SELECT code_service, AVG(nb_lits) FROM chambre GROUP BY code_service"); //R6
     //maconnexion.ajouterRequete("SELECT COUNT(no_docteur) FROM soigne"); //R7
     maconnexion.ajouterRequete("SELECT code_service, COUNT(DISTINCT numero)/(SELECT COUNT(DISTINCT no_malade) FROM hospitalisation WHERE code_service='CAR') FROM infirmier WHERE code_service='CAR'"); //R8.1 (améliorer pour généraliser à tous les services)
     maconnexion.ajouterRequete("SELECT code_service, COUNT(DISTINCT numero)/(SELECT COUNT(DISTINCT no_malade) FROM hospitalisation WHERE code_service='CHG') FROM infirmier WHERE code_service='CHG'"); //R8.2
     maconnexion.ajouterRequete("SELECT code_service, COUNT(DISTINCT numero)/(SELECT COUNT(DISTINCT no_malade) FROM hospitalisation WHERE code_service='REA') FROM infirmier WHERE code_service='REA'"); //R8.3
     maconnexion.ajouterRequete("SELECT nom, prenom FROM employe WHERE EXISTS (SELECT numero FROM docteur)"); //R9
     maconnexion.ajouterRequete("SELECT nom, prenom, no_docteur FROM employe, soigne WHERE no_docteur=no_malade IS NULL ");//R10
//String mutuelle="LMDE"; 
    /**
     * Méthode privée qui initialise la liste des requetes de MAJ
     */}
    
   private void remplirRequetesMaj() {
        // Requêtes d'insertion
     

    }
  

   
   public void ajouter() throws SQLException   {
      String requete="INSERT INTO DOCTEUR(NUMERO, SPECIALITE) VALUES ("+selectionTexte.getText()+",'"+selectionSpecialite.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete);
       
      String requete_employe="INSERT INTO EMPLOYE(NUMERO, NOM, PRENOM, ADRESSE, TEL) VALUES ("+selecNum_employe.getText()+",'"+selecNom_employe.getText()+","+selecPrenom_employe.getText()+","+selecAdresse_employe.getText()+","+selecTel_employe.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_employe);
       
      String requete_soigne="INSERT INTO SOIGNE(NO_DOCTEUR, NO_MALADE) VALUES ("+selecNum_docteur.getText()+","+selecNum_malade.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_soigne);
       
      String requete_hospitalisation="INSERT INTO HOSPITALISATION(NO_MALADE, CODE_SERVICE, NO_CHAMBRE, LIT) VALUES ("+selecNum_malade.getText()+",'"+selecCode_service.getText()+","+selecNum_chambre.getText()+","+selecNum_lit.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_hospitalisation);
       
      String requete_chambre="INSERT INTO CHAMBRE(CODE_SERVICE, NO_CHAMBRE, SURVEILLANT, NB_LITS) VALUES ("+selecCode_service.getText()+",'"+selecNum_chambre.getText()+","+selecNum_surveillant.getText()+","+selecNb_lit.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_chambre);
       
      String requete_infirmier="INSERT INTO INFIRMIER(NUMERO,CODE_SERVICE, ROTATION, SALAIRE) VALUES ("+selecNum_infirmier.getText()+",'"+selecCode_service.getText()+","+selecRotation.getText()+","+selecSalaire.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_infirmier);
       
       String requete_service="INSERT INTO SERVICE(CODE_SERVICE, NOM, BATIMENT, DIRECTEUR) VALUES ("+selecCode_service.getText()+",'"+selecNom_service.getText()+","+selecBatiment.getText()+","+selecDirecteur.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_service);
       
       String requete_malade="INSERT INTO MALADE(NUMERO, NOM, PRENOM, ADRESSE, TEL) VALUES ("+selecNum_malade.getText()+",'"+selecNom_malade.getText()+","+selecPrenom_malade.getText()+","+selecAdresse_malade.getText()+","+selecTel_malade.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete_malade);
         
        
            try{
            maconnexion.executeUpdate(requete);
            maconnexion.executeUpdate(requete_employe);
            maconnexion.executeUpdate(requete_soigne);
            maconnexion.executeUpdate(requete_hospitalisation);
            maconnexion.executeUpdate(requete_chambre);
            maconnexion.executeUpdate(requete_infirmier);
            maconnexion.executeUpdate(requete_service);
            maconnexion.executeUpdate(requete_malade);
            // Requêtes de modification
            // maconnexion.ajouterRequeteMaj("UPDATE Dept SET loc='Eiffel' WHERE loc='Paris';");
            
            // Requêtes de suppression
            //maconnexion.ajouterRequeteMaj("DELETE FROM Dept WHERE loc='Eiffel';");
        } catch (SQLException ex) {
            Logger.getLogger(FenetreJp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    }
   
      public void supprimer() throws SQLException   {
      String requete="DELETE FROM DOCTEUR(NUMERO, SPECIALITE) VALUES ("+selectionTexte.getText()+",'"+selectionSpecialite.getText()+"');";
       maconnexion.ajouterRequeteMaj(requete);
       
      String requete_employe=("DELETE FROM EMPLOYE WHERE NUMERO="+selecSuppr_employe.getText()+");");
       maconnexion.ajouterRequeteMaj(requete_employe);
       
      String requete_soigne=("DELETE FROM SOIGNE WHERE NO_MALADE="+selecSuppr_soigne.getText()+");");
       maconnexion.ajouterRequeteMaj(requete_soigne);
       
      String requete_infirmier=("DELETE FROM INFIRMIER WHERE NUMERO="+selecSuppr_infirmier.getText()+");");
       maconnexion.ajouterRequeteMaj(requete_infirmier);
       
       String requete_service=("DELETE FROM SERVICE WHERE NOM="+selecSuppr_service.getText()+");");
       maconnexion.ajouterRequeteMaj(requete_service);
       
       String requete_malade=("DELETE FROM MALADE WHERE NUMERO="+selecSuppr_soigne.getText()+");");
       maconnexion.ajouterRequeteMaj(requete_malade);
         
        
            try{
            maconnexion.executeUpdate(requete);
            maconnexion.executeUpdate(requete_employe);
            maconnexion.executeUpdate(requete_soigne);
            maconnexion.executeUpdate(requete_infirmier);
            maconnexion.executeUpdate(requete_service);
            maconnexion.executeUpdate(requete_malade);
            // Requêtes de modification
            // maconnexion.ajouterRequeteMaj("UPDATE Dept SET loc='Eiffel' WHERE loc='Paris';");
            
            // Requêtes de suppression
            //maconnexion.ajouterRequeteMaj("DELETE FROM Dept WHERE loc='Eiffel';");
        } catch (SQLException ex) {
            Logger.getLogger(FenetreJp.class.getName()).log(Level.SEVERE, null, ex);
        }
                    }
   
    /**
     *
     * Afficher les tables
     */
    public void afficherTables() {
        for (String table : maconnexion.tables) {
            listeDeTables.add(table);
        }
    }

    /**
     *
     * Afficher les lignes de la table sélectionnée
     */
    public void afficherLignes(String nomTable) {
        try {
            ArrayList<String> liste;

            // effacer les résultats
            fenetreLignes.removeAll();

            // recupérér les résultats de la table selectionnee
            liste = maconnexion.remplirChampsTable(nomTable);

            // afficher les champs de la table selectionnee 
            fenetreLignes.setText("");
            for (String liste1 : liste) {
                fenetreLignes.append(liste1);
            }

            // recuperer la liste de la table sélectionnée
            String requeteSelectionnee = "select * from " + nomTable + ";";
            liste = maconnexion.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            for (String liste1 : liste) {
                fenetreLignes.append(liste1);
            }

        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
            fenetreRes.setText("");
            fenetreRes.append("Echec table SQL");
            e.printStackTrace();

        }
    }

    /**
     *
     * Afficher les requetes de selection et de MAJ dans la fenetre
     */
    public void afficherRequetes() {
        for (String requete : maconnexion.requetes) {
            listeDeRequetes.add(requete);
        }
    }

    /**
     *
     * Afficher et retourner les résultats de la requete sélectionnée
     *
     * @param requeteSelectionnee
     */
    public ArrayList<String> afficherRes(String requeteSelectionnee) throws SQLException {
        ArrayList<String> liste = null;
        try {

            // effacer les résultats
            fenetreRes.removeAll();

            // recupérér les résultats de la requete selectionnee
            liste = maconnexion.remplirChampsRequete(requeteSelectionnee);

            // afficher les lignes de la requete selectionnee a partir de la liste
            fenetreRes.setText("");
            for (String liste1 : liste) {
                fenetreRes.append(liste1);
            }
        } catch (SQLException e) {
            // afficher l'erreur dans les résultats
            fenetreRes.setText("");
            fenetreRes.append("Echec requete SQL");
        }
        return liste;
    }

    /**
     *
     * Pour gerer les actions sur les boutons on utilise la fonction
     * actionPerformed
     *
     * @param evt
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        // tester cas de la commande evenementielle
        if (source == connect) {
            ArrayList<String> liste;
            String passwdECEString = new String(passwdECETexte.getPassword());
            String passwdBDDString = new String(passwdBDDTexte.getPassword());
            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    maconnexion = new Connexion("hopital","root","");

                    // effacer les listes de tables et de requêtes
                    listeDeTables.removeAll();
                    listeDeRequetes.removeAll();

                    // initialisation de la liste des requetes de selection et de MAJ
                    remplirTables();
                    remplirRequetesMaj();

                    // afficher la liste de tables et des requetes
                    afficherTables();
                    afficherRequetes();

                    // se positionner sur la première table et requête de selection
                    listeDeTables.select(0);
                    listeDeRequetes.select(0);

                    // afficher les champs de la table sélectionnée
                    String nomTable = listeDeTables.getSelectedItem();

                    // recuperer les lignes de la table selectionnee
                    afficherLignes(nomTable);

                    // recuperer la liste des lignes de la requete selectionnee
                    String requeteSelectionnee = listeDeRequetes.getSelectedItem();

                    // afficher les résultats de la requete selectionnee
                    afficherRes(requeteSelectionnee);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } else if (source == local) {
            ArrayList<String> liste;
            try {
                try {
                    // tentative de connexion si les 4 attributs sont remplis
                    maconnexion = new Connexion("hoptial", "root", " ");
                    // effacer les listes de tables et de requêtes
                    listeDeTables.removeAll();
                    listeDeRequetes.removeAll();

                    // initialisation de la liste des requetes de selection et de MAJ
                    remplirTables();
                    remplirRequetesMaj();

                    // afficher la liste de tables et des requetes
                    afficherTables();
                    afficherRequetes();

                    // se positionner sur la première table et requête de selection
                    listeDeTables.select(0);
                    listeDeRequetes.select(0);

                    // afficher les champs de la table sélectionnée
                    String nomTable = listeDeTables.getSelectedItem();

                    // recuperer les lignes de la table selectionnee
                    afficherLignes(nomTable);

                    // recuperer la liste des lignes de la requete selectionnee
                    String requeteSelectionnee = listeDeRequetes.getSelectedItem();

                    // afficher les résultats de la requete selectionnee
                    afficherRes(requeteSelectionnee);
                } catch (ClassNotFoundException cnfe) {
                    System.out.println("Connexion echouee : probleme de classe");
                    cnfe.printStackTrace();
                }
            } catch (SQLException e) {
                System.out.println("Connexion echouee : probleme SQL");
                e.printStackTrace();
            }
        } else if (source == exec) {
            try {
                ajouter();
            } catch (SQLException ex) {
                Logger.getLogger(FenetreJp.class.getName()).log(Level.SEVERE, null, ex);
            }
            // effacer les résultats
            fenetreRes.removeAll();

          
            

        }
    }

    /**
     *
     * Pour gerer les actions sur items d'une liste on utilise la methode
     * itemStateChanged
     */
    @Override
    @SuppressWarnings("CallToThreadDumpStack")
    public void itemStateChanged(ItemEvent evt) {
        // sélection d'une requete et afficher ses résultats
        if (evt.getSource() == listeDeRequetes) {
            // recuperer la liste des lignes de la requete selectionnee
            String requeteSelectionnee = listeDeRequetes.getSelectedItem();
            try {
                afficherRes(requeteSelectionnee);
            } catch (SQLException ex) {
                Logger.getLogger(Fenetre.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (evt.getSource() == listeDeTables) {
            // afficher les lignes de la table sélectionnée
            String nomTable = listeDeTables.getSelectedItem();
            afficherLignes(nomTable);
        }
    }
}
