/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.sql.*;
import java.util.ArrayList;


import java.sql.Connection;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author solen
 */
public class Statistiques {
    
    
    public Statistiques() throws SQLException, ClassNotFoundException
    {
              Connexion conloc;
     conloc=new Connexion("hopital","root","");
    }
    
    public void aficherCamembert()
    {
    DefaultPieDataset dataset = new DefaultPieDataset();
dataset.setValue("Category 1", 43.2);
dataset.setValue("Category 2", 27.9);
dataset.setValue("Category 3", 79.5);
JFreeChart chart = ChartFactory.createPieChart(
"Sample Pie Chart",
dataset,
true, // legend?
true, // tooltips?
false); // URLs?
ChartFrame frame = new ChartFrame("Test", chart);
frame.pack();
frame.setVisible(true);
    }
    
    /*
   public void afficherCamembert2() throws SQLException, ClassNotFoundException
    {
       Statistiques sta=new Statistiques();

        String requete ="SELECT * FROM CHAMBRE ";
         sta.getResultSet() =    sta.getStatement().executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
       DefaultCategoryDataset data=new DefaultCategoryDataset();
       //   DefaultPieDataset my_pie_chart_dataset = new DefaultPieDataset();
      //  String requete ="SELECT nb_lits FROM CHAMBRE ";
                ajouterRequete(requete);
                   
                   int success_rate=0;
                   int oldrea=0;
                   int oldchir=0;
                   int oldcar=0;
                  while (rset.next()) {
                      
                      switch(rset.getString("CODE_SERVICE"))
                      {
                          case "REA":
                                String state = rset.getString("CODE_SERVICE");
                                 success_rate = rset.getInt("NB_LITS")+oldrea;
                                 oldrea=success_rate;
                                data.setValue(success_rate,"s1",state);
                                break;
                                
                                         case "CAR":
                                String state2 = rset.getString("CODE_SERVICE");
                                 success_rate = rset.getInt("NB_LITS")+oldcar;
                                 oldcar=success_rate;
                                data.setValue(success_rate,"s1",state2);
                                break;
                                         case "CHG":
                                String state3 = rset.getString("CODE_SERVICE");
                                 success_rate = rset.getInt("NB_LITS")+oldchir;
                                 oldchir=success_rate;
                                data.setValue(success_rate,"s1",state3);
                                break;
                           
                                //my_pie_chart_dataset.setValue(state, success_rate); //Convert data source from table to Pie Chart Data Source                               
                                }
                  }
     */
     
     
    private PieDataset readData() {
JDBCPieDataset data = null;
String url = "jdbc:postgresql://localhost";
Connexion con;
 
try {
con = new Connexion("hopital","root","");
data = new JDBCPieDataset((Connection) con);
String sql = "SELECT * FROM CHAMBRE;";
data.executeQuery(sql);

}
catch (SQLException e) {
System.err.print("SQLException: ");
System.err.println(e.getMessage());
}
catch (Exception e) {
System.err.print("Exception: ");
System.err.println(e.getMessage());
}
return data;
}

}

