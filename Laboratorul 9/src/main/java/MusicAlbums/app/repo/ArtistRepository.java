package MusicAlbums.app.repo;

import MusicAlbums.app.Database;
import MusicAlbums.app.entity.Album;
import MusicAlbums.app.entity.Artist;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

public class ArtistRepository {
    String name;
    String country;
    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void create(int idArtist, String artistName, String artistCountry){
        try {
            Connection con = (Connection) new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManager em = (EntityManager) EntityManagerFactory.createEntityManager();
        EntityTransaction et = null;
        try{
            et = em.getTransaction();
            et.begin();

            Artist art = new Artist();
            art.setName(artistName);
            art.setCountry(artistCountry);
            art.setId(idArtist);

            em.persist(art);
            et.commit();
        }catch(Exception ex) {
            System.err.println("Eroare la inserare");
        }finally {
            em.close();
        }
    }

    public static void findById(int key){
        try {
            Connection con = (Connection) new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManager em = (EntityManager) EntityManagerFactory.createEntityManager();
        String query = "SELECT * FROM artists WHERE id='"+key+"'";
        TypedQuery<Artist> tq=em.createQuery(query, Artist.class);
        List<Artist> text;
        try{
            text=tq.getResultList();
        }catch(NoResultException ex){
            System.err.println("Niciun rezultat");
        }finally{
            em.close();
        }
    }

    public static void findByName(String myName){
        try {
            Connection con = (Connection) new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManager em = (EntityManager) EntityManagerFactory.createEntityManager();
        String query = "SELECT * FROM artist WHERE name='"+myName+"'";
        TypedQuery<Artist> tq=em.createQuery(query, Artist.class);
        List<Artist> text;
        try{
            text=tq.getResultList();
        }catch(NoResultException ex){
            System.err.println("Niciun rezultat");
        }finally{
            em.close();
        }
    }
}
