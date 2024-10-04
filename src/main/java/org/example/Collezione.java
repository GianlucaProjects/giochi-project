package org.example;

import java.util.List;
import java.util.Objects;

public class Collezione {

    private List<Gioco> listaGiochi;

    public Collezione(List<Gioco> listaGiochi) {
        this.listaGiochi = listaGiochi;
    }

    void addElement(Gioco gioco) throws GameException {
        if(this.listaGiochi.stream().noneMatch(item -> gioco.getIdGioco() == item.getIdGioco())) {
            this.listaGiochi.add(gioco);
        }
        else {
            throw new GameException("Il gioco con id: " + gioco.getIdGioco() + " già esiste!");
        }
    }

    Gioco findById(int idGioco) throws GameException {
        return this.listaGiochi.stream().filter(gioco -> gioco.getIdGioco() == idGioco).findFirst().orElseThrow(() -> new GameException("Gioco con id " + idGioco + " non trovato!"));
    }

    List<Gioco> findByPriceLessThanInput(double prezzo) {
        return this.listaGiochi.stream().filter(gioco -> gioco.getPrezzo() < prezzo).toList();
    }

    List<GiocoDaTavolo> findByNumberOfPlayers(int numberOfPlayer) {
        return this.listaGiochi.stream().filter(giocoDaTavolo -> giocoDaTavolo instanceof GiocoDaTavolo).filter(giocoDaTavolo -> ((GiocoDaTavolo) giocoDaTavolo).getNumeroGiocatori() == numberOfPlayer).map(item -> (GiocoDaTavolo) item).toList();
    }

    void deleteGiocoById(int idGioco) throws GameException {
        if(Objects.isNull(this.listaGiochi.stream().map(gioco -> {
            if (gioco.getIdGioco() == idGioco) {
                this.listaGiochi.remove(gioco);
                return true;
            }
            return null;
        }))) {
            throw new GameException("Il gioco con id: " + idGioco + " non esiste!");
        }
    }

    void updateGameById(Gioco newGame) throws GameException {
        Gioco gioco = findById(newGame.getIdGioco());
        gioco.setPrezzo(newGame.getPrezzo());
        gioco.setAnnoPubblicazione(newGame.getAnnoPubblicazione());
        gioco.setTitolo(newGame.getTitolo());
    }
}
