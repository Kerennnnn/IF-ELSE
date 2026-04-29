let dropdown = document.querySelectorAll(".dropdown-item");
dropdown.forEach((element) => {
    element.onclick = function () {
        let texto = this.textContent;

        let inp = document.querySelector("#aukera");
        inp.value = texto;

        let df = document.querySelector("#dropdownForm");
        df.submit();
    };
});

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