package jupyter.catalog.generated.swagger.server.api;

import jupyter.catalog.generated.swagger.model.UserDTO;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthControllerApiControllerIntegrationTest {

    @Autowired
    private AuthControllerApi api;

    @Test
    public void whoamiTest() throws Exception {
        ResponseEntity<UserDTO> responseEntity = api.whoami();
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
