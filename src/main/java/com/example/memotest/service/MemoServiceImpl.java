package com.example.memotest.service;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.dto.MemoResponse;
import com.example.memotest.dto.MemoUpdateRequest;
import com.example.memotest.entity.Memo;
import com.example.memotest.exception.ErrorCode;
import com.example.memotest.exception.MemoAPIException;
import com.example.memotest.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService{

    private final MemoRepository memoRepository;
    @Transactional(readOnly = true)
    @Override
    public List<MemoResponse> getAll() {

//        List<Memo> memoList = memoRepository.findAll();
        List<MemoResponse> memoResponseList = memoRepository.findAll(Sort.by(Sort.Direction.DESC, "id")).stream()
                .map(MemoResponse::toDto)
                .collect(Collectors.toList());

        log.info("memoResponseList: {}", memoResponseList);

        return memoResponseList ;
    }

    @Transactional(readOnly = true)
    @Override
    public MemoResponse getById(Long memoId) {

        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new MemoAPIException(ErrorCode.NO_FOUND_ENTITY, "memo", "memeId", memoId));
        MemoResponse memoResponse = MemoResponse.toDto(memo);
        log.info("memoResponse: {}", memoResponse);
        return memoResponse;
    }

    @Transactional
    @Override
    public void create(MemoCreateRequest memoCreateRequest) {

        memoRepository.save(Memo.of(memoCreateRequest));
    }

    @Transactional
    @Override
    public void update(MemoUpdateRequest memoUpdateRequest, Long memoId) {

        Memo findMemo = memoRepository.findById(memoId)
                .orElseThrow(() -> new RuntimeException("엔티티 없음"));

        findMemo.updateMemo(memoUpdateRequest);

    }

    @Transactional
    @Override
    public void delete(Long memoId) {

        Memo findMemo = memoRepository.findById(memoId)
                .orElseThrow(() -> new RuntimeException("엔티티 없음"));

        memoRepository.delete(findMemo);
    }
}
