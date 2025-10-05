APICalls = {

    getAsText: async function(url) {
        const resp = await fetch(url, {
            method: "GET",
            cache: "no-cache"
        });
        return resp.text();
    },

    postJson: async function(url, body) {
        const resp = await fetch(url, {
            method: "POST",
            cache: "no-cache",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(body)
        });
        return resp.text();
    }

};

Globals = {
    tableAnchor: undefined,

    fillTableAnchor: function(node) {
        this.tableAnchor.replaceChildren(node);
    }

};


