import './App.css';
import React, {useEffect} from 'react';
import Navbar from './components/Navbar/Navbar';
import Main from './components/Routing/Main';

function App() {
  useEffect(() => {
		document.title = "Pregled Kreditov";
	});
  return (
    <div>
        <Navbar></Navbar>
        <Main></Main>
    </div>
  );
}

export default App;
