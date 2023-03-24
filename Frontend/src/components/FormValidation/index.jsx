import React from 'react';
import { useContext } from 'react';
import { useForm } from 'react-hook-form';
import { Context } from '../../context';
import s from './index.module.css';
import Button from '../Button';

export default function FormValidation() {

const { bmi, setBmi } = useContext(Context);

const addAnswer = (params) => {
  setBmi(params);     
}  

const submit = (data) => {
  addAnswer(data)
}

console.log(bmi);

const { register, handleSubmit, formState: { errors }} = useForm({
    mode: 'onBlur'
});

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
      <div className={s.input_container}>
        <div className={s.input_box}>
          <label>Height</label>
          <input type="number" name='height' placeholder='175' autoComplete="off" {...heightRegister}/>
        </div>
        <div className={s.input_box}>
          <label>Weight</label>
          <input type="number" name='weight' placeholder='85' autoComplete="off" {...weightRegister}/>
        </div>
        <div className={s.input_box}>
          <label>Age</label>
          <input type="number" name='age' placeholder='50' autoComplete="off" {...ageRegister}/>
        </div>
      </div>
        
        <Button>Confirm</Button>
        {/* <button>Confirm</button> */}

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
