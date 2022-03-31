
package Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;


abstract public class Pessoa {


    
    protected String cpf;
    protected char Sexo;
    protected Date nascimento;
    protected String telefone;
    protected String email;
    protected String endereco;

    public Pessoa() {
    }


    public Pessoa(int Id, String Nome, String cpf, char Sexo, String nascimento, String telefone, String email, String endereco) {

        this.cpf = cpf;
        this.Sexo = Sexo;
        try {
            this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Digite uma data de nascimento válida!!!");
        }
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public char getSexo() {
        return Sexo;
    }

    public void setSexo(char Sexo) {
        this.Sexo = Sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
