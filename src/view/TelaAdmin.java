package view;

import control.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAdmin extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String id;

    public TelaAdmin() {
        initComponents();
        con = conexao.AbrirConexao();
    }

    private void PesquisarContatos() {
        String sql = "select * from contato";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            TABELACONTATO.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }
    
    
     private void PesquisarContatosPorAssunto() throws SQLException {
        String sql = "select * from contato where assunto like ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, campoPesquisaContato.getText() + "%");
            rs = pst.executeQuery();

            TABELACONTATO.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABELACONTATO = new javax.swing.JTable();
        BuscarMensa = new javax.swing.JLabel();
        campoPesquisaContato = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mensagens");
        setToolTipText("");
        setAutoscrolls(true);
        setPreferredSize(new java.awt.Dimension(615, 450));
        setVisible(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        TABELACONTATO.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TABELACONTATO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Assunto", "Mensagem"
            }
        ));
        TABELACONTATO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABELACONTATOMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABELACONTATO);

        BuscarMensa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Buacar.png"))); // NOI18N
        BuscarMensa.setToolTipText("");
        BuscarMensa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarMensa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BuscarMensaMouseClicked(evt);
            }
        });

        campoPesquisaContato.setToolTipText("");
        campoPesquisaContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoPesquisaContatoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoPesquisaContato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BuscarMensa)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BuscarMensa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoPesquisaContato))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 619, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarMensaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMensaMouseClicked
        PesquisarContatos();
    }//GEN-LAST:event_BuscarMensaMouseClicked

    private void TABELACONTATOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABELACONTATOMouseClicked

    }//GEN-LAST:event_TABELACONTATOMouseClicked

    private void campoPesquisaContatoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPesquisaContatoKeyReleased
        try {
            PesquisarContatosPorAssunto();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campoPesquisaContatoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BuscarMensa;
    private javax.swing.JTable TABELACONTATO;
    private javax.swing.JTextField campoPesquisaContato;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
