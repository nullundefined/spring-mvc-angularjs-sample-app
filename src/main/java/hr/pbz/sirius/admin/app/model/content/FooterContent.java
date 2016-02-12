package hr.pbz.sirius.admin.app.model.content;

import java.util.Date;

/**
 * Created by matija on 05.12.15..
 */
public class FooterContent extends BasicContent{
    private String phoneNumber;
    private String fullAddress;
    private String urlWeb;

    public FooterContent(String phoneNumber, String fullAddress, String urlWeb) {
        this.phoneNumber = phoneNumber;
        this.fullAddress = fullAddress;
        this.urlWeb = urlWeb;
        setType(ContentType.FOOTER);
        setDate(new Date());
        setId(new Long(1));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getUrlWeb() {
        return urlWeb;
    }

    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }
}
