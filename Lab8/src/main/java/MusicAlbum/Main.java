package MusicAlbum;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class Main {
    public static void main(String[] args) throws Exception{
        createTableOne();
        createTableTwo();
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
