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
          <p>Before we can help you, please complete a short simple form.</p>
          <p>There are only 36 questions here, but it won't take much of your time. Our app will find the therapy recommendations that are right especially for you and that have been tested by other users. </p>
          
        </div>

        <Link to='/select_problem'>
        <Button>Let's start</Button>
        </Link>
        
      </div>
    </div>
  )
}
