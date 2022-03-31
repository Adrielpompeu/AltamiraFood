/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author W
 */
@Entity
public class Pedidos implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String pedidos;
    double valor;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date data;
    String hora;
    String observacao;
    boolean concluido = false;

    public Pedidos() {
    }
    
    
    public Pedidos(String pedidos, double valor, String data, String hora, String observacao, boolean concluido) {
        this.pedidos = pedidos;
        this.valor = valor;
         try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Digite uma data de nascimento válida!!!");
        }
        this.hora = hora;
        this.observacao = observacao;
        this.concluido = concluido;
    }

    public Pedidos(int id, String pedidos, String hora, String observacao) {
        this.id = id;
        this.pedidos = pedidos;
        this.hora = hora;
        this.observacao = observacao;
    }

    public Pedidos(String pedidos, double valor, String observacao, boolean concluido) {
        this.pedidos = pedidos;
        this.valor = valor;
        this.observacao = observacao;
        this.concluido = concluido;
    }

    public Pedidos(int id, String pedidos, double valor, String data, String hora, String observacao,  boolean concluido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valor = valor;
         try {
            this.data = new SimpleDateFormat("dd/MM/yyyy").parse(data);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Digite uma data de nascimento válida!!!");
        }
        this.hora = hora;
        this.observacao = observacao;
        this.concluido = concluido;
    }

    public Pedidos(int id) {
        this.id = id;
    }
    
    
    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPedidos() {
        return pedidos;
    }

    public void setPedidos(String pedidos) {
        this.pedidos = pedidos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

  
    
    
}
