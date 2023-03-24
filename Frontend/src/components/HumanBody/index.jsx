import React, { useContext } from 'react';
import s from './index.module.css';
import human from './media/Siluet_human.png';
import { useState } from 'react';
import { Context } from '../../context';
import { Link } from 'react-router-dom';

export default function HumanBody() {

  const {bodyArea, setBodyArea, toggleBodyArea, checked} = useContext(Context);

  const getBodyArea = (event) => {
    event.preventDefault();
    const answer = event.target.title;
    toggleBodyArea(answer);
  };

  console.log(bodyArea)

  const getDotClasses = (name, dotClass) => {
    const res = [s.dot, dotClass];
    if (bodyArea.includes(name)) {
      res.push(s.dot_active);
    }
    return res;
  }
 
  // className={getDotClasses('head', s.head).join(' ') - 'head' - title from area
  
  return (
    <div>
      <div className={s.block_human}>
        <div className={getDotClasses('head', s.head).join(' ')}> </div> 
        <div className={getDotClasses('right_hand', s.right_hand).join(' ')}> </div>
        <div className={getDotClasses('right_shoulder', s.right_shoulder).join(' ')}> </div>
        <div className={getDotClasses('left_hand', s.left_hand).join(' ')}> </div>
        <div className={getDotClasses('left_shoulder', s.left_shoulder).join(' ')}> </div>
        <div className={getDotClasses('right_leg', s.right_leg).join(' ')}> </div>
        <div className={getDotClasses('left_leg', s.left_leg).join(' ')}> </div>
        <div className={getDotClasses('upper_back', s.upper_back).join(' ')}> </div>
        <div className={getDotClasses('mid_back', s.mid_back).join(' ')}> </div>
        <div className={getDotClasses('small_of_the_back', s.small_of_the_back).join(' ')}> </div>

        <img src={human} alt='human' useMap="#image-map" />

        <map name="image-map">
          <area onClick={getBodyArea} alt="head" title="head" href="" coords="46,0,44,40,86,42,86,2,66,1" shape="poly"/>  
          <area onClick={getBodyArea} alt="right hand" title="right_hand" href="" coords="21,114,51,116,29,198,2,193" shape="poly"/>
          <area onClick={getBodyArea} alt="right shoulder" title="right_shoulder" href="" coords="49,50,17,67,15,92,51,95" shape="poly"/>
          <area onClick={getBodyArea} alt="left hand" title="left_hand" href="" coords="84,123,113,115,137,190,110,203" shape="poly"/>
          <area onClick={getBodyArea} alt="left shoulder" title="left_shoulder" href="" coords="86,51,84,91,118,93,116,67" shape="poly"/>
          <area onClick={getBodyArea} alt="right leg" title="right_leg" href="" coords="28,217,60,212,62,290,29,293" shape="poly"/>
          <area onClick={getBodyArea} alt="left leg" title="left_leg" href="" coords="82,212,78,290,110,291,114,216" shape="poly"/>
          <area onClick={getBodyArea} alt="upper back" title="upper_back" href="" coords="189,37,220,37,227,65,180,65" shape="poly"/>
          <area onClick={getBodyArea} alt="mid back" title="mid_back" href="" coords="166,73,241,73,239,110,172,109" shape="poly"/>
          <area onClick={getBodyArea} alt="small of the back" title="small_of_the_back" href="" coords="184,121,226,121,234,159,179,160" shape="poly"/>
        </map>
      </div>   
    </div>
  )
}


