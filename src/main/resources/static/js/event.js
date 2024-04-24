window.onload = function() {

    // 문의 리스트에서 글쓰기 누르면 문의등록 페이지로 이동
    if (document.getElementById("inquiryWrite")) {
        const $inquiryWrite = document.getElementById("inquiryWrite");
        $inquiryWrite.onclick = function () {
            location.href = "/inquiry/regist";
        }
    }

    // 리뷰 리스트에서 글쓰기 누르면 리뷰등록 페이지로 이동
    if (document.getElementById("reviewWrite")) {
        const $reviewWrite = document.getElementById("reviewWrite");
        $reviewWrite.onclick = function () {
            location.href = "/review/regist";
        }
    }
}