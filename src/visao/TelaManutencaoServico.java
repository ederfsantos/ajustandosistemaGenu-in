/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import controle.ServicoControle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Prestarservico;

/**
 *
 * @author Brasil
 */
public class TelaManutencaoServico extends javax.swing.JDialog {

    private List<Prestarservico> listaServicosPrestados = new ArrayList();
    private ServicoControle se = new ServicoControle();

    /**
     * Creates new form ManutencaoDespesa
     */
    public TelaManutencaoServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        listarTodosServicos();
        preencherTabela();
    }

    /**
     * METODO REALIZA UMA LISTAGEM DAs Despesas EXISTENTES NO BANCO DE DADOS.
     */
    public void listarTodosServicos() {
        this.listaServicosPrestados.clear();//apagando toda a lista antes do novo carregamento
        this.listaServicosPrestados = se.listarTodos();

    }

    /**
     * METODO PREENCHE A TABELA COM OS DADOS VINDO DO BANCO
     */
    public void preencherTabela() {

        DefaultTableModel dtm = (DefaultTableModel) tabelaServicosPrestados.getModel();
        dtm.setNumRows(0);//apagando todas as linhas para novo preenchimento.
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat df = new SimpleDateFormat("HH:mm");
        listaServicosPrestados.clear();
        listaServicosPrestados.addAll(se.listarTodos());
        for (Prestarservico s : listaServicosPrestados) {

            dtm.addRow(new Object[]{formato.format(s.getData()), (s.getHorario() == null) ? "" : df.format(s.getHorario()), s.getDescricao(), s.getFuncionario().getNome(), s.getCliente().getNome(),
                String.format("%.2f", s.getValor())});
        }

    }

    /**
     * METODO REALIZA A BUSCA SIMULTANEA, DE ACORDO COM O QUE É DIGITADO
     */
    public void pesquisar() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbManutencaoVeiculo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaServicosPrestados = new javax.swing.JTable();
        jPanelBotoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela de Listagem de Prestação de Serviços Realizados a Genu-in");

        lbManutencaoVeiculo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbManutencaoVeiculo.setText("                             Serviços Realizados a Genu-in");

        tabelaServicosPrestados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabelaServicosPrestados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaServicosPrestados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Descricao", "Funcionario", "Cliente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaServicosPrestados.setMinimumSize(new java.awt.Dimension(90, 500));
        jScrollPane1.setViewportView(tabelaServicosPrestados);
        if (tabelaServicosPrestados.getColumnModel().getColumnCount() > 0) {
            tabelaServicosPrestados.getColumnModel().getColumn(0).setResizable(false);
            tabelaServicosPrestados.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelaServicosPrestados.getColumnModel().getColumn(1).setResizable(false);
            tabelaServicosPrestados.getColumnModel().getColumn(1).setPreferredWidth(15);
            tabelaServicosPrestados.getColumnModel().getColumn(2).setPreferredWidth(500);
            tabelaServicosPrestados.getColumnModel().getColumn(3).setResizable(false);
            tabelaServicosPrestados.getColumnModel().getColumn(3).setPreferredWidth(120);
            tabelaServicosPrestados.getColumnModel().getColumn(4).setResizable(false);
            tabelaServicosPrestados.getColumnModel().getColumn(4).setPreferredWidth(120);
            tabelaServicosPrestados.getColumnModel().getColumn(5).setResizable(false);
            tabelaServicosPrestados.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jPanelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelBotoes.setLayout(new java.awt.GridLayout(1, 0));

        btNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btNovo.setText("Novo Agendamento");
        btNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNovoMouseClicked(evt);
            }
        });
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(btNovo);

        btAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(btAlterar);

        btExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });
        jPanelBotoes.add(btExcluir);

        btVisualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btVisualizar.setText("Voltar");
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(btVisualizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbManutencaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbManutencaoVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        TelaServico tela = new TelaServico(null, true);
        tela.setVisible(true);
        listarTodosServicos();
        preencherTabela();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        if (tabelaServicosPrestados.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para alterar!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {
            Prestarservico s = listaServicosPrestados.get(tabelaServicosPrestados.getSelectedRow());
            TelaServico tela = new TelaServico(null, true);
             tela.setPrestarServico(s);
            tela.setVisible(true);
            listarTodosServicos();
            preencherTabela();


    }//GEN-LAST:event_btAlterarActionPerformed
    }
    private void btNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_btNovoMouseClicked

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        dispose();
    }//GEN-LAST:event_btVisualizarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        if (tabelaServicosPrestados.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela para excluir!", "Atenção", JOptionPane.WARNING_MESSAGE);
        } else {

            int op = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este serviço?", "Atenção", JOptionPane.YES_NO_OPTION);
            if (op == 0) {
                Prestarservico s = listaServicosPrestados.get(tabelaServicosPrestados.getSelectedRow());
                se.removerPrestarServico(s);
                listarTodosServicos();
                preencherTabela();
            }

        }

    }//GEN-LAST:event_btExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaManutencaoServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoServico.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaManutencaoServico dialog = new TelaManutencaoServico(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btVisualizar;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbManutencaoVeiculo;
    private javax.swing.JTable tabelaServicosPrestados;
    // End of variables declaration//GEN-END:variables
}
