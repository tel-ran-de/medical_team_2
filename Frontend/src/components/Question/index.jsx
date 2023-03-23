import React, { useState, useContext } from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { questions } from './data/questions.js';
import s from './index.module.css';
import { BiArrowBack } from 'react-icons/bi'
import Button from '../Button/index.jsx';
import { Context } from '../../context';


export default function Question() {

  const navigate = useNavigate();

  const [ questionNum, setQuestionNum ] = useState(0);

  const { answers, setAnswers } = useContext(Context);

  const addAnswer = (idx, answer) => {
    const newAnswers = [...answers];
    newAnswers[idx] = answer;
    setAnswers(newAnswers);     
  }     
  
  const questionNumIncr = (event) => {
    event.preventDefault();
    if (questionNum < 35) {
      const answer = event.target.value;
      const idx = questionNum;
      addAnswer(idx, answer)
      setQuestionNum(questionNum + 1);
    } else if (questionNum === 35) {
      const answer = event.target.value;
      const idx = 35;
      addAnswer(idx, answer)
      navigate('/user_info')
    } 
  };

  const questionNumDecr = () => {
    if (questionNum > 0) {
      setQuestionNum(questionNum - 1);
    } else {
      setQuestionNum(questionNum = 0);
    }
  };

  console.log(answers);
  
  return (
    <div className={s.question_container}>

      <div className={s.question_block}>
        {
          questions[questionNum].section_title 
          ? <h2>{questions[questionNum].section_title}</h2> 
          : <></>
        }

        <div>{questions[questionNum].id}</div>
        <p>{questions[questionNum].question}</p>
        </div>
      <div className={s.answers_block}>
        <div className={s.btns_answers}>
          <button value={questions[questionNum].answer_green} onClick={questionNumIncr}></button>
          <button value={questions[questionNum].answer_light_green} onClick={questionNumIncr}></button>
          <button value={questions[questionNum].answer_light_yellow} onClick={questionNumIncr}></button>
          <button value={questions[questionNum].answer_yellow} onClick={questionNumIncr}></button>
          <button value={questions[questionNum].answer_orange} onClick={questionNumIncr}></button>
          <button value={questions[questionNum].answer_red} onClick={questionNumIncr}></button>
        </div>
        <div className={s.btns_back_help}>
        {
          questionNum === 0 
          ? <Link to='/select_problem'> <Button>return to problem choose</Button> </Link>
          :<button onClick={questionNumDecr} className={s.btn_back}><BiArrowBack />go back</button>
        }
        </div>
      </div>        
      
    </div>
  )
}
