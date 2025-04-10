package lims.api.test.service;

import lims.api.test.dto.request.CreateResultInputDto;
import lims.api.test.dto.request.ModifyResultInputDto;
import lims.api.test.dto.request.ResultInputApproveDto;
import lims.api.test.dto.response.ResultInputDto;

import java.util.List;

public interface ResultInputService {
    List<ResultInputDto> findAll();

    void create(CreateResultInputDto createResultInputDto);

    void delete(Long id);

    void update(ModifyResultInputDto modifyResultInputDto);

    void draft(Long id, List<ResultInputApproveDto> resultInputApprovers);
}
