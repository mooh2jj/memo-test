package com.example.memotest.controller;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.dto.MemoResponse;
import com.example.memotest.dto.MemoUpdateRequest;
import com.example.memotest.common.page.PageRequestDto;
import com.example.memotest.dto.ResultDto;
import com.example.memotest.enums.ResultCode;
import com.example.memotest.service.MemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.memotest.enums.ResultCode.*;

@Api(value = "CRUD memo controller REST APIs")
@Slf4j
@RequestMapping("/memo")
@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @ApiOperation(value = "REST API to getAll Memo app")
    @GetMapping
    public ResponseEntity<?> getAll() {
        log.info("getAll");
        List<MemoResponse> memoList = memoService.getAll();
        return new ResponseEntity<>(memoList, HttpStatus.OK);
//        return ResponseEntity.ok(new ResultDto<>(SUCCESS_CODE.getCode(), SUCCESS_CODE.getMessage(), null, memoList));
    }

    @GetMapping("/page1")
    public ResponseEntity<ResultDto> list1(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 5)
            Pageable pageable
    )
    {
        Page<MemoResponse> responsePage = memoService.list1(pageable);
//        return new ResponseEntity<>(responsePage, HttpStatus.OK);
        return ResponseEntity.ok(new ResultDto<>(SUCCESS_CODE.getCode(), SUCCESS_CODE.getMessage(), null, responsePage));
    }

    // querydsl 사용
    @GetMapping("/page2")
    public ResponseEntity<ResultDto> list2(
            PageRequestDto pageRequestDto)
    {
        Page<MemoResponse> responsePage = memoService.list2(pageRequestDto);
//        return new ResponseEntity<>(responsePage, HttpStatus.OK);
        return ResponseEntity.ok(new ResultDto<>(SUCCESS_CODE.getCode(), SUCCESS_CODE.getMessage(), null, responsePage));
    }

    @GetMapping("/{memoId}")
    public ResponseEntity<MemoResponse> getById(@PathVariable("memoId") Long memoId) {

        MemoResponse memoResponse = memoService.getById(memoId);

        return new ResponseEntity<>(memoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody MemoCreateRequest memoCreateRequest) {
        log.info("memoCreateRequest: {}", memoCreateRequest);
        memoService.create(memoCreateRequest);

        return new ResponseEntity<>("create memo", HttpStatus.CREATED);
    }

    @PutMapping("/{memoId}")
    public ResponseEntity<String> update(
            @RequestBody MemoUpdateRequest memoUpdateRequest,
            @PathVariable("memoId") Long memoId
    ) {
        memoService.update(memoUpdateRequest, memoId);

        return new ResponseEntity<>("update success", HttpStatus.OK);
    }

    @DeleteMapping("/{memoId}")
    public ResponseEntity<String> delete(@PathVariable("memoId") Long memoId) {

        memoService.delete(memoId);
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

}
