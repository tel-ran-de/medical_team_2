import React from 'react';
import { Link } from 'react-router-dom';
import HumanBody from '../../components/HumanBody';
import s from './index.module.css';
import Button from '../../components/Button';

export default function SelectProblemPage() {
  return (
    <div className={s.human_block}>
      <p>Please mark the place where you feel pain and move on to the next.</p>
      <HumanBody/>
      <Link to='/question'>
        <Button>Next</Button> 
      </Link>
    </div>
  )
}
