package jupyter.catalog.domain.auth;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jupyter.catalog.generated.swagger.model.Failure;
import jupyter.catalog.generated.swagger.model.UserDTO;
import jupyter.catalog.generated.swagger.model.UserDTO2;
import jupyter.catalog.generated.swagger.server.api.AuthControllerApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping(value = "/auth/whoiam2", produces = {"application/json"}, method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Failure.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Failure.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Failure.class),
            @ApiResponse(code = 404, message = "Not Found", response = Failure.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Failure.class)})
    @ApiOperation(value = "", nickname = "whoami2", notes = "", response = UserDTO2.class, tags = {"auth-controller",})
    @Override
    public ResponseEntity<UserDTO2> whoami2() {
        UserDTO2 userInfo = new UserDTO2();

        userInfo.setSex("Male");
        return new ResponseEntity<UserDTO2>(userInfo, HttpStatus.OK);

    }


/*
    @PostMapping(value = "/auth/registerUser")
    @ApiOperation(value="회원 등록", notes = "회원을 등록한다.")

    public ResponseEntity<UserDTO2> registerUser(
            @ApiParam(value="id", required = true) @RequestParam Long uid,
            @ApiParam(value="passwored", required = true) @RequestParam String upw
    ) {
        UserDTO2 user = new UserDTO2();

        user.setId(uid);
        user.setPassword(upw);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/



//`    @ApiOperation(value = "회원 수정", notes = "회원정보를 수정한다")
//    @PutMapping(value = "/auth/updateUser")
//
//    public ResponseEntity<UserDTO2> updateUser(
//          @ApiParam(value="passwored", required = true) @RequestParam String upw
//    ){
//      UserDTO2 user = new UserDTO2();
//
//      user.setId(uid);
//      user.setPassword(upw);
//      return new ResponseEntity<>(user, HttpStatus.OK);
//
//    }
//
//
///*
//    @PostMapping(value = "/auth/registerUser")
//    //@PostMapping(value="/auth/registerUser")
//    @ApiOperation(value="회원 등록", notes = "회원을 등록한다.")
//
//    public ResponseEntity<UserDTO2> registerUser(
//            @ApiParam(value="id", required = true) @RequestParam Long uid,
//            @ApiParam(value="passwored", required = true) @RequestParam String upw
//    ) {
//        UserDTO2 user = new UserDTO2();
//
//        user.setId(uid);
//        user.setPassword(upw);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }*/
//
//

}
