package gui;

import user.UserList;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import reference.Reference;

public class PasswordManagerGUI extends javax.swing.JFrame 
{
    
    private Login loginPanel;
    private NewAccount newAccountPanel;
    private Home homePanel;
    private NewSite newSitePanel;
    private EditSite editSitePanel;
    private CardLayout cardLayout;
    
    
    public PasswordManagerGUI() 
    {
        loginPanel = new Login();
        newAccountPanel = new NewAccount();
        homePanel = new Home();
        newSitePanel = new NewSite();
        editSitePanel = new EditSite();
        initComponents();
        
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/lock.png"));
        setIconImage(icon.getImage());
        
        cards.add(loginPanel, "Login");
        cards.add(newAccountPanel, "New Account");
        cards.add(homePanel, "Home");
        cards.add(newSitePanel, "New Site");
        cards.add(editSitePanel, "Edit Site");
        
        cardLayout = (CardLayout) cards.getLayout();
        
        if(!UserList.currentUser.getUsername().equals(""))
        {
            setPanel("Home");
        }
        else
        {
            setPanel("Login");   
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Manager");

        cards.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    public void setPanel(String title)
    {
        if(title.equals("Home") && getTitle().indexOf("-") == -1)
        {
            setTitle(getTitle() + " - " + UserList.currentUser.getUsername());
        }
        cardLayout.show(cards, title);
    }
    
    public Home getHomePanel()
    {
        return homePanel;
    }
    
    public EditSite getEditSitePanel()
    {
        return editSitePanel;
    }
    
    /**  
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordManagerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        UserList.initList();
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PasswordManagerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel cards;
    // End of variables declaration//GEN-END:variables
}
