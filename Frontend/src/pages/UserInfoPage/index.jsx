import React, { useContext } from 'react';
import FormValidation from '../../components/FormValidation';
import Therapy from '../../components/Therapy';
import { Context } from '../../context';
import s from './index.module.css';
import { therapy_list } from './data/therapy_list';
import Description from '../../components/Description';

export default function UserInfoPage() {

  const { collectUserDataForRequest } = useContext(Context);

  return (
    <div>
      <FormValidation />
      <div className={s.therapy_container}>
        {
          therapy_list.map(el => <Therapy key={el.id} {...el}/>)
        }
      </div>
      <Description />
      <button className={s.btn} onClick={collectUserDataForRequest}>get tips</button>
    </div>
  )
}
