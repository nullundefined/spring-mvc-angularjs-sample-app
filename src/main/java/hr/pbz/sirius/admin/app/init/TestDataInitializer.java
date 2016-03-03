package hr.pbz.sirius.admin.app.init;

import hr.pbz.sirius.admin.app.model.ContentBuilder;
import hr.pbz.sirius.admin.app.model.Meal;
import hr.pbz.sirius.admin.app.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.sql.Time;
import java.util.Date;

/**
 *
 * This is a initializing bean that inserts some test data in the database. It is only active in
 * the development profile, to see the data login with test123 / Password123 and do a search starting on
 * 1st of January 2015.
 *
 */
@Component
public class TestDataInitializer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;


    public void init() throws Exception {

        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        //password = 12345
        User user = new User("test",
            /*"$2a$10$1G22iS7YOy0kifAuSNlK.OrzJyZWJCTur4xZZlldS5CIIPpiDGtfu"*/
            "$2a$10$4nK54JKu564AgTUWIpkLHOiCkN0Um8VJgjif.bZeP/Q.eqmcVq/sO", "test@email.com", 1000L,
            User.UserStatus.ACTIVE);


        User user1 = new User("user1",
            /*"$2a$10$1G22iS7YOy0kifAuSNlK.OrzJyZWJCTur4xZZlldS5CIIPpiDGtfu"*/
            "$2a$10$4nK54JKu564AgTUWIpkLHOiCkN0Um8VJgjif.bZeP/Q.eqmcVq/sO", "test@email.com", 1000L,
            User.UserStatus.ACTIVE);

        User user2 = new User("user2",
            /*"$2a$10$1G22iS7YOy0kifAuSNlK.OrzJyZWJCTur4xZZlldS5CIIPpiDGtfu"*/
            "$2a$10$4nK54JKu564AgTUWIpkLHOiCkN0Um8VJgjif.bZeP/Q.eqmcVq/sO", "test@email.com", 1000L,
            User.UserStatus.ACTIVE);

        session.persist(user);
        session.persist(user1);
        session.persist(user2);


        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Java").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Scala").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("C++").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("JavaScript").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Haskell").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Go").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("C#").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("PHP").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Clojure").setUserChanged(user).setUserCreated(user).createContent());
        session.persist(new ContentBuilder().setDateChanged(new Date()).setDateCreated(new Date()).setMainContent("Kotlin").setUserChanged(user).setUserCreated(user).createContent());

        session.persist(new Meal(user, new Date(115, 0, 1), new Time(12, 0, 0), "1 - Mitraillette", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 1), new Time(19, 0, 0), "1 - Eggplant Parmesan", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 2), new Time(12, 0, 0), "2 -  Chickpea with roasted cauliflower", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 2), new Time(19, 0, 0), "2 - Chicken Stew with Turnips & Mushrooms", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 3), new Time(12, 0, 0), "3 - Rosemary Lentils & Greens on Toasted Bread", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 3), new Time(19, 0, 0), "3 - Salmon Cakes with Olives, Lemon & Dill", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 4), new Time(12, 0, 0), "4 - Cowboy Beef & Bean Chili", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 4), new Time(19, 0, 0), "4 -  Duck Chiles Rellenos", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 5), new Time(12, 0, 0), "5 - Brussels Sprout & Potato Hash", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 5), new Time(19, 0, 0), "5 -  Creamy Green Chile Chicken Soup", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 6), new Time(12, 0, 0), "6 -  Duck Chiles Rellenos", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 6), new Time(19, 0, 0), "6 -  Apricot-Chile Glazed Salmon", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 7), new Time(12, 0, 0), "7 -  Creamy Mustard Chicken", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 7), new Time(19, 0, 0), "7 -   Grape Chutney", 1000L));
        session.persist(new Meal(user, new Date(115, 0, 8), new Time(12, 0, 0), "8 -  Broccoli Rabe", 2000L));
        session.persist(new Meal(user, new Date(115, 0, 8), new Time(19, 0, 0), "8 -  Moules Frites", 1000L));

        transaction.commit();
    }
}
