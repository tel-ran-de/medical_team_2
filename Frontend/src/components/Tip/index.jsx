import React from 'react'
import s from './index.module.css'
import Button from '../Button'
import green from '../../media/lightgreen.jfif'
import orange from '../../media/orange.jfif'

export default function Tip() {
  return (
    <div className={s.tip_block}>
      <p>I am struggling with my lower back pain. Nothing helped me.</p>
      <div className={s.therapy_block}>
        <div className={s.therapy_img}>
          <div className={s.massage}>Massage</div>
          <img src={green} alt="green" />
        </div>
        <div className={s.therapy_img}>
          <div className={s.drugs}>Drugs</div>
          <img src={orange} alt="green" />
        </div>
      </div>
      <div className={s.feedback_block}>
        <Button>Comment</Button>
        <button>I feel sorry for you</button>
      </div>    
    </div>
  )
}