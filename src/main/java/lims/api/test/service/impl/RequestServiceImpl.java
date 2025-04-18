package lims.api.test.service.impl;

import lims.api.test.dto.request.RequestCreateDto;
import lims.api.test.dto.request.RequestModifyDto;
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
    public void create(RequestCreateDto requestCreateDto) {
        Request request = requestCreateDto.toEntity();
        requestRepository.insert(request);
    }

    @Override
    public void update(Long id, RequestModifyDto requestModifyDto) {
        Request request = requestRepository.findById(id);
        request.modify(requestModifyDto);
        requestRepository.update(request);
    }

    @Override
    public void submitRequest(Long id) {
        Request request = requestRepository.findById(id);
        request.submit();
        requestRepository.save(request);
    }

    @Override
    public void delete(Long id) {
        requestRepository.deleteById(id);
    }


}
