package Model.DAO;




import Model.Funcionario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;


public class FuncionarioDAO {
    
    private final EntityManagerFactory entityManagerFactory;

    public FuncionarioDAO(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    
    
    //insere os dados
    public void insert(Funcionario funcionario) throws SQLException{
          
            EntityManager em = entityManagerFactory.createEntityManager();
            
            try{
              em.getTransaction().begin();
              em.persist(funcionario);
              em.getTransaction().commit();
              System.out.println("Adicionado");
            }catch(Exception e){
                System.out.println("INSERT : " + e.getMessage());
            }finally{
                em.close();
           }
            JOptionPane.showMessageDialog(null, "funcionario adicionado com sucesso!!");
        }
    
    
    //atualiza os dados
    public void update(Funcionario funcionario) throws SQLException{
        
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        em.find(Funcionario.class, funcionario.getId());
  
        try{
            em.getTransaction().begin();
            em.merge(funcionario);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("UPDATE : " + e.getMessage());
        }finally{
            em.close();
        }
        
        JOptionPane.showMessageDialog(null, " Funcionario Alterado Com sucesso");
    }
    
    //insere ou atualiza os dados
    public void insertOrUpdate(Funcionario funcionario) throws SQLException{
        if(funcionario.getId() > 0){
            update(funcionario);
        }else{
            insert(funcionario);
        }
    }
    
    //apaga os dados
    public void detele(Funcionario funcionario) throws SQLException{
        
        EntityManager em = entityManagerFactory.createEntityManager();
        
        funcionario = em.find(Funcionario.class, funcionario.getId());
        
        try{
            em.getTransaction().begin();
            em.remove(funcionario);
            em.getTransaction().commit();
        }catch(Exception e){
            System.out.println("REMOVE : " + e.getMessage());
        }finally{
            em.close();
        }
        
    }
    
    //retornar todos os usuarios em uma arraylist
    public List<Funcionario> selectAll() throws SQLException{
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Funcionario> funcionarios = null;
        try{
            funcionarios = em.createQuery("from Funcionario").getResultList();
        }catch(Exception e){
            System.out.println("PESQUISA : " + e.getMessage());
        }finally{
            em.close();
        }
            
            return funcionarios;
    }
/*
    private ArrayList<Funcionario> pesquisa(PreparedStatement statement) throws SQLException {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while(resultSet.next()){
            
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String senha = resultSet.getString("senha");
            String cpf = resultSet.getString("cpf");
            String sexo = resultSet.getString("sexo");
            String telefone = resultSet.getString("telefone");
            String email = resultSet.getString("email");
            String endereco = resultSet.getString("endereco");
            String nascimento = resultSet.getString("nascimento");
            
            Funcionario funcionarioCdados = new Funcionario(id, nome, senha, cpf, sexo, nascimento, telefone, email, endereco);
            funcionarios.add(funcionarioCdados);
        }
        return funcionarios;
    }
    */
    
    //busca por id
    public Funcionario selectPorId(Funcionario funcionario) throws SQLException{
            EntityManager em = entityManagerFactory.createEntityManager();
            
            try{
                em.find(Funcionario.class, funcionario.getId());
            }catch(Exception e){
                System.out.println("PESQUISA ID : " + e.getMessage());
            }finally{
                em.close();
            }
            
            return funcionario;
            
    }
    
    //checa se existe por usuario e senha
    public boolean existePorUsuarioeSenha(Funcionario funcionario) throws SQLException {
        List<Funcionario> funcionarios = null;
        
        EntityManager em = entityManagerFactory.createEntityManager();
        try{
            String jpql = "select f from Funcionario f where nome = :nomefun and senha = :senhafun ";// and senha = :senhafun";
            TypedQuery<Funcionario> typedQuery = em.createQuery(jpql, Funcionario.class).setParameter("nomefun", funcionario.getnome()).setParameter("senhafun", funcionario.getSenha());
            funcionarios = typedQuery.getResultList();
            
        }catch(Exception e){
            System.out.println("PESQUISA : " + e.getMessage());
        }finally{
            em.close();
        }
      
        try{
        if(funcionarios.isEmpty()){
            return false;
        }
        }catch(Exception e){
            System.out.println("CHECK : " + e.getMessage());
        }
        return true;
    }
    
    //checa se existe por id
        public boolean existePorId(Funcionario funcionario) throws SQLException {
            
            EntityManager em = entityManagerFactory.createEntityManager();
            List<Funcionario> funcionarios = null;
            
            try{
                em.getTransaction().begin();
                funcionario = em.find(Funcionario.class, funcionario.getId());
                em.getTransaction().commit();
            }catch(Exception e){
                System.out.println("FIND POR ID : " + e.getMessage());
            }finally{
                em.close();
            }

            if(funcionarios.isEmpty()){
                return false;
            }
        return true;
    }

}
