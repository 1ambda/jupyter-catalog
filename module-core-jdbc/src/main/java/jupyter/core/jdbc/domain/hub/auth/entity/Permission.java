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
@Table(name = "`Permission`",
        uniqueConstraints = {
                @UniqueConstraint(name = "`uniq_Permission_code`", columnNames = {"`code`"}),
        }
)
public class Permission extends BaseAuditEntity {
    public enum Code {

        /**
         * for ADMIN ROLE
         */
        PERM_BYPASS("PERM_BYPASS"),

        /**
         * for USER BASIC ROLE
         */
        PERM_SETTING("PERM_SETTING"),

        /**
         * for SPECIFIC ROLE
         */
        PERM_DATA_PRICE_READ("PERM_DATA_PRICE_READ"),
        PERM_DATA_LEISURE_READ("PERM_DATA_LEISURE_READ"),
        PERM_DATA_SELLER_READ("PERM_DATA_SELLER_READ"),
        PERM_DATA_SEARCH_READ("PERM_DATA_SEARCH_READ"),
        PERM_DATA_EXPERIMENT_READ("PERM_DATA_EXPERIMENT_READ"),
        PERM_DATA_REPORT_READ("PERM_DATA_REPORT_READ"),
        PERM_MANAGE_ACCOUNT_ALL("PERM_MANAGE_ACCOUNT_ALL"),
        PERM_INVALID("PERM_INVALID");

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
    private Code code;

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
            mappedBy = "permission"
    )
    private List<PermissionToRole> permissionToRoles = new ArrayList<>();

    /**
     * functions
     */

    public void addPermissionToRole(PermissionToRole permissionToRole) {
        permissionToRole.setPermission(this);
        permissionToRoles.add(permissionToRole);
    }

    public void removePermissionToRole(PermissionToRole permissionToRole) {
        permissionToRole.setPermission(null);
        permissionToRoles.remove(permissionToRole);
    }

    public void cleanPermissionToRoles() {
        this.getPermissionToRoles().forEach(permissionToRole -> {
            permissionToRole.setPermission(null);
            permissionToRoles = new ArrayList<>();
        });
    }
}
