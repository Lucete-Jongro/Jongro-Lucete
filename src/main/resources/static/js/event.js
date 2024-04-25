

function checkPasswordMatch() {
    var password = document.getElementById("user_pwd").value;
    var confirmPassword = document.getElementById("user_pwd_check").value;

    if (password != confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }
    return true;
}
window.onload = function() {
if(document.getElementById("duplicationCheck")) {

    const $duplication = document.getElementById("duplicationCheck");
    console.log($duplication);
    $duplication.onclick = function() {
        let memberId = document.getElementById("memId").value.trim();


        fetch("/user/idDupCheck", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json;charset=UTF-8'
            },
            body: JSON.stringify({memberId: memberId})
        })
            .then(result => result.text())
            .then(result => alert(result))
            .catch((error) => error.text().then((res) => alert(res)));


        }
    }
}
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






