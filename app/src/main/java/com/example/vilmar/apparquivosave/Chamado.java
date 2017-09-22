package com.example.vilmar.apparquivosave;

/**
 * Created by VILMAR on 21/09/2017.
 */

public class Chamado {
    String nomeCliente,empresa,CNPJ,contato,email,problema;

    public Chamado() {
    }

    public Chamado(String nomeCliente, String empresa, String CNPJ, String contato, String email, String problema) {
        this.nomeCliente = nomeCliente;
        this.empresa = empresa;
        this.CNPJ = CNPJ;
        this.contato = contato;
        this.email = email;
        this.problema = problema;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
    public String toString ()
    {
        return getNomeCliente()+";"+getEmpresa()+";"+getCNPJ()+";"+getEmail()+";"+getContato()+";"+getProblema()+"\n";
    }
}
