package org.example;

public class Prodotti {

    public String nome;
    public String descrizione;
    public double prezzo;
    public int quantita;
    public int idProdotti;


    public Prodotti(String nome, int quantita, String descrizione, double prezzo) {
        this.nome = nome;
        this.quantita = quantita;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    public Prodotti(int quantita, int idProdotti, double prezzo, String descrizione, String nome) {
        this.quantita = quantita;
        this.idProdotti = idProdotti;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getIdProdotti() {
        return idProdotti;
    }

    @Override
    public String toString() {
        return "Prodotti{" +
                "nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzo=" + prezzo +
                ", quantita=" + quantita +
                ", idProdotti=" + idProdotti +
                '}';
    }
}
