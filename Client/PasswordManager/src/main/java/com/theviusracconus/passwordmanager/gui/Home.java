package com.theviusracconus.passwordmanager.gui;

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import com.theviusracconus.passwordmanager.reference.Reference;
import com.theviusracconus.passwordmanager.user.Site;
import com.theviusracconus.passwordmanager.user.Sites;
import com.theviusracconus.passwordmanager.user.CurrentUser;
import java.util.ArrayList;

/**
 *
 * @author 16watsones
 */
public class Home extends javax.swing.JPanel {

    /**
     * Creates new form Home
     */
    public Home() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        editMenu = new javax.swing.JMenuItem();
        copyUsernameMenu = new javax.swing.JMenuItem();
        copyPasswordMenu = new javax.swing.JMenuItem();
        openSiteMenu = new javax.swing.JMenuItem();
        scrollPane = new javax.swing.JScrollPane();
        siteList = new javax.swing.JList();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        editMenu.setText("Edit Site");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });
        popupMenu.add(editMenu);

        copyUsernameMenu.setText("Copy Username");
        copyUsernameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyUsernameMenuActionPerformed(evt);
            }
        });
        popupMenu.add(copyUsernameMenu);

        copyPasswordMenu.setText("Copy Password");
        copyPasswordMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyPasswordMenuActionPerformed(evt);
            }
        });
        popupMenu.add(copyPasswordMenu);

        openSiteMenu.setText("Open Site");
        openSiteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openSiteMenuActionPerformed(evt);
            }
        });
        popupMenu.add(openSiteMenu);

        initList(CurrentUser.getSites());
        siteList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siteListMouseClicked(evt);
            }
        });
        siteList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                siteListKeyPressed(evt);
            }
        });
        scrollPane.setViewportView(siteList);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(logoutButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, logoutButton, removeButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(removeButton)
                    .addComponent(logoutButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        add();
    }//GEN-LAST:event_addButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        remove();
    }//GEN-LAST:event_removeButtonActionPerformed

    private void siteListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siteListMouseClicked
        JList list = (JList)evt.getSource();
        
        if(SwingUtilities.isRightMouseButton(evt) && list.getModel().getSize() > 0)
        {
            int row = list.locationToIndex(evt.getPoint());
            list.setSelectedIndex(row);
            popupMenu.show(siteList, evt.getX(), evt.getY());
        }
        else if(evt.getClickCount() == 2 && list.getModel().getSize() > 0)
        {
            editSite();
        }
    }//GEN-LAST:event_siteListMouseClicked

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        editSite();
    }//GEN-LAST:event_editMenuActionPerformed

    private void copyUsernameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyUsernameMenuActionPerformed
        copyUsername();
    }//GEN-LAST:event_copyUsernameMenuActionPerformed

    private void copyPasswordMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyPasswordMenuActionPerformed
        copyPassword();
    }//GEN-LAST:event_copyPasswordMenuActionPerformed

    private void openSiteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openSiteMenuActionPerformed
        openSite();
    }//GEN-LAST:event_openSiteMenuActionPerformed

    private void siteListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_siteListKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_DELETE)
        {
            remove();
        }
        if(evt.getKeyCode() == KeyEvent.VK_N && evt.isControlDown())
        {
            add();
        }
    }//GEN-LAST:event_siteListKeyPressed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        CurrentUser.sites = new ArrayList<Site>();
        CurrentUser.userId = 0;
        CurrentUser.username = "";
        PasswordManagerGUI frame = (PasswordManagerGUI)SwingUtilities.getRoot(this);
        frame.setPanel("Login");
        String title = frame.getTitle();
        title = title.substring(0, title.indexOf(" - "));
        frame.setTitle(title);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void editSite()
    {
        int index = siteList.getSelectedIndex();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a site to edit!");
        }
        else
        {
            PasswordManagerGUI frame = (PasswordManagerGUI)SwingUtilities.getRoot(this);
            frame.setPanel("Edit Site");
            frame.getEditSitePanel().setSite(CurrentUser.sites.get(index));
        }
    }
    
    private void copyUsername()
    {
        int index = siteList.getSelectedIndex();
        String username;
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a site!");
        }
        
        username = CurrentUser.sites.get(index).getUsername();
        Reference.copy(username);
    }
    
    private void copyPassword()
    {
        int index = siteList.getSelectedIndex();
        String password;
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "You must select a site!");
        }
        
        password = CurrentUser.sites.get(index).getPassword();
        Reference.copy(password);
    }
    
    private void openSite()
    {
        int index = siteList.getSelectedIndex();
        String url = CurrentUser.sites.get(index).getSiteName();
        if(url.length() < 4 || !url.substring(0, 4).equals("www."))
        {
            url = "www." + url;
        }
        if(Desktop.isDesktopSupported())
        {
            Desktop desktop = Desktop.getDesktop();
            try 
            {
                desktop.browse(new URI(url));
            } 
            catch (IOException ex) 
            {
                ex.printStackTrace();
            }
            catch (URISyntaxException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            Runtime runtime = Runtime.getRuntime();
            try 
            {
                runtime.exec("xdg-open " + url);
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }

    }
    
    private void remove()
    {
        int[] indices = siteList.getSelectedIndices();
        String message = "Are you sure you would like to remove " + indices.length;
        if(indices.length > 1)
        {
            message += " sites?";
        }
        else if (indices.length == 1)
        {
            message += " site?";
        }
        else
        {
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, message);
        if(confirm == JOptionPane.YES_OPTION)
        {
            CurrentUser.removeSites(indices);
        }
        initList(CurrentUser.getSites());
    }
    
    private void add()
    {
        PasswordManagerGUI frame = (PasswordManagerGUI)SwingUtilities.getRoot(this);
        frame.setPanel("New Site");
    }
    
    public void initList(final String[] sites)
    {
        siteList.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return sites.length; }
            public Object getElementAt(int i) { return sites[i]; }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JMenuItem copyPasswordMenu;
    private javax.swing.JMenuItem copyUsernameMenu;
    private javax.swing.JMenuItem editMenu;
    private javax.swing.JButton logoutButton;
    private javax.swing.JMenuItem openSiteMenu;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JList siteList;
    // End of variables declaration//GEN-END:variables
}