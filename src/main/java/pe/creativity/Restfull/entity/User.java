package pe.creativity.Restfull.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pe.interbank.tunki.common.model.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Table(name = "TBL_USER")
@Entity
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "USER_ID", length = 10)
    @NotNull
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(name = "USER_NAME", length = 255)
    @NotNull
    private String userName;

    @Column(name = "PASSWORD", length = 255)
    @NotNull
    private String password;

    @Column(name = "FLAG_TEMP", length = 1)
    @NotNull
    private Boolean flagTemp;

    @Column(name = "STATUS", length = 10)
    @NotNull
    private Integer status;

    @Column(name = "REGISTER_STEP", length = 1)
    @NotNull
    private Integer registerStep;

    @Column(name = "SOCIAL_TYPE", length = 1)
    @NotNull
    private Integer socialType;

    @Column(name = "SOCIAL_ID", length = 255)
    @NotNull
    private String socialId;

    @Column(name = "IS_ABLE_TO_PAY")
    @NotNull
    private Boolean isAbleToPay;

    @Column(name = "IS_OUR_CLIENT")
    @NotNull
    private Boolean isOurClient;

    @Column(name = "TERM_CONDITION")
    @NotNull
    private Boolean termCondition;

    @Column(name = "PRIVACY_POLICY")
    @NotNull
    private Boolean privacyPolicy;

    @Column(name = "UUID")
    private String uuid;


//    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH})
//    private List<UserDevice> lstUserDevice;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH})
    private List<UserRole> lstUserRole;

//    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH})
//    private List<Photo> lstPhoto;

//    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH})
//    private List<CommerceUserStore> lstCommerceUserStore;

//    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY,cascade={CascadeType.PERSIST ,CascadeType.MERGE,CascadeType.DETACH})
//    private List<UserAdminCommerce> lstUserAdminCommerce;

    public User() {
        //Construct default
    }

    public User(Long id, Person person, String userName, String password,
                Boolean flagTemp, Integer status, Integer registerStep, Integer socialType, String socialId,
                Boolean isAbleToPay,Boolean isOurClient, Boolean termCondition, Boolean privacyPolicy, String uuid
                ,List<UserRole> lstUserRole
                ) {
        super();
        this.id = id;
        this.person = person;
        this.userName = userName;
        this.password = password;
        this.flagTemp = flagTemp;
        this.status = status;
        this.registerStep = registerStep;
        this.socialType = socialType;
        this.socialId = socialId;
        this.isAbleToPay = isAbleToPay;
        this.isOurClient = isOurClient;
        this.termCondition = termCondition;
        this.privacyPolicy = privacyPolicy;
        this.uuid = uuid;
       // this.lstUserDevice = lstUserDevice;
       // this.lstPhoto = lstPhoto;
        this.lstUserRole = lstUserRole;
       // this.lstCommerceUserStore = lstCommerceUserStore;
       // this.lstUserAdminCommerce = lstUserAdminCommerce;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName.toUpperCase();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getFlagTemp() {
        return flagTemp;
    }

    public void setFlagTemp(Boolean flagTemp) {
        this.flagTemp = flagTemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public List<UserDevice> getLstUserDevice() {
//        return lstUserDevice;
//    }

//    public void setLstUserDevice(List<UserDevice> lstUserDevice) {
//        this.lstUserDevice = lstUserDevice;
//    }

    public Integer getRegisterStep() {
        return registerStep;
    }

    public void setRegisterStep(Integer registerStep) {
        this.registerStep = registerStep;
    }

    public Boolean getTermCondition() {
        return termCondition;
    }

    public void setTermCondition(Boolean termCondition) {
        this.termCondition = termCondition;
    }

    public Boolean getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(Boolean privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public Integer getSocialType() {
        return socialType;
    }

    public void setSocialType(Integer socialType) {
        this.socialType = socialType;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

//    public List<Photo> getLstPhoto() {
//        return lstPhoto;
//    }

//    public void setLstPhoto(List<Photo> lstPhoto) {
//        this.lstPhoto = lstPhoto;
//    }

    public Boolean getIsAbleToPay() {
        return isAbleToPay;
    }

    public void setIsAbleToPay(Boolean isAbleToPay) {
        this.isAbleToPay = isAbleToPay;
    }

    public Boolean getIsOurClient() {
        return isOurClient;
    }

    public void setIsOurClient(Boolean isOurClient) {
        this.isOurClient = isOurClient;
    }

    public List<UserRole> getLstUserRole() {
        return lstUserRole;
    }

    public void setLstUserRole(List<UserRole> lstUserRole) {
        this.lstUserRole = lstUserRole;
    }

//    public List<CommerceUserStore> getLstCommerceUserStore() {
//        return lstCommerceUserStore;
//    }

//    public void setLstCommerceUserStore(List<CommerceUserStore> lstCommerceUserStore) {
//        this.lstCommerceUserStore = lstCommerceUserStore;
//    }

//    public List<UserAdminCommerce> getLstUserAdminCommerce() {
//        return lstUserAdminCommerce;
//    }

//    public void setLstUserAdminCommerce(List<UserAdminCommerce> lstUserAdminCommerce) {
//        this.lstUserAdminCommerce = lstUserAdminCommerce;
//    }
}
