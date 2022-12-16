// express 라이브러리 로딩하기
const express = require('express');
//HTTP 요청을 다루는 라이브러리 로딩하기
const request = require('request');
//POST 요청으로 보낸 payload를 분석하는 라이브러리 등록하기
//const bodyParser = require('body-parser');

const port = 3000; // 웹서버 포트 번호


//express() 를 호출하여 웹서버를 준비한다.
const app = express();


//POST 요청으로 보낸 patload 데이터를 분석할 객체를 지정학
// => Content.type: application/x-www-form-urlencoded 형식으로 된 payload 처리
//  예) name=hong&age=20
app.use(express.urlencoded({extended: true}));

// 클라이언트 요청에 대해 호출될 메서드를 등록
app.get(                           // GET  요청이 들어 왔을 때 호출될 메서드 지정
  '/exam01-1',                     // 요청 URL
  (req, res) => {  
        res.set('Access-Control-Allow-Origin', '*');            // 요청 핸들러: 요청이 들어왔을 때 호출되는 메서드
        res.set('Content-Type', 'text/plain;charset=UTF-8');
        res.send('Hello(조준호)');         
    } 
);

app.get('/exam02-1', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');            // 요청 핸들러: 요청이 들어왔을 때 호출되는 메서드
    res.set('Content-Type', 'text/plain;charset=UTF-8');
        
    var payload = `이름: ${req.query.name}\n`;
    payload += `나이: ${req.query.age} \n`;
    
    res.send(payload);
    });

app.post('/exam02-2', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');            // 요청 핸들러: 요청이 들어왔을 때 호출되는 메서드
    res.set('Content-Type', 'text/plain;charset=UTF-8');
            
    var payload = `이름: ${req.body.name}\n`;
    payload += `나이: ${req.body.age}\n`;
        
    res.send(payload);
    });

app.get('/exam03-1', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');     
    res.set('Content-Type', 'text/plain;charset=UTF-8');

    setTimeout(() =>{
        res.send('Hello');
     },15000);        
});

app.get('/exam03-4', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');     
    res.set('Content-Type', 'text/plain;charset=UTF-8');

    let a = parseInt(req.query.a);
    let b = parseInt(req.query.b);
    

    res.send(`${a + b}`);        
});

app.get('/header', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');     
    res.set('Content-Type', 'text/html;charset=UTF-8');

    res.send("<h1>비트캠프 네이버 클라우드 AIaas 개발자 양성과정</h1>");        
});

app.get('/footer', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');     
    res.set('Content-Type', 'text/html;charset=UTF-8');

    res.send(`<address>비트캠프 서초캠프@2022</address>`);        
});


app.get('/exam04-3', (req, res) => {  
    res.set('Access-Control-Allow-Origin', '*');     
    res.set('Content-Type', 'text/html;charset=UTF-8');

    let arr = [
        {no:1, title:'제목1', writer:'홍길동', viewCnt:19},
        {no:2, title:'제목2', writer:'임꺽정', viewCnt:312},
        {no:3, title:'제목3', writer:'유관순', viewCnt:31},
        {no:4, title:'제목4', writer:'안중근', viewCnt:100},
        {no:5, title:'제목5', writer:'윤봉길', viewCnt:200}
    ];   
    
    res.send(JSON.stringify(arr));
});


// 클라이언트 요청을 다른 서버에게 보낸다.
app.get('/proxy', (req, res) => {  

    res.set('Access-Control-Allow-Origin', '*');            
    res.set('Content-Type', 'text/plain;charset=UTF-8');

    const options = {
        uri: req.query.url
    };
    
    request.get(options, (error, response, body) => {
        res.send(body);
    });      
});

app.get('/proxy2', (req, res) => {  

    res.set('Access-Control-Allow-Origin', '*');            
    res.set('Content-Type', 'application/json/plain;charset=UTF-8');

    let 

    const options = {
        uri: req.query.url
    };
    
    request.get({url:"https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=LLqe8Wy4B%2F15ibQfhKMAawTCtvvkgI7Ld0TfzoJCtPYncvf9iEh9NE39B8yeZ%2Bn5haHfOEStYIZbU7b6Pz7OiQ%3D%3D&pageNo=1&numOfRows=1000&dataType=JSON&base_date=20221216&base_time=0600&nx=55&ny=127"}
    ,(error, response, body) => {
        res.send(body);
    });      
});
    
    
// 웹서버 실행하기
app.listen(
    3000,                           // 포트 번호 지정
    () => {                         // 서버가 시작되었을 때 호출될 함수 = 리스너 = 이벤트 핸들러
        console.log(`${port}번 포드에서 서버 시작했음!`);
    }  
);

