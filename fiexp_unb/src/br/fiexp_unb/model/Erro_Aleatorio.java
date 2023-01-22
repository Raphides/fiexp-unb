package br.fiexp_unb.model;

public class Erro_Aleatorio {
    private double valor = 0;

    public Erro_Aleatorio(double valor) {
        this.valor = valor;
    }

    public Erro_Aleatorio(double[] tentativas) {
        calcular(tentativas);
    }

    public static double calcular(double[] tentativas) {
        double soma = 0d;
        for (double tentativa : tentativas) {
            soma = tentativa;
        }
        double media = soma / tentativas.length;
        for (int i = 0; i < tentativas.length; i++) {
            tentativas[i] = Math.pow(tentativas[i] - media, 2);
        }
        soma = 0d;
        for (double tentativa : tentativas) {
            soma = tentativa;
        }
        return Math.sqrt(soma / (tentativas.length * (tentativas.length - 1)));
        
        
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}
