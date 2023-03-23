import React, { useContext } from 'react';
import s from './index.module.css';
import human from './media/Siluet_human.png';
import { useState } from 'react';
import { Context } from '../../context';
import { Link } from 'react-router-dom';

export default function HumanBody() {

  // const [ bodyArea, setBodyArea ] = useState([]);
  // console.log(bodyArea)

  // const {collectUserData, userData} = useContext(Context);

  // const [checked, setChecked] = useState(false);
  // const handleChange = () => {
  //     setChecked(!checked)
  //   };

  

  // const getBodyArea = (event) => {
  //   event.preventDefault();
  //   const answer = {
  //     id_body: event.target.title,
  //   };
  //   console.log(answer)
  //   collectUserData(answer)
  // }

  // const getBodyArea = (event) => {
  //   event.preventDefault();
  //   const answer = event.target.title
  //   console.log(answer)
  //   setBodyArea([...bodyArea, answer])
  // }

  // console.log(bodyArea);
  // console.log(userData);

 
  const {bodyArea, setBodyArea, toggleBodyArea, checked} = useContext(Context);

  let dot_active = {};

  const getBodyArea = (event) => {
    event.preventDefault();
    const answer = event.target.title;
    toggleBodyArea(answer);

    // if (bodyArea.includes(answer)) {
    //   dot_active = {
    //     backgroundColor: '#be4ed4',
    //   }
    // } else {
    //   dot_active = {
    //     backgroundColor: '',
    //   }
    // }


  };



  // const checkArea = (event) => {
    // event.preventDefault();
    // console.log(event.target)
    // const answer = event.target.name;
    // if (bodyArea.includes(answer)) {
    //   dot_active = {
    //     backgroundColor: '#be4ed4',
    //   }
    // } else {
    //   dot_active = {
    //     backgroundColor: '',
    //   }
    // }
  //   console.log(answer)
  // }

  

  dot_active = {
    backgroundColor: checked ? '#be4ed4' : ''
  }
  console.log(dot_active)

//   const style_discont = {
//     fontSize: page_name === 'category_page' ? '20px' : '28px',
//     paddingBottom: page_name === 'category_page' ? '0' : '10px',
// }

  // const dot_active = {
  //   backgroundColor: '#be4ed4',
  // }

  console.log(bodyArea)
 
  return (
    <div>
      <div className={s.block_human}>
        <button name='head' className={[s.head, s.dot].join(' ')} style={dot_active}> </button>
        <button name='right hand' className={[s.right_hand, s.dot].join(' ')} style={dot_active}> </button>
        <div className={[s.right_shoulder, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.left_hand, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.left_shoulder, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.right_leg, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.left_leg, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.upper_back, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.mid_back, s.dot].join(' ')} style={dot_active}> </div>
        <div className={[s.small_of_the_back, s.dot].join(' ')} style={dot_active}> </div>

        <img src={human} alt='human' useMap="#image-map" />

        <map name="image-map">
          <Link to='/question'>
           <area onClick={getBodyArea} alt="head" title="head" href="" coords="46,0,44,40,86,42,86,2,66,1" shape="poly"/>  
          </Link>
          
          <area onClick={getBodyArea} alt="right hand" title="right_hand" href="" coords="21,114,51,116,29,198,2,193" shape="poly"/>
          <area onClick={getBodyArea} alt="right shoulder" title="right_shoulder" href="" coords="49,50,17,67,15,92,51,95" shape="poly"/>
          <area onClick={getBodyArea} alt="left hand" title="left_hand" href="" coords="84,123,113,115,137,190,110,203" shape="poly"/>
          <area onClick={getBodyArea} alt="left shoulder" title="left_shoulder" href="" coords="86,51,84,91,118,93,116,67" shape="poly"/>
          <area onClick={getBodyArea} alt="right leg" title="right_leg" href="" coords="28,217,60,212,62,290,29,293" shape="poly"/>
          <area onClick={getBodyArea} alt="left leg" title="left_leg" href="" coords="82,212,78,290,110,291,114,216" shape="poly"/>
          <area onClick={getBodyArea} alt="upper back" title="upper_back" href="" coords="189,37,220,37,227,65,180,65" shape="poly"/>
          <area onClick={getBodyArea} alt="mid back" title="mid_back" href="" coords="166,73,241,73,239,110,172,109" shape="poly"/>
          <area onClick={getBodyArea} alt="small_of_the_back" title="small of the back" href="" coords="184,121,226,121,234,159,179,160" shape="poly"/>
        </map>
      </div>   
    </div>
  )
}


