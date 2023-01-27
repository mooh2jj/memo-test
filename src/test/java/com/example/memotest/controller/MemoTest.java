package com.example.memotest.controller;

import com.example.memotest.entity.Memo;
import com.example.memotest.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.stream.LongStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
class MemoTest {

    @Autowired
    private MemoRepository memoRepository;

    @Test
    @DisplayName("saveTest")
    public void save() {

        LongStream.rangeClosed(1,30).forEach( i -> {
            Memo memo = Memo.builder()
                    .title("title_"+i)
                    .content("content_"+i)
                    .build();

            memoRepository.save(memo);
        });

    }

    @Test
    @DisplayName("getAll 테스트")
    public void getAll() {

        List<Memo> all = memoRepository.findAll();
        log.info("all : {}", all);

        System.out.println("all = " + all);
        assertThat(all.size()).isGreaterThan(30);
    }

}
