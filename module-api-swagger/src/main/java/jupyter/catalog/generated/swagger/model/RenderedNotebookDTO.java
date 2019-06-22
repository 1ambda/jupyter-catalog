package jupyter.catalog.generated.swagger.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * RenderedNotebookDTO
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@EqualsAndHashCode
@ToString
public class RenderedNotebookDTO {
  @JsonProperty(value = "path")
  @Builder.Default
  private String path = null;

  @JsonProperty(value = "content")
  @Builder.Default
  private String content = null;

  public RenderedNotebookDTO path(String path) {
    this.path = path;
    return this;
  }

   /**
   * Notebook File Path
   * @return path
  **/
  @ApiModelProperty(value = "Notebook File Path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RenderedNotebookDTO content(String content) {
    this.content = content;
    return this;
  }

   /**
   * Notebook Content
   * @return content
  **/
  @ApiModelProperty(value = "Notebook Content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


}


