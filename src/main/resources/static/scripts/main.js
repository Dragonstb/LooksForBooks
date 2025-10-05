document.addEventListener('DOMContentLoaded', afterLoadingMainPage);

function afterLoadingMainPage() {

    Globals.tableAnchor = document.querySelector('#tableAnchor');
    Author.init();

    let authorBtn = document.querySelector('#authors-btn');
    authorBtn.addEventListener('click', Author.requestAllAuthorsPaged);

    let authorApiBtn = document.querySelector('#authors-api-btn');
    authorApiBtn.addEventListener('click', requestAllAuthors);



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


}

