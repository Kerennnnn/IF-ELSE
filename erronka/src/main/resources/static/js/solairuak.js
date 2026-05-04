let btnGora = document.querySelector("#btn-gora");
window.onscroll = function () {
    if (document.body.scrollTop > 150 || document.documentElement.scrollTop > 150) {
        btnGora.style.display = "block";
    } else {
        btnGora.style.display = "none";
    }
};

btnGora.onclick = function () {
    window.scrollTo({
        top: 0,
        behavior: "smooth"
    });
};