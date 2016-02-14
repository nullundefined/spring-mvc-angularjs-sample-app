package hr.pbz.sirius.admin.app.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by mcurkovic on 08.02.2016..
 */
@Entity
@Table(name = "CONTENTS")
public class Content extends AbstractEntity {
  @OneToOne
  public User userCreated;
  @OneToOne
  public User userChanged;
  public String mainContent;
  public String otherContent;
  public Date validUntil;
  public Date dateCreated;
  public Date dateChanged;

  public String getOtherContent() {
    return otherContent;
  }

  public void setOtherContent(String otherContent) {
    this.otherContent = otherContent;
  }

  public Date getValidUntil() {
    return validUntil;
  }

  public void setValidUntil(Date validUntil) {
    this.validUntil = validUntil;
  }

  public User getUserCreated() {
    return userCreated;
  }

  public void setUserCreated(User userCreated) {
    this.userCreated = userCreated;
  }

  public User getUserChanged() {
    return userChanged;
  }

  public void setUserChanged(User userChanged) {
    this.userChanged = userChanged;
  }

  public String getMainContent() {
    return mainContent;
  }

  public void setMainContent(String mainContent) {
    this.mainContent = mainContent;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateChanged() {
    return dateChanged;
  }

  public void setDateChanged(Date dateChanged) {
    this.dateChanged = dateChanged;
  }

  public Content(User userCreated, User userChanged, String mainContent, Date dateCreated, Date dateChanged, String otherContent, Date validUntil) {
    this.userCreated = userCreated;
    this.userChanged = userChanged;
    this.mainContent = mainContent;
    this.dateCreated = dateCreated;
    this.dateChanged = dateChanged;
    this.otherContent = otherContent;
    this.validUntil = validUntil;
  }

  public Content(){

  }
}
