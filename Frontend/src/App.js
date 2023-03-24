import { useState } from 'react';
import './App.css';
import { Routes, Route, useNavigate } from 'react-router-dom';
import Layout from './components/Layout';
import StartPage from './pages/StartPage';
import SelectProblemPage from './pages/SelectProblemPage';
import QuestionPage from './pages/QuestionPage';
import UserInfoPage from './pages/UserInfoPage';
import TipsPage from './pages/TipsPage';
import { Context } from './context';
import { questions } from './QuestionsList/questions';
import { postUserData } from './requests/postUserData';

function App() {

  const navigate = useNavigate();

  const [ bodyArea, setBodyArea ] = useState([]);
  const [checked, setChecked ] = useState(false);
  const [ answers, setAnswers ] = useState([]);
  const [ bmi, setBmi ] = useState([]);
  const [ therapy, setTherapy ] = useState([]);
  const [ description, setDescription ] = useState([]);
  const [ response, setResponse ] = useState([]);

  const toggleBodyArea = (title) => {
    if (bodyArea.includes(title)) {
      setBodyArea(bodyArea.filter(el => el !== title));
      setChecked(!checked)
    } else {
      setBodyArea([...bodyArea, title]);
      setChecked(!checked)
    }
  }; 

  const collectUserDataForRequest = () => {
    const userData = {
        user_body_areas: bodyArea,
        user_answers: answers,
        user_bmi: bmi,
        user_therapy: therapy,
        // user_description: description,
      }
      console.log(userData);
      postUserData(userData, (res) => {  // res from server
        navigate('/tips')
        setResponse(res)
      });
    // return userData;   
  } 

  return (
    <div>
      <Context.Provider value={{bodyArea, setBodyArea, toggleBodyArea, checked, answers, setAnswers, collectUserDataForRequest, bmi, setBmi, therapy, setTherapy, description, setDescription, response, questions}}>
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
