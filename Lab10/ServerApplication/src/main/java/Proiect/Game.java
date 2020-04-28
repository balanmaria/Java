package Proiect;

import java.util.List;

public class Game {
    private List<String> Players;
    private int attemps;


    public String submit(int parse) {
        ++attemps;
        if (attemps == 5) return "5 piese puse pe o linie";
        else  return "Numarul de piese puse pe tabla difera";
    }
}
