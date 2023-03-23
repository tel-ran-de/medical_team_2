export const postUserData = (body, callback) => {
    fetch('https://api.escuelajs.co/api/v1/products/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body),
    })
        .then(resp => resp.json())
        .then(json => callback(json))
}