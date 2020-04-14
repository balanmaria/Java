package MusicAlbums.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="albums")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="artistId")
    private int arttistId;

    @Column(name="releaseYeard")
    private int releaseYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArttistId() {
        return arttistId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setArttistId(int arttistId) {
        this.arttistId = arttistId;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAlbumId(int myAlbumId) {
    }
}
