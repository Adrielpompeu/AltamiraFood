
package Controller;

import Controller.Helper.BDfuncionariosHelper;
import Model.DAO.FuncionarioDAO;
import Model.Funcionario;
import View.BDfuncionarios;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author W
 */
public class BDfuncionariosController {
    
    public BDfuncionarios view;
    private final BDfuncionariosHelper helper;


    public BDfuncionariosController(BDfuncionarios view) {
        this.view = view;
        this.helper = new BDfuncionariosHelper(view);
    }

    

    public void atualizaFuncionarios() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);
        List<Funcionario> funcionarios = funcionarioDAO.selectAll();
        
        helper.preencherTabela(funcionarios);
    }

    public void deletarfuncionario() throws SQLException {
     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
       
     int id = Integer.parseInt(view.getTfid().getText());
     
     FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);
     
     Funcionario funcionario = new Funcionario(id);
     
     boolean existeporid = funcionarioDAO.existePorId(funcionario);
     
     if(existeporid){
     funcionarioDAO.detele(funcionario);
     JOptionPane.showMessageDialog(null, "Funcionario Excluído Do Banco De Dados!!!");
     atualizaFuncionarios();
     }else{
     JOptionPane.showMessageDialog(null, "Insira um id válido!!!");
     }
     }

    public void alterarFuncionario() throws SQLException {
     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
     FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);
     
     int id = Integer.parseInt(view.getTfid().getText());
     String nome = view.getTfnome().getText();
     String senha = view.getTfsenha().getText();
     String cpf = view.getTfcpf().getText();
     String sexo = view.getComboboxsexo().getSelectedItem().toString();
     String nascimento = view.getTfnascimento().getText();
     String telefone = view.getTftelefone().getText();
     String email = view.getTfemail().getText();
     String endereco = view.getTfendereco().getText();
     
     Funcionario funcionario = new Funcionario(id, nome, senha, cpf, sexo, nascimento, telefone, email, endereco);
        
     funcionarioDAO.update(funcionario);
     atualizaFuncionarios();
    }

    public void inserirfuncionario() throws SQLException {
     EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
     FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);
     
     int id = Integer.parseInt(view.getTfid().getText());
     String nome = view.getTfnome().getText();
     String senha = view.getTfsenha().getText();
     String cpf = view.getTfcpf().getText();
     String sexo = view.getComboboxsexo().getSelectedItem().toString();
     String nascimento = view.getTfnascimento().getText();
     String telefone = view.getTftelefone().getText();
     String email = view.getTfemail().getText();
     String endereco = view.getTfendereco().getText();
     
     if(sexo.equals("Selecione")||nome.isEmpty()||senha.isEmpty()|| cpf.isEmpty()||nascimento.isEmpty() ){
         JOptionPane.showMessageDialog(null, "Preencha Todos os campos !!");
        } else{
         Funcionario funcionario = new Funcionario(id, nome, senha, cpf, sexo, nascimento, telefone, email, endereco);
         funcionarioDAO.insert(funcionario);
         atualizaFuncionarios();
        }
    }
}

