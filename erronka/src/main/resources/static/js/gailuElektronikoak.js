let dropdown = document.querySelectorAll(".dropdown-item");
dropdown.forEach(element => {
    element.onclick = function () {
        let texto = this.textContent;

        let inp = document.querySelector("#aukera");
        inp.value = texto;

        let df = document.querySelector("#dropdownForm");
        df.submit();
    };
});