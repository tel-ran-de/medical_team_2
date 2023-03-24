import React, { useContext } from 'react';
import FormValidation from '../../components/FormValidation';
import { Context } from '../../context';
import s from './index.module.css';

export default function UserInfoPage() {

  const { collectUserDataForRequest } = useContext(Context);

  return (
    <div>
      <FormValidation />
      <button className={s.btn} onClick={collectUserDataForRequest}>get tips</button>
    </div>
  )
}
