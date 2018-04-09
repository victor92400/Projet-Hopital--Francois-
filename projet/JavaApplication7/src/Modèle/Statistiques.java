/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import java.sql.Connection;
import java.sql.SQLException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.data.jdbc.JDBCPieDataset;

/**
 *
 * @author solen
 */
public class Statistiques {
    
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
    
    
    /*  public void afficherCamembert2(Connexion conloc)
    {
           DefaultPieDataset my_pie_chart_dataset = new DefaultPieDataset();
        String requete ="SELECT nb_lits FROM CHAMBRE ";
                   conloc.ajouterRequete(requete);
                   
                   
                  while (requete.next()) {
                                String state = requete.getString("STATE");
                                int success_rate = requete.getInt("SUCCESS_RATE");
                                my_pie_chart_dataset.setValue(state, success_rate); //Convert data source from table to Pie Chart Data Source                               
                                }
                   
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
