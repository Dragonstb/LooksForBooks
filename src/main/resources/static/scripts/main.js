document.addEventListener('DOMContentLoaded', afterLoadingMainPage);

function afterLoadingMainPage() {

    let authorBtn = document.querySelector('#authors-btn');
    authorBtn.addEventListener('click', requestAllAuthors);

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
        // TODO: something useful
    }
}

