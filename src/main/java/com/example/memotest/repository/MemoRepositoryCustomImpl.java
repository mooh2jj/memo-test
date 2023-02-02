package com.example.memotest.repository;

import com.example.memotest.dto.PageRequestDto;
import com.example.memotest.entity.Memo;
import com.example.memotest.entity.QMemo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static com.example.memotest.entity.QMemo.memo;

public class MemoRepositoryCustomImpl implements MemoRepositoryCustom {

    private JPAQueryFactory queryFactory;

    public MemoRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<Memo> getMemoPage(PageRequestDto pageRequestDto, Pageable pageable) {

        QMemo memo = QMemo.memo;

        QueryResults<Memo> results = queryFactory
                .selectFrom(memo)
                .where(getSearch(pageRequestDto))
//                .orderBy(memo.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Memo> memoList = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(memoList, pageable, total);
    }

    private BooleanBuilder getSearch(PageRequestDto pageRequestDto) {
        String type = pageRequestDto.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        String keyword = pageRequestDto.getKeyword();
        BooleanExpression expression = memo.id.gt(0L); // id > 0 조건만
        booleanBuilder.and(expression);

        // 검색조건이 없는 경우
        if (StringUtils.isEmpty(type)) {
            return booleanBuilder;
        }

        // 검색 조건이 있는 경우
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("t")){
            conditionBuilder.or(memo.title.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(memo.content.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;

    }
}
