import React, { useContext } from 'react'
import Tip from '../../components/Tip'
import s from './index.module.css'
import { Context } from '../../context';

export default function TipsPage() {

  const { response } = useContext(Context);

  return (
    <div>
      <div className={s.score}>
        <p>Your health score:</p>
        <p>{'res'}</p>
      </div>
      <div className={s.bmi}>
        <p>Your BMI:</p>
        <p>#</p>
      </div>
      <p className={s.tips_title}>Meet your treatment buddies:</p>
      <Tip />
      <Tip />
    </div>
  )
}
