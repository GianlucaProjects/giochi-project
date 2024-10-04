package org.example;

public class Videogioco extends Gioco {

    private String piattaforma;
    private double durataGioco;
    private Genere genere;

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
        this.piattaforma = piattaforma;
    }

    public double getDurataGioco() {
        return durataGioco;
    }

    public void setDurataGioco(double durataGioco) {
        this.durataGioco = durataGioco;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }
}
