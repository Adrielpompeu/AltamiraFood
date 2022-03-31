
package Controller;

import Controller.Helper.cozinhaHelper;
import Model.DAO.CozinhaDAO;
import Model.Pedidos;
import View.TelaCozinha;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TelaCozinhaController {
    
    private final TelaCozinha view;
    private final cozinhaHelper helper;

    public TelaCozinhaController(TelaCozinha view) {
        this.view = view;
        this.helper = new cozinhaHelper(view);
    }
    
   public void mostrapedidos() throws SQLException{
       EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
       
       CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
       List<Pedidos> pedidos = cozinhadao.mostraPorIdMenor();
      
       helper.mostraHelper(pedidos);
   }

    public void concluipedido1() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid1().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
    }
    
    
       public void concluipedido2() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid2().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
       }
       
        public void concluipedido3() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid3().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
       }
        
        public void concluipedido4() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid4().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
       }
        
        public void concluipedido5() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid5().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
       }
        
        public void concluipedido6() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        CozinhaDAO cozinhadao = new CozinhaDAO(entityManagerFactory);
        int id = Integer.parseInt(view.getTfid6().getText());
        Pedidos pedido = new Pedidos(id);
        cozinhadao.pedidoconcluido(pedido);
        mostrapedidos();
       }
}
