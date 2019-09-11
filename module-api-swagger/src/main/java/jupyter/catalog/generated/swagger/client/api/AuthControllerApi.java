package jupyter.catalog.generated.swagger.client.api;

import jupyter.catalog.generated.swagger.client.invoker.ApiClient;
import jupyter.catalog.generated.swagger.client.invoker.EncodingUtils;

import jupyter.catalog.generated.swagger.model.Failure;
import jupyter.catalog.generated.swagger.model.UserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

public interface AuthControllerApi extends ApiClient.Api {

  /**
   * 
   * 
   * @return UserDTO
   */
  @RequestLine("GET /auth/whoiam")
  @Headers({
      "Accept: application/json",
  })
  UserDTO whoami();
}
