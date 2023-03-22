import React from 'react';
import { Link } from 'react-router-dom';
import s from './index.module.css'
import Button from '../../components/Button';

export default function StartPage() {
  return (
    <div className={s.start_page}>
        <h2>You are welcome!</h2>
        <div>
          <p> Are you in pain?</p>
          <p>Before we can help you, please complete form F-36.</p>
          <p>There are only 36 questions here, but it won't take much of your time.</p>
          {/* <p> Our app will find the therapy recommendations that are right especially for you and that have been tested by other users. Fill out a questionnaire with 36 short questions and get recommendations!</p> */}
        </div>
        
        <p className={s.welcome_start}>You are welcome! Are you in pain? Our app will find the therapy recommendations that are right especially for you and that have been tested by other users. Fill out a questionnaire with 36 short questions and get recommendations! </p>
        <Link to='/select_problem'>
        {/* <button className={s.start_button}>Let's start</button> */}
        <Button>Let's start</Button>
        </Link>
    </div>
  )
}
