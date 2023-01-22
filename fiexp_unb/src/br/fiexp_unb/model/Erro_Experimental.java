package br.fiexp_unb.model;

public class Erro_Experimental {
    private double valor = 0;
    private Erro_Instrumental erro_instrumental;
    private Erro_Aleatorio Erro_Aleatorio;

    public Erro_Experimental(double valor) {
        this.valor = valor;
    }
    public Erro_Experimental(double erro_aleatorio, double erro_instrumental) {
        this.valor = erro_aleatorio + erro_instrumental;
    }    
    public Erro_Experimental(Erro_Aleatorio erro_aleatorio, Erro_Instrumental erro_instrumental) {
        this.valor = erro_aleatorio.getValor() + erro_instrumental.getValor();
    }

    public double getValor() {
        return valor;
    }public void setValor(double valor) {
        this.valor = valor;
    }public Erro_Instrumental getErro_instrumental() {
        return erro_instrumental;
    }public void setErro_instrumental(Erro_Instrumental erro_instrumental) {
        this.erro_instrumental = erro_instrumental;
    }public Erro_Aleatorio getErro_Aleatorio() {
        return Erro_Aleatorio;
    }public void setErro_Aleatorio(Erro_Aleatorio erro_Aleatorio) {
        Erro_Aleatorio = erro_Aleatorio;
    }
}
