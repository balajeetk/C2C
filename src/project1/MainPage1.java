package project1;



import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.table.TableModel;
import static project1.MainPage1.cartItemTable;
public class MainPage1 extends javax.swing.JFrame {

    static Object[] data = new Object[4];   
    static int total = 0;
    static String tot = "";
    static boolean signInStatus = false;
    static int wrongPass = 0;
    useridpart uip=new useridpart();
    public String usid=uip.uid;
        String rbrand = "";
        String rmodel = "";
        String rprice = "";
    public MainPage1() {
        initComponents();
   
        
        ArrayList<ProductList> list = ElectronicsDB.TableGenerator();
        
        Object rowData[] = new Object[6];
        
        DefaultTableModel model =  (DefaultTableModel) homeTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        homeTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        

       
        model.setRowCount(0); 
        
        for(int i=0; i<list.size(); i++){
            rowData[0] = list.get(i).getBrand();
            rowData[1] = list.get(i).getModel();
            rowData[2] = list.get(i).getPrice();
            
            rowData[3] = list.get(i).getDescription();
            ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMimage()).getImage()
             .getScaledInstance(160, 160, Image.SCALE_SMOOTH) );   
            rowData[4] = image;
            model.addRow(rowData);
            homeTable.setRowHeight(150);
            homeTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            
        }
        
        list.clear();
    }
    
    public void doPanelHideShow()
    {
  
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        searchBar = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        newlyAdded = new javax.swing.JButton();
        electronicsButton = new javax.swing.JButton();
        accountButton = new javax.swing.JButton();
        cartButton = new javax.swing.JButton();
        cardParentPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        homeTable = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        searchTable = new javax.swing.JTable();
        electronicsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        electronicsTable = new javax.swing.JTable();
        cartPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartItemTable = new javax.swing.JTable();
        billLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));
        BackgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(1199, 72));
        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Surety4Shopping");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Shopping_Bag_48px.png"))); 

        jSeparator6.setForeground(new java.awt.Color(0, 77, 64));
        jSeparator6.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jSeparator6.setOpaque(true);

        searchBar.setBackground(new java.awt.Color(153, 153, 153));
        searchBar.setFont(new java.awt.Font("Roboto", 0, 14)); 
        searchBar.setForeground(new java.awt.Color(255, 255, 255));
        searchBar.setBorder(null);
        searchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBarMouseClicked(evt);
            }
        });
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        searchButton.setBackground(new java.awt.Color(51, 102, 255));
        searchButton.setFont(new java.awt.Font("Roboto", 0, 20)); 
        searchButton.setForeground(new java.awt.Color(255, 255, 255));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Search_31px.png"))); 
        searchButton.setToolTipText("Search");
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchButton.setOpaque(true);
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                searchButtonMouseReleased(evt);
            }
        });
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); 
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Search");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator6)
                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(3, 3, 3))
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BackgroundPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 60));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        newlyAdded.setBackground(new java.awt.Color(51, 102, 255));
        newlyAdded.setFont(new java.awt.Font("Roboto", 0, 20)); 
        newlyAdded.setForeground(new java.awt.Color(255, 255, 255));
        newlyAdded.setText("Newly Added");
        newlyAdded.setToolTipText("Check what's new!");
        newlyAdded.setBorderPainted(false);
        newlyAdded.setContentAreaFilled(false);
        newlyAdded.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newlyAdded.setOpaque(true);
        newlyAdded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newlyAddedMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newlyAddedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newlyAddedMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newlyAddedMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newlyAddedMouseReleased(evt);
            }
        });
        newlyAdded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newlyAddedActionPerformed(evt);
            }
        });

        electronicsButton.setBackground(new java.awt.Color(51, 102, 255));
        electronicsButton.setFont(new java.awt.Font("Roboto", 0, 20)); 
        electronicsButton.setForeground(new java.awt.Color(255, 255, 255));
        electronicsButton.setText("All");
        electronicsButton.setToolTipText("All devices");
        electronicsButton.setBorderPainted(false);
        electronicsButton.setContentAreaFilled(false);
        electronicsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        electronicsButton.setOpaque(true);
        electronicsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                electronicsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                electronicsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                electronicsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                electronicsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                electronicsButtonMouseReleased(evt);
            }
        });
        electronicsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electronicsButtonActionPerformed(evt);
            }
        });

        accountButton.setBackground(new java.awt.Color(51, 102, 255));
        accountButton.setFont(new java.awt.Font("Roboto", 0, 20)); 
        accountButton.setForeground(new java.awt.Color(255, 255, 255));
        accountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Person_48px.png"))); 
        accountButton.setToolTipText("Account Info");
        accountButton.setBorderPainted(false);
        accountButton.setContentAreaFilled(false);
        accountButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountButton.setOpaque(true);
        accountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accountButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accountButtonMouseReleased(evt);
            }
        });
        accountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountButtonActionPerformed(evt);
            }
        });

        cartButton.setBackground(new java.awt.Color(51, 102, 255));
        cartButton.setFont(new java.awt.Font("Roboto", 0, 20)); 
        cartButton.setForeground(new java.awt.Color(255, 255, 255));
        cartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_OpenCart_24px.png"))); 
        cartButton.setText("Cart");
        cartButton.setToolTipText("View your cart.");
        cartButton.setBorderPainted(false);
        cartButton.setContentAreaFilled(false);
        cartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartButton.setMaximumSize(new java.awt.Dimension(67, 49));
        cartButton.setOpaque(true);
        cartButton.setPreferredSize(new java.awt.Dimension(67, 49));
        cartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cartButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cartButtonMouseReleased(evt);
            }
        });
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

       

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(newlyAdded)
                .addGap(23, 23, 23)
                .addComponent(electronicsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(cartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(accountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(accountButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(electronicsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                
                .addComponent(newlyAdded, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BackgroundPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 60, 1210, 50));

        cardParentPanel.setLayout(new java.awt.CardLayout());

        homeTable.setFont(new java.awt.Font("Roboto", 0, 14)); 
        homeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Name", "Model", "Price",  "Features", "Photo"
            }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, 
                java.lang.Integer.class, java.lang.String.class, javax.swing.Icon.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }

        });
        homeTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        homeTable.setSelectionBackground(new java.awt.Color(153,153,153));
        homeTable.getTableHeader().setReorderingAllowed(false);
        homeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(homeTable);

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        cardParentPanel.add(homePanel, "card5");

        searchTable.setFont(new java.awt.Font("Roboto", 0, 14)); 
        searchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Brand Name", "Model", "Price", "Features", "Photo"
            }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class,
                java.lang.Integer.class, java.lang.String.class, javax.swing.Icon.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,  false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }

        });
        searchTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchTable.setSelectionBackground(new java.awt.Color(153,153,153));
        searchTable.getTableHeader().setReorderingAllowed(false);
        searchTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(searchTable);

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        cardParentPanel.add(searchPanel, "card9");

        electronicsTable.setFont(new java.awt.Font("Roboto", 0, 14)); 
        electronicsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Brand", "Price","Features", "Photo"
            }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, 
                java.lang.Integer.class, java.lang.String.class, javax.swing.Icon.class
            };
            boolean[] canEdit = new boolean [] {
                false, false,  false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int columnIndex){
                return types [columnIndex];
            }

        });
        electronicsTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        electronicsTable.setSelectionBackground(new java.awt.Color(153,153,153));
        electronicsTable.getTableHeader().setReorderingAllowed(false);
        electronicsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                electronicsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(electronicsTable);

        javax.swing.GroupLayout electronicsPanelLayout = new javax.swing.GroupLayout(electronicsPanel);
        electronicsPanel.setLayout(electronicsPanelLayout);
        electronicsPanelLayout.setHorizontalGroup(
            electronicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        electronicsPanelLayout.setVerticalGroup(
            electronicsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );

        cardParentPanel.add(electronicsPanel, "card4");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        cartItemTable.setFont(new java.awt.Font("Roboto", 0, 14)); 
        cartItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Brand", "Price"
            }
        ));
        cartItemTable.setEnabled(true);
        cartItemTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(cartItemTable);

        billLabel.setFont(new java.awt.Font("Roboto", 1, 18)); 
        billLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); 
        jLabel4.setText("Rupees Only");

        buyButton.setBackground(new java.awt.Color(51, 102, 255));
        buyButton.setFont(new java.awt.Font("Roboto", 0, 20)); 
        buyButton.setForeground(new java.awt.Color(255, 255, 255));
        buyButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Buy_24px.png"))); 
        buyButton.setText("Buy");
        buyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    buyButtonActionPerformed(evt);
                } catch (SQLException ex) {
                    Logger.getLogger(MainPage1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        rmcrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
                        Statement st = conn.createStatement();

                        st.executeUpdate("delete from producttable where user_id='"+usid+"' and p_name='"+rbrand+"' and brand='"+rmodel+"' and cost='"+rprice+"' and status='no'");
                        conn.close();
                        System.out.println("Success!");
            } catch (ClassNotFoundException | SQLException e) {
                        System.out.println("     " + e);
                    }
            d.setVisible(false);
            cartButtonActionPerformed(evt);
            }
        });
           cartItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartItemTableMouseClicked(evt);
            }
        });
        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); 
        jLabel5.setText("Total Bill:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(462, 462, 462)
                .addComponent(billLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
                .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(377, 377, 377)
                    .addComponent(jLabel5)
                    .addContainerGap(746, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(billLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addContainerGap(435, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(49, 49, 49)))
        );

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(cartPanelLayout.createSequentialGroup()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 40, Short.MAX_VALUE)))
        );

        cardParentPanel.add(cartPanel, "card8");

        
        BackgroundPanel.add(cardParentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1200, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        
        
        pack();
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
        
    }

    private void newlyAddedActionPerformed(java.awt.event.ActionEvent evt) {
       
        cardParentPanel.removeAll();
        cardParentPanel.add(homePanel);
        cardParentPanel.repaint();
        cardParentPanel.revalidate();
        
        //Adding last three entries from every categories in home
        
        ArrayList<ProductList> list = ElectronicsDB.homePageContent();
        
        Object rowData[] = new Object[6];
        
        DefaultTableModel model =  (DefaultTableModel) homeTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        homeTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        homeTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        

       
        model.setRowCount(0); 
        
        for(int i=0; i<list.size(); i++){
            rowData[0] = list.get(i).getBrand();
            rowData[1] = list.get(i).getModel();
            rowData[2] = list.get(i).getPrice();
            
            rowData[3] = list.get(i).getDescription();
            ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMimage()).getImage()
             .getScaledInstance(160, 160, Image.SCALE_SMOOTH) );   
            rowData[4] = image;
            model.addRow(rowData);
            homeTable.setRowHeight(150);
            homeTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        }
         
    }

    private void newlyAddedMouseReleased(java.awt.event.MouseEvent evt) {
        
        newlyAdded.setBackground(new Color(51,102,255));
    }

    private void newlyAddedMousePressed(java.awt.event.MouseEvent evt) {
        
        newlyAdded.setBackground(new Color(153,153,153));
    }

    private void newlyAddedMouseExited(java.awt.event.MouseEvent evt) {
       
        newlyAdded.setBackground(new Color(51,102,255));
    }

    private void newlyAddedMouseEntered(java.awt.event.MouseEvent evt) {
      
        newlyAdded.setBackground(new Color(153,153,153));

    }

    private void newlyAddedMouseClicked(java.awt.event.MouseEvent evt) {
        
    }

    private void electronicsButtonMouseClicked(java.awt.event.MouseEvent evt) {
   
        cardParentPanel.removeAll();
        cardParentPanel.add(electronicsPanel);
        cardParentPanel.repaint();
        cardParentPanel.revalidate();
    }

    private void electronicsButtonMouseEntered(java.awt.event.MouseEvent evt) {
       
         electronicsButton.setBackground(new Color(153,153,153));
    }
    
    private void electronicsButtonMouseExited(java.awt.event.MouseEvent evt) {
        
        electronicsButton.setBackground(new Color(51,102,255));
    }

    private void electronicsButtonMousePressed(java.awt.event.MouseEvent evt) {
        
        electronicsButton.setBackground(new Color(153,153,153));
    }

    private void electronicsButtonMouseReleased(java.awt.event.MouseEvent evt) {
        
         electronicsButton.setBackground(new Color(51,102,255));
    }

    private void electronicsButtonActionPerformed(java.awt.event.ActionEvent evt) {
       
        ProductInformation.categoryChooser = "electronics";
        ArrayList<ProductList> list = ElectronicsDB.TableGenerator();
        Object rowData[] = new Object[6];
        
        DefaultTableModel model =  (DefaultTableModel) electronicsTable.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        electronicsTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        electronicsTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        electronicsTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        electronicsTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        

       
        model.setRowCount(0); 
        
        for(int i=0; i<list.size(); i++){
            rowData[0] = list.get(i).getBrand();
            rowData[1] = list.get(i).getModel();
            rowData[2] = list.get(i).getPrice();
           
            rowData[3] = list.get(i).getDescription();
            ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMimage()).getImage()
             .getScaledInstance(160, 160, Image.SCALE_SMOOTH) );   
            rowData[4] = image;
            model.addRow(rowData);
            electronicsTable.setRowHeight(150);
            electronicsTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        }
    }

    private void accountButtonMouseClicked(java.awt.event.MouseEvent evt) {
       
    }

    private void accountButtonMouseEntered(java.awt.event.MouseEvent evt) {
       
        accountButton.setBackground(new Color(153,153,153));
    }

    private void accountButtonMouseExited(java.awt.event.MouseEvent evt) {
        
        accountButton.setBackground(new Color(51,102,255));
    }

    private void accountButtonMousePressed(java.awt.event.MouseEvent evt) {
       
        accountButton.setBackground(new Color(153,153,153));
    }

    private void accountButtonMouseReleased(java.awt.event.MouseEvent evt) {
        
        accountButton.setBackground(new Color(51,102,255));

    }

    private void accountButtonActionPerformed(java.awt.event.ActionEvent evt) {
       
    }

    public void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {
        cardParentPanel.removeAll();
        cardParentPanel.add(cartPanel);
        cardParentPanel.repaint();
        cardParentPanel.revalidate();
        
         boolean tf=false;
        try {
            DefaultTableModel model =  (DefaultTableModel) cartItemTable.getModel();
         model.setRowCount(0);
         total = 0;
         tot = "";
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/s4s", "root", "");
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("select * from producttable where user_id=" +usid+ " AND  status='no'");
                        while (rs.next()) {
                            data[0] = rs.getString("P_name");
                            data[1] = rs.getString("brand");
                            data[2] = rs.getString("cost");
                            total=total+rs.getInt("cost");
                            model.addRow(data);
                            cartItemTable.setRowHeight(20);
                            if((usid.equals(rs.getString("user_id"))&&("no".equals(rs.getString("status")))))
                                  {
                                    tf=true;
                                  }
                        }
                        billLabel.setText(String.valueOf(total));
                        //st.executeUpdate("update producttb,"+s+" set  where "+s+".ordered=1 ");
                        conn.close();
                        System.out.println("Success!");
                    } catch (ClassNotFoundException | SQLException e) {
                        System.out.println("     " + e);
                    }
        
            
            cartItemTable.setRowHeight(20);
            
       
                     if(tf==true)
                           {
                              buyButton.setEnabled(true);
                           }  
                     else
                     {
                         buyButton.setEnabled(false);
                     }
            
        
       
        billLabel.setText(String.valueOf(total));
        
    }
    
    private void cartButtonMouseClicked(java.awt.event.MouseEvent evt) {
       
    }

    private void cartButtonMouseEntered(java.awt.event.MouseEvent evt) {
       
        cartButton.setBackground(new Color(153,153,153));
    }

    private void cartButtonMouseExited(java.awt.event.MouseEvent evt) {
       
        cartButton.setBackground(new Color(51,102,255));
    }

    private void cartButtonMousePressed(java.awt.event.MouseEvent evt) {
        
        cartButton.setBackground(new Color(153,153,153));
    }

    private void cartButtonMouseReleased(java.awt.event.MouseEvent evt) {
        
        cartButton.setBackground(new Color(51,102,255));
    }

   ProductInformation pi = new ProductInformation();
    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        
                       purchase pw=new purchase();
                             pw.confirmord();  
                        
                          
    }
    private void electronicsTableMouseClicked(java.awt.event.MouseEvent evt) {
       
        pi.setVisible(true);
        pi.pack();
        
        int selectedRow = electronicsTable.getSelectedRow();
        TableModel tm = electronicsTable.getModel();
        
        String brand = tm.getValueAt(selectedRow, 0).toString();
        String model = tm.getValueAt(selectedRow, 1).toString();
        String price = tm.getValueAt(selectedRow, 2).toString();
       
        String feature = tm.getValueAt(selectedRow, 3).toString();
        ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);
        
        pi.productInfoBrandName.setText(brand);
        pi.productInfoModel.setText(model);
        pi.productInfoPrice.setText(price);
       
        pi.productInfoFeature.setText(feature);
        pi.productPhoto.setIcon(img);
    }
    private void cartItemTableMouseClicked(java.awt.event.MouseEvent evt)
    {
        GroupLayout dLayout = new GroupLayout(d.getContentPane());
        d.getContentPane().setLayout(dLayout);
        dLayout.setHorizontalGroup(
                dLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(dLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(dwrc)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(dLayout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(rmcrt)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(nrmcrt)
                                .addGap(82, 82, 82))
        );
        dLayout.setVerticalGroup(
                dLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(dLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(dwrc)
                                .addGap(36, 36, 36)
                                .addGroup(dLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(rmcrt)
                                        .addComponent(nrmcrt))
                                .addContainerGap(44, Short.MAX_VALUE))
        );
        d.setLocationRelativeTo(d);
        d.pack();
        d.setVisible(true); 
       int selectedRow =cartItemTable.getSelectedRow();
       
       TableModel tm = cartItemTable.getModel();
        
        rbrand = tm.getValueAt(selectedRow, 0).toString();
        rmodel = tm.getValueAt(selectedRow, 1).toString();
        rprice = tm.getValueAt(selectedRow, 2).toString();
        
        
        
    }
    private void homeTableMouseClicked(java.awt.event.MouseEvent evt) {
        
        int rowIndex = homeTable.getSelectedRow();
        
        if(rowIndex>=0)
            ProductInformation.categoryChooser = "electronics";
        
        pi.setVisible(true);
        pi.pack();
        
        int selectedRow = homeTable.getSelectedRow();
        TableModel tm = homeTable.getModel();
        
        String brand = tm.getValueAt(selectedRow, 0).toString();
        String model = tm.getValueAt(selectedRow, 1).toString();
        String price = tm.getValueAt(selectedRow, 2).toString();
        
        String feature = tm.getValueAt(selectedRow, 3).toString();
        ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);
        
        pi.productInfoBrandName.setText(brand);
        pi.productInfoModel.setText(model);
        pi.productInfoPrice.setText(price);
        
        pi.productInfoFeature.setText(feature);
        pi.productPhoto.setIcon(img);
    }

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {
        
    }

    private void searchButtonMouseEntered(java.awt.event.MouseEvent evt) {
       searchButton.setBackground(new Color(153,153,153));
    }

    private void searchButtonMouseExited(java.awt.event.MouseEvent evt) {
        searchButton.setBackground(new Color(51,102,255));
    }

    private void searchButtonMousePressed(java.awt.event.MouseEvent evt) {
        
        searchButton.setBackground(new Color(153,153,153));
    }

    private void searchButtonMouseReleased(java.awt.event.MouseEvent evt) {
        
        searchButton.setBackground(new Color(51,102,255));
    }

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {
       
        Search.electronics=0;
      
        ArrayList<ProductList> list = Search.mobileSearch(searchBar.getText());
        Object rowData[] = new Object[6];
        int i;
        
        
        if(searchBar.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Search field empty!");
        else if(Search.electronics==0 )
            JOptionPane.showMessageDialog(null, "Sorry! Product does not exist!");
        else{
            cardParentPanel.removeAll();
            cardParentPanel.add(searchPanel);
            cardParentPanel.repaint();
            cardParentPanel.revalidate();
                    
            DefaultTableModel model =  (DefaultTableModel) searchTable.getModel();
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            searchTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
            searchTable.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            searchTable.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            searchTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            


            model.setRowCount(0);
            for(i=0 ; i<Search.electronics; i++){
                rowData[0] = list.get(i).getBrand();
                rowData[1] = list.get(i).getModel();
                rowData[2] = list.get(i).getPrice();
                
                rowData[3] = list.get(i).getDescription();
               ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMimage()).getImage()
             .getScaledInstance(160, 160, Image.SCALE_SMOOTH) );   
            rowData[4] = image;
                model.addRow(rowData);
                searchTable.setRowHeight(150);
                searchTable.getColumnModel().getColumn(5).setPreferredWidth(150);
            }
            
        }
    }

    private void searchBarMouseClicked(java.awt.event.MouseEvent evt) {
        
        searchBar.setText("");
    }
    public void rmcrtButtonActionPerformed(java.awt.event.MouseEvent evt)
    {
        
        
    }
    private void searchTableMouseClicked(java.awt.event.MouseEvent evt) {
        
        int rowIndex = searchTable.getSelectedRow();
        
        if(Search.electronics!=0 && rowIndex<Search.electronics)
            ProductInformation.categoryChooser = "electronics";
        
        pi.setVisible(true);
        pi.pack();
        
        int selectedRow = searchTable.getSelectedRow();
        TableModel tm = searchTable.getModel();
        
        String brand = tm.getValueAt(selectedRow, 0).toString();
        String model = tm.getValueAt(selectedRow, 1).toString();
        String price = tm.getValueAt(selectedRow, 2).toString();
        
        String feature = tm.getValueAt(selectedRow, 3).toString();
        ImageIcon img = (ImageIcon) tm.getValueAt(selectedRow, 4);
        
        pi.productInfoBrandName.setText(brand);
        pi.productInfoModel.setText(model);
        pi.productInfoPrice.setText(price);
        
        pi.productInfoFeature.setText(feature);
        pi.productPhoto.setIcon(img);
    }
    
    public static void main(String args[]) {
        JFrame newMain = new MainPage1();
        newMain.setTitle("C2C Shopping Cart");
        newMain.setVisible(true);
        newMain.setResizable(false);    
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton accountButton;
    public static javax.swing.JLabel billLabel;
    public javax.swing.JButton buyButton;
    private javax.swing.JPanel cardParentPanel;
    private javax.swing.JButton cartButton;
    public static javax.swing.JTable cartItemTable;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JButton electronicsButton;
    private javax.swing.JPanel electronicsPanel;
    private javax.swing.JTable electronicsTable;
    private javax.swing.JPanel homePanel;
    private javax.swing.JTable homeTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JButton newlyAdded;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTable searchTable;
    private  JButton rmcrt=new JButton("YES");
    private  JButton nrmcrt=new JButton("NO");
    private  JLabel dwrc=new JLabel("REMOVE FROM CART");
    private  JDialog d = new JDialog();
    // End of variables declaration
}
