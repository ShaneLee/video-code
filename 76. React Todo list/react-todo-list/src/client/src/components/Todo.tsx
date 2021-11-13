import React from 'react'
import { Form, Formik } from 'formik'

type Todo = {
  _id: string
  todo: string 
  complete: string
}

interface Values {
  id: string
}

const key = (index: number, type: string): string => type + index.toString()

export interface Props {
  todos: Array<Todo>
  onSubmit: (values: Values) => void
}

export const Todo: React.FC<Props> = (props: Props) => {
  return (
    <ul>
      {props.todos.map((item: Todo, index: number) => 
        <Formik key={key(index, 'formik')}
                initialValues={{ id: item._id }}
                onSubmit={() => props.onSubmit({ id: item._id })}>
         {() => (
            <Form key={key(index, 'form')}>                      
              <li key={key(index, 'li')}>
                <button key={key(index, 'btn')} className='todo-item' type='submit'>{item.todo}</button>
              </li>  
            </Form>
        )}
      </Formik>
      )}
    </ul>
  ) 
}
