package lims.api.test.service;

import lims.api.test.dto.request.RequestInfoDto;
import lims.api.test.dto.response.RequestDto;

import java.util.List;

public interface RequestService {

    void request(RequestInfoDto testRequestDto);
    List<RequestDto> findAll();

    void delete(Long id);

}
