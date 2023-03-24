import React, { useContext } from 'react';
import FormValidation from '../../components/FormValidation';
import { Context } from '../../context';
import Button from '../../components/Button';
import { Link } from 'react-router-dom';

export default function UserInfoPage() {

  const { collectUserDataForRequest } = useContext(Context);

  return (
    <div>
      <FormValidation />
   
      <Button onClick={collectUserDataForRequest}>get tips</Button>
    
    </div>
  )
}
