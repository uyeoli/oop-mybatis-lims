package lims.api.user.service;

import lims.api.user.dto.UserDto;
import lims.api.user.entity.User;

import java.util.List;

public interface UserService {

    List<UserDto> get();

    void save(UserDto userDto);
}
