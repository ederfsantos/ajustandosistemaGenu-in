package visao;


import controle.ClienteControle;
import controle.FuncionarioControle;
import controle.ServicoControle;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import model.Cliente;
import model.Prestarservico;

/**
 *
 * @author Brasil
 */
public class TelaServico extends javax.swing.JDialog {

    private Prestarservico prestarServico;
    private ServicoControle controle = new ServicoControle();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat dfh = new SimpleDateFormat("HH:mm");
    private Cliente cliente;
    private Funcionario funcionario; // tenho que trazer o funcionario 
    private List<Funcionario> funcionarios = new ArrayList();
    private List<Cliente> clientes = new ArrayList();
    private controle.FuncionarioControle cf = new FuncionarioControle();
    private controle.ClienteControle cc = new ClienteControle();

    public TelaServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        funcionarios = cf.listarTodos();
        clientes = cc.listarTodos();
        for (Funcionario f : funcionarios) {
           comboFuncionario.addItem(f.getNome());
        }

    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
    public void salvarPrestarServico()throws ParseException {
          if (this.prestarServico == null) {
            this.prestarServico = new Prestarservico();
            this.prestarServico.setData(txtData.getDate());
            this.prestarServico.setDescricao(txtDescricaoServico.getText());
            this.prestarServico.setValor(Float.parseFloat(txtValorServico.getText()));
           // this.agenda.setCliente(localizarCliente(String.valueOf(jTableListaCliente.getSelectedRow())));
              
           this.prestarServico.setCliente(localizarCliente(txtPesquisar.getText())); // estou pegando o nome do cliente do campo de pesquisa
            this.prestarServico.setFuncionario(localizarFuncionario(String.valueOf(comboFuncionario.getSelectedItem())));
            this.prestarServico.setHorario(dfh.parse(txt_Format_HoraParaServico.getText()));

            controle.salvarPrestarServico(prestarServico);
            JOptionPane.showMessageDialog(null, "Serviço salvo !!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        } else {   
            this.prestarServico.setData(txtData.getDate());
            this.prestarServico.setDescricao(txtDescricaoServico.getText());
            this.prestarServico.setValor(Float.parseFloat(txtValorServico.getText()));
           // this.agenda.setCliente(localizarCliente(String.valueOf(jTableListaCliente.getSelectedRow())));
           // não preciso ler o cliente, pois estou alterando um agendamento existente. 
            this.prestarServico.setFuncionario(localizarFuncionario(String.valueOf(comboFuncionario.getSelectedItem())));
            this.prestarServico.setHorario(dfh.parse(txt_Format_HoraParaServico.getText()));

            controle.salvarPrestarServico(prestarServico);
            JOptionPane.showMessageDialog(null, "Prestação de Serviço Atualizada !!!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }
             
     
    }
   
   public Cliente localizarCliente(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equals(nome)) {
                return c;
            }

        }
        return null;
    }
    
      /**
     * METODO REALIZA UMA LISTAGEM DOS CLIENTES EXISTENTES NO BANCO DE DADOS.
     */
    public void listarTodosClientes() {
        this.clientes.clear();//apagando toda a lista antes do novo carregamento
        this.clientes = controle.listarTodos();

    }

    public Funcionario localizarFuncionario(String nome) {

        for (Funcionario f : funcionarios) {
            if (f.getNome().equals(nome)) {
                return f;
            }
        }
        return null;

    }

    public void limparCampos() {
       
        txtDescricaoServico.setText("");
        txtValorServico.setText("");
        txt_Format_HoraParaServico.setText("");
       // jTableListaCliente.("");
        comboFuncionario.setSelectedItem("");

    }
     public Prestarservico getPrestarservico(){
         return prestarServico;
     }
     
       public void setPrestarServico(Prestarservico prestarservico) {
        this.prestarServico = prestarservico;
        txtData.setDate(this.prestarServico.getData());
        txt_Format_HoraParaServico.setText((this.prestarServico.getHorario() == null) ? "" : dfh.format(this.prestarServico.getHorario()));
        txtValorServico.setText(String.valueOf(this.prestarServico.getValor()));
        txtDescricaoServico.setText(this.prestarServico.getDescricao());
        comboFuncionario.setSelectedItem(this.prestarServico.getFuncionario().getNome());
        txtPesquisar.setText(prestarservico.getCliente().getNome()); // estou o nome do cliente.
        txtPesquisar.setEditable(false); // nao deixa apagar
        
        bt_Limpar.setEnabled(false);

    }
    
   

   

   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanelTelaAgendamento = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDescricaoServico = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        comboFuncionario = new javax.swing.JComboBox<>();
        jLabelNomeFuncionario1 = new javax.swing.JLabel();
        lab_data = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtValorServico = new javax.swing.JTextField();
        jlValorDiaria = new javax.swing.JLabel();
        txt_Format_HoraParaServico = new javax.swing.JFormattedTextField();
        txtData = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListaCliente = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        jComboBoxNome = new javax.swing.JComboBox<>();
        lbPesquisa = new javax.swing.JLabel();
        jLabelNomeFuncionario = new javax.swing.JLabel();
        pnBotoes = new javax.swing.JPanel();
        bt_Salvar = new javax.swing.JButton();
        bt_Limpar = new javax.swing.JButton();
        bt_Cancelar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("tela de Cadastro de Serviços");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(517, 517));

        jPanelTelaAgendamento.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTelaAgendamento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registar Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanelTelaAgendamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("                   Registrar Serviço");
        jPanelTelaAgendamento.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 480, 40));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Registro"));

        jLabel3.setText("Descrição do Serviço");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        comboFuncionario.setEditable(true);
        comboFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFuncionarioActionPerformed(evt);
            }
        });

        jLabelNomeFuncionario1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNomeFuncionario1.setText("Nome Funcionario");

        lab_data.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lab_data.setText("Data Para prestar o Serviço");

        jLabel2.setText("Hora Para prestar o Serviço");

        jlValorDiaria.setText("Valor do Serviço");

        try {
            txt_Format_HoraParaServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("    ##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_Format_HoraParaServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Format_HoraParaServicoActionPerformed(evt);
            }
        });

        txtData.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabelNomeFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab_data, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Format_HoraParaServico, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlValorDiaria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lab_data, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jlValorDiaria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Format_HoraParaServico)
                            .addComponent(txtValorServico)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addComponent(jLabelNomeFuncionario1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTableListaCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableListaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "nome", "Setor", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableListaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListaClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListaCliente);

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        jComboBoxNome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Telefone" }));
        jComboBoxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeActionPerformed(evt);
            }
        });

        lbPesquisa.setText("Cliente Solicitante");

        jLabelNomeFuncionario.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelNomeFuncionario.setText("Pesquisar ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(460, 460, 460)
                        .addComponent(jLabelNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jComboBoxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPesquisa)
                    .addComponent(jLabelNomeFuncionario))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtDescricaoServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelTelaAgendamento.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 770, 430));

        pnBotoes.setBackground(new java.awt.Color(204, 204, 204));
        pnBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnBotoes.setPreferredSize(new java.awt.Dimension(504, 45));
        pnBotoes.setLayout(new java.awt.GridLayout(1, 0));

        bt_Salvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_Salvar.setText("Salvar");
        bt_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SalvarActionPerformed(evt);
            }
        });
        pnBotoes.add(bt_Salvar);

        bt_Limpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_Limpar.setText("Limpar");
        bt_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_LimparActionPerformed(evt);
            }
        });
        pnBotoes.add(bt_Limpar);

        bt_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bt_Cancelar.setText("Cancelar");
        bt_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_CancelarActionPerformed(evt);
            }
        });
        pnBotoes.add(bt_Cancelar);

        btNovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btNovo.setText("Add Cliente");
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
        pnBotoes.add(btNovo);

        jPanelTelaAgendamento.add(pnBotoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 770, -1));

        getContentPane().add(jPanelTelaAgendamento, java.awt.BorderLayout.CENTER);
        jPanelTelaAgendamento.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txt_Format_HoraParaServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Format_HoraParaServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Format_HoraParaServicoActionPerformed

    private void bt_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_LimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_bt_LimparActionPerformed

    private void bt_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_CancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bt_CancelarActionPerformed

    private void bt_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SalvarActionPerformed
     try {
            // TODO add your handling code here:
            salvarPrestarServico();
        } catch (ParseException ex) {
            System.out.println("Erro ao salvar a agenda " + ex);
        }
           

    }//GEN-LAST:event_bt_SalvarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        pesquisar();
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void jComboBoxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNomeActionPerformed

    private void btNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNovoMouseClicked
        //  TODO add your handling code here:
        //    TelaCliente tela = new TelaCliente(this,true);
        //                    tela.setVisible(true);
    }//GEN-LAST:event_btNovoMouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        TelaCliente tela = new TelaCliente(null, true);
        tela.setVisible(true);
        listarTodosClientes();
        preencherTabela();
    }//GEN-LAST:event_btNovoActionPerformed

    private void comboFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFuncionarioActionPerformed

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void jTableListaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaClienteMouseClicked
        // TODO add your handling code here:
         this.cliente = clientes.get(jTableListaCliente.getSelectedRow()); //  nesta linha eu seleciono o cliente 
         txtPesquisar.setText(cliente.getNome()); // estou atribuindo o nome do cliente 
             
        
    }//GEN-LAST:event_jTableListaClienteMouseClicked

    /**
     * METODO PREENCHE A TABELA COM OS DADOS VINDO DO BANCO
     */
    public void preencherTabela() {

        DefaultTableModel dtm = (DefaultTableModel) jTableListaCliente.getModel();
        dtm.setNumRows(0);//apagando todas as linhas para novo preenchimento.
        for (Cliente cc : clientes) {
           
         dtm.addRow(new Object[]{cc.getNome(),cc.getSetor(), cc.getTelefone()});

        }

    }

    public void pesquisar() {
        String str = "from Cliente c ";
        String atributo = "";
        if (jComboBoxNome.getSelectedItem().toString().equals("Nome")) {
            atributo = "c.nome";
        }

        if (jComboBoxNome.getSelectedItem().toString().equals("Telefone")) {
            atributo = "c.telefone";
        }

        String filtro = txtPesquisar.getText();
        if (filtro.length() > 0 && filtro != null) {
            str += "where upper(" + atributo + ") like '%" + filtro.toUpperCase() + "%' ";
        }

        str += "order by " + atributo;
  //      this.clientes = controle.pesquisarRelease(str);//ATUALIZA A LISTA COM OS DADOS DESTA PESQUISA RELEASE
        DefaultTableModel dtm = (DefaultTableModel) jTableListaCliente.getModel();
        dtm.setNumRows(0);//LIMPA A TABELA
        preencherTabela();//PREENCHE COM OS NOVOS DADOS
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
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaServico dialog = new TelaServico(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btNovo;
    private javax.swing.JButton bt_Cancelar;
    private javax.swing.JButton bt_Limpar;
    private javax.swing.JButton bt_Salvar;
    private javax.swing.JComboBox<String> comboFuncionario;
    private javax.swing.JComboBox<String> jComboBoxNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelNomeFuncionario;
    private javax.swing.JLabel jLabelNomeFuncionario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTelaAgendamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListaCliente;
    private javax.swing.JLabel jlValorDiaria;
    private javax.swing.JLabel lab_data;
    private javax.swing.JLabel lbPesquisa;
    private javax.swing.JPanel pnBotoes;
    private com.toedter.calendar.JDateChooser txtData;
    private javax.swing.JTextField txtDescricaoServico;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtValorServico;
    private javax.swing.JFormattedTextField txt_Format_HoraParaServico;
    // End of variables declaration//GEN-END:variables

   

}
