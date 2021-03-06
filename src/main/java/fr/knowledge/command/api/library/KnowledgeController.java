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
@Api(description = "Endpoints to interact with the knowledge library content")
public class KnowledgeController {
  private final LibraryService libraryService;

  @Autowired
  public KnowledgeController(LibraryService libraryService) {
    this.libraryService = libraryService;
  }

  @ApiOperation(value = "Endpoint to add a new knowledge to a category", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.POST, value = "/knowledges")
  public ResponseEntity addKnowledge(@RequestHeader("client") String client,
                                       @RequestHeader("secret") String secret,
                                       @RequestHeader("username") String username,
                                       @RequestHeader("access-token") String accessToken,
                                       @RequestBody KnowledgeDTO knowledgeDTO) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.addKnowledge(authorizationInfoDTO, knowledgeDTO);
  }

  @ApiOperation(value = "Endpoint to update a knowledge", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.PUT, value = "/knowledges")
  public ResponseEntity updateKnowledge(@RequestHeader("client") String client,
                                       @RequestHeader("secret") String secret,
                                       @RequestHeader("username") String username,
                                       @RequestHeader("access-token") String accessToken,
                                       @RequestBody KnowledgeDTO knowledgeDTO) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.updateKnowledge(authorizationInfoDTO, knowledgeDTO);
  }

  @ApiOperation(value = "Endpoint to delete a knowledge", response = ResponseEntity.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 401, message = "Unauthorized")
  })
  @RequestMapping(method = RequestMethod.POST, value = "/knowledges/delete")
  public ResponseEntity deleteKnowledge(@RequestHeader("client") String client,
                                       @RequestHeader("secret") String secret,
                                       @RequestHeader("username") String username,
                                       @RequestHeader("access-token") String accessToken,
                                       @RequestBody KnowledgeDTO knowledgeDTO) {
    AuthorizationInfoDTO authorizationInfoDTO = new AuthorizationInfoDTO(client, secret, username, accessToken);
    return libraryService.deleteKnowledge(authorizationInfoDTO, knowledgeDTO);
  }
}
