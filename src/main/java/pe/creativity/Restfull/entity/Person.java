package pe.creativity.Restfull.entity;

import org.hibernate.annotations.GenericGenerator;
import pe.creativity.Restfull.base.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table( name= "TBL_PERSON" , schema = "public")
public class Person extends BaseEntity implements Serializable {

//    private static final long serialVersionUID = 1L;
//
//    @Id
//    //@SequenceGenerator(name = "SEQ_TBL_PERSON", sequenceName = "TBL_PERSON_SEQ", allocationSize = 1)
//    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_PERSON")
//    @GeneratedValue(generator="system-uuid")
//    @GenericGenerator(name="system-uuid", strategy = "uuid")
//    @Column(name = "PERSON_ID", length = 20)
//    @NotNull
//    private String person_id;
//
//    @Column(name = "FIRST_NAME", length = 255)
//    @NotNull
//    private String first_name;
//
//    @Column(name = "LAST_NAME", length = 255)
//    @NotNull
//    private String last_name;
//
//    @Column(name = "PHONE", length = 20)
//    @NotNull
//    private String phone;
//
//    @Column(name = "COUNTRY_CODE", length = 20)
//    @NotNull
//    private String country_code;
//
//    @Column(name = "EMAIL", length = 255)
//    @NotNull
//    private String email;
//
//    @Column(name = "DOC_TYPE", length = 10)
//    @NotNull
//    private Integer doc_type;
//
//    @Column(name = "DOC_NUMBER", length = 20)
//    @NotNull
//    private String doc_number;
//
//    @Column(name = "IS_ABLE_TO_TRANSFER")
//    @NotNull
//    private Integer is_able_to_transfer;
//
//    public Person() {
//        // Construct default
//    }
//
//    public Person(String person_id, String first_name, String last_name, String phone, String email,
//                  Integer doc_type, String doc_number, Integer is_able_to_transfer,
//                  String country_code) {
//        super();
//        this.person_id = person_id;
//        this.first_name = first_name;
//        this.last_name = last_name;
//        this.phone = phone;
//        this.email = email;
//        this.doc_type = doc_type;
//        this.doc_number = doc_number;
//        this.is_able_to_transfer = is_able_to_transfer;
//        this.country_code = country_code;
//    }
//
//
//    public String getPerson_id() {
//        return person_id;
//    }
//
//    public void setPerson_id(String person_id) {
//        this.person_id = person_id;
//    }
//
//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getCountry_code() {
//        return country_code;
//    }
//
//    public void setCountry_code(String country_code) {
//        this.country_code = country_code;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Integer getDoc_type() {
//        return doc_type;
//    }
//
//    public void setDoc_type(Integer doc_type) {
//        this.doc_type = doc_type;
//    }
//
//    public String getDoc_number() {
//        return doc_number;
//    }
//
//    public void setDoc_number(String doc_number) {
//        this.doc_number = doc_number;
//    }
//
//    public Integer getIs_able_to_transfer() {
//        return is_able_to_transfer;
//    }
//
//    public void setIs_able_to_transfer(Integer is_able_to_transfer) {
//        this.is_able_to_transfer = is_able_to_transfer;
//    }

    private static final long serialVersionUID = -970382247150699607L;

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "PERSON_ID", length = 10)
    @NotNull
    private String id;

    @Column(name = "FIRST_NAME", length = 255)
    @NotNull
    private String firstName;

    @Column(name = "LAST_NAME", length = 255)
    @NotNull
    private String lastName;

    @Column(name = "PHONE", length = 20)
    @NotNull
    private String phone;

    @Column(name = "COUNTRY_CODE", length = 20)
    @NotNull
    private String countryCode;

    @Column(name = "EMAIL", length = 255)
    @NotNull
    private String email;

    @Column(name = "DOC_TYPE", length = 10)
    @NotNull
    private Integer docType;

    @Column(name = "DOC_NUMBER", length = 20)
    @NotNull
    private String docNumber;

    @Column(name = "IS_ABLE_TO_TRANSFER")
    @NotNull
    private Integer isAbleToTransfer;

    public Person() {
        // Construct default
    }

    public Person(String id, String firstName, String lastName, String phone, String email,
                  Integer docType, String docNumber, Integer isAbleToTransfer,
                  String countryCode) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.docType = docType;
        this.docNumber = docNumber;
        this.isAbleToTransfer = isAbleToTransfer;
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public Integer getIsAbleToTransfer() {
        return isAbleToTransfer;
    }

    public void setIsAbleToTransfer(Integer isAbleToTransfer) {
        this.isAbleToTransfer = isAbleToTransfer;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


}
