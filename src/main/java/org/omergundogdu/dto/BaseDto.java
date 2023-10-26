package org.omergundogdu.dto;

import java.io.Serializable;
import java.util.Date;

// BaseDto
public class BaseDto implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID = 1L;

    // Variable
    protected Long id;
    protected Date systemCreatedDate;

    // Constructor (parametresiz)
    public BaseDto() {
        systemCreatedDate = new Date(System.currentTimeMillis());
    }

    //  constructor (parametreli)
    public BaseDto(Long id, Date systemCreatedDate) {
        this.id = id;
        this.systemCreatedDate = systemCreatedDate;
    }

    // toString
    @Override
    public String toString() {
        return "BaseDto{" +
                "id=" + id +
                ", systemCreatedDate=" + systemCreatedDate +
                '}';
    }

    // Getter And Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSystemCreatedDate() {
        return systemCreatedDate;
    }

    public void setSystemCreatedDate(Date systemCreatedDate) {
        this.systemCreatedDate = systemCreatedDate;
    }
} //end class