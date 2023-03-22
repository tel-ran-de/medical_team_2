import React from 'react';
import s from './index.module.css';
import human from './media/Siluet_human.png';
import { useState } from 'react';

export default function HumanBody() {

  // const [checked, setChecked] = useState(false);

  // const handleChange = () => {
  //     setChecked(!checked)
  //   };


 
  return (
    <div>
      <div className={s.block_human}>
        <div className={[s.head, s.dot].join(' ')}> </div>
        <div className={[s.right_hand, s.dot].join(' ')}> </div>
        <div className={[s.right_shoulder, s.dot].join(' ')}> </div>
        <div className={[s.left_hand, s.dot].join(' ')}> </div>
        <div className={[s.left_shoulder, s.dot].join(' ')}> </div>
        <div className={[s.right_leg, s.dot].join(' ')}> </div>
        <div className={[s.left_leg, s.dot].join(' ')}> </div>
        <div className={[s.upper_back, s.dot].join(' ')}> </div>
        <div className={[s.mid_back, s.dot].join(' ')}> </div>
        <div className={[s.small_of_the_back, s.dot].join(' ')}> </div>

        <img src={human} alt='human' useMap="#image-map" />

        <map name="image-map">
          <area onClick={() => alert('head')} alt="head" title="head" href="" coords="46,0,44,40,86,42,86,2,66,1" shape="poly"/>
          <area onClick={() => alert('right hand')} alt="right hand" title="right_hand" href="" coords="21,114,51,116,29,198,2,193" shape="poly"/>
          <area onClick={() => alert('right shoulder')} alt="right shoulder" title="right_shoulder" href="" coords="49,50,17,67,15,92,51,95" shape="poly"/>
          <area onClick={() => alert('left hand')}  alt="left hand" title="left_hand" href="" coords="84,123,113,115,137,190,110,203" shape="poly"/>
          <area onClick={() => alert('left shoulder')}  alt="left shoulder" title="left_shoulder" href="" coords="86,51,84,91,118,93,116,67" shape="poly"/>
          <area onClick={() => alert('right leg')} alt="right leg" title="right_leg" href="" coords="28,217,60,212,62,290,29,293" shape="poly"/>
          <area onClick={() => alert('left leg')}  alt="left leg" title="left_leg" href="" coords="82,212,78,290,110,291,114,216" shape="poly"/>
          <area onClick={() => alert('upper back')}  alt="upper back" title="upper_back" href="" coords="189,37,220,37,227,65,180,65" shape="poly"/>
          <area onClick={() => alert('mid back')}alt="mid back" title="mid_back" href="" coords="166,73,241,73,239,110,172,109" shape="poly"/>
          <area onClick={() => alert('small of the back')} alt="small_of_the_back" title="small of the back" href="" coords="184,121,226,121,234,159,179,160" shape="poly"/>
        </map>
      </div>   
    </div>
  )
}


