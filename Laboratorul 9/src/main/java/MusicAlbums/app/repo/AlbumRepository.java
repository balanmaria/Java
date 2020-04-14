package MusicAlbums.app.repo;

import MusicAlbums.app.Database;
import MusicAlbums.app.entity.Album;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

public class AlbumRepository {
    String name;
    int relaseYear;
    int idArtist;
    int albumId;

    AlbumRepository(String name1, int relaseYear1){
        name=name1;
        relaseYear=relaseYear1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRelaseYear() {
        return relaseYear;
    }

    public String getName() {
        return name;
    }

    public void setReleaseYear(int relaseYear) {
        this.relaseYear = relaseYear;
    }

    public int getIdArtist() {
        return idArtist;
    }

    public void setIdArtist(int idArtist) {
        this.idArtist = idArtist;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public static void create(String albumName,int myAlbumId,  int albumYear, int idMyArtist){
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

            Album alb = new Album();
            alb.setName(albumName);
            alb.setReleaseYear(albumYear);
            alb.setArttistId(idMyArtist);
            alb.setAlbumId(myAlbumId);

            em.persist(alb);
            et.commit();
        }catch(Exception ex) {
            System.err.println("Eroare la inserare");
        }finally {
                em.close();
        }

    }

    public static void findById(int key)  {
        try {
            Connection con = (Connection) new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManager em = (EntityManager) EntityManagerFactory.createEntityManager();
        String query = "SELECT * FROM albums WHERE id='"+key+"'";
        TypedQuery<Album> tq=em.createQuery(query, Album.class);
        List<Album> text;
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
        String query = "SELECT * FROM albums WHERE name='"+myName+"'";
        TypedQuery<Album> tq=em.createQuery(query, Album.class);
        List<Album> text;
        try{
            text=tq.getResultList();
        }catch(NoResultException ex){
            System.err.println("Niciun rezultat");
        }finally{
            em.close();
        }
    }

    public static void findByArtist(int artistId){
        try {
            Connection con = (Connection) new Database();
        } catch (Exception e) {
            e.printStackTrace();
        }
        EntityManager em = (EntityManager) EntityManagerFactory.createEntityManager();
        String query = "SELECT name FROM albums WHERE name='"+artistId+"'";
        TypedQuery<Album> tq=em.createQuery(query, Album.class);
        List<Album> text;
        try{
            text=tq.getResultList();
        }catch(NoResultException ex){
            System.err.println("Niciun rezultat");
        }finally{
            em.close();
        }
    }
}


