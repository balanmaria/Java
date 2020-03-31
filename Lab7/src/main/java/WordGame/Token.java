package WordGame;

import java.util.Random;

public class Token {
    public int blank;
    public int m;

    public int getBlank() {
        return blank;
    }

    public int getM() {
        return m;
    }

    public void setBlank(int blank) {
        this.blank = blank;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int generateAnNumber(){
        Random rand=new Random();
        int randNumber=m+1;
        int myNumber=rand.nextInt(randNumber); //selectam un nr din intervalul [0,m]

        //consideram 0, ca fiind "blank"
        if(myNumber == 0){
            System.out.println("Blank");
        }
        return myNumber;
    }

}
