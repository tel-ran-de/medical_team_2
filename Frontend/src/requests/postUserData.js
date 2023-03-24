export const postUserData = (body, callback) => {
    fetch('http://localhost:8080/health/result', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body),
    })
        .then(resp => resp.json())
        .then(json => callback(json))
}