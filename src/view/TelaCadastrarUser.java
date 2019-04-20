package view;

import control.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TelaCadastrarUser extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastrarUser() {
        initComponents();
        con = conexao.AbrirConexao();

    }

    private void adicionar() {
        String sql = "insert into cadastrar (nome,endereco,cep,cidade,uf,telefone,email,cpf, perfil, login, senha) values (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);

            pst.setString(1, nome.getText());
            pst.setString(2, end.getText());
            pst.setString(3, cep.getText());
            pst.setString(4, cidade.getText());
            pst.setString(5, uf.getSelectedItem().toString());
            pst.setString(6, telefone.getText());
            pst.setString(7, email.getText());
            pst.setString(8, cpf.getText());
            pst.setString(9, camPerfil.getSelectedItem().toString());
            pst.setString(10, clogin.getText());
            pst.setString(11, senha.getText());

            if (!isSenhasIguais()) {
                JOptionPane.showMessageDialog(null, "SENHAS DIFERENTES!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            if (existeCamposVazios()) {
                JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS VAZIOS!", "ERRO", JOptionPane.ERROR_MESSAGE);

            } else {
                int adc = pst.executeUpdate();
                if (adc > 0) {

                    JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO!", "ASSISTENCIA TECNICA", JOptionPane.INFORMATION_MESSAGE);

                    TelaLogin l = new TelaLogin();
                    l.setVisible(true);
                    this.dispose();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrar1 = new javax.swing.JPanel();
        jLabel61 = new javax.swing.JLabel();
        nome = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        cidade = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        cep = new javax.swing.JFormattedTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        cpf = new javax.swing.JFormattedTextField();
        jLabel73 = new javax.swing.JLabel();
        senha = new javax.swing.JPasswordField();
        jLabel74 = new javax.swing.JLabel();
        conf_senha = new javax.swing.JPasswordField();
        limpar = new javax.swing.JButton();
        confirmar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        telefone = new javax.swing.JFormattedTextField();
        uf = new javax.swing.JComboBox<String>();
        jLabel65 = new javax.swing.JLabel();
        camPerfil = new javax.swing.JComboBox<String>();
        jLabel75 = new javax.swing.JLabel();
        clogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar-Se");

        cadastrar1.setBackground(new java.awt.Color(204, 204, 204));
        cadastrar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel61.setText("NOME:");

        Id.setEditable(false);
        Id.setEnabled(false);
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel62.setText("ID:");

        jLabel64.setText("ENDEREÇO:");

        jLabel66.setText("CIDADE:");

        jLabel67.setText("UF:");

        jLabel69.setText("CEP:");

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel70.setText("TELEFONE:");

        jLabel71.setText("EMAIL:");

        jLabel72.setText("CPF:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel73.setText("SENHA:");

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        jLabel74.setText("CONFIRMAÇÃO: ");

        limpar.setBackground(new java.awt.Color(204, 204, 204));
        limpar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        limpar.setText("Limpar");
        limpar.setToolTipText("LIMPAR");
        limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        confirmar.setBackground(new java.awt.Color(204, 204, 204));
        confirmar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        confirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/UserAdd.png"))); // NOI18N
        confirmar.setText("Confirmar");
        confirmar.setToolTipText("CONFIRMAR");
        confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        confirmar.setMaximumSize(new java.awt.Dimension(60, 45));
        confirmar.setMinimumSize(new java.awt.Dimension(63, 45));
        confirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmarMouseClicked(evt);
            }
        });
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });

        cancelar.setBackground(new java.awt.Color(204, 204, 204));
        cancelar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("CANCELAR");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.setMaximumSize(new java.awt.Dimension(60, 45));
        cancelar.setMinimumSize(new java.awt.Dimension(60, 45));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        uf.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));

        jLabel65.setText("PERFIL:");

        camPerfil.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        camPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "user" }));

        jLabel75.setText("LOGIN:");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRAR-SE");

        javax.swing.GroupLayout cadastrar1Layout = new javax.swing.GroupLayout(cadastrar1);
        cadastrar1.setLayout(cadastrar1Layout);
        cadastrar1Layout.setHorizontalGroup(
            cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(limpar)
                        .addGap(45, 45, 45)
                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel66)
                            .addComponent(jLabel64)
                            .addComponent(jLabel70)
                            .addComponent(jLabel73)
                            .addComponent(jLabel65)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72)
                            .addComponent(jLabel75)
                            .addComponent(jLabel74))
                        .addGap(39, 39, 39)
                        .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(cadastrar1Layout.createSequentialGroup()
                                        .addComponent(nome)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel62)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(end, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cadastrar1Layout.createSequentialGroup()
                                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                        .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                                .addComponent(jLabel67)
                                                .addGap(18, 18, 18)
                                                .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                                .addComponent(jLabel69)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(78, 78, 78))
                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(conf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(camPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cpf)
                                        .addComponent(clogin)
                                        .addComponent(senha, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                        .addComponent(email)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrar1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(190, 190, 190))
        );

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelar, confirmar, limpar});

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {clogin, conf_senha, cpf, senha});

        cadastrar1Layout.setVerticalGroup(
            cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrar1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(camPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel70)
                        .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(clogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel73))
                .addGap(9, 9, 9)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(conf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(limpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cancelar, confirmar, limpar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(568, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
        nome.setText("");
        clogin.setText("");
        end.setText("");
        cep.setText("");
        cidade.setText("");
        uf.setSelectedItem("");
        telefone.setText("");
        email.setText("");
        senha.setText("");
        conf_senha.setText("");
        cpf.setText("");
    }//GEN-LAST:event_limparActionPerformed

    private void confirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarMouseClicked

    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        adicionar();
    }//GEN-LAST:event_confirmarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar esse cadastro? ", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            TelaLogin tl = new TelaLogin();
            tl.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_cancelarActionPerformed

    public boolean isSenhasIguais() {
        return senha.getText().equals(conf_senha.getText());
    }

    public boolean existeCamposVazios() {
        if (nome.getText().isEmpty()) {
            return true;
        }
        if (end.getText().isEmpty()) {
            return true;
        }
        if (cpf.getText().isEmpty()) {
            return true;
        }
        if (cep.getText().isEmpty()) {
            return true;
        }
        if (uf.getSelectedItem().toString().isEmpty()) {
            return true;
        }
        if (telefone.getText().isEmpty()) {
            return true;
        }
        if (email.getText().isEmpty()) {
            return true;
        }
        if (senha.getText().isEmpty()) {
            return true;
        }
        if (conf_senha.getText().isEmpty()) {
            return true;
        }
        if (camPerfil.getSelectedItem().toString().isEmpty()) {
            return true;
        }
        if (clogin.getText().isEmpty()) {
            return true;
        } else {

            return false;
        }
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
            java.util.logging.Logger.getLogger(TelaCadastrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastrarUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JPanel cadastrar1;
    private javax.swing.JComboBox<String> camPerfil;
    private javax.swing.JButton cancelar;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JTextField clogin;
    private javax.swing.JPasswordField conf_senha;
    private javax.swing.JButton confirmar;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField email;
    private javax.swing.JTextField end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JButton limpar;
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
