package Controller;
import Model.DAO.FuncionarioDAO;
import Model.Funcionario;
import View.Login;
import View.MenuPrincipal;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class LoginController {
    private final Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("altamirafoodjpa");
        
        String nome = view.getTf_nome().getText();
        String senha = view.getPf_senha().getText();
    
        
        Funcionario funcionario = new Funcionario(nome, senha);
 
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(entityManagerFactory);

        boolean existeOuNao = funcionarioDAO.existePorUsuarioeSenha(funcionario);
        
            if(existeOuNao){
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                this.view.dispose();
            }else{
                JOptionPane.showMessageDialog(view, "Usu·rio ou Senha inv·lido");
            }
            
    }
        
    }

    

/*

    private final Login view;
    private LoginHelper helper;            
            
    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema() {
        //Pegar um usuario da view
        Funcionario funcionario = helper.obterModelo();
        
        //pesquisa Usuario no banco
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        Funcionario funcionarioAutenticado = funcionarioDAO.selectPorNomeESenha(funcionario);
        //checa se o usuario esta correto ou nao
        if(funcionarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
        }else{
            view.exibeMensagem("Usu√°rio ou senha inv√°lidos!!");
        }
    }
    
 */


   

