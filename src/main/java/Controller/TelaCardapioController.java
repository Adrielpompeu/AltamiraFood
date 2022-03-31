
package Controller;

import Model.DAO.CardapioDAO;
import Model.Pedidos;
import View.TelaCadastro;
import View.TelaCardapio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class TelaCardapioController extends Pedidos{

    private final TelaCardapio view;
    
    
    public TelaCardapioController(TelaCardapio view){
        this.view = view;
    }
    
    
     public Pedidos pegaPedido() {
        
        int carnedesol = (int) view.getSelecaoCDS().getValue();
        int bifeacebolado = (int) view.getSelecaoBA().getValue();
        int bifedefigado = (int) view.getSelecaoBF().getValue();
        int bistecadeporco = (int) view.getSelecaoBP().getValue();
        int frangoguisado = (int) view.getSelecaoFG().getValue();
        int picanha = (int) view.getSelecaoP().getValue();
        int peixefrito = (int) view.getSelecaoPF().getValue();
        int camaraoaomolhobranco = (int) view.getSelecaoCMB().getValue();
        int costeladeporco = (int) view.getSelecaoCP().getValue();
        int cocacola = (int) view.getCocaCola().getValue();
        int guarana = (int) view.getGuarana().getValue();
        int fanta = (int) view.getFanta().getValue();
        
        String nomepedidos = "";
        double valor=0;
        
        if(carnedesol > 0){
           nomepedidos = carnedesol + " - Carne De Sol  | ";
           valor = carnedesol*18;
        }
            
        if(bifeacebolado > 0){
            nomepedidos = bifeacebolado + " - Bife Acebolado | ";
            valor= bifeacebolado*15;
        }
        
        if(bifedefigado > 0){
            nomepedidos = bifedefigado + " - Bife De Figado | ";
            valor = bifedefigado*12;
        }
        
        if(bistecadeporco > 0){
            nomepedidos = bistecadeporco + " - Bisteca De Porco | ";
            valor = bistecadeporco*20;
        }
        
        if(frangoguisado > 0){
            nomepedidos = frangoguisado + " - Frango Guisado | ";
            valor = frangoguisado*15;
        }
        
        if(picanha > 0){
            nomepedidos =  picanha + " - Picanha Assada | ";
            valor = picanha*45;
        }
        
        if(peixefrito > 0){
            nomepedidos = peixefrito + " - Peixe Frito | ";
            valor = peixefrito*25;
        }
        
        if(camaraoaomolhobranco > 0){
            nomepedidos = camaraoaomolhobranco + " - Camarão Ao Molho Branco | ";
            valor = camaraoaomolhobranco*40;
        }
         
        if(costeladeporco > 0){
            nomepedidos = costeladeporco + " - Costela De Porco | ";
            valor = costeladeporco*25;
        }     
        
        if(cocacola > 0){
            nomepedidos = cocacola + " - Coca-Cola em lata | ";
            valor = cocacola*6;
        }
        
        if(fanta > 0){
            nomepedidos = fanta + " - Fanta Laranja 1.5 Litros | ";
            valor = fanta*9;
        }
        
        if(guarana > 0){
            nomepedidos = guarana + " - Guarana 2 Litros | ";
            valor = guarana*11;
        }
        
        String pedidos = nomepedidos;
        
            
        
        String observacao = view.getTfobservacoes().getText();
        boolean concluido = false;
        
        Pedidos pedido = new Pedidos(pedidos, valor, observacao, concluido);
        return pedido;
    }
    
        public void salvaPedido(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        
        try {

            CardapioDAO cardapioDAO = new CardapioDAO(entityManagerFactory);
            cardapioDAO.inserePedido(pegaPedido());
            JOptionPane.showMessageDialog(null, "Pedido Enviado Para a Cozinha");
        } catch (SQLException ex) {
            
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
