package util;

import entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class FactoryConfigration {

    public static FactoryConfigration factoryConfigration;

    private SessionFactory sessionFactory;

    private FactoryConfigration() {
        Configuration configuration = new Configuration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Room.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static FactoryConfigration getInstance() {
        return factoryConfigration == null ? factoryConfigration = new FactoryConfigration() : factoryConfigration;
    }

    public Session getSession () {
        return sessionFactory.openSession();
    }
}
