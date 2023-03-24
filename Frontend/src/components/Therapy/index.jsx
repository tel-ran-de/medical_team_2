import React from 'react';
import s from './index.module.css';
import red from '../../media/red.jfif';
import yellow from '../../media/yellow.jfif';
import green from '../../media/green.jfif';

export default function Therapy({ therapy_name }) {

const addTherapy = (event) => {

};


  return (
    <div>
        <div className={s.therapy_block}>
          <div className={s.therapy}>{ therapy_name }</div>
          <div className={s.smile_block}>
            <button value='3' onClick={addTherapy}><img src={green} alt="green" /></button>
            <button value='2' onClick={addTherapy}><img src={yellow} alt="yellow" /></button>
            <button value='1' onClick={addTherapy}><img src={red} alt="red" /></button>
          </div>
        </div>
    </div>
  )
}
