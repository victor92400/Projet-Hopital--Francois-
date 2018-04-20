/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.victor;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import projet.victor.SSHTunnel;

/**
 * 
 * Connexion a votre BDD locale ou à distance sur le serveur de l'ECE via le tunnel SSH
 * 
 * @author segado
 */
public class Connexion {

    static Scanner in = new Scanner(System.in);
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private static Connection conn;
    private static Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public pour les tables
     */
    public ArrayList<String> tables = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> requetes = new ArrayList<>();
    /**
     * ArrayList public pour les requêtes de MAJ
     */
    public ArrayList<String> requetesMaj = new ArrayList<>();

    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        String urlDatabase = "jdbc:mysql://localhost/" + nameDatabase;

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }

    /**
     * Constructeur avec 4 paramètres : username et password ECE, login et
     * password de la BDD à distance sur le serveur de l'ECE
     * @param usernameECE
     * @param passwordECE
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String usernameECE, String passwordECE, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException {
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // Connexion via le tunnel SSH avec le username et le password ECE
        SSHTunnel ssh = new SSHTunnel(usernameECE, passwordECE);

        if (ssh.connect()) {
            System.out.println("Connexion reussie");

            // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
            String urlDatabase = "jdbc:mysql://localhost:3305/" + usernameECE;

            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();

        }
    }

    
    
    
    
    
    
    public static void AjouterChambre(int num_chambre, int code_service, int num_surveillant, int nb_lits)
    {

            System.out.println("Le numéro de chambre à ajouter");
            num_chambre=in.nextInt();
            System.out.println("Le code service à ajouter");
            code_service=in.nextInt();
            System.out.println("Le numéro du surveillant de la chambre à ajouter");
            num_surveillant=in.nextInt();
            System.out.println("Le nombre de lits à ajouter");
            nb_lits=in.nextInt();
            
            String query="INSERT INTO CHAMBRE VALUES("+num_chambre+","+code_service+","+num_surveillant+","+nb_lits+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerChambre(int num_chambre)
    {
        
            System.out.println("Donner le numéro de la chambre à supprimer");
            num_chambre=in.nextInt();
            
            String query=("DELETE FROM CHAMBRE WHERE no_chambre='num_chambre';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierChambre(int num_chambre, int code_service, int num_surveillant, int nb_lits)
        {
            
            int num_chambremodif;
            System.out.println("Donner le numéro de la chambre à modifier");
            num_chambremodif=in.nextInt();
            System.out.println("Donner le nouveau numéro de chambre");
            num_chambre=in.nextInt();
            
            
            System.out.println("Donner le nouveau code service");
            code_service=in.nextInt();
            String query2 = "UPDATE CHAMBRE SET code_service="+code_service+" WHERE no_chambre="+num_chambremodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner le nouveau numéro de surveillant");
            num_surveillant=in.nextInt();
            String query3 = "UPDATE CHAMBRE SET surveillant="+num_surveillant+" WHERE no_chambre="+num_chambremodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner le nouveau nombre de lits");
            nb_lits=in.nextInt();
            String query4 = "UPDATE CHAMBRE SET nb_lits="+nb_lits+" WHERE no_chambre="+num_chambremodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            String query = "UPDATE CHAMBRE SET no_chambre="+num_chambre+" WHERE no_chambre="+num_chambremodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    
    
    public static void AjouterDocteur(int num_docteur, String specialite)
    {

            System.out.println("Le num du docteur à ajouter");
            num_docteur=in.nextInt();
            System.out.println("La spécialité du docteur à ajouter");
            specialite=in.nextLine();
            
            String query="INSERT INTO DOCTEUR VALUES("+num_docteur+","+specialite+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerDocteur(int num_docteur)
    {
        
            System.out.println("Donner le numéro du docteur à supprimer");
            num_docteur=in.nextInt();
            
            String query=("DELETE FROM DOCTEUR WHERE numero='num_docteur';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierDocteur(int num_docteur, String specialite)
        {
            
            int num_docteurmodif;
            System.out.println("Donner le numéro du docteur à modifier");
            num_docteurmodif=in.nextInt();
            System.out.println("Donner le nouveau numéro du docteur");
            num_docteur=in.nextInt();
            
            
            System.out.println("Donner la nouvelle spécialité du docteur");
            specialite=in.nextLine();
            String query2 = "UPDATE DOCTEUR SET specialite="+specialite+" WHERE numero="+num_docteurmodif;
            maconnexion.ajouterRequeteMaj(query2);
           
            
            String query = "UPDATE DOCTEUR SET numero="+num_docteur+" WHERE numero="+num_docteurmodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
            // Pareil avec tous 
        }
    
    
    
    
    
    
    public static void AjouterEmploye(int num_employe, String nom, String prenom, String adresse, int tel)
    {

            System.out.println("Le numéro d'employé à ajouter");
            num_employe=in.nextInt();
            System.out.println("Le nom de l'employé à ajouter");
            nom=in.nextLine();
            System.out.println("Le prénom de l'employé à ajouter");
            prenom=in.nextLine();
            System.out.println("L'adresse de l'employé à ajouter");
            adresse=in.nextLine();
            System.out.println("Le numéro de tel de l'employé à ajouter");
            tel=in.nextInt();
            
            String query="INSERT INTO EMPLOYE VALUES("+num_employe+","+nom+","+prenom+","+adresse+","+tel+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerEmploye(int num_employe)
    {
        
            System.out.println("Donner le numéro de l'employé à supprimer");
            num_employe=in.nextInt();
            
            String query=("DELETE FROM EMPLOYE WHERE numero='num_employe';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierEmploye(int num_employe, String nom, String prenom, String adresse, int tel)
        {
            
            int num_employemodif;
            System.out.println("Donner le numéro de l'employé à modifier");
            num_employemodif=in.nextInt();
            System.out.println("Donner le nouveau numéro de l'employé");
            num_employe=in.nextInt();
            
            
            System.out.println("Donner le nouveau nom de l'employé");
            nom=in.nextLine();
            String query2 = "UPDATE EMPLOYE SET nom="+nom+" WHERE numero="+num_employemodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner le nouveau prénom de l'employé");
            prenom=in.nextLine();
            String query3 = "UPDATE EMPLOYE SET prenom="+prenom+" WHERE numero="+num_employemodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner la nouvelle adresse de l'employé");
            adresse=in.nextLine();
            String query4 = "UPDATE EMPLOYE SET adresse="+adresse+" WHERE numero="+num_employemodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            System.out.println("Donner le nouveau de tel de l'employé");
            tel=in.nextInt();
            String query5 = "UPDATE EMPLOYE SET tel="+tel+" WHERE numero="+num_employemodif;
            maconnexion.ajouterRequeteMaj(query5);
            
            
            String query = "UPDATE EMPLOYE SET numero="+num_employe+" WHERE numero="+num_employemodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    
    public static void AjouterHospitalisation(int num_malade, int code_service, int num_chambre, int num_lit)
    {

            System.out.println("Le numéro du malade à ajouter");
            num_malade=in.nextInt();
            System.out.println("Le code service à ajouter");
            code_service=in.nextInt();
            System.out.println("Le numéro du surveillant de la chambre à ajouter");
            num_chambre=in.nextInt();
            System.out.println("Le numéro du lit à ajouter");
            num_lit=in.nextInt();
            
            String query="INSERT INTO HOSPITALISATION VALUES("+num_malade+","+code_service+","+num_chambre+","+num_lit+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerHospitalisation(int num_malade)
    {
        
            System.out.println("Donner le numéro du malade à supprimer");
            num_malade=in.nextInt();
            
            String query=("DELETE FROM HOSPITALISATION WHERE no_malade='num_malade';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierHospitalisation(int num_malade, int code_service, int num_chambre, int num_lit)
        {
            
            int num_malademodif;
            System.out.println("Donner le numéro du malade à modifier");
            num_malademodif=in.nextInt();
            System.out.println("Donner le nouveau numéro de malade");
            num_malade=in.nextInt();
            
            
            System.out.println("Donner le nouveau code service");
            code_service=in.nextInt();
            String query2 = "UPDATE HOSPITALISATION SET code_service="+code_service+" WHERE no_malade="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner le nouveau numéro de chambre");
            num_chambre=in.nextInt();
            String query3 = "UPDATE HOSPITALISATION SET no_chambre="+num_chambre+" WHERE no_malade="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner le numéro du lit");
            num_lit=in.nextInt();
            String query4 = "UPDATE HOSPITALISATION SET nb_lits="+num_lit+" WHERE WHERE no_malade="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            String query = "UPDATE HOSPITALISATION SET no_malade="+num_malade+" WHERE WHERE no_malade="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    /////// JOUR ET NUIT A BLINDER ROTATION ////////////////////
    
    
    
    public static void AjouterInfirmier(int num_infirmier, int code_service, String rotation, int salaire)
    {

            System.out.println("Le numéro de l'infirmier à ajouter");
            num_infirmier=in.nextInt();
            System.out.println("Le code service à ajouter");
            code_service=in.nextInt();
            System.out.println("La rotation de l'infirmier à ajouter");
            rotation=in.nextLine();
            System.out.println("Le salaire de l'infirmier à ajouter");
            salaire=in.nextInt();
            
            String query="INSERT INTO INFIRMIER VALUES("+num_infirmier+","+code_service+","+rotation+","+salaire+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerInfirmier(int num_infirmier)
    {
        
            System.out.println("Donner le numéro de l'infirmier à supprimer");
            num_infirmier=in.nextInt();
            
            String query=("DELETE FROM INFIRMIER WHERE numero='num_infirmier';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierInfirmier(int num_infirmier, int code_service, String rotation, int salaire)
        {
            
            int num_infirmiermodif;
            System.out.println("Donner le numéro de l'infirmier à modifier");
            num_infirmiermodif=in.nextInt();
            System.out.println("Donner le nouveau numéro de l'infirmier");
            num_infirmier=in.nextInt();
            
            
            System.out.println("Donner le nouveau code service");
            code_service=in.nextInt();
            String query2 = "UPDATE INFIRMIER SET code_service="+code_service+" WHERE numero="+num_infirmiermodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner la nouvelle rotation");
            rotation=in.nextLine();
            String query3 = "UPDATE INFIRMIER SET rotation="+rotation+" WHERE numero="+num_infirmiermodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner le nouveau salaire");
            salaire=in.nextInt();
            String query4 = "UPDATE INFIRMIER SET salaire="+salaire+"WHERE numero="+num_infirmiermodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            String query = "UPDATE INFIRMIER SET numero="+num_infirmier+" WHERE numero="+num_infirmiermodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    
    
    public static void AjouterMalade(int num_malade, String nom, String prenom, String adresse, int tel, String mutuelle)
    {

            System.out.println("Le numéro du malade à ajouter");
            num_malade=in.nextInt();
            System.out.println("Le nom du malade à ajouter");
            nom=in.nextLine();
            System.out.println("Le prénom du malade à ajouter");
            prenom=in.nextLine();
            System.out.println("L'adresse du malade à ajouter");
            adresse=in.nextLine();
            System.out.println("Le numéro de tel du malade à ajouter");
            tel=in.nextInt();
            System.out.println("La mutuelle du malade à ajouter");
            mutuelle=in.nextLine();
            
            String query="INSERT INTO MALADE VALUES("+num_malade+","+nom+","+prenom+","+adresse+","+tel+","+mutuelle+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerMalade(int num_malade)
    {
        
            System.out.println("Donner le numéro du malade à supprimer");
            num_malade=in.nextInt();
            
            String query=("DELETE FROM MALADE WHERE numero='num_malade';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierMalade(int num_malade, String nom, String prenom, String adresse, int tel, String mutuelle)
        {
            
            int num_malademodif;
            System.out.println("Donner le numéro du malade à modifier");
            num_malademodif=in.nextInt();
            System.out.println("Donner le nouveau numéro du malade");
            num_malade=in.nextInt();
            
            
            System.out.println("Donner le nouveau nom du malade");
            nom=in.nextLine();
            String query2 = "UPDATE MALADE SET nom="+nom+" WHERE numero="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner le nouveau prénom de l'employé");
            prenom=in.nextLine();
            String query3 = "UPDATE MALADE SET prenom="+prenom+" WHERE numero="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner la nouvelle adresse de l'employé");
            adresse=in.nextLine();
            String query4 = "UPDATE MALADE SET adresse="+adresse+" WHERE numero="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            System.out.println("Donner le nouveau de tel de l'employé");
            tel=in.nextInt();
            String query5 = "UPDATE MALADE SET tel="+tel+" WHERE numero="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query5);
            
            
            String query = "UPDATE MALADE SET numero="+num_malade+" WHERE numero="+num_malademodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    public static void AjouterService(int code, String nom, String batiment, int num_directeur)
    {

            System.out.println("Le code du service à ajouter");
            code=in.nextInt();
            System.out.println("Le nom du service à ajouter");
            nom=in.nextLine();
            System.out.println("Le nom du batiment à ajouter");
            batiment=in.nextLine();
            System.out.println("Le numéro du directeur du service à ajouter");
            num_directeur=in.nextInt();
            
            String query="INSERT INTO SERVICE VALUES("+code+","+nom+","+batiment+","+num_directeur+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerService(String nom)
    {
        
            System.out.println("Donner le nom du service à supprimer");
            nom=in.nextLine();
            
            String query=("DELETE FROM SERVICE WHERE nom='nom';");
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierService(int code, String nom, String batiment, int num_directeur)
        {
            
            String nommodif;
            System.out.println("Donner le nom du service à modifier");
            nommodif=in.nextLine();
            System.out.println("Donner le nouveau nom du service");
            nom=in.nextLine();
            
            
            System.out.println("Donner le nouveau code du service");
            code=in.nextInt();
            String query2 = "UPDATE SERVICE SET code="+code+" WHERE nom="+nommodif;
            maconnexion.ajouterRequeteMaj(query2);
            
            
            System.out.println("Donner le nouveau nom du batiment");
            batiment=in.nextLine();
            String query3 = "UPDATE SERVICE SET batiment="+batiment+" WHERE nom="+nommodif;
            maconnexion.ajouterRequeteMaj(query3);
            
            
            System.out.println("Donner le nouveau salaire");
            salaire=in.nextInt();
            String query4 = "UPDATE SERVICE SET directeur="+num_directeur+" WHERE nom="+nommodif;
            maconnexion.ajouterRequeteMaj(query4);
            
            
            String query = "UPDATE SERVICE SET nom="+nom+" WHERE nom="+nommodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
        }
    
    
    
    
    
    
        
    public static void AjouterSoigne(int num_docteur, int num_malade)
    {

            System.out.println("Le numéro du docteur à ajouter");
            num_docteur=in.nextInt();
            System.out.println("Le numéro du malade à ajouter");
            num_malade=in.nextInt();
            
            String query="INSERT INTO SOIGNE VALUES("+num_docteur+","+num_malade+")";
            maconnexion.ajouterRequeteMaj(query);
            
    }
    
    public static void SupprimerSoigne(int num_docteur, int num_malade)
    {
        
            System.out.println("Donner le numéro du docteur à supprimer");
            num_docteur=in.nextInt();
            
            System.out.println("Donner le numéro du malade à supprimer");
            num_docteur=in.nextInt();
            
            String query=("DELETE FROM SOIGNE WHERE no_docteur='num_docteur' AND ;");/////////////////////////
            maconnexion.ajouterRequeteMaj(query);
            
    }
        
    public static void ModifierSoigne(int num_docteur, int num_malade)
        {
            
            int num_docteurmodif;
            System.out.println("Donner le numéro du docteur à modifier");
            num_docteurmodif=in.nextInt();
            System.out.println("Donner le nouveau numéro du docteur");
            num_docteur=in.nextInt();
            
            
            System.out.println("Donner le numéro du docteur à modifier");
            num_malade=in.nextInt();
            String query2 = "UPDATE SOIGNE SET no_malade="+num_malade+" WHERE no_docteur="+num_docteurmodif;
            maconnexion.ajouterRequeteMaj(query2);
           
            
            String query = "UPDATE SOIGNE SET no_docteur="+num_docteur+" WHERE no_docteur="+num_docteurmodif;
            maconnexion.ajouterRequeteMaj(query);
                
            
            // Je modifie en dernier le numéro de chambre pour être sur de ne modifier que la ligne 
            // sur laquelle je travaille
            // Sans ça,
            // Imaginons je modifie le numéro de chambre et que 2 chambres ont le même numéro
            // ensuite j'applique le resteç!!!
            // les deux chambres vont être modifiées
            // Pareil avec tous 
        }
    
    
    
    
    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     */
    public void ajouterTable(String table) {
        tables.add(table);
    }

    /**
     * Méthode qui ajoute la requete de selection en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequete(String requete) {
        requetes.add(requete);
    }

    /**
     * Méthode qui ajoute la requete de MAJ en parametre dans son
     * ArrayList
     *
     * @param requete
     */
    public void ajouterRequeteMaj(String requete) {
        requetesMaj.add(requete);
    }

    /**
     * Méthode qui retourne l'ArrayList des champs de la table en parametre
     *
     * @param table
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsTable(String table) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery("select * from " + table);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<>();
        String champs = "";
        // Ajouter tous les champs du resultat dans l'ArrayList
        for (int i = 0; i < nbColonne; i++) {
            champs = champs + " " + rsetMeta.getColumnLabel(i + 1);
        }

        // ajouter un "\n" à la ligne des champs
        champs = champs + "\n";

        // ajouter les champs de la ligne dans l'ArrayList
        liste.add(champs);

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Methode qui retourne l'ArrayList des champs de la requete en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    public ArrayList remplirChampsRequete(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    /**
     * Méthode qui execute une requete de MAJ en parametre
     * @param requeteMaj
     * @throws java.sql.SQLException
     */
    public void executeUpdate(String requeteMaj) throws SQLException {
        stmt.executeUpdate(requeteMaj);
    }
}
