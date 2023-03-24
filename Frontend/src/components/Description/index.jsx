import React from 'react';
import s from './index.module.css';

export default function Description() {
  return (
    <div>
        <div className={s.input_box}>
          <label>Сomment</label>
          <textarea type="text" name="users_commit" maxLength="255"/>
        </div>
    </div>
  )
}
