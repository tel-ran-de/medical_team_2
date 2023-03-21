import React from 'react';
import { Link } from 'react-router-dom';
import s from './index.module.css'

export default function StartPage() {
  return (
    <div className={s.start_page}>
        <p className={s.welcome_start}>You are welcome!</p>
        <Link to='/select_problem'>
        <button className={s.start_button}>Let's start</button>
        </Link>
    </div>
  )
}
