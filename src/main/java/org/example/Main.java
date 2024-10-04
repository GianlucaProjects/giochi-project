package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Collezione collezione = new Collezione(new ArrayList<>());

        String input = "";

        while(input != "stop") {

            System.out.println("Inserisci il tipo di gioco che vuoi aggiungere (videogioco o gioco da tavolo): ");
            Scanner scanner = new Scanner(System.in);

            input = scanner.nextLine();

            if (input.equals("videogioco")){
                Videogioco videogioco = new Videogioco();
                videogioco.setIdGioco(collezione.getListaGiochi().isEmpty() ? 1 : collezione.getListaGiochi().size() + 1);

                System.out.println("Inserisci ora il seguente dato: piattaforma del videogioco :");
                videogioco.setPiattaforma(scanner.nextLine());

                System.out.println("Inserisci ora il seguente dato: durata di gioco del videogioco :");
                videogioco.setDurataGioco(Double.valueOf(scanner.nextLine()));

                // System.out.println("Inserisci ora il seguente dato: genere del videogioco :");
                videogioco.setGenere(Genere.AZIONE); // non ho, per mancanza di tempo, checkato che genere mette ma lo
                // sto settando io presumendo che sia sempre azione

                try {
                    collezione.findById(videogioco.getIdGioco());
                } catch (GameException e) {
                    System.out.println("Gioco con id: " + videogioco.getIdGioco() + " non trovato! Provvedo ad aggiungerlo!");
                    collezione.getListaGiochi().add(videogioco);
                }
            }
        else{
                GiocoDaTavolo giocoDaTavolo = new GiocoDaTavolo();
                giocoDaTavolo.setIdGioco(collezione.getListaGiochi().isEmpty() ? 1 : collezione.getListaGiochi().size() + 1);

                System.out.println("Inserisci ora il seguente dato: numero di giocatori del gioco da tavolo :");
                giocoDaTavolo.setNumeroGiocatori(scanner.nextInt());

                System.out.println("Inserisci ora il seguente dato: durata media partita del gioco da tavolo :");
                giocoDaTavolo.setDurataMediaPartita(scanner.nextInt());

                try {
                    collezione.findById(giocoDaTavolo.getIdGioco());
                } catch (GameException e) {
                    System.out.println("Gioco con id: " + giocoDaTavolo.getIdGioco() + " non trovato! Provvedo ad aggiungerlo!");
                    collezione.getListaGiochi().add(giocoDaTavolo);
                }
            }
        }
    }
}