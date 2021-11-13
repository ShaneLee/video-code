const express = require('express')
const router = express.Router()

const db = require('./database')

router.get('/todos', (req, res) => db.getTodos(res))
router.post('/complete', (req, res) => db.completeTodo(res, req.body.id))

module.exports = router
