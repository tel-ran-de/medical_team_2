import React from 'react';
import { Link } from 'react-router-dom';
import HumanBody from '../../components/HumanBody';
import s from './index.module.css';

export default function SelectProblemPage() {
  return (
    <div className={s.human_block}>
      <HumanBody/>
      <Link to='/question'>
        <button>Next</button> 
      </Link>
    </div>
  )
}
