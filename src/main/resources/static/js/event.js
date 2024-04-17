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