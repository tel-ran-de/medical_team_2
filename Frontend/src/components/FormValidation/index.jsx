import React from 'react';
import { useState } from 'react';
import { useForm } from 'react-hook-form';

export default function FormValidation() {

const [ userParams, setUserParams ] = useState([]);

// const createNewUser = user => {
//     setUser(prev => user)
//   };

const { register, handleSubmit, formState: { errors }} = useForm({
    mode: 'onBlur'
});

const submit = data => {
    console.log(data)
}

const heightRegex = /^\d{2,3}$/;
const weightRegex = /^\d{1,3}$/;
const ageRegex = /^\d{1,3}$/;

const heightRegister = register('height', { 
    required: 'Required field',
    pattern: {
        value: heightRegex,
        message: 'Not valid height format'
    } 
});

const weightRegister = register('weight', { 
    required: 'Required field',
    pattern: {
        value: weightRegex,
        message: 'Not valid weight format'
    } 
});

const ageRegister = register('age', { 
    required: 'Required field',
    pattern: {
        value: ageRegex,
        message: 'Not valid age format'
    } 
});

  return (
    <form onSubmit={handleSubmit(submit)}>
        <input type="number" name='height' placeholder='175' {...heightRegister}/>
        <input type="number" name='weight' placeholder='85' {...weightRegister}/>
        <input type="number" name='age' placeholder='50'  {...ageRegister}/>
        <button>Add user</button>

        <div>
          { errors?.height && <p> {errors?.height?.message } </p>}
        </div>
        <div>
          { errors?.weight && <p> {errors?.weight?.message } </p>}
        </div>
        <div>
          { errors?.age && <p> {errors?.age?.message } </p>}
        </div>
    </form>
  )
}
