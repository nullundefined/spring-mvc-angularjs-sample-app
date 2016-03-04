package hr.pbz.sirius.admin.app.model.role;

/**
 * Created by mcurkovic on 04.03.2016..
 */
public class RoleFilteringParams {
  private Role.RoleStatus roleStatus;

  public Role.RoleStatus getRoleStatus() {
    return roleStatus;
  }

  public void setRoleStatus(Role.RoleStatus roleStatus) {
    this.roleStatus = roleStatus;
  }
}
