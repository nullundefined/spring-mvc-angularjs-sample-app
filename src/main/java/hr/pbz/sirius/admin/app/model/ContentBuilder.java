package hr.pbz.sirius.admin.app.model;

import java.util.Date;

public class ContentBuilder {
  private User userCreated;
  private User userChanged;
  private String mainContent;
  private Date dateCreated;
  private Date dateChanged;
  private String otherContent;
  private Date validUntil;


  public ContentBuilder setUserCreated(User userCreated) {
    this.userCreated = userCreated;
    return this;
  }

  public ContentBuilder setUserChanged(User userChanged) {
    this.userChanged = userChanged;
    return this;
  }

  public ContentBuilder setMainContent(String mainContent) {
    this.mainContent = mainContent;
    return this;
  }

  public ContentBuilder setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
    return this;
  }

  public ContentBuilder setDateChanged(Date dateChanged) {
    this.dateChanged = dateChanged;
    return this;
  }

  public ContentBuilder setOtherContent(String otherContent) {
    this.otherContent = otherContent;
    return this;
  }

  public ContentBuilder setValidUntil(Date validUntil) {
    this.validUntil = validUntil;
    return this;
  }

  public Content createContent() {
    return new Content(userCreated, userChanged, mainContent, dateCreated, dateChanged, otherContent, validUntil);
  }
}