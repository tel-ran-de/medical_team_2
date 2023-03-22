import React from 'react'
import Tip from '../../components/Tip'
import s from './index.module.css'

export default function TipsPage() {
  return (
    <div>
      <div className={s.score}>
        <p>Your health score:</p>
        <p>#</p>
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
