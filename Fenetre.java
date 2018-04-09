/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.hopital.victor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author Victor
 */


public class Fenetre extends JPanel implements ActionListener 
{
    
   private JButton rechercherinfo = new JButton("Recherche d'informations");
   private JButton mise_a_jour = new JButton("Mise à jour des données");
   private JButton reporting = new JButton("Reporting");
   
   public JLabel label = new JLabel("Le JLabel");


   public Fenetre() 
   {
      
      mise_a_jour.addActionListener(new BoutonListenerMise_a_jour());
      //bouton2.addActionListener(new Bouton2Listener());
       
      setLayout(new BorderLayout(50, 50));
      JPanel lesBoutons = new JPanel();
      lesBoutons.add(rechercherinfo);
      lesBoutons.add(mise_a_jour);
      lesBoutons.add(reporting);
      add(lesBoutons, BorderLayout.CENTER);
      
  }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
