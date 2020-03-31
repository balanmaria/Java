package WordGame;

public class Player implements Runnable {
    private String name;
    private Game game;

    Player(String name){
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public String getName() {
        return name;
    }

    private boolean createSubmitNumber() throws InterruptedException{
        int extracted=-1;
        extracted = game.getToken().generateAnNumber();
        if(extracted == -1){
            return false;
        }
        StringBuilder numbers = new StringBuilder();
        for(int i=1; i<=extracted; i++){
            numbers.append(i);
        }
        game.getBoard().addNumber(this, Integer.valueOf(numbers.toString()));
        Thread.sleep(300);
        return true;
    }

    public void run() {
        while (true){
            try{
                if(!createSubmitNumber()){
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
