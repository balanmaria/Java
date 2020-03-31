package WordGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Integer> numberList;

    public Board() {
        numberList = new ArrayList<Integer>();
    }

    synchronized final void addNumber(Player p, Integer number) throws NullPointerException{
        if( number == null){
            throw new NullPointerException("Please enter a number!");
        }
        if( p == null) {
            throw new NullPointerException("An existing player must introduce a number");
        }
        numberList.add(number);
        System.out.println("Player " + p.getName() + "submitted the number " + number);
    }
}
