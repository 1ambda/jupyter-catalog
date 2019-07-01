package jupyter.core.jdbc.domain.hub.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jupyter.core.jdbc.domain.base.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(
        name = "`RoleToUser`"
)
public class RoleToUser extends BaseEntity {
    @ToString.Exclude
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "`role_id`",
            referencedColumnName = "`id`"
    )
    private Role role;

    @ToString.Exclude
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "`user_id`",
            referencedColumnName = "`id`"
    )
    private User user;
}
