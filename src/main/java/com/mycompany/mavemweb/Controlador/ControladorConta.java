/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavemweb.Controlador;

import com.mycompany.mavemweb.DAO.ContaDAO;
import com.mycompany.mavemweb.Modelo.Tabconta;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel
 */
@ManagedBean
public class ControladorConta {
    
    private Tabconta conta = new Tabconta();
    private ContaDAO contadao = new ContaDAO();
    
    private List<Tabconta> listaContas;
    
    @PostConstruct
    private void carregarContas() {
        setListaContas(getContadao().listar());
    }

    
    public void salvarConta(){        
        System.out.println(conta.toString());
        contadao.salvar(conta);
        conta = new Tabconta();
        carregarContas();  
    }
 
    
    public void removerConta(Tabconta conta){
        try{
            contadao.remover(conta);
        }catch(Exception e){
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Hey!", "Você não pode remover uma conta que está em lançamento!"));
        }
        
        carregarContas();    
    }
    
    public List<Tabconta> listarConta(){
    
        List<Tabconta> lista;
        lista = contadao.listar();
        
        return lista;
    }
    
    public Tabconta filtrarConta(Integer idConta){
        Tabconta conta = contadao.filtrarCt(idConta);
        return conta;
    }

    
    
    
    /* ---- Getters and Setters ---- */
    
    /**
     * @return the conta
     */
    public Tabconta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Tabconta conta) {
        this.conta = conta;
    }

    public List<Tabconta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Tabconta> listaContas) {
        this.listaContas = listaContas;
    }

    public ContaDAO getContadao() {
        return contadao;
    }

    public void setContadao(ContaDAO contadao) {
        this.contadao = contadao;
    }
    
    
    
    
}
