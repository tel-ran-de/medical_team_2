import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { questions } from './data/questions.js';
import s from './index.module.css';
import { BiArrowBack } from 'react-icons/bi'
import { postQuestion } from '../../requests/postQuestion.js';


export default function Question() {

  const [questionNum, setQuestionNum] = useState(33);
  
  const questionNumIncr = (event) => {
    if (questionNum < 35) {
      const answer = {
        id: questions[questionNum].id,
        value: event.target.value,
      };
      console.log(answer)
      postQuestion(answer);
      setQuestionNum(questionNum + 1);
    } else if (questionNum === 35) {
      const answer = {
        id: questions[questionNum].id,
        value: event.target.value,
      };
      postQuestion(answer);
      console.log(answer)
    } 
  }

  const questionNumDecr = () => {
    if (questionNum > 0) {
      setQuestionNum(questionNum - 1);
    } else {
      setQuestionNum(questionNum = 0);
    }
      
  }

  console.log(questionNum)

  return (
    <div className={s.question_block}>
      {
        questions[questionNum].section_title 
        ? <p>{questions[questionNum].section_title}</p> 
        : <></>
      }

      <div>{questions[questionNum].id}</div>
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
        :<button onClick={questionNumDecr} className={s.btn_go_back}><BiArrowBack /> Go back</button>
      }

      {
        questionNum === 35 
        ? <Link to='/tips'> <button>get help</button> </Link>
        :<></>
      }

    </div>
  )
}
