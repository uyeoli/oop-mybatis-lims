package lims.api.test.service;

import lims.api.test.dto.request.ResultInputCreateDto;
import lims.api.test.dto.request.ResultInputModifyDto;
import lims.api.test.dto.request.ResultInputApproveDto;
import lims.api.test.dto.response.ResultInputDto;

import java.util.List;

public interface ResultInputService {
    List<ResultInputDto> findAll();

    void insert(ResultInputCreateDto resultInputCreateDto);

    void delete(Long id);

    void update(ResultInputModifyDto resultInputModifyDto);

    void draft(Long id, List<ResultInputApproveDto> resultInputApprovers);
}
