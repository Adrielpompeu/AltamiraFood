
package Model.DAO;

import Model.Pedidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PedidosDAO {
    private final EntityManagerFactory entityManagerFactory;

    public PedidosDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

 
    
    public void inserePedido(Pedidos pedido) throws SQLException{
                
        EntityManager em = entityManagerFactory.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(pedido);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("INSERT : " + e.getMessage());
        }finally{
            em.close();
        }
    }
    
}
