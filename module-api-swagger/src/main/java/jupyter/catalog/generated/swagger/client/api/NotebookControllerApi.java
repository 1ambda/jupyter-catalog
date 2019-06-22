package jupyter.catalog.generated.swagger.client.api;

import jupyter.catalog.generated.swagger.client.invoker.ApiClient;
import jupyter.catalog.generated.swagger.client.invoker.EncodingUtils;

import jupyter.catalog.generated.swagger.model.Failure;
import jupyter.catalog.generated.swagger.model.RenderedNotebookDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;


public interface NotebookControllerApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return RenderedNotebookDTO
   */
  @RequestLine("GET /notebook/display")
  @Headers({
    "Accept: application/json",
  })
  RenderedNotebookDTO displayNotebook();
}
