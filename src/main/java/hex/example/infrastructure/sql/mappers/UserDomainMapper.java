package hex.example.infrastructure.sql.mappers;

import hex.example.application.domain.User;
import hex.example.infrastructure.sql.models.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {

    UserEntity toUserEntity(User user);

    User toUserDomain(UserEntity userEntity);

    default List<User> toUserDomainList(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::toUserDomain).collect(Collectors.toList());
    }

}
