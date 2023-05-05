package com.example.memotest.service;

import com.example.memotest.dto.MemoResponse;
import com.example.memotest.entity.Memo;
import com.example.memotest.exception.ErrorCode;
import com.example.memotest.exception.MemoAPIException;
import com.example.memotest.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

    private final MemoRepository memoRepository;

    @Transactional(readOnly = true)
    public MemoResponse getById(Long memoId) {

        Memo memo = memoRepository.findById(memoId)
                .orElseThrow(() -> new MemoAPIException(ErrorCode.NO_FOUND_ENTITY, "memo", "memeId", memoId));
        MemoResponse memoResponse = MemoResponse.toDto(memo);
        log.info("memoResponse: {}", memoResponse);
        return memoResponse;
    }

}
