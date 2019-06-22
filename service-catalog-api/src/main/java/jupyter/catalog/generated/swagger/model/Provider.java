package jupyter.catalog.generated.swagger.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonValue;
import javax.validation.constraints.*;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets Provider
 */
public enum Provider {
  
  PASSWORD("PASSWORD"),
  
  LDAP("LDAP"),
  
  OAUTH_GOOGLE("OAUTH_GOOGLE");

  private String value;

  Provider(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Provider fromValue(String text) {
    for (Provider b : Provider.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}


