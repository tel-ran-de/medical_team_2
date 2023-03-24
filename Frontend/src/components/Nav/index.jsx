import React from 'react';
import logo from './data/logo.svg';
import { Link } from 'react-router-dom';
import s from './index.module.css';

export default function Nav() {
  return (
    <nav className='content_wrapper'>
      <Link to='/'>
        <img src={logo} alt="Logo" className={s.logo}/>
      </Link>
    </nav>
  )
}
