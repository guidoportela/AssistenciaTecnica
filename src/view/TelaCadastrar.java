package view;

import control.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaCadastrar extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCadastrar() {
        initComponents();
        con = conexao.AbrirConexao();
    }

    private void adicionar() {
        String sql = ("insert into cadastrar (nome,endereco,cep,cidade,uf,telefone,email,cpf, perfil, login,senha) values (?,?,?,?,?,?,?,?,?,?,?)");
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
            pst.setString(10, cplogin.getText());
            pst.setString(11, senha.getText());

            if (existeCamposVazios()) {
                JOptionPane.showMessageDialog(null, "PREENCHA OS CAMPOS VAZIOS!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
            if (!isSenhasIguais()) {
                JOptionPane.showMessageDialog(null, "SENHAS DIFERENTES!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                int adc = pst.executeUpdate();
                if (adc > 0) {

                    JOptionPane.showMessageDialog(null, "CADASTRO REALIZADO COM SUCESSO", "ASSISTENCIA TECNICA", JOptionPane.INFORMATION_MESSAGE);

                    nome.setText("");
                    cplogin.setText("");
                    end.setText("");
                    cep.setText("");
                    cidade.setText("");
                    uf.setSelectedItem(null);
                    telefone.setText("");
                    email.setText("");
                    senha.setText("");
                    conf_senha.setText("");
                    cpf.setText("");
                    camPerfil.setSelectedItem(null);
                }
            }
            
        } catch (com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "LOGIN JÁ EXISTENTE!", "ERRO", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
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
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        end = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
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
        telefone = new javax.swing.JFormattedTextField();
        uf = new javax.swing.JComboBox<String>();
        camPerfil = new javax.swing.JComboBox<String>();
        cplogin = new javax.swing.JTextField();
        btConfirmar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastrar");
        setPreferredSize(new java.awt.Dimension(615, 450));

        cadastrar1.setBackground(new java.awt.Color(204, 204, 204));
        cadastrar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cadastrar1.setPreferredSize(new java.awt.Dimension(615, 450));

        jLabel61.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel61.setText("NOME:");

        Id.setEnabled(false);
        Id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel62.setText("ID:");

        jLabel63.setText("LOGIN:");

        jLabel64.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel64.setText("ENDEREÇO:");

        jLabel65.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel65.setText("PERFIL:");

        jLabel66.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel66.setText("CIDADE:");

        jLabel67.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel67.setText("UF:");

        jLabel69.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel69.setText("CEP:");

        try {
            cep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel70.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel70.setText("TELEFONE:");

        jLabel71.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel71.setText("EMAIL:");

        jLabel72.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel72.setText("CPF:");

        try {
            cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel73.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel73.setText("SENHA:");

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel74.setText("CONFIRMAR SENHA:");

        try {
            telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        uf.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        uf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PR", "PB", "PA", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SE", "SP", "TO" }));
        uf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        camPerfil.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        camPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "admin", "user" }));

        btConfirmar.setBackground(new java.awt.Color(204, 204, 204));
        btConfirmar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/UserAdd.png"))); // NOI18N
        btConfirmar.setText("Cadastrar");
        btConfirmar.setToolTipText("CADASTRAR");
        btConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btConfirmar.setMaximumSize(new java.awt.Dimension(60, 45));
        btConfirmar.setMinimumSize(new java.awt.Dimension(63, 45));
        btConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmarMouseClicked(evt);
            }
        });
        btConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmarActionPerformed(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(204, 204, 204));
        btLimpar.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/limpar.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.setToolTipText("LIMPAR");
        btLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("CANCELAR");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cadastrar1Layout = new javax.swing.GroupLayout(cadastrar1);
        cadastrar1.setLayout(cadastrar1Layout);
        cadastrar1Layout.setHorizontalGroup(
            cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel66)
                                    .addComponent(jLabel70))
                                .addGap(277, 277, 277)
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cadastrar1Layout.createSequentialGroup()
                                        .addComponent(jLabel67)
                                        .addGap(18, 18, 18)
                                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(cadastrar1Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel73)
                                    .addComponent(jLabel74))
                                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(camPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(senha)
                                    .addComponent(cpf, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(conf_senha)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastrar1Layout.createSequentialGroup()
                                            .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(cplogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                                .addComponent(nome, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel62)
                                            .addGap(18, 18, 18)
                                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(end, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadastrar1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btLimpar)
                                .addGap(75, 75, 75)
                                .addComponent(btCancelar)))
                        .addContainerGap(60, Short.MAX_VALUE))))
        );

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cidade, conf_senha, cpf, senha, telefone});

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancelar, btConfirmar, btLimpar});

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {email, end});

        cadastrar1Layout.setVerticalGroup(
            cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(cplogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(camPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(cep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel67)
                        .addComponent(uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel70)
                    .addComponent(telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel71))
                    .addGroup(cadastrar1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(conf_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(cadastrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLimpar)
                    .addComponent(btCancelar))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btCancelar, btConfirmar, btLimpar});

        cadastrar1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {email, end});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
        );

        cadastrar1.getAccessibleContext().setAccessibleName("");

        setBounds(0, 0, 619, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void IdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void btConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btConfirmarMouseClicked

    private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
        adicionar();
    }//GEN-LAST:event_btConfirmarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        nome.setText("");
        cplogin.setText("");
        end.setText("");
        cep.setText("");
        cidade.setText("");
        uf.setSelectedItem("");
        telefone.setText("");
        email.setText("");
        senha.setText("");
        conf_senha.setText("");
        cpf.setText("");
        camPerfil.setSelectedItem("");
        requestFocus();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

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
        if (cplogin.getText().isEmpty()) {
            return true;
        }
        if (senha.getText().isEmpty()) {
            return true;
        }
        if (conf_senha.getText().isEmpty()) {
            return true;
        }

        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Id;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JPanel cadastrar1;
    private javax.swing.JComboBox<String> camPerfil;
    private javax.swing.JFormattedTextField cep;
    private javax.swing.JTextField cidade;
    private javax.swing.JPasswordField conf_senha;
    private javax.swing.JFormattedTextField cpf;
    private javax.swing.JTextField cplogin;
    private javax.swing.JTextField email;
    private javax.swing.JTextField end;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
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
    private javax.swing.JTextField nome;
    private javax.swing.JPasswordField senha;
    private javax.swing.JFormattedTextField telefone;
    private javax.swing.JComboBox<String> uf;
    // End of variables declaration//GEN-END:variables
}
