package jupyter.core.jdbc.domain.hub.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import jupyter.core.jdbc.domain.base.BaseAuditEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "`Role`",
        uniqueConstraints = {
                @UniqueConstraint(name = "`uniq_Role_code`", columnNames = {"code"}),
        }
)
public class Role extends BaseAuditEntity {
    public enum Code {
        ROLE_INVALID("ROLE_INVALID"),
        ROLE_ANONYMOUS("ROLE_ANONYMOUS"),

        ROLE_MKT("ROLE_MKT"),
        ROLE_BA("ROLE_BA"),
        ROLE_CX("ROLE_CX"),
        ROLE_SOS("ROLE_SOS"),
        ROLE_BO("ROLE_BO"),
        ROLE_PF("ROLE_PF"),
        ROLE_HOTEL("ROLE_HOTEL"),

        ROLE_USER("ROLE_USER"),
        ROLE_ADMIN("ROLE_ADMIN");

        private String value;

        Code(String value) {
            this.value = value;
        }

        @JsonValue
        public String value() {
            return value;
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "`code`", nullable = false)
    private Role.Code code;

    @Size(min = 0, max = 255)
    @Column(name = "`description`", nullable = false)
    private String description;

    /**
     * relations
     */

    @ToString.Exclude
    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "role"
    )
    private List<RoleToUser> roleToUsers = new ArrayList<>();

    @ToString.Exclude
    @Builder.Default
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "role"
    )
    private List<PermissionToRole> permissionToRoles = new ArrayList<>();

    /**
     * functions
     */

    public void addRoleToUser(RoleToUser roleToUser) {
        roleToUsers.add(roleToUser);
        roleToUser.setRole(this);
    }

    public void removeRoleToUser(RoleToUser roleToUser) {
        roleToUser.setRole(null);
        roleToUsers.remove(roleToUser);
    }

    public void addPermissionToRole(PermissionToRole permissionToRole) {
        permissionToRole.setRole(this);
        permissionToRoles.add(permissionToRole);
    }

    public void removePermissionToRole(PermissionToRole permissionToRole) {
        permissionToRole.setRole(null);
        permissionToRoles.remove(permissionToRole);
    }

    public void cleanPermissionToRoles() {
        this.getPermissionToRoles().forEach(permissionToRole -> {
            permissionToRole.setPermission(null);
            permissionToRoles = new ArrayList<>();
        });
    }
}
