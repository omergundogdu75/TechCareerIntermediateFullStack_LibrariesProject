package org.omergundogdu.dto;

import java.io.Serializable;
import java.util.Date;

// RegisterDto
public class RegisterDto extends  BaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    //Variable
    private String uNickName;
    private String uEmailAddress;
    private String uPassword;

    // Constructor
    public RegisterDto() {
    }

    public RegisterDto(String uNickName, String uEmailAddress, String uPassword) {
        this.uNickName = uNickName;
        this.uEmailAddress = uEmailAddress;
        this.uPassword = uPassword;
    }

    public RegisterDto(Long id, Date systemCreatedDate, String uNickName, String uEmailAddress, String uPassword) {
        super(id, systemCreatedDate);
        this.uNickName = uNickName;
        this.uEmailAddress = uEmailAddress;
        this.uPassword = uPassword;
    }

    // toString
    @Override
    public String toString() {
        return "RegisterDto{" +
                "uNickName='" + uNickName + '\'' +
                ", uEmailAddress='" + uEmailAddress + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", id=" + id +
                ", systemCreatedDate=" + systemCreatedDate +
                "} " + super.toString();
    }

    // GETTER AND SETTER
    public String getuNickName() {
        return uNickName;
    }

    public void setuNickName(String uNickName) {
        this.uNickName = uNickName;
    }

    public String getuEmailAddress() {
        return uEmailAddress;
    }

    public void setuEmailAddress(String uEmailAddress) {
        this.uEmailAddress = uEmailAddress;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }
} //end  class} //end  class