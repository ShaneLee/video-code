import React, { Component, ReactNode } from 'react'
import './App.css'
import axios from 'axios'

import { Todo } from './components/Todo'

interface Values {
  id: string
}

class App extends Component {
  completeTodo = (values: Values): Promise<void> =>
    axios.post('http://localhost:8080/complete', values)
         .then((res: any) => this.componentDidMount()) 


  state = {
    title: 'Todos to dominate the world',
    todos: []
  }

  componentDidMount(): void {
    axios.get('http://localhost:8080/todos')
      .then((res: any) => {
        const todos = res.data
        this.setState({ todos })
      })
  }

  render(): ReactNode {
    return (
      <div className='App'>
        <h1>{this.state.title}</h1>
        <Todo todos={ this.state.todos } onSubmit={ this.completeTodo } />
      </div>
    )
  }
}

export default App
