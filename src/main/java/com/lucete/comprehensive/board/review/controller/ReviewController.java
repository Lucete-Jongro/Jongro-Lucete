package com.lucete.comprehensive.board.review.controller;

import com.lucete.comprehensive.board.inquiry.dto.CommDTO;
import com.lucete.comprehensive.board.review.dto.CommentDTO;
import com.lucete.comprehensive.board.review.dto.ReviewDTO;
import com.lucete.comprehensive.board.review.service.ReviewService;
import com.lucete.comprehensive.common.file.FileDTO;
import com.lucete.comprehensive.user.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/review")

public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


    /* 소비자 리뷰글 리스트 조회 */
    @GetMapping("/list")
    public String getReviewList(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(required = false) String searchCondition,
                                @RequestParam(required = false) String searchValue,
                                Model model) {

        log.info("reviewList page : {}", page);
        log.info("reviewList searchCondition : {}", searchCondition);
        log.info("reviewList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> reviewListAndPaging = reviewService.selectReviewList(searchMap, page);
        model.addAttribute("paging", reviewListAndPaging.get("paging"));
        model.addAttribute("reviewList", reviewListAndPaging.get("reviewList"));

        return "review/reviewList";

    }

    @GetMapping("/regist")
    public String getRegistPage() {

        return "review/reviewRegist";
    }

    /* 소비자 리뷰글 등록 */


    /*소비자 리뷰글 상세 보기 */
    @GetMapping("/detail")
    public String getReviewDetail(@RequestParam int revNo, Model model) {

        ReviewDTO reviewDetail = reviewService.selectReviewDetail(revNo);
        log.info("reviewDetail : {}", reviewDetail);
        model.addAttribute("review", reviewDetail);

        return "review/reviewDetail";
    }

    /* 소비자 리뷰글 삭제 */
    @RequestMapping("/delete")
    public String reviewDelete(ReviewDTO review) {

        reviewService.deleteReview(review.getRevNo());

        return "redirect:/review/list";

    }

    /* 소비자 리뷰 업데이트 페이지 반환*/
    @GetMapping("/update/{revNo}")
    public String reviewEdit(@PathVariable("revNo") int revNo, Model model) {

        model.addAttribute("review", reviewService.selectReviewDetail(revNo));

        return "/review/reviewUpdate";
    }
    @PostMapping("/regist")
    public String registReview(@RequestParam("file") MultipartFile file,
                               @RequestParam("revTitle") String revTitle,
                               @RequestParam("revContent") String revContent,
                               @RequestParam("revCategory") String revCategory) {



        boolean review = reviewService.registReview(revTitle,revContent,revCategory);


        if (review) {

            ReviewDTO lastReview = reviewService.searchLastReview();

            ReviewDTO reviewNo = reviewService.getRevNo(lastReview.getRevNo());


            if (reviewNo != null) {

                boolean isFileUpload = reviewService.reviewFile(file,reviewNo);

                if (isFileUpload) {
                    log.info("파일 업로드 성공");

                    return "파일 업로드 성공!";

                }else {
                    log.error("파일 업로드 실패");

                    return "실패";
                }

            } else {

                return "실패";

            }

        }

        return "실패";
    }


    /* 소비자 문의글 수정 페이지 */
    @PostMapping("/update/{revNo}")
    public String inquiryUpdate(@PathVariable("revNo") int revNo, ReviewDTO review) {

        /*현재의 문의글을 반환*/
        ReviewDTO reviewTemp = reviewService.selectReviewDetail(revNo);

        /*수정 내용 덮기*/
        reviewTemp.setRevTitle(review.getRevTitle());
        System.out.println(reviewTemp.getRevTitle());
        reviewTemp.setRevContent(review.getRevContent());

        /*업데이트 */
        reviewService.updateReview(reviewTemp);

        return "redirect:/review/list";
    }

//    /* 관리자 - 답글 등록 */
//    @PostMapping("/registComment")
//    public ResponseEntity<String> registComment(@RequestBody CommentDTO registComment) {
//        //관리자만 접근 가능하도록 설정 추가 필요
//
//        //registComment.setMemNo(member);
//        log.info("registComment : {}", registComment);
//        reviewService.registComment(registComment);
//
//        return ResponseEntity.ok("답글 등록 완료");
//    }
//
//    /* 소비자, 관리자 - 답글 보기 */
//    @GetMapping("/loadComment")
//    public ResponseEntity<List<CommentDTO>> loadComment(CommentDTO loadComment) {
//
//        log.info("loadComment RevNo : {}", loadComment.getRevNo());
//
//        List<CommentDTO> commentList = reviewService.loadComment(loadComment);
//
//        log.info("loadComment commentList : {}", commentList);
//
//        return ResponseEntity.ok(commentList);
//    }
//
//    /* 관리자- 답글 삭제*/
//    @PostMapping("/removeComment")
//    public ResponseEntity<String> removeComment(@RequestBody CommentDTO removeComment) {
//
//        log.info("removeComment no : {}", removeComment.getRevNo());
//
//        reviewService.removeComment(removeComment);
//
//        return ResponseEntity.ok("답글 삭제 완료");
//    }

    /*관리자페이지 문의목록 조회 페이징*/
    @GetMapping("/adminList")
    public String getAdminReviewList(@RequestParam(defaultValue = "1") int page,
                                     @RequestParam(required = false) String searchCondition,
                                     @RequestParam(required = false) String searchValue,
                                     Model model) {

        log.info("AdminReviewList page : {}", page);
        log.info("AdminReviewList searchCondition : {}", searchCondition);
        log.info("AdminReviewList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> AdminReviewListAndPaging = reviewService.AdminSelectReviewList(searchMap, page);
        model.addAttribute("paging", AdminReviewListAndPaging.get("paging"));
        model.addAttribute("reviewList", AdminReviewListAndPaging.get("reviewList"));

        return "review/reviewAdminList";

    }

    /* 관리자페이지 문의글 삭제 */
//    @RequestMapping("/adminDelete")
//    public String AdminReviewDelete(@RequestParam("selectedRevNos") List<String> selectedReyNos) {
//
//        reviewService.AdminDeleteReview(selectedRevNos);
//
//
//        return "redirect:/review/reviewAdminList";
//
//    }

    @GetMapping("/adminDetail")
    public String getAdminReviewDetail(@RequestParam int revNo, Model model) {

        ReviewDTO reviewDetail = reviewService.AdminSelectReviewDetail(revNo);
        log.info("reviewDetail : {}", reviewDetail);
        if (reviewDetail == null) {
            // 적절한 에러 처리를 해주거나 다른 페이지로 리다이렉트
            return "/common/error";
        }
        model.addAttribute("review", reviewDetail);

        return "review/reviewAdminDetail";
    }
}

