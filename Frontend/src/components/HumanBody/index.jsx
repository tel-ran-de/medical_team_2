import React from 'react';
import s from './index.module.css';
import human from './media/Siluet_human.png';
// import { useState } from 'react';

export default function HumanBody() {

  // const [checked, setChecked] = useState(false);

  // const handleChange = () => {
  //     setChecked(!checked)
  //   };



  return (
    <div>
      <div className={s.block_human}>
        <div className={s.head}> </div>
        <div className={s.right_hand}> </div>
        <div className={s.right_shoulder}> </div>
        <div className={s.left_hand}> </div>
        <div className={s.left_shoulder}> </div>
        <div className={s.right_leg}> </div>
        <div className={s.left_leg}> </div>
        <div className={s.upper_back}> </div>
        <div className={s.mid_back}> </div>
        <div className={s.small_of_the_back}> </div>

        <img src={human} alt='human' useMap="#image-map" />

        <map name="image-map">
          <area onClick={() => alert('head')} alt="head" title="head" href="" coords="46,0,44,40,86,42,86,2" shape="poly"/>
          <area onClick={() => alert('right hand')} alt="right hand" title="right hand" href="" coords="21,114,51,116,29,198,2,193" shape="poly"/>
          <area onClick={() => alert('right shoulder')} alt="right shoulder" title="right shoulder" href="" coords="49,50,17,67,15,92,51,95" shape="poly"/>
          <area onClick={() => alert('left hand')}  alt="left hand" title="left hand" href="" coords="84,123,113,115,137,190,110,203" shape="poly"/>
          <area onClick={() => alert('left shoulder')}  alt="left shoulder" title="left shoulder" href="" coords="86,51,84,91,118,93,116,67" shape="poly"/>
          <area onClick={() => alert('right leg')} alt="right leg" title="right leg" href="" coords="28,217,60,212,62,290,29,293" shape="poly"/>
          <area onClick={() => alert('left leg')}  alt="left leg" title="left leg" href="" coords="82,212,78,290,110,291,114,216" shape="poly"/>
          <area onClick={() => alert('upper back')}  alt="upper back" title="upper back" href="" coords="189,46,220,46,227,74,180,74" shape="poly"/>
          <area onClick={() => alert('mid back')}alt="mid back" title="mid back" href="" coords="166,82,241,82,239,119,172,118" shape="poly"/>
          <area onClick={() => alert('small of the back')} alt="small of the back" title="small of the back" href="" coords="176,127,234,127,235,163,176,163" shape="poly"/>
        </map>
      </div>   
    </div>
  )
}
