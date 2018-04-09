package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner; 
import test.Point;
/**
 *
 * @author ROYER Alexandra
 */
public class Test {
    /**
     * @param args the command line arguments
     * @param String
     */
    public static void main(String[] args, String String) {
       Point p1 = new Point();
       
       Scanner clavier = new Scanner(System.in);
        System.out.println ("Saisir un abscisse : ");
        int x = clavier.nextInt();
        System.out.println ("Saisir une ordonnee : ");
        int y = clavier.nextInt();
            
    
     Point p2 = new Point(x,y );
        System.out.println("Veuillez saisir un nom :");
        String nom = clavier.nextLine();
      
      Point p3;
      p3 = new Point (nom);
      
      /*modifie p2 avec setter*/
      p2.changeNom(nom);
      
      p1.affiche(String);
      p1.changeNom(nom);
      p1.deplace(x, y);
      p1.incrementeX();
      p1.toString();
      
      p2.affiche(String);
      p2.changeNom(nom);
      p2.deplace(x, y);
      p2.incrementeX();
      p2.toString();
      
      p3.affiche(String);
      p3.changeNom(nom);
      p3.deplace(x, y);
      p3.incrementeX();
      p3.toString();
            
      Segment s1 = new Segment (p1,p2);
      s1.affiche();
      
      Segment s2 = new Segment (p2,p3);
      s2.affiche();
      
      s1.affiche(String);
      s2.affiche(String);
      
      s1.deplace(p3,p3);
      
      
      
       }
    }

