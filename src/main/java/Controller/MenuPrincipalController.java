
package Controller;
import View.BDfuncionarios;
import View.Caixa;
import View.MenuPrincipal;
import View.TelaCadastro;
import View.TelaCardapio;
import View.TelaCozinha;
import java.sql.SQLException;


public class MenuPrincipalController {
private final MenuPrincipal view;   

public MenuPrincipalController(MenuPrincipal view){
    this.view = view;
}
    
public void navegarParaTelaCardapio(){
    TelaCardapio telaCardapio = new TelaCardapio();
    telaCardapio.setVisible(true);
}

public void navegarParaOCaixa(){
    Caixa caixa = new Caixa();
   caixa.setVisible(true);
}

    public void navegarParaCozinha() throws SQLException {
        TelaCozinha telaCozinha = new TelaCozinha();
        telaCozinha.setVisible(true);
    }

    public void navegarParaCadastro() {
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.setVisible(true);
    }

    public void navegarParaBDfuncionario() throws SQLException {
        BDfuncionarios bDfuncionarios = new BDfuncionarios();
        bDfuncionarios.setVisible(true);
        
    }
    
    
}