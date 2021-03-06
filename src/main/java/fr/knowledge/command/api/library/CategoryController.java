package fr.knowledge.command.api.library;

import fr.knowledge.command.api.common.AuthorizationInfoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
@Api(description = "Endpoints to interact with the knowledge library categories")
public class CategoryController {
  private final LibraryService libraryService;

  @Autowired
  public CategoryController(LibraryService libraryService) {
    this.libraryService = libraryService;
  }

  @ApiOperation(value = "Endpoint to create a new category", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.POST, value = "/categories")
  public ResponseEntity createCategory(@RequestHeader("client") String client,
                                     @RequestHeader("secret") String secret,
                                     @RequestHeader("username") String username,
                                     @RequestHeader("access-token") String accessToken,
                                     @RequestBody CategoryDTO categoryDTO) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.createCategory(authorizationInfoDTO, categoryDTO);
  }

  @ApiOperation(value = "Endpoint to update a category", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.PUT, value = "/categories")
  public ResponseEntity updateCategory(@RequestHeader("client") String client,
                                       @RequestHeader("secret") String secret,
                                       @RequestHeader("username") String username,
                                       @RequestHeader("access-token") String accessToken,
                                       @RequestBody CategoryDTO categoryDTO) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.updateCategory(authorizationInfoDTO, categoryDTO);
  }



  @ApiOperation(value = "Endpoint to delete a category", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.DELETE, value = "/categories/{categoryId}")
  public ResponseEntity deleteCategory(@RequestHeader("client") String client,
                                       @RequestHeader("secret") String secret,
                                       @RequestHeader("username") String username,
                                       @RequestHeader("access-token") String accessToken,
                                       @PathVariable String categoryId) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.deleteCategory(authorizationInfoDTO, categoryId);
  }
}
