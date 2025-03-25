package lims.api.user.service.impl;

import lims.api.user.dto.UserDto;
import lims.api.user.repository.UserRepository;
import lims.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<UserDto> get() {
        return userRepository.get();
    }

    @Override
    public void save(UserDto userDto) {
        userRepository.save(userDto);
    }
}
