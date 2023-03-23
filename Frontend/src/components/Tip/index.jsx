import React from 'react'
import s from './index.module.css'
import Button from '../Button'
// import orange_smile from '../../media/orange.png'

export default function Tip() {
  return (
    <div>
      <p>I am struggling with my lower back pain. Nothing helped me.</p>
      <div className={s.therapy_block}>
        <div>Massage</div>
        <div>Drugs</div>
      </div>
      <div className={s.feedback_block}>
        <Button>Comment</Button>
        <button>I feel sorry for you</button>
      </div>
      
    </div>
  )
}
