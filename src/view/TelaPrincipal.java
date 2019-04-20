package view;

import control.conexao;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DateFormat;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import java.util.Date;

public class TelaPrincipal extends javax.swing.JFrame {

    Connection con = null;

    public TelaPrincipal() {
        initComponents();
        con = conexao.AbrirConexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Desktop = new javax.swing.JDesktopPane();
        nomeUser = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imaUser = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menOpCadas = new javax.swing.JMenuItem();
        opcOS = new javax.swing.JMenu();
        menOpOs = new javax.swing.JMenuItem();
        MenuAdm = new javax.swing.JMenu();
        OpcMsg = new javax.swing.JMenuItem();
        OpcEditor = new javax.swing.JMenuItem();
        MenuRelatorio = new javax.swing.JMenu();
        menRelCli = new javax.swing.JMenuItem();
        menRelServ = new javax.swing.JMenuItem();
        menuContato = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        MenOpc = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Assistencia Tecnica");
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel2.setText("jLabel2");

        Desktop.setPreferredSize(new java.awt.Dimension(615, 450));

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        nomeUser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        nomeUser.setText("Usuário");

        jLabel3.setText("jLabel3");

        imaUser.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        imaUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/inspiration-39-128.png"))); // NOI18N

        lbData.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbData.setText("DATA");
        lbData.setToolTipText("");

        jMenuBar1.setPreferredSize(new java.awt.Dimension(60, 30));

        menuCadastrar.setText("Cadastrar");
        menuCadastrar.setToolTipText("");
        menuCadastrar.setEnabled(false);
        menuCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCadastrarMouseClicked(evt);
            }
        });

        menOpCadas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        menOpCadas.setText("Cadastrar");
        menOpCadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpCadasActionPerformed(evt);
            }
        });
        menuCadastrar.add(menOpCadas);

        jMenuBar1.add(menuCadastrar);

        opcOS.setText("OS");
        opcOS.setToolTipText("");
        opcOS.setEnabled(false);
        opcOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                opcOSMouseClicked(evt);
            }
        });
        opcOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcOSActionPerformed(evt);
            }
        });

        menOpOs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        menOpOs.setText("Ordem de Serviço");
        menOpOs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menOpOsActionPerformed(evt);
            }
        });
        opcOS.add(menOpOs);

        jMenuBar1.add(opcOS);

        MenuAdm.setText("Administrador");
        MenuAdm.setToolTipText("");
        MenuAdm.setEnabled(false);

        OpcMsg.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        OpcMsg.setText("Adm Mensagens");
        OpcMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcMsgActionPerformed(evt);
            }
        });
        MenuAdm.add(OpcMsg);

        OpcEditor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        OpcEditor.setText("Adm Editor");
        OpcEditor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpcEditorActionPerformed(evt);
            }
        });
        MenuAdm.add(OpcEditor);

        jMenuBar1.add(MenuAdm);

        MenuRelatorio.setText("Relatório");
        MenuRelatorio.setToolTipText("");
        MenuRelatorio.setEnabled(false);

        menRelCli.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menRelCli.setText("Clientes");
        menRelCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelCliActionPerformed(evt);
            }
        });
        MenuRelatorio.add(menRelCli);

        menRelServ.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menRelServ.setText("Serviços");
        menRelServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menRelServActionPerformed(evt);
            }
        });
        MenuRelatorio.add(menRelServ);

        jMenuBar1.add(MenuRelatorio);

        menuContato.setText("Fale Conosco");
        menuContato.setToolTipText("");
        menuContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuContatoMouseClicked(evt);
            }
        });
        menuContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuContatoActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuContato);

        jMenu1.setText("Opções");
        jMenu1.setToolTipText("");

        MenOpc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        MenOpc.setText("Sair");
        MenOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenOpcActionPerformed(evt);
            }
        });
        jMenu1.add(MenOpc);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nomeUser)
                        .addGap(47, 47, 47))
                    .addComponent(imaUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbData)
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 388, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 378, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(nomeUser)
                .addGap(43, 43, 43)
                .addComponent(imaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbData)
                .addGap(49, 49, 49))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Desktop, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 238, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(0, 239, Short.MAX_VALUE)))
        );

        Desktop.getAccessibleContext().setAccessibleName("");

        setSize(new java.awt.Dimension(816, 559));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcOSActionPerformed

    private void OpcMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcMsgActionPerformed
        TelaAdmin ad = new TelaAdmin();
        ad.setVisible(true);
        Desktop.add(ad);
    }//GEN-LAST:event_OpcMsgActionPerformed

    private void OpcEditorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpcEditorActionPerformed
        TelaAdministrador adm = new TelaAdministrador();
        adm.setVisible(true);
        Desktop.add(adm);
    }//GEN-LAST:event_OpcEditorActionPerformed

    private void MenOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenOpcActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair? ",
                "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_MenOpcActionPerformed

    private void menuContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuContatoActionPerformed

    }//GEN-LAST:event_menuContatoActionPerformed

    private void menuContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuContatoMouseClicked
        TelaContato c = new TelaContato();
        c.setVisible(true);
        Desktop.add(c);
    }//GEN-LAST:event_menuContatoMouseClicked

    private void menuCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastrarMouseClicked

    }//GEN-LAST:event_menuCadastrarMouseClicked

    private void opcOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcOSMouseClicked

    }//GEN-LAST:event_opcOSMouseClicked

    private void menRelServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelServActionPerformed
        int confi = JOptionPane.showConfirmDialog(null, "Confirma a Emissãos deste Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confi == JOptionPane.YES_OPTION) {
            try {
                JasperPrint print = JasperFillManager.fillReport("C:/pasta/servicos.jasper", null, con);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_menRelServActionPerformed

    private void menRelCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menRelCliActionPerformed
        int confi = JOptionPane.showConfirmDialog(null, "Confirma a Emissãos deste Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confi == JOptionPane.YES_OPTION) {
            try {
                JasperPrint print = JasperFillManager.fillReport("C:/pasta/clientes.jasper", null, con);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_menRelCliActionPerformed

    private void menOpCadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpCadasActionPerformed
        TelaCadastrar cad = new TelaCadastrar();
        cad.setVisible(true);
        Desktop.add(cad);
    }//GEN-LAST:event_menOpCadasActionPerformed

    private void menOpOsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menOpOsActionPerformed
        TelaOS tos = new TelaOS();
        tos.setVisible(true);
        Desktop.add(tos);
    }//GEN-LAST:event_menOpOsActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        //substituição da label data pelo data atual
        Date data = new Date();
        DateFormat formato = DateFormat.getDateInstance(DateFormat.LONG);
        lbData.setText(formato.format(data));
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem MenOpc;
    public static javax.swing.JMenu MenuAdm;
    public static javax.swing.JMenu MenuRelatorio;
    private javax.swing.JMenuItem OpcEditor;
    private javax.swing.JMenuItem OpcMsg;
    private javax.swing.JLabel imaUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbData;
    private javax.swing.JMenuItem menOpCadas;
    private javax.swing.JMenuItem menOpOs;
    private javax.swing.JMenuItem menRelCli;
    private javax.swing.JMenuItem menRelServ;
    public static javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenu menuContato;
    public static javax.swing.JLabel nomeUser;
    public static javax.swing.JMenu opcOS;
    // End of variables declaration//GEN-END:variables
}
