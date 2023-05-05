package com.example.memotest.repository;

import com.example.memotest.common.page.PageRequestDto;
import com.example.memotest.entity.Memo;
import com.example.memotest.entity.QMemo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.memotest.entity.QMemo.memo;

@Slf4j
@RequiredArgsConstructor
public class MemoRepositoryCustomImpl implements MemoRepositoryCustom {

    private final JPAQueryFactory queryFactory;

//    public MemoRepositoryCustomImpl(EntityManager em) {
//        this.queryFactory = new JPAQueryFactory(em);
//    }


    @Override
    public Page<Memo> getMemoPage(PageRequestDto pageRequestDto, Pageable pageable) {

        QMemo memo = QMemo.memo;

        List<Memo> memoList = queryFactory
                .selectFrom(memo)
                .where(getSearch(pageRequestDto))
                .orderBy(memo.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        log.info("memoList: {}", memoList);

        JPAQuery<Long> countQuery = queryFactory
                .select(memo.count())
                .from(memo)
                .where(getSearch(pageRequestDto))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize());

//        return new PageImpl<>(memoList, pageable, countQuery.fetchCount());
        return PageableExecutionUtils.getPage(memoList, pageable, countQuery::fetchCount);
    }

    private BooleanBuilder getSearch(PageRequestDto pageRequestDto) {
        String type = pageRequestDto.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        String keyword = pageRequestDto.getKeyword();
        BooleanExpression expression = memo.id.gt(0L); // id > 0 조건만
        booleanBuilder.and(expression);

        // 검색조건이 없는 경우
//        if (StringUtils.isEmpty(type)) {
//            return booleanBuilder;
//        }

//        if(type.contains("t")){
//            conditionBuilder.or(memo.title.contains(keyword));
//        }
//        if(type.contains("c")){
//            conditionBuilder.or(memo.content.contains(keyword));
//        }

        // 검색 조건이 있는 경우
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (!StringUtils.isEmpty(keyword)) {
            conditionBuilder.or(memo.title.contains(keyword))
                    .or(memo.content.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);
        return booleanBuilder;

    }
}
