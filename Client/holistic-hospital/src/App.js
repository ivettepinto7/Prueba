import React, { lazy, Suspense } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MenuState from "./contexts/MenuContext/MenuState";
import UserState from "./contexts/UserContext/UserState";

import "primereact/resources/themes/lara-light-indigo/theme.css"; //theme
import "primereact/resources/primereact.min.css"; //core css
import "primeicons/primeicons.css"; //icons

//Components imports
const Login = lazy(() => import("./pages/Login"));
const RecoverPassword = lazy(() => import("./pages/RecoverPassword"));
const RestorePassword = lazy(() => import("./pages/RestorePassword"));
const Landing = lazy(() => import("./pages/Landing"));
const Users = lazy(() => import("./pages/Users"));
const Inmunizations = lazy(() => import("./pages/Inmunizations"));
const ExamsExistence = lazy(() => import("./pages/ExamsExistence"));
const Tests = lazy(() => import("./pages/Tests"));
const PrevAppointments = lazy(() => import("./pages/PrevAppoin"));


function App() {
  return (
    <MenuState>
      <UserState>
        <Suspense fallback={<div></div>}>
          <Router>
            <Routes>
              <Route index element={<Login />} />
              <Route exact path="recuperar" element={<RecoverPassword />} />
              <Route exact path="restablecer" element={<RestorePassword />} />
              
              <Route path="landing" element={<Landing />}>
                <Route index exact path="usuarios" element={<Users />} />
                <Route exact path="examenes" element={<ExamsExistence />} />

                <Route exact path="expediente">
                  <Route index exact path="inmunizaciones" element={<Inmunizations />} />
                  <Route exact path="examenes-realizados" element={<Tests />} />
                  <Route exact path="citas-previas" element={<PrevAppointments/>} />
                </Route>
                {/*TODO app routes*/}
              </Route>
              <Route path="*" element={<h1>Page not found: 404!</h1>} />
            </Routes>
          </Router>
        </Suspense>
      </UserState>
    </MenuState>
  );
}

export default App;
