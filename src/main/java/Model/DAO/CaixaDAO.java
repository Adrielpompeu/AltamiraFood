/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Controller.Helper.CaixaHelper;
import Model.Funcionario;
import Model.Pedidos;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author W
 */
public class CaixaDAO {
    
   private final EntityManagerFactory entityManagerFactory;

   public CaixaDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
   }


    //busca todos os pedidos
   public List<Pedidos> selectAll() throws SQLException{
    
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Pedidos> pedidos = null;
            
        pedidos = em.createQuery("from Pedidos").getResultList();
            
        return pedidos;      
   }
        
        
   //atualiza os pedidos
    public void update(Pedidos pedido) throws SQLException{
                
        EntityManager em = entityManagerFactory.createEntityManager();
        em.find(Pedidos.class, pedido.getId());
                
        try{
            em.getTransaction().begin();
            em.merge(pedido);
            em.getTransaction().commit();
                
        }catch(Exception e){
                System.out.println("UPDATE: " + e.getMessage());
        }finally{
                em.close();   
        }
    }
}

