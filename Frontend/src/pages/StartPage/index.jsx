import React from 'react';
import { Link } from 'react-router-dom';

export default function StartPage() {
  return (
    <div>
        <p>You are welcome!</p>
        <Link to='/select_problem'>
        <button>Let's start</button>
        </Link>
    </div>
  )
}
