package com.example.memotest.test;

import com.example.memotest.dto.MemoResponse;
import com.example.memotest.dto.ResponseTestDto;
import com.example.memotest.service.TestService;
import com.example.memotest.test.domain.Student;
import com.example.memotest.test.dto.StudentResDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @GetMapping
    public List<String> test() {

        return Arrays.asList("bab", "banana", "apple");
    }

    // 로또 넘버 생성기
    @GetMapping("/lotto/{num}")
    public ResponseTestDto lottoGenerate(@PathVariable("num") int num) {

        ResponseTestDto responseTestDto = new ResponseTestDto(num);
        System.out.println("responseDto.getOutputs() = " + responseTestDto.getOutputs());
        return responseTestDto;
    }

    @PostMapping("/student")
    public StudentResDto inputStudent(@RequestBody Student student) {
        log.info("inputStudent run......");
        return StudentResDto.of(student);
    }

    @GetMapping("/test/{memoId}")
    public ResponseEntity<MemoResponse> getById(@PathVariable("memoId") Long memoId) {

        MemoResponse memoResponse = testService.getById(memoId);

        return new ResponseEntity<>(memoResponse, HttpStatus.OK);
    }
}



