package com.example.memotest.controller;

import com.example.memotest.entity.Memo;
import com.example.memotest.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.LongStream;

@SpringBootTest
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

}
