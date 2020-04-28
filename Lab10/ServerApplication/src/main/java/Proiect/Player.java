package Proiect;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String player;
    private List<String> friends;
    private List<String> messages;

    Player(String name){
        this.player=name;
        friends = new ArrayList<>();
       messages = new ArrayList<>();
    }

    public String getPlayer() {
        return player;
    }


    public List<String> getFriends() {
        return friends;
    }

    public List<String> getMessages() {
        return messages;
    }

    //public void setFriends(List<String> friends) {
       // this.friends = friends;
    //}

   // public void setMessages(List<String> messages) {
    //    this.messages = messages;
    //}

   // public void setPlayer(String player) {
    //    this.player = player;
   // }


}
