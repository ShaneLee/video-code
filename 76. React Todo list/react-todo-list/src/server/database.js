const MongoClient = require('mongodb').MongoClient
const ObjectID = require('mongodb').ObjectID
const url = 'mongodb://localhost:27017/'

initTestData()

function initTestData() {
  deleteAll()
  MongoClient.connect(url, (err, db) => {
      if (err) throw err
      const todos = [
            { todo: 'Buy milk', complete: '0'},
            { todo: 'Blackmail Mr. Big', complete: '0'},
            { todo: 'Buy cat', complete: '0'}
          ]
      db.db('todo_database').collection('todos').insertMany(todos, (err, res) => {
        if (err) throw err
        db.close()
      })

  })
}

function deleteAll() {
  MongoClient.connect(url, (err, db) => {
      if (err) throw err
      db.db('todo_database').collection('todos').deleteMany({}, (err, obj) => {
            if (err) throw err
            db.close()
      })
  })
}

const completeTodo = (id, res) => {
  MongoClient.connect(url, (err, db) => {
    if (err) throw err
    db.db('todo_database').collection('todos')
                          .updateOne({ _id: ObjectID(id)},
                                     { $set: { complete: '1' }}, 
                                      (err, result) => {
        if (err) throw err
        db.close()
        res.send('Success')
      })
  })
}

const findAllTodos = (res) => {
   MongoClient.connect(url, (err, db) => {
      if (err) throw err
      db.db('todo_database')
               .collection('todos')
               .find({ complete: '0' })
               .toArray()
               .then(result => res.json(result))
  })
}

const db = module.exports = {}

db.getTodos = (res) => findAllTodos(res)
db.completeTodo = (res, id) => completeTodo(id, res)
