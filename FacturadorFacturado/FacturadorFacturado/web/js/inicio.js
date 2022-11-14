const deleteTags = (node) => {
    /*
     *  Se eliminan todas las etiquetas que contengan z-label
     *    en el nodo padre pasado por argumento
     */

    const container = document.querySelector(node);

    const list = Array.from(container.querySelectorAll(".z-label"));
    console.log('hola', list)
    list.forEach((e) => e.classList.remove("z-label"));
};

const stopLoading = () => {
    const loading = document.querySelector(".loading_inicio");
    loading.style.display = "none";
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
        }, 2000);
    });
})();
