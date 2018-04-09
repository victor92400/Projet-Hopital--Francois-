/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.hopital.victor;

import javax.swing.JFrame;

/**
 *
 * @author Victor
 */

public class ProjetHopitalVictor 
{


    public static void main(String[] args) 
    {
        //Fenetre fen = new Fenetre();
        JFrame monCadre = new JFrame();
        monCadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        monCadre.setLocation(400,400);
        monCadre.setContentPane(new Fenetre());
        monCadre.pack();
        monCadre.setVisible(true);
        //new FenetreMise_a_jour();
    }
    
}