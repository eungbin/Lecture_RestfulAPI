const express = require('express');

const app = express();

app.get('*', (req, res) => {
    res.redirect('http://hanbit.co.kr');
});

app.listen(52273, () =>{
    console.log('server running');
})