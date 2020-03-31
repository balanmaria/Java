package WordGame;

public class Main {

    public static void main(String[] args){
        Game game = new Game();
        game.setBoard(new Board());
        game.setToken(new Token());

        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));
        game.start();
    }
}
