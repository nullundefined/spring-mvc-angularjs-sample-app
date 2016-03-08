package hr.pbz.sirius.admin.app.model.role;

import hr.pbz.sirius.admin.app.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mcurkovic on 04.03.2016..
 */
@Entity
@Table(name = "ROLES")
public class Role extends AbstractEntity {
  public enum RoleStatus{
    ACTIVE,
    INACTIVE
  }

  private String name;
  private String description;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
