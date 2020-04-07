package MusicAlbum.DAO;

import MusicAlbum.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlbumController {
    String name;
    String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void create(String name, int artistId, int releaseYear) {
        try{
            Database con = (Database) new Database();
            PreparedStatement posted = ((Connection) con).prepareStatement("INSERT INTO albums (name, artist_id, release_year ) VALUES ('"+name+"', '"+artistId+"', '"+releaseYear+"')");

            posted.executeUpdate();
        } catch(Exception e){System.out.println(e);}
        finally {
            System.out.println("Insert Completed.");
        }
    }
    public ResultSet findByArtist(int artistId){
        try{
            Connection con = (Connection) new Database();
            int myIdArtist=artistId;
            PreparedStatement statement = con.prepareStatement("SELECT id FROM albumss WHERE name='"+myIdArtist+"'");

            ResultSet result = statement.executeQuery();
            return result;

        }catch(Exception e){System.out.println(e);}
        return null;
    }
}
