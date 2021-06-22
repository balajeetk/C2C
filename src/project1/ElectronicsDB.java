package project1;


import project.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ElectronicsDB {
    public static boolean flag = false;
    
    
    public static ArrayList<ProductList> TableGenerator(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
             Class.forName("com.mysql.jdbc.Driver");

             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root","");
            //Connection con = DriverManager.getConnection("jdbc:sqlite:E:/electronicsDB.db");
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery("SELECT * FROM displaytable where status='approved'");
            
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("p_name"),rs.getString("brand"),
                        rs.getInt("cost"),rs.getString("descrip"),
                        rs.getBytes("image"));
                
                list.add(pl);

            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ElectronicsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        }
   public static ArrayList<ProductList> homePageContent(){
        ArrayList<ProductList> list = new ArrayList<>();
        try {
             Class.forName("com.mysql.jdbc.Driver");

             Connection con = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root","");
            
            Statement ps = con.createStatement();
            
            ResultSet rs=ps.executeQuery("SELECT * FROM displaytable where status='approved' ORDER BY date DESC LIMIT 3 ");
            ProductList pl;
            
            while(rs.next()){
                pl = new ProductList(rs.getString("p_name"),rs.getString("brand"),
                        rs.getInt("cost"),rs.getString("descrip"),
                        rs.getBytes("image"));
                
                list.add(pl);

            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ElectronicsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
   }
    
}
