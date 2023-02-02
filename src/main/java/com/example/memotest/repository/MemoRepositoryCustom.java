package com.example.memotest.repository;

import com.example.memotest.dto.PageRequestDto;
import com.example.memotest.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemoRepositoryCustom {
    Page<Memo> getMemoPage(PageRequestDto pageRequestDto, Pageable pageable);
}
