const input = document.getElementById("imgUrl");
    const preview = document.getElementById("preview");

    input.addEventListener("input", () => {
        const url = input.value.trim();
        if (url) {
            preview.src = url;
            preview.style.display = "block";
        } else {
            preview.style.display = "none";
        }
    });