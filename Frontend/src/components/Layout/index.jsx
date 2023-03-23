import React from 'react';
import { Outlet } from 'react-router-dom';
import Nav from '../Nav';
import s from './index.module.css'

export default function Layout() {
  return (
    <div className={s.layout}>
        <Nav />
        <main className='content_wrapper'>
          <Outlet />
        </main>
    </div>
  )
}
