package hr.pbz.sirius.admin.app.init;

import hr.pbz.sirius.admin.app.model.ContentBuilder;
import hr.pbz.sirius.admin.app.model.User;
import hr.pbz.sirius.admin.app.model.role.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import java.util.Date;

/**
 * This is a initializing bean that inserts some test data in the database. It is only active in
 * the development profile, to see the data login with test123 / Password123 and do a search starting on
 * 1st of January 2015.
 */
@Component
public class TestDataInitializer {
  //password = 12345
  private static final String PASSWORD_DIGEST = "$2a$10$4nK54JKu564AgTUWIpkLHOiCkN0Um8VJgjif.bZeP/Q.eqmcVq/sO";
  private static final String TEST_EMAIL_COM = "test@email.com";

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  public void init() throws Exception {

    SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();

    //USERS
    final User user = new User("test", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE);
    session.persist(user);

    session.persist(new User("user1", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE));
    session.persist(new User("user2", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE));
    session.persist(new User("user3", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE));
    session.persist(new User("user4", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE));
    session.persist(new User("user5", PASSWORD_DIGEST, TEST_EMAIL_COM, User.UserStatus.ACTIVE));

    //ROLES
    Role role1 = new Role();
    role1.setDescription("Full system administrators");
    role1.setName("admin_role");

    Role role2 = new Role();
    role2.setDescription("Matching list operators");
    role2.setName("payments_role");

    Role role3 = new Role();
    role3.setDescription("Content managers. E.g. LBS management, CMS management...");
    role3.setName("content_role");

    Role role4 = new Role();
    role4.setDescription("LBS management");
    role4.setName("lbs_role");

    session.persist(role1);
    session.persist(role2);
    session.persist(role3);
    session.persist(role4);

    //CONTENT
    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("Java")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());
    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("C++")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());

    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("Scala")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());

    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("Kotlin")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());

    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("Haskell")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());

    session.persist(
        new ContentBuilder()
            .setDateChanged(new Date())
            .setDateCreated(new Date())
            .setMainContent("Clojure")
            .setUserChanged(user)
            .setUserCreated(user)
            .createContent());

    transaction.commit();
  }
}
