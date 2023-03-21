import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { questions } from './data/questions.js';
import s from './index.module.css';

export default function Question() {

  let [questionNum, setQuestionNum] = useState(32);
  
  let questionNumIncr = (event) => {
    if (questionNum < 35) {
      console.log(event.target.value)
      const answer = {
        id: questionNum,
        value: event.target.value,
      };
      console.log(answer)
      setQuestionNum(questionNum += 1);
    } else {
      setQuestionNum(questionNum = 35);
    }
    
  }

  let questionNumDecr = () => {
    if (questionNum > 0) {
      setQuestionNum(questionNum -= 1);
    } else {
      setQuestionNum(questionNum = 0);
    }
      
  }

  console.log(questionNum)

  return (
    <div>
      {
        questions[questionNum].section_title 
        ? <p>{questions[questionNum].section_title}</p> 
        : <></>
      }

      <p>{questions[questionNum].question}</p>
      <div className={s.buttons_container}>
        <button value='1' onClick={questionNumIncr}>1</button>
        <button value='2' onClick={questionNumIncr}>2</button>
        <button value='3' onClick={questionNumIncr}>3</button>
        <button value='4' onClick={questionNumIncr}>4</button>
        <button value='5' onClick={questionNumIncr}>5</button>
      </div>
            
      {
        questionNum === 0 
        ? <Link to='/select_problem'> <button>return to problem choose</button> </Link>
        :<button onClick={questionNumDecr}>go back</button>
      }

      {
        questionNum === 35 
        ? <Link to='/tips'> <button>get help</button> </Link>
        :<></>
      }

    </div>
  )
}
