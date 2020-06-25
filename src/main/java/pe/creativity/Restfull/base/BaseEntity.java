package pe.creativity.Restfull.base;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String ADMIN = "ADMIN";
    @Column(name = "CREATED_USER", length = 255)
    @NotNull
    private String createdUser;

    @Column(name = "CREATED_DATE")
    @Type(type = "timestamp")
    @NotNull
    private Date createdDate;

    @Column(name = "LAST_MODIFIED_USER", length = 255)
    @NotNull
    private String lastModifiedUser;

    @Column(name = "LAST_MODIFIED_DATE")
    @Type(type = "timestamp")
    @NotNull
    private Date lastModifiedDate;

    public BaseEntity() {
        super();
        this.createdUser = "";
        this.createdDate = new Date();
        this.lastModifiedUser = "";
        this.lastModifiedDate = new Date();
    }

    public BaseEntity(String createdUser, Date createdDate, String lastModifiedUser,
                      Date lastModifiedDate) {
        super();
        this.createdUser = createdUser;
        this.createdDate = createdDate;
        this.lastModifiedUser = lastModifiedUser;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedUser() {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser) {
        this.lastModifiedUser = lastModifiedUser;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @PrePersist
    public void setCreationDate() {
        Date currentDate = Calendar.getInstance(TimeZone.getTimeZone("GMT-5:00")).getTime();
        if (createdUser == null) {
            this.createdUser = ADMIN;
        }
        if (createdDate == null) {
            this.createdDate = currentDate;

        }
        if (lastModifiedUser == null) {
            this.lastModifiedUser = ADMIN;
        }
        if (lastModifiedDate == null) {
            this.lastModifiedDate = currentDate;
        }
    }

    @PreUpdate
    public void setChangeDate() {
        Date currentDate = Calendar.getInstance(TimeZone.getTimeZone("America/Lima")).getTime();
        if (lastModifiedUser == null) {
            this.lastModifiedUser = ADMIN;
        }
        if (lastModifiedDate == null) {
            this.lastModifiedDate = currentDate;
        }
    }
}
