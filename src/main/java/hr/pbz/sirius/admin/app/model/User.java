package hr.pbz.sirius.admin.app.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The User JPA entity.
 */
@Entity
@Table(name = "USERS")
@NamedQueries({
    @NamedQuery(
        name = User.FIND_BY_USERNAME,
        query = "select u from User u where username = :username"
    ),
    @NamedQuery(
        name = User.COUNT_TODAYS_CALORIES,
        query = "select sum(m.calories) from Meal m where m.user.username = :username and m.date = CURRENT_DATE"
    ),
    @NamedQuery(
        name = User.FIND_ACTIVE_USERS,
        query = "select u from User u where u.status=:status"
    )
})
public class User extends AbstractEntity {

  public static final String FIND_BY_USERNAME = "user.findByUserName";
  public static final String COUNT_TODAYS_CALORIES = "user.todaysCalories";
  public static final String FIND_ACTIVE_USERS = "user.findActiveUsers";

  private String username;
  private String passwordDigest;
  private String email;
  private Long maxCaloriesPerDay;
  private UserStatus status;

  public User() {

  }

  public User(String username, String passwordDigest, String email, Long maxCaloriesPerDay, UserStatus status) {
    this.username = username;
    this.passwordDigest = passwordDigest;
    this.email = email;
    this.maxCaloriesPerDay = maxCaloriesPerDay;
    this.status = status;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPasswordDigest() {
    return passwordDigest;
  }

  public void setPasswordDigest(String passwordDigest) {
    this.passwordDigest = passwordDigest;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getMaxCaloriesPerDay() {
    return maxCaloriesPerDay;
  }

  public void setMaxCaloriesPerDay(Long maxCaloriesPerDay) {
    this.maxCaloriesPerDay = maxCaloriesPerDay;
  }

  public UserStatus getStatus() {
    return status;
  }

  public void setStatus(UserStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "User{" +
        "username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", maxCaloriesPerDay=" + maxCaloriesPerDay +
        '}';
  }

  /**
   * Created by mcurkovic on 08.02.2016..
   */
  public static enum UserStatus {
    ACTIVE,
    BLOCKED
  }
}
