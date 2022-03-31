package Model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.swing.JOptionPane;

@Entity
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String senha;
    protected String cpf;
    protected String Sexo;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date nascimento;
    protected String telefone;
    protected String email;
    protected String endereco;

    public Funcionario(){
    }
    
    public Funcionario(int id, String nome, String senha, String cpf) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    public Funcionario(String nome, String senha, String cpf, String Sexo, String nascimento, String telefone, String email, String endereco) {
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.Sexo = Sexo;
        try {
            this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Digite uma data de nascimento v·lida!!!");
        }
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Funcionario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
    }

    public Funcionario(int id) {
        this.id = id;
    }
    
    public Funcionario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Funcionario(int id, String nome, String senha, String cpf, String Sexo, String nascimento, String telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.Sexo = Sexo;
        try {
            this.nascimento = new SimpleDateFormat("dd/MM/yyyy").parse(nascimento);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Digite uma data de nascimento v√°lida!!!");
        }
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Funcionario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
   
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getnome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
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
