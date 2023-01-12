package com.example.memotest.dto;

import com.example.memotest.entity.Memo;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemoResponse {

    private Long id;
    private String title;
    private String content;

    @Builder
    public MemoResponse(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static MemoResponse toDto(Memo memo) {
        return MemoResponse.builder()
                .id(memo.getId())
                .title(memo.getTitle())
                .content(memo.getContent())
                .build();
    }

}
