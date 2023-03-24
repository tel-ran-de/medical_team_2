import React, { useContext } from 'react';
import s from './index.module.css';
import { Context } from '../../context';

export default function Description() {

  const { description, setDescription } = useContext(Context);

  const addDescription = (event) => {
    // event.preventDefault();
    // let target = event.target;
    // while (target.tagName.toLowerCase() !== "button") {
    // target = target.parentNode;
    // }

    // const answer = {
    //   therapy: therapy_name,
    //   reaction: target.value
    // };
    // console.log(answer)
    // setTherapy([...therapy, answer])
  };

  console.log(description)

  return (
    <div>
        <div className={s.input_box}>
          <label>Сomment</label>
          <textarea type="text" name="users_commit" maxLength="255" />
        </div>
    </div>
  )
}
