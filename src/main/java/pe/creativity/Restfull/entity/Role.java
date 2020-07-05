package pe.creativity.Restfull.entity;


import pe.creativity.Restfull.base.BaseEntity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ROLE")
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID= -4171400306239186884L;

    @Id
    @SequenceGenerator(
            name = "SEQ_TBL_ROLE",
            sequenceName = "TBL_ROLE_SEQ",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_TBL_ROLE"
    )
    @Column(
            name = "ROLE_ID",
            length = 10
    )
    @NotNull
    private Long id;
    @Column(
            name = "DESCRIPTION",
            length = 20
    )
    @NotNull
    private String description;

    public Role() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
