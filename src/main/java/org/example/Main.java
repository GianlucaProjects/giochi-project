package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Inserisci il tipo di gioco che vuoi aggiungere (videogioco o gioco da tavolo): ");
        Scanner scanner = new Scanner(System.in);

        if(scanner.nextLine().equals("videogioco")) {
            Videogioco videogioco = new Videogioco();
            System.out.println("Inserisci ora i seguenti dati: piattaforma, durata di gioco, genere :");

            if(scanner.nextLine().equals("aggiunta")) {

            }
        }
    }
}