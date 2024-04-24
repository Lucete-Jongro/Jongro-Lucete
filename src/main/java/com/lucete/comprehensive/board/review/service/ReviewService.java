package com.lucete.comprehensive.board.review.service;

import com.lucete.comprehensive.board.review.dao.ReviewMapper;
import com.lucete.comprehensive.board.review.dto.CommentDTO;
import com.lucete.comprehensive.board.review.dto.ReviewDTO;
import com.lucete.comprehensive.common.paging.Pagenation;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) {
        this.reviewMapper = reviewMapper;
    }


    public Map<String, Object> selectReviewList(Map<String, String> searchMap, int page) {
        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = reviewMapper.selectTotalCount(searchMap);
        log.info("reviewList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;
        int buttonAmount = 3;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("reviewList selectCriteria : {}", selectCriteria);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */

        List<ReviewDTO> reviewList = reviewMapper.selectReviewList(selectCriteria);
        log.info("inquiryList : {}", reviewList);

        Map<String, Object> reviewListPaging = new HashMap<>();
        reviewListPaging.put("paging", selectCriteria);
        reviewListPaging.put("reviewList", reviewList);


        return reviewListPaging;

    }

    public void registReview(ReviewDTO review) {
        /* 소비자- 리뷰글 등록 */
        reviewMapper.insertReview(review);

    }

    public ReviewDTO selectReviewDetail(int revNo) {

        /* 조회수 증가 로직 호출 */
        reviewMapper.incrementReviewCount(revNo);

        /* 소비자- 리뷰 상세 내용 조회 */
        return reviewMapper.selectReviewDetail(revNo);
    }

    public void deleteReview(int revNo) {
        /* 소비자 - 리뷰글 삭제 */
        reviewMapper.deleteReview(revNo);


        //회원 로그인 되면 회원만 삭제 접근 하는 기능 넣어야함

    }

    public void updateReview(ReviewDTO revNo) {

        /* 소비자- 리뷰글 수정 */
        reviewMapper.updateReview(revNo);

        //회원 로그인 되면 회원만 수정 접근 하는 기능 넣어야함
    }

//    public void registComment(CommentDTO registComment) {
//        /* 답글 등록 */
//        reviewMapper.insertComment(registComment);
//    }
//
//    public List<CommentDTO> loadComment(CommentDTO loadComment) {
//        /* 답글 조회 */
//        return reviewMapper.selectCommentList(loadComment);
//    }
//
//    public void removeComment(CommentDTO removeComment) {
//        /* 답글 삭제 */
//        reviewMapper.deleteComment(removeComment);
//    }

    /* 관리자 페이지 페이징처리 */
    public Map<String, Object> AdminSelectReviewList(Map<String, String> searchMap, int page) {
        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = reviewMapper.AdminSelectTotalCount(searchMap);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;
        int buttonAmount = 3;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */

        List<ReviewDTO> reviewList = reviewMapper.AdminSelectReviewList(selectCriteria);

        Map<String, Object> reviewListPaging = new HashMap<>();
        reviewListPaging.put("paging", selectCriteria);
        reviewListPaging.put("inquiryList", reviewList);


        return reviewListPaging;

    }

//    public void AdminDeleteReview(List<Long> selectedRevNos) {
//        /* 관리자 - 리뷰글 삭제 */
//        reviewMapper.AdminDeleteReview(selectedRevNos);
//
//        //회원 로그인 되면 관리자만 삭제 접근 하는 기능 넣어야함
//
//    }

    public ReviewDTO AdminSelectReviewDetail(int revNo) {
        /* 관리자- 리뷰 상세 내용 조회 */
        return reviewMapper.AdminSelectReviewDetail(revNo);
    }
}
