/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postproduct;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class postt extends javax.swing.JFrame {
    InputStream in;
    Connection con = null;
    PreparedStatement pst = null;

    public postt() {

        initComponents();

    }

    private void initComponents() {

        txtDescription = new javax.swing.JTextField();
        txtCost = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtProductname = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Attach = new javax.swing.JButton();
        txtProductimg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 230, 30));
        getContentPane().add(txtCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 230, 30));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, -1, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 0));
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Product name              :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, 23));

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Brand                           :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 120, 24));

        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Description                   :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, -1, 26));


        getContentPane().add(txtProductname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 230, 30));

       
        getContentPane().add(txtBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 230, 30));

        jLabel10.setForeground(new java.awt.Color(255, 51, 51));
        jLabel10.setText("Cost                              :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 120, 24));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Product img                  :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 130, 20));

        Attach.setBackground(new java.awt.Color(255, 51, 51));
        Attach.setText("Attach");
        Attach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AttachActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(postt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        getContentPane().add(Attach, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));
        getContentPane().add(txtProductimg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 230, 30));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 18));
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setText("PRODUCT REGISTRATION FORM");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 270, 50));

        lbl_image.setBackground(new java.awt.Color(255, 51, 51));
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 350, 270));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, -1, -1));

        jPanel2.setLayout(null);

  
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 240, 160));

        setSize(new java.awt.Dimension(894, 642));
        setLocationRelativeTo(null);
    }                      

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        try {

            Class.forName("com.mysql.jdbc.Driver");

            String image = txtProductimg.getText();
            image = image.replace("\\", "\\\\");

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            String strDate = dateFormat.format(date);
            System.out.println(strDate);

            String query = "INSERT INTO `reg`(`productname`, `cost`, `brand`, `description`, `productimg`,`date`) VALUES (?,?,?,?,?,?)";
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
            System.out.println("\n connected\n");
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, txtProductname.getText());
            pst.setString(2, txtCost.getText());
            pst.setString(3, txtBrand.getText());
            pst.setString(4, txtDescription.getText());
            pst.setBlob(5, in);
            pst.setString(6, strDate);

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Requested  Successfully");

        } catch (Exception ev) {
            JOptionPane.showMessageDialog(null, ev);
        }
    }

    private void AttachActionPerformed(java.awt.event.ActionEvent evt) throws FileNotFoundException {

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        in=new FileInputStream(filename);
        txtProductimg.setText(filename);
        Image getAbsolutePath = null;
        ImageIcon icon = new ImageIcon(filename);
        Image image = icon.getImage().getScaledInstance(lbl_image.getWidth(), lbl_image.getHeight(), Image.SCALE_SMOOTH);
        lbl_image.setIcon(icon);

    }

    public static void main(String args[]) {

       
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new post().setVisible(true);
            }
        });
    }

    private javax.swing.JButton Attach;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtCost;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtProductimg;
    private javax.swing.JTextField txtProductname;

}
