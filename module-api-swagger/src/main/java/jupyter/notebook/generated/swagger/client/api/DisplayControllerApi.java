package jupyter.notebook.generated.swagger.client.api;

import jupyter.notebook.generated.swagger.client.invoker.ApiClient;
import jupyter.notebook.generated.swagger.client.invoker.EncodingUtils;

import jupyter.notebook.generated.swagger.model.Failure;
import jupyter.notebook.generated.swagger.model.RenderedNotebookDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface DisplayControllerApi extends ApiClient.Api {


  /**
   * 
   * 
    * @param path Notebook Path (optional)
   * @return RenderedNotebookDTO
   */
  @RequestLine("GET /notebook/display?path={path}")
  @Headers({
    "Accept: application/json",
  })
  RenderedNotebookDTO displayNotebook(@Param("path") String path);

  /**
   * 
   * 
   * Note, this is equivalent to the other <code>displayNotebook</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link DisplayNotebookQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>path - Notebook Path (optional)</li>
   *   </ul>
   * @return RenderedNotebookDTO
   */
  @RequestLine("GET /notebook/display?path={path}")
  @Headers({
  "Accept: application/json",
  })
  RenderedNotebookDTO displayNotebook(@QueryMap(encoded=true) Map<String, Object> queryParams);

  /**
   * A convenience class for generating query parameters for the
   * <code>displayNotebook</code> method in a fluent style.
   */
  public static class DisplayNotebookQueryParams extends HashMap<String, Object> {
    public DisplayNotebookQueryParams path(final String value) {
      put("path", EncodingUtils.encode(value));
      return this;
    }
  }
}
