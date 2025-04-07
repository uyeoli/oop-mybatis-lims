package lims.api.test.service.impl;

import lims.api.test.dto.request.ResultInputInfoDto;
import lims.api.test.dto.response.ResultInputDto;
import lims.api.test.service.ResultInputService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultInputServiceImpl implements ResultInputService {
    @Override
    public List<ResultInputDto> findAll() {
        return null;
    }

    @Override
    public void save(ResultInputInfoDto resultInputInfoDto) {

    }

    @Override
    public void delete(Long id) {

    }
}
