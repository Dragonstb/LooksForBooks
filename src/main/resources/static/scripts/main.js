document.addEventListener('DOMContentLoaded', afterLoadingMainPage);

function afterLoadingMainPage() {

    let authorBtn = document.querySelector('#authors-btn');
    authorBtn.addEventListener('click', requestAllAuthorsPaged);

    let authorApiBtn = document.querySelector('#authors-api-btn');
    authorApiBtn.addEventListener('click', requestAllAuthors);

    let tableAnchor = document.querySelector('#tableAnchor');

    function requestAllAuthors() {
        let url = "./rest/authors";

        sendFindAllAuthorsRequest(url)
                .then(
                     (resp) => {resolveResponse(resp);}
                );
    }

    async function sendFindAllAuthorsRequest(url) {
        const resp = await fetch(url, {
            method: "GET",
            cache: "no-cache"
        });
        return resp.json();
    }

    function resolveResponse(data) {
        console.dir(data);
        // TODO: something useful
    }

    function requestAllAuthorsPaged() {
        let url = "./imp/authors";

        // TODO: handling errors
        sendFindAllAuthorsRequestPaged(url)
                .then(
                     (resp) => {resolveResponsePaged(resp);}
                );
    }

    async function sendFindAllAuthorsRequestPaged(url) {
        const resp = await fetch(url, {
            method: "GET",
            cache: "no-cache"
        });
        return resp.text();
    }

    function resolveResponsePaged(data) {
        let table = new DOMParser().parseFromString(data, "text/html");
        tableAnchor.replaceChildren(table.querySelector('table'));
    }

}

