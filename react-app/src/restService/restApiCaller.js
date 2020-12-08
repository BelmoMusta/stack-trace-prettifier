export function post(input, callback) {
    const requestOptions = {
        method: 'POST',
        body: input
    };

   return  fetch('http://localhost:8080/prettify', requestOptions)
       .then(res => res.json())
       .then(data => callback(data))

}
