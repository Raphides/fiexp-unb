package br.fiexp_unb.model;

public class Erro_Instrumental {
    private double valor = 0d;

    public Erro_Instrumental(Instrumento instrumento) {
        instrumento.setErro(this);
        if (instrumento.isEletronico()) {
            this.valor = instrumento.getPrecisao();
        } else {
            this.valor = instrumento.getPrecisao() / 2;
        }
        
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
