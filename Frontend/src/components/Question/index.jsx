import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { questions } from './data/questions.js';
import s from './index.module.css';
import { BiArrowBack } from 'react-icons/bi'
import { postQuestion } from '../../requests/postQuestion.js';
import Button from '../Button/index.jsx';


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
        id: 36,
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
        ? <h2>{questions[questionNum].section_title}</h2> 
        : <></>
      }

      <div>{questions[questionNum].id}</div>
      <p>{questions[questionNum].question}</p>
      <div className={s.btns_answers}>
        <button value='1' onClick={questionNumIncr}>1</button>
        <button value='2' onClick={questionNumIncr}>2</button>
        <button value='3' onClick={questionNumIncr}>3</button>
        <button value='4' onClick={questionNumIncr}>4</button>
        <button value='5' onClick={questionNumIncr}>5</button>
      </div>
      <div className={s.btns_back_help}>
      {
        questionNum === 0 
        ? <Link to='/select_problem'> <button>return to problem choose</button> </Link>
        :<button onClick={questionNumDecr} className={s.btn_back}><BiArrowBack /> back</button>
      }

      {
        questionNum === 35 
        ? <Link to='/tips'> <Button>get help</Button> </Link>
        :<></>
      }

      </div>
            
      
    </div>
  )
}
