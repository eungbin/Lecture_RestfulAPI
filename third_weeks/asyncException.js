const fs = require('fs');

fs.readFile('none.txt', (error, file) => {
    if(error) {
        console.log('파일을 읽지 못했습니다.');
        console.log(error);
    } else {
        console.log(file);
        console.log(file.toString());
    }
});