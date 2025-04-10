package lims.api.test.service.impl;

import lims.api.test.dto.request.CreateRequestDto;
import lims.api.test.dto.request.ModifyRequestDto;
import lims.api.test.dto.response.RequestDto;
import lims.api.test.entity.Request;
import lims.api.test.repository.RequestRepository;
import lims.api.test.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements RequestService {
    private final RequestRepository requestRepository;

    @Override
    public List<RequestDto> findAll() {
        return requestRepository.findAll().stream().map(RequestDto::of).toList();
    }


    @Override
    public void create(CreateRequestDto createRequestDto) {
        Request request = createRequestDto.toEntity(createRequestDto);
        requestRepository.insert(request);
    }

    @Override
    public void update(Long id, ModifyRequestDto modifyRequestDto) {
        Request request = requestRepository.findById(id);
        requestRepository.update(request);
    }

    @Override
    public void delete(Long id) {
        requestRepository.deleteById(id);
    }


}
