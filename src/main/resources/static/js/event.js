window.onload = function() {


    if(document.getElementById("inquiryWrite")) {
        const $inquiryWrite = document.getElementById("inquiryWrite");
        $inquiryWrite.onclick = function() {
            location.href = "/inquiry/regist";
        }
    }


}