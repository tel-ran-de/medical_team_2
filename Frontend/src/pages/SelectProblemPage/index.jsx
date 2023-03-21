import React from 'react';
import { Link } from 'react-router-dom';

export default function SelectProblemPage() {
  return (
    <div>
      <Link to='/question'>
        <button>Human body</button> 
      </Link>
    </div>
  )
}
