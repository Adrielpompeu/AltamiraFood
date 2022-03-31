/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Pedidos;
import View.TelaCozinha;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author W
 */
public class cozinhaHelper {
    private final TelaCozinha view;

    public cozinhaHelper(TelaCozinha view) {
        this.view = view;
        
    }

    
   public void mostraHelper(List<Pedidos> pedido){ 
       Pedidos pedido1;
       Pedidos pedido2;
       Pedidos pedido3;
       Pedidos pedido4;
       Pedidos pedido5;
       Pedidos pedido6;
       
       
      
              
       if(pedido.size() >0){
       pedido1 = pedido.get(0);
       String id = String.valueOf(pedido1.getId());
       String nome = pedido1.getPedidos();
       String hora = pedido1.getHora();
       String observacao = pedido1.getObservacao();
       
       view.getTfid1().setText(id);
       view.getTfpedido1().setText(nome);
       view.getTfhora1().setText(hora);
       view.getTfobservacoes1().setText(observacao);
       }  else{
                  
       view.getTfid1().setText("");
       view.getTfpedido1().setText("");
       view.getTfhora1().setText("");
       view.getTfobservacoes1().setText("");
         
       }   
        
              
       if(pedido.size() > 1){
       pedido2 = pedido.get(1);
       String id = String.valueOf(pedido2.getId());
       String nome = pedido2.getPedidos();
       String hora = pedido2.getHora();
       String observacao = pedido2.getObservacao();
       
       view.getTfid2().setText(id);
       view.getTfpedido2().setText(nome);
       view.getTfhora2().setText(hora);
       view.getTfobservacoes2().setText(observacao);
       }else{
                  
       view.getTfid2().setText("");
       view.getTfpedido2().setText("");
       view.getTfhora2().setText("");
       view.getTfobservacoes2().setText("");
         
       }
         
       
       
       if(pedido.size() > 2){
       pedido3 = pedido.get(2);
       String id = String.valueOf(pedido3.getId());
       String nome = pedido3.getPedidos();
       String hora = pedido3.getHora();
       String observacao = pedido3.getObservacao();
       
       view.getTfid3().setText(id);
       view.getTfpedido3().setText(nome);
       view.getTfhora3().setText(hora);
       view.getTfobservacoes3().setText(observacao);
       }else{
                  
       view.getTfid3().setText("");
       view.getTfpedido3().setText("");
       view.getTfhora3().setText("");
       view.getTfobservacoes3().setText("");
         
       }
       
       
       if(pedido.size() > 3){
       pedido4 = pedido.get(3);
           
       String id = String.valueOf(pedido4.getId());
       String nome = pedido4.getPedidos();
       String hora = pedido4.getHora();
       String observacao = pedido4.getObservacao();
       
       view.getTfid4().setText(id);
       view.getTfpedido4().setText(nome);
       view.getTfhora4().setText(hora);
       view.getTfobservacoes4().setText(observacao);
       }else{
                  
       view.getTfid4().setText("");
       view.getTfpedido4().setText("");
       view.getTfhora4().setText("");
       view.getTfobservacoes4().setText("");
         
       }
       
       
       if(pedido.size() > 4 ){
        pedido5 = pedido.get(4);
           
       String id = String.valueOf(pedido5.getId());
       String nome = pedido5.getPedidos();
       String hora = pedido5.getHora();
       String observacao = pedido5.getObservacao();
       
       view.getTfid5().setText(id);
       view.getTfpedido5().setText(nome);
       view.getTfhora5().setText(hora);
       view.getTfobservacoes5().setText(observacao);
           
       }else{
                  
       view.getTfid5().setText("");
       view.getTfpedido5().setText("");
       view.getTfhora5().setText("");
       view.getTfobservacoes5().setText("");
         
       }
       
       
       
       if( pedido.size() > 5 ){
           pedido6 = pedido.get(5);
           
       String id = String.valueOf(pedido6.getId());
       String nome = pedido6.getPedidos();
       String hora = pedido6.getHora();
       String observacao = pedido6.getObservacao();
       
       view.getTfid6().setText(id);
       view.getTfpedido6().setText(nome);
       view.getTfhora6().setText(hora);
       view.getTfobservacoes6().setText(observacao);
           
       }else{
                  
       view.getTfid6().setText("");
       view.getTfpedido6().setText("");
       view.getTfhora6().setText("");
       view.getTfobservacoes6().setText("");
         
       }
       
                   
                            
   }
}

