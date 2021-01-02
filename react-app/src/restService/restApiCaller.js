export function post(input, callback) {
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify(input),
        headers: {
            'Content-Type': 'application/json; charset=utf-8'
        }
    };

   return  fetch('http://51.222.106.8:8080/prettify', requestOptions)
       .then(res => res.json())
       .then(data => callback(data))

}
