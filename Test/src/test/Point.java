package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author ROYER Alexandra
 */
public class Point {
    /**
    * Positions x et y courante du point
    */    
    private int x;
    private int y;  
    private String nom;

    /* Constructeur par défaut*/
    public Point()
    {
        x = 0;
        y = 0;
        nom = "";
    }
       
  /** Constructeur surcharge
     * @param abs
     * @param ord */
 public Point(int abs, int ord) {
        this.x = abs;
        this.y = ord;
        this.nom ="";
  }
/* constructeur surcharge*/
 public Point (String n_nom) {
     this();
     this.nom = n_nom;
 }

   /** Methode de type accesseurs */
 public void affiche () {
     this.affiche("Je suis un point " + "de coordonnées (" + x +","+ y + ").");
 }
 
 public void affiche(String chaine) {
      System.out.println(chaine);
    }    
 
 
 /** Methode de type modifieurs
     * @param dx
     * @param dy */
 public void deplace(int dx, int dy) {
       this.x += dx;
       this.y += dy;
    }
  public void incrementeX(){
        x++;
    }
  public void changeNom(String nouvNom){
        nom = nouvNom;
    }
 
  public int getPosX ()
  {
      return x;
  }
  
    public int getPosY ()
  {
      return y;
  }
  
@Override
 public String toString(){
     return "nom=" +this.nom+ "abscisse" +this.x+ "ordonnee" +this.y;
 }
 
}

