package com.example.memotest.init;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.service.MemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevInitData {
    @Bean
    public CommandLineRunner initDevData(MemoService memoService) {
        return args -> {

            memoService.create(new MemoCreateRequest("제목1", "컨텐츠1"));
            memoService.create(new MemoCreateRequest("제목2", "컨텐츠2"));
        };
    }
}
