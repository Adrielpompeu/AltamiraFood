
package Controller;

import Controller.Helper.CaixaHelper;
import Model.DAO.CaixaDAO;
import Model.DAO.PedidosDAO;
import Model.Pedidos;
import View.Caixa;
import View.TelaCadastro;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class CaixaController {
    
    private final Caixa view;
    private final CaixaHelper helper;


    public CaixaController(Caixa view) {
        this.view = view;
        this.helper = new CaixaHelper(view);
    }
    
    
       public void insert(Pedidos pedido) throws SQLException{
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        
            try {

            PedidosDAO pedidosdao= new PedidosDAO(entityManagerFactory);
            pedidosdao.inserePedido(pedido);
            JOptionPane.showMessageDialog(null, " Pedido Enviado Para A Cozinha!!");
            atualizaTabela();
        } catch (SQLException ex) {
            
            Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }       
        }

       
    public void atualizaTabela() throws SQLException{
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CaixaDAO caixaDAO = new CaixaDAO(entityManagerFactory);
        List<Pedidos> pedidos = caixaDAO.selectAll();
        
        helper.preencherTabela(pedidos);
       }

    public void alterarpedido() throws SQLException {
      EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
       CaixaDAO caixaDAO = new CaixaDAO(entityManagerFactory);
        
       int id = Integer.parseInt(view.getTfid().getText());
       String pedidos = view.getLbl_pedido().getText();
       String data = view.getLbl_data().getText();
       String hora = view.getLbl_hora().getText();
       String observacao = view.getLbl_observacoes().getText();
       double valor = Double.parseDouble(view.getLbl_valor().getText());
       boolean concluido = view.isconcluido();
       
       Pedidos pedido = new Pedidos(id, pedidos, valor, data, hora, observacao, concluido);
       
       caixaDAO.update(pedido);
       atualizaTabela();
       }

  
    
    
}