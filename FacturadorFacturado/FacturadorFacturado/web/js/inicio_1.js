const deleteTags = (node) => {
    /*
     *  Se eliminan todas las etiquetas que contengan z-label
     *    en el nodo padre pasado por argumento
     */

    const container = document.querySelector(node);

    const list = Array.from(container.querySelectorAll(".z-label"));

    list.forEach((e) => e.classList.remove("z-label"));
};

const stopLoading = () => {
    const loading = document.querySelector(".loading_inicio");
    loading.style.display = "none";
};

const showPassword = () => {
    const password = document.querySelector(".input_password_reg");
    const icon = document.querySelector(".icon_eye_reg");

    const toggleShowPass = () => {
        if (password.type === "password") {
            password.type = "text";
            icon.classList.remove("fa-eye");
            icon.classList.add("fa-eye-slash");
        } else {
            password.type = "password";
            icon.classList.remove("fa-eye-slash");
            icon.classList.add("fa-eye");
        }
    };

    icon.addEventListener("click", toggleShowPass);
};



const showLogin = () => {
    const wrapper_modal = document.querySelector(
            ".container_wrapper_signin_root"
            );
    const modal = document.querySelector(".wrapper_signin");
    const login_btn = document.querySelector(".login_btn");

    document.addEventListener("click", (e) => {
        if (login_btn.contains(e.target)) {
            wrapper_modal.style.display = "flex";
        } else if (!modal.contains(e.target)) {
            wrapper_modal.style.display = "none";
        }
    });
};

(() => {
    zk.afterMount(function () {
        setTimeout(() => {
            deleteTags(".all_wrapper"); //inicio.zul
            stopLoading();
          
            showLogin();
            showPassword();
        }, 2000);
    });
})();
