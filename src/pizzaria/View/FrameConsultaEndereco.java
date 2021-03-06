/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria.View;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import pizzaria.Controller.ControllerEndereco;
import pizzaria.Interfaces.Frame.Observador;
import pizzaria.Model.Endereco;
import pizzaria.Interfaces.Frame.IFrameAlterar;
import pizzaria.Interfaces.IPedido;
import pizzaria.Model.Pedido;
import pizzaria.Interfaces.Frame.IFrameAltera;
import pizzaria.Interfaces.Frame.IFrameConsultaEndereco;
import pizzaria.View.Util.ConfiguraJScroll;

/**
 *
 * @author Guilh
 */
public class FrameConsultaEndereco extends javax.swing.JPanel implements IFrameAltera, IFrameConsultaEndereco, IPedido{

    /**
     * Creates new form FrameConsultaEndereco
     */
    private DefaultListModel model;
    private ControllerEndereco controllerEndereco;
    protected Endereco ero;
    protected Pedido pedido;
    private boolean observado;
    
    public FrameConsultaEndereco() {
        initComponents();
        
        model = new DefaultListModel();
        lstProcurar.setModel(model);
        
        controllerEndereco = new ControllerEndereco();
        CarregarDados();
    }
    
    public FrameConsultaEndereco(Pedido pedido) {
        initComponents();
        
        this.pedido = pedido;
        model = new DefaultListModel();
        lstProcurar.setModel(model);
        
        controllerEndereco = new ControllerEndereco();
        CarregarDados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        lstProcurar = new javax.swing.JList<>();
        txtProcurar = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblEndereco1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(530, 530));

        jScrollPane3.setBorder(null);

        lstProcurar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lstProcurar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstProcurarValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstProcurar);

        txtProcurar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtProcurar.setBorder(null);
        txtProcurar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProcurarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProcurarFocusLost(evt);
            }
        });
        txtProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcurarActionPerformed(evt);
            }
        });

        lblEndereco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Escreva a cidade:");
        jLabel5.setToolTipText("");

        lblEndereco1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEndereco1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 157, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEndereco)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtProcurarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProcurarFocusGained
        ConfigurarProcurarDados();
    }//GEN-LAST:event_txtProcurarFocusGained

    private void txtProcurarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProcurarFocusLost
        ConfigurarProcurarDados();
    }//GEN-LAST:event_txtProcurarFocusLost

    private void txtProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcurarActionPerformed
        ConfigurarProcurarDados();
    }//GEN-LAST:event_txtProcurarActionPerformed

    private void lstProcurarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstProcurarValueChanged
        if(this.lstProcurar.getSelectedIndex() != -1){
            lblEndereco.setText(getCidade() + ", "+ getLogradouro());
            ero = new Endereco(this.getId(), this.getLogradouro(), this.getBairro(), this.getCidade());
        }
    }//GEN-LAST:event_lstProcurarValueChanged

    private void ConfigurarProcurarDados() {
        if(!(txtProcurar.getText().isEmpty())) ProcurarDado(txtProcurar.getText());
        else CarregarDados();
    }

    public void ProcurarDado(String cidade){
        ArrayList<Endereco> enderecos = controllerEndereco.pegar(Integer.parseInt(txtProcurar.getText()));
        model.clear();
        enderecos.forEach(c -> model.addElement(c));
    }
    
    public void AtualizarConsulta(){
        CarregarDados();
    }
    
    private void CarregarDados() {
        model.clear();
        ConfiguraJScroll.configJscrollPane(jScrollPane3);
        controllerEndereco.pegarVarios().forEach(c -> model.addElement(c.toString()));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblEndereco1;
    private javax.swing.JList<String> lstProcurar;
    private javax.swing.JTextField txtProcurar;
    // End of variables declaration//GEN-END:variables
    //Para Alteração
    @Override
    public Pedido getObjeto() {
        try{
            pedido.setEndereco(ero);
            return pedido;
        } catch(NullPointerException ex) {
            throw new RuntimeException("Não foi possível pegar o endereço!\nErro:"+ex.getMessage());
        }
    }
    //Propiedades Endereco
    @Override
    public int getId() throws NullPointerException{
        return Integer.parseInt(lstProcurar.getSelectedValue().split(",")[0].trim());
    }

    @Override
    public String getLogradouro() throws NullPointerException {
        return lstProcurar.getSelectedValue().split(",")[1].trim();
    }

    @Override
    public String getBairro() throws NullPointerException {
        return lstProcurar.getSelectedValue().split(",")[2].trim();
    }

    @Override
    public String getCidade() throws NullPointerException {
        return lstProcurar.getSelectedValue().split(",")[3].trim();
    }
}
