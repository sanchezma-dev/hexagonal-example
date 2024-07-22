package hex.example.infrastructure.apirest.adapters;

import hex.example.application.ports.in.UserServicePort;
import hex.example.infrastructure.apirest.mappers.UserRestMapper;
import hex.example.infrastructure.apirest.models.UserDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("app/user/v1/")
public class UserControllerAdapter {

    private final UserServicePort userServicePort;
    private final UserRestMapper userRestMapper;

    @GetMapping("usersAll")
    public ResponseEntity<List<UserDTO>> users() {
        var response = userServicePort.findAllUsers();
        return ResponseEntity.ok(userRestMapper.toUserDTOList(response));
    }

    @PostMapping("createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody final UserDTO userNewDTO) {
        var response = userServicePort.saveUser(userRestMapper.toUserRest(userNewDTO));
        return ResponseEntity.ok(userRestMapper.toUserDTORest(response));
    }

}
