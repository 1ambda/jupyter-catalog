package jupyter.catalog.domain.auth;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jupyter.catalog.generated.swagger.model.Failure;
import jupyter.catalog.generated.swagger.model.UserDTO;
import jupyter.catalog.generated.swagger.server.api.AuthControllerApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api")
public class AuthController implements AuthControllerApi {

    @RequestMapping(value = "/auth/whoiam", produces = {"application/json"}, method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Failure.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Failure.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Failure.class),
            @ApiResponse(code = 404, message = "Not Found", response = Failure.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Failure.class)})
    @ApiOperation(value = "", nickname = "whoami", notes = "", response = UserDTO.class, tags = {"auth-controller",})
    @Override
    public ResponseEntity<UserDTO> whoami() {
        return null;
    }
}
