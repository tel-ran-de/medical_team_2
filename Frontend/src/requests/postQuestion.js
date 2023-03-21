export const postQuestion = (body) => {
    fetch('https://http://localhost:8080/quiz', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body),
    })
        .then(console.log(body))
}