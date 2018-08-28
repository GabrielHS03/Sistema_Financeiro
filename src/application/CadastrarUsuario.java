/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import DAO.UsuarioDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Usuario;

/**
 *
 * @author Alyson-Casa
 */
public class CadastrarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarUsuario() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        jTUsuarios.setRowSorter(new TableRowSorter(modelo));

        readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jCadastrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTUsuarios = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jExcluir = new javax.swing.JButton();
        jAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome do Usuario");

        jLabel2.setText("Senha do Usuario");

        jCadastrar.setText("Cadastrar");
        jCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCadastrarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        jTUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuario", "Senha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTUsuarios);

        jLabel3.setText("Usuario Cadastrados");

        jExcluir.setText("Excluir");
        jExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExcluirActionPerformed(evt);
            }
        });

        jAlterar.setText("Alterar");
        jAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCadastrar)
                                .addGap(77, 77, 77)
                                .addComponent(jExcluir)
                                .addGap(45, 45, 45)
                                .addComponent(jAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jCadastrar)
                    .addComponent(jExcluir)
                    .addComponent(jAlterar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTUsuarios.getModel();
        modelo.setNumRows(0);
        UsuarioDAO userDAO = new UsuarioDAO();
        for (Usuario user : userDAO.buscarTodos()) {
            modelo.addRow(new Object[]{
                user.getID(),
                user.getLogin(),
                user.getSenha(),});
        }

    }

    private void jCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCadastrarActionPerformed
        Usuario user = new Usuario();
        UsuarioDAO userDAO = new UsuarioDAO();

        user.setLogin(txtUsuario.getText());
        user.setSenha(txtSenha.getText());

        userDAO.save(user);

        txtUsuario.setText("");
        txtSenha.setText("");
        readJTable();

    }//GEN-LAST:event_jCadastrarActionPerformed

    private void jExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExcluirActionPerformed
        // TODO add your handling code here:

        if (jTUsuarios.getSelectedRow() != -1) {

        if (jTUsuarios.getSelectedRow() != -1) {

            Usuario user = new Usuario();
            UsuarioDAO userDAO = new UsuarioDAO();

            user.setLogin(txtUsuario.getText());
            user.setSenha(txtSenha.getText());
            //user.setID((int)jTUsuarios.getValueAt(jTUsuarios.getSelectedRow(), 0));
            userDAO.remove((int)jTUsuarios.getValueAt(jTUsuarios.getSelectedRow(), 0));

            txtUsuario.setText("");
            txtSenha.setText("");
            readJTable();
        }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um usuarios para excluir");
        }

        //System.out.println("Linha Selecionada"+jTUsuarios.getSelectedRow());

    }//GEN-LAST:event_jExcluirActionPerformed

    private void jTUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuariosMouseClicked
        // TODO add your handling code here:
        if (jTUsuarios.getSelectedRow() != -1) {
            txtUsuario.setText(jTUsuarios.getValueAt(jTUsuarios.getSelectedRow(), 1).toString());
            txtSenha.setText(jTUsuarios.getValueAt(jTUsuarios.getSelectedRow(), 2).toString());
        }


    }//GEN-LAST:event_jTUsuariosMouseClicked

    private void jAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarActionPerformed

        if (jTUsuarios.getSelectedRow() != -1) {

            Usuario user = new Usuario();
            UsuarioDAO userDAO = new UsuarioDAO();

            user.setLogin(txtUsuario.getText());
            user.setSenha(txtSenha.getText());
            user.setID((int)jTUsuarios.getValueAt(jTUsuarios.getSelectedRow(), 0));
            userDAO.save(user);

            txtUsuario.setText("");
            txtSenha.setText("");
            readJTable();
        }
    }//GEN-LAST:event_jAlterarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jCadastrar;
    private javax.swing.JButton jExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTUsuarios;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}