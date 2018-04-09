package test;


import test.Point;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ROYER Alexandra
 */
public class Segment {
    
    private int longSeg;
    Point p1;
    Point p2;
    private String nom;
    
    /*Constructeur par défaut*/
    public Segment()
    {
        longSeg = 0;
        p1 = new Point();
        p2 = new Point();
        
    }
    
    public Segment (Point point1, Point point2)
    {
         point1 = p1;
         point2 = p2;
    }
    
    /**
     *
     */
    public void calcul()
    {
       return Math.sqrt(sqr(p1.getPosY() - p2.getPosY()) + sqrt(p2.getPosX() - p1.getPosX()));
    }
    
    public void deplace (Point, int dx, int dy)
    {
       this.p1 += dx;
       this.p2 += dy;
    }
    
    @Override
     public String toString(){
     return "nom=" +this.nom+ "abscisse" +this.p1+ "ordonnee" +this.p2;
 }
     
     public void affiche () {
     this.affiche("Je suis un segment de longueur" + longSeg);
 }
      
      public void affiche(String chaine) {
      System.out.println(chaine);
    }   
}

