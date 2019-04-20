package view;

import control.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class TelaOS extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private String tipo;

    public TelaOS() {
        initComponents();
        con = conexao.AbrirConexao();
    }

    private void PesquisarClientes() throws SQLException {
        String sql = "select id as Id, nome as Nome, cpf as Cpf from cadastrar where nome like ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtPesquisarCli.getText() + "%");
            rs = pst.executeQuery();

            tableClientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ListarCampos() {
        int listar = tableClientes.getSelectedRow();
        txtIdCli.setText(tableClientes.getModel().getValueAt(0, listar).toString());
    }

    private void EmitirOs() {
        String sql = " insert into tbos(tipo, situacao, equipamento, defeito, servico,tecnico,valor,id) values (?,?,?,?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cbOsSit.getSelectedItem().toString());
            pst.setString(3, txtEquip.getText());
            pst.setString(4, txtDef.getText());
            pst.setString(5, txtServico.getText());
            pst.setString(6, txtTec.getText());
            pst.setString(7, txtValor.getText().replace(",", "."));
            pst.setString(8, txtIdCli.getText());

            if ((txtIdCli.getText().isEmpty()) || (txtEquip.getText().isEmpty()) || (txtDef.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS *OBRIGATÓRIOS!", "ERRO", JOptionPane.ERROR_MESSAGE);

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "OS EMITIDA COM SUCESSO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

                    txtIdCli.setText("");
                    txtEquip.setText("");
                    txtDef.setText("");
                    txtServico.setText("");
                    txtTec.setText("");
                    txtValor.setText("");
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    private void PesquisarOs() {
        String numOs = JOptionPane.showInputDialog("Número da Os: ");
        String sql = "select * from tbos where os = " + numOs;

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtOS.setText(rs.getString(1));
                txtData.setText(rs.getString(2));
                String rbTipo = rs.getString(3);
                if (rbTipo.equals("OS")) {
                    opOS.setSelected(true);
                    tipo = "OS";
                } else {
                    opOrcamento.setSelected(true);
                    tipo = "Orçamento";
                }
                cbOsSit.setSelectedItem(rs.getString(4));
                txtEquip.setText(rs.getString(5));
                txtDef.setText(rs.getString(6));
                txtServico.setText(rs.getString(7));
                txtTec.setText(rs.getString(8));
                txtValor.setText(rs.getString(9));
                txtIdCli.setText(rs.getString(10));

                btAddOS.setEnabled(false);
                txtPesquisarCli.setEnabled(false);
                tableClientes.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "OS NÃO CADASTRADA!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        } catch (com.mysql.jdbc.exceptions.MySQLSyntaxErrorException e) {
            JOptionPane.showMessageDialog(null, "OS INVÁLIDA!", "ERRO", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void AlterarOs() {
        String sql = "update tbos set tipo=?,situacao=?,equipamento=?,defeito=?,servico=?,tecnico=?,valor=? where os=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cbOsSit.getSelectedItem().toString());
            pst.setString(3, txtEquip.getText());
            pst.setString(4, txtDef.getText());
            pst.setString(5, txtServico.getText());
            pst.setString(6, txtTec.getText());
            pst.setString(7, txtValor.getText().replace(",", "."));
            pst.setString(8, txtOS.getText());

            if ((txtIdCli.getText().isEmpty()) || (txtEquip.getText().isEmpty()) || (txtDef.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "PREENCHA TODOS OS CAMPOS *OBRIGATÓRIOS!", "ERRO", JOptionPane.ERROR_MESSAGE);

            } else {
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "OS ALTERADA COM SUCESSO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

                    txtOS.setText(null);
                    txtData.setText(null);
                    txtIdCli.setText("");
                    txtEquip.setText("");
                    txtDef.setText("");
                    txtServico.setText("");
                    txtTec.setText("");
                    txtValor.setText("");

                    btAddOS.setEnabled(true);
                    txtPesquisarCli.setEnabled(true);
                    tableClientes.setVisible(true);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void ExcluirOs() {
        int confi = JOptionPane.showConfirmDialog(null, "Tem Certeza que deseja Excluir está OS?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);

        if (confi == JOptionPane.YES_OPTION) {
            String sql = "delete from tbos where os=?";
            try {
                pst = con.prepareStatement(sql);
                pst.setString(1, txtOS.getText());
                int excluido = pst.executeUpdate();
                if (excluido > 0) {
                    JOptionPane.showMessageDialog(null, "OS EXCLUIDA COM SUCESSO!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);

                    txtOS.setText("");
                    txtData.setText("");
                    txtIdCli.setText("");
                    txtEquip.setText("");
                    txtDef.setText("");
                    txtServico.setText("");
                    txtTec.setText("");
                    txtValor.setText("");

                    btAddOS.setEnabled(true);
                    txtPesquisarCli.setEnabled(true);
                    tableClientes.setVisible(true);

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    private void ImprimirOs() {
        int confi = JOptionPane.showConfirmDialog(null, "Deseja realmente Imprimir está OS?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (confi == JOptionPane.YES_OPTION) {
            try {
                HashMap filtro = new HashMap();
                filtro.put("os", Integer.parseInt(txtOS.getText()));
                JasperPrint print = JasperFillManager.fillReport("C:/pasta/os.jasper", filtro, con);
                JasperViewer.viewReport(print, false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtOS = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        opOrcamento = new javax.swing.JRadioButton();
        opOS = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cbOsSit = new javax.swing.JComboBox<String>();
        jPanel2 = new javax.swing.JPanel();
        txtPesquisarCli = new javax.swing.JTextField();
        pesquisarOS = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtServico = new javax.swing.JTextField();
        txtEquip = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        opOrcamento1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jPanel4 = new javax.swing.JPanel();
        jTextField9 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        txtDef = new javax.swing.JTextField();
        txtTec = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btAddOS = new javax.swing.JButton();
        btEditOS = new javax.swing.JButton();
        btBuscarOS = new javax.swing.JButton();
        btDeleteOS = new javax.swing.JButton();
        btPrintarOS = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("OS");
        setPreferredSize(new java.awt.Dimension(615, 470));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nº OS:");

        jLabel2.setText("DATA:");

        txtOS.setEditable(false);
        txtOS.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtOS.setEnabled(false);

        txtData.setEditable(false);
        txtData.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtData.setToolTipText("");
        txtData.setEnabled(false);

        buttonGroup1.add(opOrcamento);
        opOrcamento.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        opOrcamento.setText("Orçamento");
        opOrcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opOrcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(opOS);
        opOS.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        opOS.setText("Ordem de Serviço");
        opOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(opOrcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opOS)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opOrcamento)
                    .addComponent(opOS))
                .addGap(20, 20, 20))
        );

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel3.setText("Situação: ");

        cbOsSit.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cbOsSit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Na Bancada", "Entregado", "Orçamento REPROVADO", "Aguardando Aprovação", "Aguardando Peças", "Abandonado Pelo Cliente", "Retornou" }));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 11))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        txtPesquisarCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarCliKeyReleased(evt);
            }
        });

        pesquisarOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Buacar.png"))); // NOI18N

        txtIdCli.setEditable(false);
        txtIdCli.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel5.setText("*Id:");

        tableClientes.setBackground(new java.awt.Color(51, 204, 255));
        tableClientes.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Cpf"
            }
        ));
        tableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtPesquisarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pesquisarOS)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(pesquisarOS)
                    .addComponent(txtPesquisarCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel6.setText("*Equipamento:");

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel7.setText("*Defeito:");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel8.setText("Serviço:");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel9.setText("Tecnico:");

        txtServico.setToolTipText("");

        txtEquip.setToolTipText("");

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setPreferredSize(new java.awt.Dimension(615, 433));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Nº OS:");

        jLabel11.setText("DATA:");

        jTextField7.setEditable(false);

        jTextField8.setEditable(false);
        jTextField8.setToolTipText("");

        buttonGroup1.add(opOrcamento1);
        opOrcamento1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        opOrcamento1.setText("Orçamento");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jRadioButton3.setText("Ordem de Serviço");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(opOrcamento1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opOrcamento1)
                    .addComponent(jRadioButton3))
                .addGap(20, 20, 20))
        );

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel12.setText("Situação: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Entregado", "Orçamento REPROVADO", "Aguardando Aprovação", "Aguardando Peças", "Abandonado Pelo Cliente", "Na Bancada", "Retornou" }));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 11))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/1478550878_search.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel14.setText("*Id:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nome", "Telefone"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addComponent(jLabel13)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel15.setText("*Equipamento:");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel16.setText("*Defeito:");

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel17.setText("Serviço:");

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel18.setText("Tecnico:");

        jTextField11.setToolTipText("");

        jTextField12.setToolTipText("");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel16)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))))
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtDef.setToolTipText("");

        txtTec.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel19.setText("Valor Total:");

        txtValor.setText("0");
        txtValor.setToolTipText("");

        btAddOS.setBackground(new java.awt.Color(204, 204, 204));
        btAddOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DocAdd.jpg"))); // NOI18N
        btAddOS.setText("Emitir");
        btAddOS.setToolTipText("EMITIR OS");
        btAddOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btAddOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddOSActionPerformed(evt);
            }
        });

        btEditOS.setBackground(new java.awt.Color(204, 204, 204));
        btEditOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DocEditar.png"))); // NOI18N
        btEditOS.setText("Editar");
        btEditOS.setToolTipText("EDITAR");
        btEditOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btEditOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditOSActionPerformed(evt);
            }
        });

        btBuscarOS.setBackground(new java.awt.Color(204, 204, 204));
        btBuscarOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DocPesquisar.png"))); // NOI18N
        btBuscarOS.setText("Pesquisar");
        btBuscarOS.setToolTipText("PESQUISAR");
        btBuscarOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btBuscarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarOSActionPerformed(evt);
            }
        });

        btDeleteOS.setBackground(new java.awt.Color(204, 204, 204));
        btDeleteOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/DocDeletar.png"))); // NOI18N
        btDeleteOS.setText("Deletar");
        btDeleteOS.setToolTipText("DELETAR OS");
        btDeleteOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btDeleteOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteOSActionPerformed(evt);
            }
        });

        btPrintarOS.setBackground(new java.awt.Color(204, 204, 204));
        btPrintarOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        btPrintarOS.setText("Imprimir");
        btPrintarOS.setToolTipText("IMPRIMIR OS");
        btPrintarOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btPrintarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintarOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(cbOsSit, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(8, 8, 8))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(10, 10, 10)
                        .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(297, 297, 297)
                        .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(43, 43, 43)
                        .addComponent(txtDef, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8)
                        .addGap(43, 43, 43)
                        .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel9)
                        .addGap(43, 43, 43)
                        .addComponent(txtTec, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btAddOS, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btEditOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscarOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btDeleteOS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPrintarOS)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btAddOS, btBuscarOS, btDeleteOS, btEditOS, btPrintarOS});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel3))
                            .addComponent(cbOsSit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(txtEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7))
                    .addComponent(txtDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8))
                    .addComponent(txtServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel19))))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAddOS)
                    .addComponent(btEditOS)
                    .addComponent(btBuscarOS)
                    .addComponent(btDeleteOS)
                    .addComponent(btPrintarOS))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btAddOS, btBuscarOS, btDeleteOS, btEditOS, btPrintarOS});

        getAccessibleContext().setAccessibleDescription("");

        setBounds(0, 0, 619, 470);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisarCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarCliKeyReleased
        try {
            PesquisarClientes();
        } catch (SQLException ex) {
            Logger.getLogger(TelaOS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtPesquisarCliKeyReleased

    private void tableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientesMouseClicked
        ListarCampos();
    }//GEN-LAST:event_tableClientesMouseClicked

    private void opOrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opOrcamentoActionPerformed
        tipo = "Orçamento";
    }//GEN-LAST:event_opOrcamentoActionPerformed

    private void opOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opOSActionPerformed
        tipo = "OS";
    }//GEN-LAST:event_opOSActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        opOrcamento.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened

    private void btAddOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddOSActionPerformed
        EmitirOs();
    }//GEN-LAST:event_btAddOSActionPerformed

    private void btBuscarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarOSActionPerformed
        PesquisarOs();
    }//GEN-LAST:event_btBuscarOSActionPerformed

    private void btEditOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditOSActionPerformed
        AlterarOs();
    }//GEN-LAST:event_btEditOSActionPerformed

    private void btDeleteOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteOSActionPerformed
        ExcluirOs();
    }//GEN-LAST:event_btDeleteOSActionPerformed

    private void btPrintarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintarOSActionPerformed
        ImprimirOs();
    }//GEN-LAST:event_btPrintarOSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddOS;
    private javax.swing.JButton btBuscarOS;
    private javax.swing.JButton btDeleteOS;
    private javax.swing.JButton btEditOS;
    private javax.swing.JButton btPrintarOS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbOsSit;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JRadioButton opOS;
    private javax.swing.JRadioButton opOrcamento;
    private javax.swing.JRadioButton opOrcamento1;
    private javax.swing.JLabel pesquisarOS;
    private javax.swing.JTable tableClientes;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDef;
    private javax.swing.JTextField txtEquip;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtOS;
    private javax.swing.JTextField txtPesquisarCli;
    private javax.swing.JTextField txtServico;
    private javax.swing.JTextField txtTec;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
