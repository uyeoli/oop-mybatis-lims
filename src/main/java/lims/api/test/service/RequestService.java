package lims.api.test.service;

import lims.api.test.dto.request.CreateRequestDto;
import lims.api.test.dto.request.ModifyRequestDto;
import lims.api.test.dto.response.RequestDto;

import java.util.List;

public interface RequestService {

    void create(CreateRequestDto testRequestDto);
    List<RequestDto> findAll();
    void delete(Long id);

    void update(Long id, ModifyRequestDto modifyRequestDto);
}
