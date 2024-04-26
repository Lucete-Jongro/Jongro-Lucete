package com.lucete.comprehensive.board.review.dao;

import com.lucete.comprehensive.board.review.dto.CommentDTO;
import com.lucete.comprehensive.board.review.dto.ReviewDTO;
import com.lucete.comprehensive.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {
    int selectTotalCount(Map<String, String> searchMap);

    List<ReviewDTO> selectReviewList(SelectCriteria selectCriteria);

    void incrementReviewCount(int revNo);

    void insertReview(ReviewDTO review);

    ReviewDTO selectReviewDetail(int revNo);

    void deleteReview(int revNo);

    void updateReview(ReviewDTO revNo);




    /* ------ 관리자 페이지 ------*/
    int AdminSelectTotalCount(Map<String, String> searchMap);

    List<ReviewDTO> AdminSelectReviewList(SelectCriteria selectCriteria);

    ReviewDTO AdminSelectReviewDetail(int revNo);



//    void insertComment(CommentDTO registComment);
//
//    List<CommentDTO> selectCommentList(CommentDTO loadComment);
//
//    void deleteComment(CommentDTO removeComment);


//    void AdminDeleteReview(List<Long> selectedRevNos);

}
