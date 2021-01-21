export function post(input, callback) {
    const requestOptions = {
        method: 'POST',
        body: JSON.stringify(input),
        headers: {
            'Content-Type': 'application/json; charset=utf-8',
            'Access-Control-Allow-Origin' :'*',
            'Access-Control-Allow-Headers': 'X-Requested-With'
        }
    };

   return  fetch('http://10.42.5.139:8060/prettify', requestOptions)
       .then(res => res.json())
       .then(data => callback(data))

}
