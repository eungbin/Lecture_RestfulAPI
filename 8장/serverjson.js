// 모듈을 추출합니다.
var express = require('express');

// 변수를 선언합니다.
var items = [{
    name: 'Milk',
    price: '2000'
}, {
    name: 'Tea',
    price: '5000'
}, {
    name: 'Coffee',
    price: '5000'
}];

// 웹 서버를 생성합니다.
var app = express();
app.use(express.static('public'));

// 라우트 생성합니다. 
app.all('/data.html', function (request, response) {
    var output = '';
    output += '<!DOCTYPE html>';
    output += '<html>';
    output += '<head>';
    output += '    <title>Data HTML</title>';
    output += '</head>';
    output += '<body>';
    items.forEach(function (item) {
        output += '<div>';
        output += '    <h1>' + item.name + '</h1>';
        output += '    <h2>' + item.price + '</h2>';
        output += '</div>';
    });
    output += '</body>';
    output += '</html>';
    response.send(output);
});

app.all('/data.json', function (request, response) {
    response.send(items);
});

// 웹 서버를 실행합니다.
app.listen(52273, function () {
    console.log('Server Running at http://127.0.0.1:52273');
});