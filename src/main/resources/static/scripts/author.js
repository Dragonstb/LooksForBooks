const Author = {

    editAuthorForm: undefined,

    init: function() {
        let submitAuthorEdition = document.querySelector('#submit-author-edition-btn');
        submitAuthorEdition.addEventListener('click', (event)=>this.submitAuthorEdition());

        this.editAuthorForm = document.querySelector('#edit-author-form');
    },

    requestAllAuthorsPaged: function() {
        let url = "./imp/authors";

        // TODO: handling errors
        APICalls.getAsText(url)
                .then(
                     (data) => {
                        let table = new DOMParser().parseFromString(data, "text/html");
                        let node = table.querySelector('table');
                        let rows = node.querySelectorAll('.tablecontentrow');
                        rows.forEach((row) => {
                            row.addEventListener('click', (event) => Author.showAuthor(event.currentTarget) );
                        });
                        Globals.fillTableAnchor(node);
                     }
                );
    },

    submitAuthorEdition: function() {
        let aid = this.editAuthorForm.querySelector("input[id='id']").value;
        let firstName = this.editAuthorForm.querySelector("input[id='firstName']").value;
        let lastName = this.editAuthorForm.querySelector("input[id='lastName']").value;

        let body = {
            firstName: firstName,
            lastName: lastName,
            aid: aid
        };

        let url = "/rest/authors/"+aid;

        APICalls.postJson(url, body)
                .then(
                    resp => {
                        // TODO: proper response handling
                        console.log("----------- response -----------");
                        console.dir(resp);
                    }
                );
    },

    showAuthor: function(src) {
        let arr = ['firstName','lastName','id'];
        arr.forEach( (elem) => {
            let cell = src.querySelector("td[x-type='"+elem+"']");
            let input = this.editAuthorForm.querySelector("input[id='"+elem+"']");
            input.value = cell.innerHTML;
        });
    }

};