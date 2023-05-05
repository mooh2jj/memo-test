package com.example.memotest.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@NoArgsConstructor
public class ResponseTestDto {

    private int num;

    private List<Integer> outputs = new ArrayList<>();

    public ResponseTestDto(int num) {
        this.num = num;

        List<Integer> remainList = IntStream.rangeClosed(1, 45) // 로또 번호 : 1번부터 45번까지 존재
                .boxed().collect(Collectors.toList());

        Random random = new Random();

        while (outputs.size() < num) {
//            int randomInt = (int) (Math.random() * 45 + 1);  // 1~45사이 랜덤숫자
            int randomInt = random.nextInt(remainList.size()) + 1; // 1~45사이 랜덤숫자
            // 증복문제는? => 미리 remainList에서 제거해서 넣는다!
            if (!outputs.contains(randomInt)) {
                outputs.add(randomInt);
            }

        }

    }

}
