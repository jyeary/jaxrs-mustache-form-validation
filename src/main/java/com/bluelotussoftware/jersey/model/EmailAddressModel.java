package com.bluelotussoftware.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 */
@XmlRootElement
public class EmailAddressModel {

    @NotBlank
    @Email
    private String emailAddress;

    public EmailAddressModel() {
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
