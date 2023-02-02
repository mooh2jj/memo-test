package com.example.memotest.service;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.dto.MemoResponse;
import com.example.memotest.dto.MemoUpdateRequest;
import com.example.memotest.dto.PageRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemoService {
    List<MemoResponse> getAll();

    MemoResponse getById(Long memoId);

    void create(MemoCreateRequest memoCreateRequest);

    void update(MemoUpdateRequest memoUpdateRequest, Long memoId);

    void delete(Long memoId);

    Page<MemoResponse> list1(Pageable pageable);

    Page<MemoResponse> list2(PageRequestDto pageRequestDto);
}
