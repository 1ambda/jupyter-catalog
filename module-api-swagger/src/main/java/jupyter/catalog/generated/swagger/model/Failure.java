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
import javax.validation.constraints.*;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Failure
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class Failure {
  @JsonProperty(value = "timestamp")
  @Builder.Default
  private Long timestamp = null;

  @JsonProperty(value = "status")
  @Builder.Default
  private Integer status = null;

  @JsonProperty(value = "code")
  @Builder.Default
  private Integer code = null;

  @JsonProperty(value = "message")
  @Builder.Default
  private String message = null;

  @JsonProperty(value = "messages")
  @Builder.Default
  private List<String> messages = null;

  @JsonProperty(value = "type")
  @Builder.Default
  private String type = null;

  @JsonProperty(value = "path")
  @Builder.Default
  private String path = null;

  @JsonProperty(value = "stacktrace")
  @Builder.Default
  private String stacktrace = null;

  public Failure timestamp(Long timestamp) {
    this.timestamp = timestamp;
    return this;
  }

   /**
   * Epoch Millis (UTC)
   * @return timestamp
  **/
  @ApiModelProperty(value = "Epoch Millis (UTC)")
  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public Failure status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * Http Status Code
   * @return status
  **/
  @ApiModelProperty(value = "Http Status Code")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Failure code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * Internal Error Code
   * @return code
  **/
  @ApiModelProperty(value = "Internal Error Code")
  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public Failure message(String message) {
    this.message = message;
    return this;
  }

   /**
   * First Error Message
   * @return message
  **/
  @ApiModelProperty(value = "First Error Message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Failure messages(List<String> messages) {
    this.messages = messages;
    return this;
  }

  public Failure addMessagesItem(String messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * All Error Messages
   * @return messages
  **/
  @ApiModelProperty(value = "All Error Messages")
  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

  public Failure type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Error Type (e.g. Exception Class in Java)
   * @return type
  **/
  @ApiModelProperty(value = "Error Type (e.g. Exception Class in Java)")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Failure path(String path) {
    this.path = path;
    return this;
  }

   /**
   * API Path (URI)
   * @return path
  **/
  @ApiModelProperty(value = "API Path (URI)")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Failure stacktrace(String stacktrace) {
    this.stacktrace = stacktrace;
    return this;
  }

   /**
   * Get stacktrace
   * @return stacktrace
  **/
  @ApiModelProperty(value = "")
  public String getStacktrace() {
    return stacktrace;
  }

  public void setStacktrace(String stacktrace) {
    this.stacktrace = stacktrace;
  }


}


