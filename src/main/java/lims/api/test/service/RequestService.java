package lims.api.test.service;

import lims.api.test.dto.request.RequestCreateDto;
import lims.api.test.dto.request.RequestModifyDto;
import lims.api.test.dto.response.RequestDto;

import java.util.List;

public interface RequestService {

    void insert(RequestCreateDto testRequestDto);
    List<RequestDto> findAll();
    void delete(Long id);

    void update(Long id, RequestModifyDto requestModifyDto);

    void submitRequest(Long id);

}
