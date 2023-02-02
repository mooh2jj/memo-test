package com.example.memotest.entity;

import com.example.memotest.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles("local")
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemoTest {

    @Autowired
    private MemoRepository memoRepository;


//    @BeforeEach
//    void setup() {
//        Memo memo = Memo.builder()
//                .title("test_")
//                .build();
//    }

    // dumpy 데이터
    @Transactional
    @Test
    @DisplayName("등록 테스트")
    public void createTest() {

        LongStream.rangeClosed(1,30).forEach(i -> {
            Memo memo = Memo.builder()
                    .title("test_tite_"+ i)
                    .content("test_content_" + i)
                    .build();

            memoRepository.save(memo);
        });

    }

    @Transactional(readOnly = true)
    @Test
    @DisplayName("findAll 테스트")
    public void findAllTest() {

        List<Memo> all = memoRepository.findAll();

        log.info("all : {}", all);
        Assertions.assertThat(all.size()).isGreaterThan(60);
    }


}
