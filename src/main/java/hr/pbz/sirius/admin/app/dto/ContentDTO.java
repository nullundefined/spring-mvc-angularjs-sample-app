package hr.pbz.sirius.admin.app.dto;

import java.util.Date;

/**
 * Created by mcurkovic on 13.02.2016..
 */
public class ContentDTO {
  private Long id;
  private String mainContent;
  private String otherContent;
  private Date validUnitl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMainContent() {
    return mainContent;
  }

  public void setMainContent(String mainContent) {
    this.mainContent = mainContent;
  }

  public String getOtherContent() {
    return otherContent;
  }

  public void setOtherContent(String otherContent) {
    this.otherContent = otherContent;
  }

  public Date getValidUnitl() {
    return validUnitl;
  }

  public void setValidUnitl(Date validUnitl) {
    this.validUnitl = validUnitl;
  }
}
