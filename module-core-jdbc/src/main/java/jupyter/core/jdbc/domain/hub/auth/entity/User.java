package jupyter.core.jdbc.domain.hub.auth.entity;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jupyter.core.jdbc.domain.base.BaseAuditEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "`User`",
       indexes = {
         @Index(name = "`idx_User_createdAt`", columnList = "`created_at`", unique = false),
         @Index(name = "`idx_User_deletedAt`", columnList = "`deleted_at`", unique = false),
         @Index(name = "`idx_User_locked`", columnList = "`locked`", unique = false),
       },
       uniqueConstraints = {
         @UniqueConstraint(name = "`uniq_User_email`", columnNames = {"email"}),
       })
public class User extends BaseAuditEntity {
  @ToString.Exclude
  @Size(min = 0, max = 255)
  @Column(name = "`name`", nullable = false)
  private String name;

  @ToString.Exclude
  @Size(min = 0, max = 255)
  @Column(name = "`email`", nullable = false)
  private String email;

  @ToString.Exclude
  @Size(min = 0, max = 255)
  @Column(name = "`address`", nullable = false)
  private String address;

  @ToString.Exclude
  @Size(min = 0, max = 255)
  @Column(name = "`image_url`", nullable = false)
  private String imageUrl;

  @ToString.Exclude
  @Size(min = 0, max = 255)
  @Column(name = "`department`", nullable = false)
  private String department;

  /**
   * transient
   */

  @Transient
  @Column(name = "`deleted_at`")
  private LocalDateTime recentlyLoggedInAt;

  /**
   * relations
   */
  @OneToOne(
    fetch = FetchType.EAGER,
    mappedBy = "user",
    cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},
    optional = false)
  private AuthIdentity authIdentity;

//  @ToString.Exclude
//  @Builder.Default
//  @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//  private List<RoleToUser> roleToUsers = new ArrayList<>();
//
//  /**
//   * functions
//   */
//  public void addRoleToUser(RoleToUser roleToUser) {
//    roleToUser.setUser(this);
//    roleToUsers.add(roleToUser);
//  }
//
//  public void removeRoleToUser(RoleToUser roleToUser) {
//    roleToUser.setUser(null);
//    roleToUsers.remove(roleToUser);
//  }
//
//  public List<Role.Code> getRoleCodes() {
//    List<Role.Code> roles = getRoleToUsers()
//                              .stream()
//                              .map(roleToUser -> {
//                                return roleToUser.getRole().getCode();
//                              }).collect(Collectors.toList());
//
//    return roles;
//  }
//
//  public List<Permission.Code> getPermissionCodes() {
//    List<RoleToUser> roleToUsers = getRoleToUsers();
//    List<PermissionToRole> permissionToRoles = roleToUsers
//                                                 .stream()
//                                                 .flatMap(r -> r.getRole().getPermissionToRoles().stream())
//                                                 .collect(Collectors.toList());
//
//    List<Permission.Code> permissions = permissionToRoles
//                                          .stream()
//                                          .map(x -> x.getPermission().getCode())
//                                          .collect(Collectors.toList());
//
//    Set<Permission.Code> permissionSet = new HashSet<>(permissions.size());
//    permissionSet.addAll(permissions);
//
//    return new ArrayList<>(permissionSet);
//  }
//
//  public void clearRoleToUsers() {
//    this.roleToUsers = new ArrayList<>();
//  }
}
