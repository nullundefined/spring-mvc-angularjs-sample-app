package calories.tracker.app.model;

/**
 * Created by mcurkovic on 08.02.2016..
 */
public class UserFilteringParams {
  private User.UserStatus status;

  public User.UserStatus getStatus() {
    return status;
  }

  public void setStatus(User.UserStatus status) {
    this.status = status;
  }
}
