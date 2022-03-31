
package Model.DAO;


import Model.Pedidos;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

public class CozinhaDAO {
    
    
  private final EntityManagerFactory entityManagerFactory;

  public CozinhaDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
  }
  
//busca os pedidos não concluidos com menor id
  public List<Pedidos> mostraPorIdMenor() throws SQLException{
            EntityManager em = entityManagerFactory.createEntityManager();
            List<Pedidos> pedidos = null;
        
            try{
                String jpql = "select p from Pedidos p where concluido = false ";
                pedidos = em.createQuery(jpql).getResultList();
                
            }catch(Exception e){
                System.out.println("PEDIDOS CONCLUIDOS PESQUISA : " + e.getMessage());
            }finally{
                em.close();
            }
       
    return pedidos;
        }
  
     
        //conclui o pedido
      public void pedidoconcluido(Pedidos pedido) throws SQLException {
          EntityManager em = entityManagerFactory.createEntityManager();
          
          em.find(Pedidos.class, pedido.getId());
          pedido.setConcluido(true);
          try{
              em.getTransaction().begin();
              em.merge(pedido);
              em.getTransaction().commit();
          }catch(Exception e){
              System.out.println("PEDIDO CONCLUIDO ERRO : " + e.getMessage());
          }finally{
              em.close();
              JOptionPane.showMessageDialog(null, "Pedido concluído!");
          }
       
    } 
}

