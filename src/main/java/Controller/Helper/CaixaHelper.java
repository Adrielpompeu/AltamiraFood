/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Pedidos;
import View.Caixa;


import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tiago
 */
public class CaixaHelper {

    private final Caixa view;

    public CaixaHelper(Caixa view) {
        this.view = view;
    }
   
    public void preencherTabela(List<Pedidos> pedidos){
        
        //Tabela tambem funciona com MVC precisamos pegar o mode da tabela
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaBanco().getModel();  
        tableModel.setNumRows(0);
        
        
        //Percorrer a lista preenchendo o tableModel
        
        for (Pedidos pedido : pedidos) {
            
            tableModel.addRow(new Object[]{
                pedido.getId(),
                pedido.getPedidos(),
                pedido.getValor(),
                pedido.getData(),
                pedido.getHora(),
                pedido.getObservacao(),
                pedido.isConcluido()
            });
            
        }
    }    
    
}
        
 