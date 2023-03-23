import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { questions } from './data/questions.js';
import s from './index.module.css';
import { postQuestion } from '../../requests/postQuestion.js';
import Button from '../Button/index.jsx';
import red from '../../media/red.jfif';
import orange from '../../media/orange.jfif';
import lightyellow from '../../media/lightyellow.jfif';
import yellow from '../../media/yellow.jfif';
import green from '../../media/green.jfif';
import lightgreen from '../../media/lightgreen.jfif';


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
    <div className={s.question_container}>
      <div className={s.question_block}>
        <div className={s.questions}>
          {
            questions[questionNum].section_title 
            ? <p className={s.question}>{questions[questionNum].section_title}</p> 
            : <></>
          }
          <div className={s.num_question}>{questions[questionNum].id}</div>
          <p>{questions[questionNum].question}</p>
        </div>
        <div className={s.answers_block}>
          <div className={s.btns_answers}>
            <button value='1' onClick={questionNumIncr}><img src={lightgreen} alt="lightgreen" /></button>
            <button value='2' onClick={questionNumIncr}><img src={green} alt="green" /></button>
            <button value='3' onClick={questionNumIncr}><img src={lightyellow} alt="lightyelow" /></button>
            <button value='4' onClick={questionNumIncr}><img src={yellow} alt="yellow" /></button>
            <button value='5' onClick={questionNumIncr}><img src={orange} alt="orange" /></button>
            <button value='6' onClick={questionNumIncr}><img src={red} alt="red" /></button>
          </div>
          <div className={s.btns_back_help}>
            {
              questionNum === 0 
              ? <Link to='/select_problem'> <Button>return to problem choose</Button> </Link>
              :<button onClick={questionNumDecr} className={s.btn_back}>go back</button>
            }
            {
              questionNum === 35 
              ? <Link to='/tips'> <Button>get help</Button> </Link>
              :<></>
            }
          </div>  
        </div>        
      </div>
    </div>
  )
}
