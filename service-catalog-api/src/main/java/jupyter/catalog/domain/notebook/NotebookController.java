package jupyter.catalog.domain.notebook;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jupyter.catalog.generated.swagger.model.Failure;
import jupyter.catalog.generated.swagger.model.RenderedNotebookDTO;
import jupyter.catalog.generated.swagger.server.api.NotebookControllerApi;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api")
public class NotebookController implements NotebookControllerApi {

    private NotebookBridge notebookBridge;

    @Autowired
    public NotebookController(NotebookBridge notebookBridge) {
        this.notebookBridge = notebookBridge;
    }

    @RequestMapping(
            value = "/notebook/display",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = RenderedNotebookDTO.class),
            @ApiResponse(code = 400, message = "Bad Request", response = Failure.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = Failure.class),
            @ApiResponse(code = 403, message = "Forbidden", response = Failure.class),
            @ApiResponse(code = 404, message = "Not Found", response = Failure.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = Failure.class)})
    @ApiOperation(value = "", nickname = "displayNotebook", notes = "",
            response = RenderedNotebookDTO.class, tags = {"notebook-controller",})
    @Override
    public ResponseEntity<RenderedNotebookDTO> displayNotebook() {

        val dto = notebookBridge.handleDisplayNotebook();
        return ResponseEntity.ok(dto);
    }
}
