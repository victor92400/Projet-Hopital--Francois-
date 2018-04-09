/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

/**
 *
 * @author solen
 */import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
  private JPanel pan = new JPanel();
  private JButton bouton1= new JButton("Recherche dans la base de données");
    private JButton bouton2 = new JButton("Mise à jour de la base de données");
      private JButton bouton3 = new JButton("Reporting");
  

  public Fenetre(){
    this.setTitle("Animation");
    this.setSize(600, 500);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    //Ajout du bouton à notre content pane
    pan.add(bouton1);
    pan.add(bouton2);
    pan.add(bouton3);
    this.setContentPane(pan);
    this.setVisible(true);
  }       
}