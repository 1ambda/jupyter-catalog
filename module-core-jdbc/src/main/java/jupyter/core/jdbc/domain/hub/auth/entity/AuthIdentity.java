package jupyter.core.jdbc.domain.hub.auth.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import jupyter.core.jdbc.domain.base.BaseAuditEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "`AuthIdentity`",
       uniqueConstraints = {
         @UniqueConstraint(columnNames = {"username"}),
       }
)
public class AuthIdentity extends BaseAuditEntity {
  public enum Provider {
    PASSWORD("PASSWORD"),
    LDAP("LDAP"),
    OAUTH_GOOGLE("OAUTH_GOOGLE"),
    OAUTH_GITHUB("OAUTH_GITHUB"),
    OAUTH_FACEBOOK("OAUTH_FACEBOOK");

    private String value;

    Provider(String value) {
      this.value = value;
    }

    @JsonValue
    public String value() {
      return value;
    }
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "`provider`", nullable = false)
  private Provider provider;

  @Size(min = 2, max = 24)
  @Column(name = "`username`", nullable = false)
  private String username;

  @ToString.Exclude
  @Column(name = "`password`", nullable = true)
  private String password;

  /**
   * relations
   */

  @ToString.Exclude
  @OneToOne(
    fetch = FetchType.EAGER,
    optional = false
  )
  @JoinColumn(name = "`user_id`", nullable = false)
  private User user;
}
