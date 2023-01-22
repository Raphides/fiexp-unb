package br.fiexp_unb.model;

public class Instrumento {
    private String nome;
    private double precisao = 0d;
    private Erro_Instrumental erro;
    private boolean eletronico;

    public Instrumento(String nome, double precisao, boolean eletronico) {
        this.nome = nome;
        this.eletronico = eletronico;
        this.precisao = precisao;
    }
    public String getNome() {
        return nome;
    }public void setNome(String nome) {
        this.nome = nome;
    }public double getPrecisao() {
        return precisao;
    }public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }public Erro_Instrumental getErro() {
        return erro;
    }public void setErro(Erro_Instrumental erro) {
        this.erro = erro;
    }public boolean isEletronico() {
        return eletronico;
    }public void setEletronico(boolean eletronico) {
        this.eletronico = eletronico;
    }
}
