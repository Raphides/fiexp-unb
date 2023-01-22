package br.fiexp_unb.model;

import java.util.HashMap;

public class Resultado_Experimental {
    private float media = 0;
    private Erro_Experimental erro;
    HashMap<String, Float> value = new HashMap<String, Float>(2);

    public Resultado_Experimental() {
        ;
    }

     float getMedia() {
        return media;
    }
    public void setMedia(float media) {
        this.media = media;
    } public Erro_Experimental getErro() {
        return erro;
    } public void setErro(Erro_Experimental erro) {
        this.erro = erro;
    }
    public void setErro(float valor){
        this.erro = new Erro_Experimental(valor);
    }
}
