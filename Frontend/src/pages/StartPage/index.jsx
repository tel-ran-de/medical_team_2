import React from 'react';
import { Link } from 'react-router-dom';
import s from './index.module.css'

export default function StartPage() {
  return (
    <div className={s.start_page}>
        <p className={s.welcome_start}>You are welcome! Are you in pain? Our app will find the therapy recommendations that are right especially for you and that have been tested by other users. Fill out a questionnaire with 36 short questions and get recommendations! </p>
        <Link to='/select_problem'>
        <button className={s.start_button}>Let's start</button>
        </Link>
    </div>
  )
}
