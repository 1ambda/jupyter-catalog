package jupyter.catalog.generated.swagger.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import jupyter.catalog.generated.swagger.model.Provider2;
import javax.validation.constraints.*;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * UserDTO2
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class UserDTO2 {
  @JsonProperty(value = "id")
  @Builder.Default
  private Long id = null;

  @JsonProperty(value = "sex")
  @Builder.Default
  private String sex = null;

  @JsonProperty(value = "userName")
  @Builder.Default
  private String userName = null;

  @JsonProperty(value = "password")
  @Builder.Default
  private String password = null;

  @JsonProperty(value = "provider")
  @Builder.Default
  private Provider2 provider = null;

  @JsonProperty(value = "displayName")
  @Builder.Default
  private String displayName = null;

  @JsonProperty(value = "email")
  @Builder.Default
  private String email = null;

  @JsonProperty(value = "department")
  @Builder.Default
  private String department = null;

  @JsonProperty(value = "imageUrl")
  @Builder.Default
  private String imageUrl = null;

  @JsonProperty(value = "roles")
  @Builder.Default
  private List<String> roles = null;

  @JsonProperty(value = "permissions")
  @Builder.Default
  private List<String> permissions = null;

  @JsonProperty(value = "createdBy")
  @Builder.Default
  private Long createdBy = null;

  @JsonProperty(value = "modifiedBy")
  @Builder.Default
  private Long modifiedBy = null;

  @JsonProperty(value = "createdAt")
  @Builder.Default
  private Long createdAt = null;

  @JsonProperty(value = "modifiedAt")
  @Builder.Default
  private Long modifiedAt = null;

  @JsonProperty(value = "recentlyLoggedIn")
  @Builder.Default
  private Long recentlyLoggedIn = null;

  @JsonProperty(value = "isLocked")
  @Builder.Default
  private String isLocked = null;

  public UserDTO2 id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * Auto-generated ID for User
   * @return id
  **/
  @NotNull
  @ApiModelProperty(required = true, value = "Auto-generated ID for User")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserDTO2 sex(String sex) {
    this.sex = sex;
    return this;
  }

   /**
   * Get sex
   * @return sex
  **/
  @ApiModelProperty(value = "")
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public UserDTO2 userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * Get userName
   * @return userName
  **/
  @ApiModelProperty(value = "")
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public UserDTO2 password(String password) {
    this.password = password;
    return this;
  }

   /**
   * Get password
   * @return password
  **/
  @NotNull
  @ApiModelProperty(required = true, value = "")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserDTO2 provider(Provider2 provider) {
    this.provider = provider;
    return this;
  }

   /**
   * Get provider
   * @return provider
  **/
  @Valid
  @ApiModelProperty(value = "")
  public Provider2 getProvider() {
    return provider;
  }

  public void setProvider(Provider2 provider) {
    this.provider = provider;
  }

  public UserDTO2 displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

   /**
   * Get displayName
   * @return displayName
  **/
  @ApiModelProperty(value = "")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public UserDTO2 email(String email) {
    this.email = email;
    return this;
  }

   /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserDTO2 department(String department) {
    this.department = department;
    return this;
  }

   /**
   * Get department
   * @return department
  **/
  @ApiModelProperty(value = "")
  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public UserDTO2 imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

   /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public UserDTO2 roles(List<String> roles) {
    this.roles = roles;
    return this;
  }

  public UserDTO2 addRolesItem(String rolesItem) {
    if (this.roles == null) {
      this.roles = new ArrayList<>();
    }
    this.roles.add(rolesItem);
    return this;
  }

   /**
   * Get roles
   * @return roles
  **/
  @ApiModelProperty(value = "")
  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public UserDTO2 permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public UserDTO2 addPermissionsItem(String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

   /**
   * Get permissions
   * @return permissions
  **/
  @ApiModelProperty(value = "")
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  public UserDTO2 createdBy(Long createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return createdBy
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public UserDTO2 modifiedBy(Long modifiedBy) {
    this.modifiedBy = modifiedBy;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return modifiedBy
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getModifiedBy() {
    return modifiedBy;
  }

  public void setModifiedBy(Long modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public UserDTO2 createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return createdAt
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public UserDTO2 modifiedAt(Long modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return modifiedAt
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getModifiedAt() {
    return modifiedAt;
  }

  public void setModifiedAt(Long modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public UserDTO2 recentlyLoggedIn(Long recentlyLoggedIn) {
    this.recentlyLoggedIn = recentlyLoggedIn;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return recentlyLoggedIn
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getRecentlyLoggedIn() {
    return recentlyLoggedIn;
  }

  public void setRecentlyLoggedIn(Long recentlyLoggedIn) {
    this.recentlyLoggedIn = recentlyLoggedIn;
  }

  public UserDTO2 isLocked(String isLocked) {
    this.isLocked = isLocked;
    return this;
  }

   /**
   * Y / N
   * @return isLocked
  **/
  @ApiModelProperty(value = "Y / N")
  public String getIsLocked() {
    return isLocked;
  }

  public void setIsLocked(String isLocked) {
    this.isLocked = isLocked;
  }


}


