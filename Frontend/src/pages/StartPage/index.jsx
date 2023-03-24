import React from 'react';
import { Link } from 'react-router-dom';
import s from './index.module.css';
import Button from '../../components/Button';

export default function StartPage() {
  return (
  <div>
    <div className={s.start_page}>
        <h2>Wellcome!</h2>
        <div>
          <p> Are you in pain?</p>
          <p> Before we can help you, please fill out a simple, anonymous form. </p>
          <p> Answer the 36 short questions and the app will recommend the right therapy for you that has been tested by other users. </p>
        </div>

        <Link to='/select_problem'>
        <Button>Let's start</Button>
        </Link>
        
      </div>
    </div>
  )
}
