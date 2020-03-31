package WordGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Token token;
    private final List<Player> players = new ArrayList<Player>();

    public void addPlayer(Player player){
        players.add(player);
        player.setGame(this);
    }

    public Board getBoard() {
        return board;
    }

    public Token getToken() {
        return token;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void start() {
        for( Player p: players){
            new Thread(p).start();
        }
    }
}
