package com.example.dailytask2;

import java.util.HashMap;
import java.util.Map;

public class Evento {
    String nome;
    int giorno;
    int mese;
    int anno;
    boolean notifica;
    String descrizione;

    public Evento(String nome, int giorno, int mese, int anno, boolean notifica, String descrizione) {
        this.nome = nome;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.notifica = notifica;
        this.descrizione = descrizione;
    }

    public Evento(HashMap<String, Object> hmProdotto){
        for (Map.Entry<String,Object> elemento:hmProdotto.entrySet())   {
            switch (elemento.getKey())  {
                case "nome": this.nome = elemento.getValue().toString();break;
                case "giorno": this.giorno = Integer.parseInt((String) elemento.getValue());break;
                case "mese": this.mese = Integer.parseInt((String) elemento.getValue());break;
                case "anno": this.anno = Integer.parseInt((String) elemento.getValue());break;
                case "notifica": this.notifica = Boolean.parseBoolean(elemento.getValue().toString());break;
                case "descrizione": this.descrizione = elemento.getValue().toString();
            }
        }
    }

    HashMap<String, Object> serializzaSuFirebase()  {
        HashMap<String,Object> prodottoSerializzato = new HashMap<>();
        prodottoSerializzato.put("nome", this.nome);
        prodottoSerializzato.put("giorno", this.giorno);
        prodottoSerializzato.put("mese", this.mese);
        prodottoSerializzato.put("anno", this.anno);
        prodottoSerializzato.put("notifica", this.notifica);
        prodottoSerializzato.put("descrizione", this.descrizione);
        return prodottoSerializzato;
    }
}
