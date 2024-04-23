window.onload = function() {

    // 문의 리스트에서 글쓰기 누르면 문의등록 페이지로 이동
    if (document.getElementById("inquiryWrite")) {
        const $inquiryWrite = document.getElementById("inquiryWrite");
        $inquiryWrite.onclick = function () {
            location.href = "/inquiry/regist";
        }
    }
}