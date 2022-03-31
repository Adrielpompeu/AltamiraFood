/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Funcionario;
import View.BDfuncionarios;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author W
 */
public class BDfuncionariosHelper {
    
    public BDfuncionarios view;

    public BDfuncionariosHelper(BDfuncionarios view) {
        this.view = view;
        
    }
    
    public void preencherTabela(List<Funcionario> funcionarios){
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaFuncionarios().getModel();
        tableModel.setNumRows(0);
        
        for(Funcionario funcionario : funcionarios){
            tableModel.addRow(new Object[] {
                funcionario.getId(),
                funcionario.getnome(),
                funcionario.getSenha(),
                funcionario.getCpf(),
                funcionario.getSexo(),
                funcionario.getTelefone(),
                funcionario.getEmail(),
                funcionario.getEndereco(),
                funcionario.getNascimento()
        });
        }
    }
}
