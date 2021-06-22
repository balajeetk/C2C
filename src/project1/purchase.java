/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 *
 * @author balajee
 */
public class purchase {

    MainPage1 mp1 = new MainPage1();
    useridpart uip = new useridpart();
    public String s = uip.uid;
    String tp = "";
    int totamt = 0;
    JDialog jDialog1 = new JDialog();
    JLabel jLabel1 = new JLabel();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JDialog jDialog2 = new JDialog();
    JButton jButton4 = new JButton();
    JLabel jLabel2 = new JLabel();
    JFrame jFrame1 = new JFrame();
    JPanel jPanel1 = new JPanel();
    JLabel jLabel3 = new JLabel();
    JPanel jPanel2 = new JPanel();
    JLabel jLabel4 = new JLabel();
    JLabel jLabel5 = new JLabel();
    JLabel jLabel7 = new JLabel();
    JLabel jLabel8 = new JLabel();
    JLabel jLabel9 = new JLabel();
    JLabel jLabel10 = new JLabel();
    JLabel jLabel12 = new JLabel();
    JLabel jLabel16 = new JLabel();
    JLabel jLabel17 = new JLabel();
    JPanel jPanel3 = new JPanel();
    JLabel jLabel13 = new JLabel();
    JLabel jLabel14 = new JLabel();
    JLabel jLabel15 = new JLabel();
    JButton jButton6 = new JButton();
    List list1 = new java.awt.List();
    JPanel jPanel4 = new JPanel();
    JPanel jPanel5 = new JPanel();
    JLabel jLabel18 = new JLabel();
    JButton jButton1 = new JButton();
    JButton jButton7 = new JButton();

    public void confirmord() {

        Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        jLabel1.setText("CONFIRM ORDER");
        jLabel2.setText("ORDER CONFIRMED");
        jButton2.setText("YES");
        jButton3.setText("NO");
        jButton4.setText("OK");
        jLabel3.setText("ORDER SUMMARY");
        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jDialog1.setBackground(Color.white);
        jFrame1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24));
        jDialog1.setVisible(true);
        jDialog1.setSize(400, 400);
        GroupLayout jDialog1Layout = new GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
                jDialog1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jButton2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(82, 82, 82))
        );
        jDialog1Layout.setVerticalGroup(
                jDialog1Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(jDialog1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addGroup(jDialog1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        jDialog1.pack();
        jDialog1.setLocationRelativeTo(list1);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                {
                    jDialog1.setVisible(false);
                }
            }
        });

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                {
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
                        Statement st = conn.createStatement();

                        st.executeUpdate("update producttable set status='yes',date='" + sqlDate + "' where user_id='" + s + "' AND status='no' ");
                        ResultSet pch = st.executeQuery("select post_id from producttable where user_id=" + s + " AND status='yes' AND date='" + sqlDate + "'");
                        while (pch.next()) {
                            String pid = pch.getString("post_id");
                            st.executeUpdate("update producttable set status='ordered' where user_id='" + pid + "'");
                            st.executeUpdate("update displaytable set status='ordered' where user_id='" + pid + "'");
                        }

                        conn.close();
                        System.out.println("Success!");
                    } catch (Exception e) {
                        System.out.println("     " + e);
                    }
                    GroupLayout jDialog2Layout = new GroupLayout(jDialog2.getContentPane());
                    jDialog2.getContentPane().setLayout(jDialog2Layout);
                    jDialog2Layout.setHorizontalGroup(
                            jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                            .addContainerGap(90, Short.MAX_VALUE)
                                            .addComponent(jLabel2)
                                            .addGap(83, 83, 83))
                                    .addGroup(jDialog2Layout.createSequentialGroup()
                                            .addGap(149, 149, 149)
                                            .addComponent(jButton4)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jDialog2Layout.setVerticalGroup(
                            jDialog2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jDialog2Layout.createSequentialGroup()
                                            .addContainerGap(40, Short.MAX_VALUE)
                                            .addComponent(jLabel2)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton4)
                                            .addGap(46, 46, 46))
                    );
                    jDialog2.pack();
                    jDialog2.setLocationRelativeTo(list1);
                    jDialog2.setVisible(true);
                    jDialog1.setVisible(false);

                }
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                {
                    totamt = 0;
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("select * from producttable where user_id=" + s + " AND status='yes' AND date='" + sqlDate + "'");
                        while (rs.next()) {
                            tp = rs.getString("p_name");
                            totamt = totamt + rs.getInt("cost");
                            list1.add(tp);

                        }

                        //st.executeUpdate("update producttb,"+s+" set  where "+s+".ordered=1 ");
                        conn.close();
                        System.out.println("Success!");
                    } catch (Exception e) {
                        System.out.println("     " + e);
                    }
                    mp1.cartButtonActionPerformed(evt);
                    GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(496, 496, 496)
                                            .addComponent(jLabel3)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    );

                    jLabel4.setText("PRODUCT NAME:");

                    jLabel5.setText("BRAND             :");

                    jLabel7.setBackground(UIManager.getDefaults().getColor("Slider.highlight"));

                    jLabel8.setText("PRICE              :");

                    jLabel9.setText("NIL");

                    jLabel10.setText("NIL");

                    jLabel12.setText("NIL");

                    jLabel16.setText("STATUS:");

                    jLabel17.setText("NIL");

                    GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                    jPanel2.setLayout(jPanel2Layout);
                    jPanel2Layout.setHorizontalGroup(
                            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addContainerGap()
                                                            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
                                                            .addGap(60, 60, 60)
                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                                            .addComponent(jLabel8)
                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                            .addComponent(jLabel12))
                                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                    .addComponent(jLabel5, GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(jLabel4))
                                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(jLabel9)
                                                                                    .addComponent(jLabel10)))))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGap(550, 550, 550)
                                                            .addComponent(jLabel16)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel17)))
                                            .addContainerGap(167, Short.MAX_VALUE))
                    );
                    jPanel2Layout.setVerticalGroup(
                            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(jLabel16)
                                                                    .addComponent(jLabel17))
                                                            .addContainerGap(179, Short.MAX_VALUE))
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel4)
                                                                    .addComponent(jLabel9))
                                                            .addGap(44, 44, 44)
                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel5)
                                                                    .addComponent(jLabel10))
                                                            .addGap(45, 45, 45)
                                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                    .addComponent(jLabel8)
                                                                    .addComponent(jLabel12))
                                                            .addGap(173, 173, 173))))
                    );

                    jPanel3.setBackground(new java.awt.Color(102, 255, 255));

                    jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
                    jLabel13.setText("PAYMENT MODE:CASH ON DELIVERY");

                    jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
                    jLabel14.setText("TOTAL PRICE:");

                    jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
                    jLabel15.setText("0");

                    GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                    jPanel3.setLayout(jPanel3Layout);
                    jPanel3Layout.setHorizontalGroup(
                            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel13)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel14)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel15)
                                            .addGap(231, 231, 231))
                    );
                    jPanel3Layout.setVerticalGroup(
                            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    jButton6.setText("CLOSE");
                    jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jFrame1.setVisible(false);
                        }
                    });
                    String total = Integer.toString(totamt);
                    list1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            String lst = list1.getSelectedItem();
                            System.out.println(lst);
                            try {
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
                                Statement st = conn.createStatement();
                                ResultSet rs = st.executeQuery("select * from producttable where user_id=" + s + " AND p_name='" + lst + "'");
                                while (rs.next()) {
                                    jLabel9.setText(rs.getString("p_name").toUpperCase());
                                    jLabel10.setText(rs.getString("brand").toUpperCase());
                                    jLabel12.setText(rs.getString("cost"));
                                    jLabel17.setText("ORDERED");
                                    jLabel15.setText(total);
                                    byte[] img = rs.getBytes("image");
                                    ImageIcon images = new ImageIcon(img);
                                    Image im = images.getImage();
                                    Image limg = im.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
                                    ImageIcon newlimg = new ImageIcon(limg);
                                    jLabel7.setIcon(newlimg);

                                }
                                conn.close();
                                System.out.println("Success!");
                            } catch (Exception e) {
                                System.out.println("     " + e);
                            }
                        }
                    });

                    GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
                    jFrame1.getContentPane().setLayout(jFrame1Layout);
                    jFrame1Layout.setHorizontalGroup(
                            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(GroupLayout.Alignment.LEADING, jFrame1Layout.createSequentialGroup()
                                                            .addComponent(list1, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addContainerGap())
                                    .addGroup(GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton6)
                                            .addGap(84, 84, 84))
                    );
                    jFrame1Layout.setVerticalGroup(
                            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jFrame1Layout.createSequentialGroup()
                                            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addGroup(jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(list1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton6)
                                            .addGap(0, 49, Short.MAX_VALUE))
                    );

                    jPanel5.setBackground(new java.awt.Color(204, 255, 255));

                    jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
                    jLabel18.setText("MY CART");

                    GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
                    jPanel5.setLayout(jPanel5Layout);
                    jPanel5Layout.setHorizontalGroup(
                            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(497, 497, 497)
                                            .addComponent(jLabel18)
                                            .addContainerGap(555, Short.MAX_VALUE))
                    );
                    jPanel5Layout.setVerticalGroup(
                            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel18)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );

                    GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                    jPanel4.setLayout(jPanel4Layout);
                    jPanel4Layout.setHorizontalGroup(
                            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                    jPanel4Layout.setVerticalGroup(
                            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 561, Short.MAX_VALUE))
                    );

                    jFrame1.setVisible(true);// TODO add your handling code here:
                    jFrame1.pack();
                    jFrame1.setLocationRelativeTo(jDialog1);
                    jDialog2.setVisible(false);
                    jFrame1.setVisible(true);
                }
            }
        });
    }
}
