package lims.api.user.repository;

import lims.api.user.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    List<UserDto> get();

    void save(UserDto userDto);
}
