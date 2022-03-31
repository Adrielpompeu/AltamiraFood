/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helper;

import Model.Funcionario;
import View.Login;


public class LoginHelper {
    
    private final Login view;

    public LoginHelper(Login view) {
        this.view = view;
    }
    
    public Funcionario obterModelo(){
        String nome = view.getTf_nome().getText();
        String senha = view.getPf_senha().getText();
        
        Funcionario modelo = new Funcionario( nome, senha);
        return modelo;
    }
    public void setarModelo(Funcionario modelo) {
        String nome = modelo.getnome();
        String senha = modelo.getSenha();
        
        view.getTf_nome().setText(nome);
        view.getPf_senha().setText(senha);
    }
    
    public void limparTela(){
        view.getTf_nome().setText("");
        view.getPf_senha().setText("");
    }
}
