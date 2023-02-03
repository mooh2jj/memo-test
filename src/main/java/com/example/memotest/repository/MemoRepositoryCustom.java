package com.example.memotest.repository;

import com.example.memotest.common.page.PageRequestDto;
import com.example.memotest.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemoRepositoryCustom {
    Page<Memo> getMemoPage(PageRequestDto pageRequestDto, Pageable pageable);
}
