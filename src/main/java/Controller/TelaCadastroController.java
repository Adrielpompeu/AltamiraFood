/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.FuncionarioDAO;
import Model.Funcionario;
import View.TelaCadastro;
import java.sql.SQLException;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class TelaCadastroController {
    
    private TelaCadastro view;
    
    public TelaCadastroController(TelaCadastro view){
        this.view = view;
}
    
    
    
    public void salvaFuncionario() throws SQLException{
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        
        String nome = view.getTf_nome().getText();
        String senha = view.getTf_senha().getText();
        String cpf = view.getTf_cpf().getText();
        String endereco = view.getTf_endereco().getText();
        String sexo = view.getSexo().getSelectedItem().toString();
        String nascimento = view.getTf_nascimento().getText();
        String telefone = view.getTf_telefone().getText();
        String email = view.getTf_email().getText();
        
        
          Funcionario funcionario = new Funcionario(nome, senha, cpf, sexo, nascimento, telefone, email, endereco);
          FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);
          funcionarioDAO.insert(funcionario);
        
    }
 
    
}