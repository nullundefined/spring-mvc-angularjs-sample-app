package hr.pbz.sirius.admin.app.dto;

/**
 * Created by mcurkovic on 04.03.2016..
 */
public class RoleDTO {
  private String id;
  private String name;
  private String description;
  private int active;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }
}
