package com.example.memotest.entity;

import com.example.memotest.dto.MemoCreateRequest;
import com.example.memotest.dto.MemoUpdateRequest;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "memos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id")
    private Long id;

    private String title;
    private String content;

    @Builder
    public Memo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public void updateMemo(MemoUpdateRequest memoUpdateRequest) {
        this.title = memoUpdateRequest.getTitle();
        this.content = memoUpdateRequest.getContent();
    }

    public static Memo of(MemoCreateRequest memoCreateRequest) {
        return Memo.builder()
                .title(memoCreateRequest.getTitle())
                .content(memoCreateRequest.getContent())
                .build();
    }

}
