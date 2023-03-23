import { useState } from 'react';
import './App.css';
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import StartPage from './pages/StartPage';
import SelectProblemPage from './pages/SelectProblemPage';
import QuestionPage from './pages/QuestionPage';
import UserInfoPage from './pages/UserInfoPage';
import TipsPage from './pages/TipsPage';
import { Context } from './context';
import { questions } from './QuestionsList/questions';

function App() {

  const [ bodyArea, setBodyArea ] = useState([]);
  const [checked, setChecked ] = useState(false);
  const [ answers, setAnswers ] = useState([]);
  const [userData, setUserData] = useState([]);

  const toggleBodyArea = (title) => {
  
    if (bodyArea.includes(title)) {
      setBodyArea(bodyArea.filter(el => el !== title));
      setChecked(!checked)
    } else {
      setBodyArea([...bodyArea, title]);
      setChecked(!checked)
    }
  }; 
  console.log(checked);

  // const collectUserData = (data) => {
  //   setUserData(state => [...state, {
  //     id: Date.now(),
  //     ...data,
  //   }])
  // }  

  // const collectUserData = (data) => { 
  //   setUserData({
  //     ...data,
  //   })
  // }  


    

  return (
    <div>
      <Context.Provider value={{bodyArea, setBodyArea, toggleBodyArea, checked, answers, setAnswers, questions}}>
        <Routes>
          <Route path='/' element={<Layout />}>
            <Route index element={<StartPage />} />
            <Route path='select_problem' element={<SelectProblemPage />} />
            <Route path='question' element={<QuestionPage />} />
            <Route path='user_info' element={<UserInfoPage />} />
            <Route path='tips' element={<TipsPage />} />
          </Route>
        </Routes>
      </Context.Provider>
    </div>
  );
}

export default App;
