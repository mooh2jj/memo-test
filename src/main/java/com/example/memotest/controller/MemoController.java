package com.example.memotest.controller;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.dto.MemoResponse;
import com.example.memotest.dto.MemoUpdateRequest;
import com.example.memotest.entity.Memo;
import com.example.memotest.service.MemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/memo")
    public ResponseEntity<List<MemoResponse>> getAll() {

        List<MemoResponse> memoList = memoService.getAll();

        return new ResponseEntity<>(memoList, HttpStatus.OK);
    }

    @GetMapping("/memo/{memoId}")
    public ResponseEntity<MemoResponse> getById(@PathVariable("memoId") Long memoId) {

        MemoResponse memoResponse = memoService.getById(memoId);

        return new ResponseEntity<>(memoResponse, HttpStatus.OK);
    }

    @PostMapping("/memo")
    public ResponseEntity<String> create(@RequestBody MemoCreateRequest memoCreateRequest) {

        memoService.create(memoCreateRequest);

        return new ResponseEntity<>("create memo", HttpStatus.CREATED);
    }

    @PutMapping("/memo/{memoId}")
    public ResponseEntity<String> update(
            @RequestBody MemoUpdateRequest memoUpdateRequest,
            @PathVariable("memoId") Long memoId
    ) {
        memoService.update(memoUpdateRequest, memoId);

        return new ResponseEntity<>("update success", HttpStatus.OK);
    }

    @DeleteMapping("/memo/{memoId}")
    public ResponseEntity<String> delete(@PathVariable("memoId") Long memoId) {

        memoService.delete(memoId);

        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

}
