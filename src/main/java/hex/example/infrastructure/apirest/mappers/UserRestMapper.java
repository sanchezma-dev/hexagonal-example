package hex.example.infrastructure.apirest.mappers;

import hex.example.application.domain.User;
import hex.example.infrastructure.apirest.models.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserRestMapper {

    UserDTO toUserDTORest(User user);

    User toUserRest(UserDTO userDTO);

    default List<UserDTO> toUserDTOList(List<User> users) {
        return users.stream().map(this::toUserDTORest).collect(Collectors.toList());
    }

}
