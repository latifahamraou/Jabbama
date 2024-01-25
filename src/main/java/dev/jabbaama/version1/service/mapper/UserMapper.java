package dev.jabbaama.version1.service.mapper;


import dev.jabbaama.version1.model.dto.UserDto;
import dev.jabbaama.version1.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)

public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user );
    void copy (UserDto userDto, @MappingTarget User user );

}
