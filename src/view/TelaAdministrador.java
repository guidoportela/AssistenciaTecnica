package view;

import control.conexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAdministrador extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String id;

    public TelaAdministrador() {
        initComponents();

        con = (Connection) conexao.AbrirConexao();
    }

    private void PesquisarCadastrados() throws SQLException {
        String sql = "select * from cadastrar where nome like ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, campopesq.getText() + "%");
            rs = pst.executeQuery();

            tabelaadm.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void listarCampos() {
        int listar = tabelaadm.getSelectedRow();
        cid.setText(tabelaadm.getValueAt(listar, 0).toString());
        xnome.setText(tabelaadm.getValueAt(listar, 1).toString());
        xend.setText(tabelaadm.getValueAt(listar, 2).toString());
        xcep.setText(tabelaadm.getValueAt(listar, 3).toString());
        xcidade.setText(tabelaadm.getValueAt(listar, 4).toString());
        xuf.setSelectedItem(tabelaadm.getValueAt(listar, 5).toString());
        xfone.setText(tabelaadm.getModel().getValueAt(listar, 6).toString());
        xemail.setText(tabelaadm.getModel().getValueAt(listar, 7).toString());
        xcpf.setText(tabelaadm.getValueAt(listar, 8).toString());
        xPerfil.setSelectedItem(tabelaadm.getValueAt(listar, 9).toString());
    }

    private void Alterar() {
        String sql = "update cadastrar set nome =?,endereco=?,cep =?,cidade =?,uf =?,telefone =?,email =?,cpf=?, perfil=? where nome =?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, xnome.getText());
            pst.setString(2, xend.getText());
            pst.setString(3, xcep.getText());
            pst.setString(4, xcidade.getText());
            pst.setString(5, xuf.getSelectedItem().toString());
            pst.setString(6, xfone.getText());
            pst.setString(7, xemail.getText());
            pst.setString(8, xcpf.getText());
            pst.setString(9, xPerfil.getSelectedItem().toString());
            pst.setString(10, xnome.getText());

            if ((xnome.getText().isEmpty()) || (xfone.getText().isEmpty()) || (xPerfil.getSelectedItem().toString().isEmpty()) || (xuf.getSelectedItem().toString().isEmpty()) || (xcpf.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS VAZIOS!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                int adc = pst.executeUpdate();

                if (adc > 0) {
                    JOptionPane.showMessageDialog(null, "DADOS ALTERADOS COM SUCESSO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    cid.setText(null);
                    xnome.setText(null);
                    xend.setText(null);
                    xcep.setText(null);
                    xcidade.setText(null);
                    xuf.setSelectedItem(null);
                    xfone.setText(null);
                    xemail.setText(null);
                    xcpf.setText(null);
                    xPerfil.setSelectedItem(null);

                } else {
                    JOptionPane.showMessageDialog(null, "ERRO AO TENTAR ALTERAR!", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void remover() {
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este Usuário ?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from cadastrar where id=?";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, cid.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, "USUÁRIO EXCLUIDO COM SUCESSO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    cid.setText(null);
                    xnome.setText(null);
                    xend.setText(null);
                    xcep.setText(null);
                    xcidade.setText(null);
                    xuf.setSelectedItem(null);
                    xfone.setText(null);
                    xemail.setText(null);
                    xcpf.setText(null);
                    xPerfil.setSelectedItem(null);
                }
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaadm = new javax.swing.JTable();
        campopesq = new javax.swing.JTextField();
        xnome = new javax.swing.JTextField();
        xemail = new javax.swing.JTextField();
        xcidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        xfone = new javax.swing.JFormattedTextField();
        xcep = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        xend = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        xcpf = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        cid = new javax.swing.JTextField();
        lbBuscar = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        xPerfil = new javax.swing.JComboBox<String>();
        xuf = new javax.swing.JComboBox<String>();
        btAlterar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Adiministrador / Edição");
        setPreferredSize(new java.awt.Dimension(615, 450));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(615, 420));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        tabelaadm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nome", "telefone", "email", "cep", "bairro", "uf", "cidade"
            }
        ));
        tabelaadm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaadmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaadm);

        campopesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campopesqActionPerformed(evt);
            }
        });
        campopesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campopesqKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Nome:");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Fone:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Cep:");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Uf:");

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Cidade:");

        try {
            xfone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            xcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Endereço:");

        xend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xendActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Cpf:");

        try {
            xcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Id:");

        cid.setEditable(false);
        cid.setEnabled(false);

        lbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Buacar.png"))); // NOI18N
        lbBuscar.setToolTipText("PESQUISAR");
        lbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbBuscarKeyReleased(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel65.setText("Perfil:");

        xPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        xuf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));

        btAlterar.setBackground(new java.awt.Color(204, 204, 204));
        btAlterar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/UserEditar.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("ALTERAR");
        btAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btRemover.setBackground(new java.awt.Color(204, 204, 204));
        btRemover.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/UserRemover.png"))); // NOI18N
        btRemover.setText("Deletar");
        btRemover.setToolTipText("DELETAR");
        btRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.gif"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.setToolTipText("SAIR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campopesq, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btRemover)
                                        .addGap(25, 25, 25))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(xemail, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(xnome)
                                    .addComponent(xend, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel10))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(xuf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel65)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(xPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(xcep, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(xfone)
                                .addComponent(xcpf))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(31, 31, 31)))))
                .addGap(0, 4, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {xcidade, xemail, xend, xnome});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAlterar, btRemover, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campopesq, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(xnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(xcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(xemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(xfone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(xend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(xcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(cid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(xcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(xuf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(xPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRemover)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {xcidade, xemail, xend, xnome});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAlterar, btRemover, jButton1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        setBounds(0, 0, 619, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        Alterar();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void lbBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbBuscarKeyReleased
        try {
            PesquisarCadastrados();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbBuscarKeyReleased

    private void campopesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campopesqKeyReleased
        try {
            PesquisarCadastrados();
        } catch (SQLException ex) {
            Logger.getLogger(TelaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_campopesqKeyReleased

    private void campopesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campopesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campopesqActionPerformed

    private void tabelaadmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaadmMouseClicked
        listarCampos();
    }//GEN-LAST:event_tabelaadmMouseClicked

    private void xendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btRemover;
    private javax.swing.JTextField campopesq;
    private javax.swing.JTextField cid;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBuscar;
    private javax.swing.JTable tabelaadm;
    private javax.swing.JComboBox<String> xPerfil;
    private javax.swing.JFormattedTextField xcep;
    private javax.swing.JTextField xcidade;
    private javax.swing.JFormattedTextField xcpf;
    private javax.swing.JTextField xemail;
    private javax.swing.JTextField xend;
    private javax.swing.JFormattedTextField xfone;
    private javax.swing.JTextField xnome;
    private javax.swing.JComboBox<String> xuf;
    // End of variables declaration//GEN-END:variables
}
