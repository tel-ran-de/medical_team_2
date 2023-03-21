import './App.css';
import { Routes, Route } from 'react-router-dom';
import Layout from './components/Layout';
import StartPage from './pages/StartPage';
import SelectProblemPage from './pages/SelectProblemPage';
import QuestionPage from './pages/QuestionPage';
import UserInfoPage from './pages/UserInfoPage';
import TipsPage from './pages/TipsPage';

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<Layout />}>
          <Route index element={<StartPage />} />
          <Route path='select_problem' element={<SelectProblemPage />} />
          <Route path='question' element={<QuestionPage />} />
          <Route path='user_info' element={<UserInfoPage />} />
          <Route path='tips' element={<TipsPage />} />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
