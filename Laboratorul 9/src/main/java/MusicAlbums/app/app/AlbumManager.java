package MusicAlbums.app.app;

import MusicAlbums.app.Database;
import MusicAlbums.app.repo.AlbumRepository;
import MusicAlbums.app.repo.ArtistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlbumManager {
    public static void main(String[] args){
        try {
            createTableOne();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            createTableTwo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArtistRepository.create(1, "Eminem", "USA");
        ArtistRepository.create(2, "Ohio Players", "USA");
        AlbumRepository.create("Infinite",1, 1996, 1);
        AlbumRepository.create("Honey", 2,1975, 2);
        AlbumRepository.create("Recovery", 3,2010, 1);
        AlbumRepository.create("Kamikaze",4, 2018, 1);
        AlbumRepository.findByName("Infinite");
        AlbumRepository.findById(4);
        AlbumRepository.findByArtist(1);
        ArtistRepository.findByName("Eminem");
        ArtistRepository.findById(2);
    }

    public static void createTableOne() throws Exception{
        try{
            Connection con = (Connection) new Database();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS artists( id integer not null generated always as identity (start with 1, increment by 1),name varchar(100) not null, country varchar(100), primary key (id))");
            create.executeUpdate();
        }catch (Exception e) {System.out.println(e);}
        finally {
            System.out.println("Function One complete.");
        }
    }

    public static void createTableTwo() throws Exception{
        try{
            Connection con = (Connection) new Database();
            PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS albums(id integer not null generated always as identity (start with 1, increment by 1), name varchar(100) not null, artist_id integer not null references artists on delete restrict, release_year integer, primary key (id))");
            create.executeUpdate();
        }catch (Exception e) {System.out.println(e);}
        finally {
            System.out.println("Function Two complete.");
        }
    }
}
