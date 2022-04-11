import React, { lazy, Suspense } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import "primereact/resources/themes/lara-light-indigo/theme.css"; //theme
import "primereact/resources/primereact.min.css"; //core css
import "primeicons/primeicons.css"; //icons

//Components imports
const Login = lazy(() => import('./pages/Login'));

function App() {
  return (
    <Suspense fallback={<div></div>}>
      <Router>
        <Routes>
          <Route index element={<Login />} />
        </Routes>
      </Router>
      </Suspense>
  );
}

export default App;
