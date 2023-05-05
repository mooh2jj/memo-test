package com.example.memotest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TestServiceTest {


    @InjectMocks
    private TestService testService;


    @Test
    void searchById() {
//        TodoEntity entity = new TodoEntity();
//        entity.setId(123L);
//        entity.setTitle("TITLE");
//        entity.setOrder(0L);
//        entity.setCompleted(false);
//
//        Optional<TodoEntity> optional = Optional.of(entity);
//
//        given(this.todoRepository.findById(anyLong()))
//                .willReturn(optional);
//
//        TodoEntity actual = this.todoService.searchById(123L);
//
//        TodoEntity expected = optional.get();
        System.out.println("testService = " + testService);


    }


}
