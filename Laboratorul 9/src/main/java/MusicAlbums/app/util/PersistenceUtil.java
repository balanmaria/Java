package MusicAlbums.app.util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Map;

public class PersistenceUtil {
    private static Map properties;
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("MusicAlbumsPU", properties);
    EntityManager em = factory.createEntityManager();

}
