package MusicAlbum.DAO;

import MusicAlbum.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ArtistController {
    String name;
    int artistId;
    int realeaseYear;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getArtistId() {
        return artistId;
    }

    public int getRealeaseYear() {
        return realeaseYear;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public void setRealeaseYear(int realeaseYear) {
        this.realeaseYear = realeaseYear;
    }

    public void create(String name, String country){
        try{
            Database con = (Database) new Database();
            PreparedStatement posted = ((Connection) con).prepareStatement("INSERT INTO artists (name, country ) VALUES ('"+name+"', '"+country+"')");

            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert Completed.");
        }
    }
    public ResultSet findByName(String name){
        try{
            Connection con = (Connection) new Database();
            String myName=name;
            PreparedStatement statement = con.prepareStatement("SELECT id FROM artists WHERE name='"+myName+"'");

            ResultSet result = statement.executeQuery();
            return result;

        }catch(Exception e){System.out.println(e);}
        return null;
    }
}
