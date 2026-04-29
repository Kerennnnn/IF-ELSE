let btnEzabatu = document.querySelector("#btn-ezabatu");
btnEzabatu.onclick = function () {
    let form = document.querySelector("form");
    form.reset();

    let inputs = form.querySelectorAll("input:not([type=hidden])");
    inputs.forEach((i) => {
        i.value = "";
    });

    let selects = form.querySelectorAll("select");
    selects.forEach((s) => {
        s.selectedIndex = 0;
    });
};