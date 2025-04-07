package lims.api.test.service;

import lims.api.test.dto.request.ResultInputInfoDto;
import lims.api.test.dto.response.ResultInputDto;

import java.util.List;

public interface ResultInputService {
    List<ResultInputDto> findAll();

    void save(ResultInputInfoDto resultInputInfoDto);

    void delete(Long id);
}
