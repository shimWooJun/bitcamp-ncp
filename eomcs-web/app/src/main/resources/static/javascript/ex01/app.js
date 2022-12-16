console.log("Hello!")

const express = require('express')
const app = express()
const port = 3000

// const delay = async () => {
//         console.log("====> 잠들다!");
//         await sleep(5000);
//         console.log("====> 개어나다!");
//  }
//  const sleep = (ms) => {
//      return new Promise(resolve=>{
//          setTimeout(resolve,ms)
//      })
//  }

app.get('/exam05_1', async(req, res) => {
  await new Promise(resolve => setTimeout(resolve,10000));
  res.send('console.log("exam05_1 ok!");')
})


app.get('/exam05_2', async(req, res) => {
    await new Promise(resolve => setTimeout(resolve,10000));
  res.send('console.log("exam05_2 ok!");')
})

app.get('/exam05_x', async(req, res) => {
  await new Promise(resolve => setTimeout(resolve,10000));
  res.send('var = rate 30000;')
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})