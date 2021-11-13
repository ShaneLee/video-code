const express = require('express')
const cors = require('cors')
const routes = require('./routes')
const app = express()
const bodyParser = require('body-parser')

const middlewares = [
    bodyParser.urlencoded({extended: false}),
    bodyParser.json(),
    cors()
]
app.use(middlewares)

app.use('/', routes)

app.use((req, res, next) => res.status(404).send("Sorry can't find that!"))

app.use((err, req, res) => {
    console.error(err.stack)
    res.status(500).send('Something broke!')
})

app.listen(8080, () => console.log(`App running at http://localhost:8080`))

