export const postQuestion = (body) => {
    fetch('https://#', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body),
    })
        .then(console.log(body))
}