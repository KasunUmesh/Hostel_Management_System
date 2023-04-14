package util;

import entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfigration {

    public static FactoryConfigration factoryConfigration;

    private SessionFactory sessionFactory;

    private FactoryConfigration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Room.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfigration getInstance() {
        return factoryConfigration == null ? factoryConfigration = new FactoryConfigration() : factoryConfigration;
    }

    public Session getSession () {
        return sessionFactory.openSession();
    }
}
