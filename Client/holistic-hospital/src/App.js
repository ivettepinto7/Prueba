import React, { lazy, Suspense } from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import MenuState from "./contexts/MenuContext/MenuState";
import UserState from "./contexts/UserContext/UserState";

import "primereact/resources/themes/lara-light-indigo/theme.css"; //theme
import "primereact/resources/primereact.min.css"; //core css
import "primeicons/primeicons.css"; //icons

//Components imports
const Login = lazy(() => import("./pages/Login"));
const Landing = lazy(() => import("./pages/Landing"));
const Users = lazy(() => import("./pages/Users"));
const Inmunizations = lazy(() => import("./pages/Inmunizations"));
const ExamsExistence = lazy(() => import("./pages/ExamsExistence"));
const Tests = lazy(() => import("./pages/Tests"));
const PrevAppointments = lazy(() => import("./pages/PrevAppoin"));
const VaccinesExistence = lazy(() => import("./pages/VaccinesExistence"));
const Recordatorios = lazy(() => import("./pages/Reminders"));


function App() {
  return (
    <MenuState>
      <UserState>
        <Suspense fallback={<div></div>}>
          <Router>
            <Routes>
              <Route index element={<Login />} />
              <Route path="landing" element={<Landing />}>
                <Route index exact path="usuarios" element={<Users />} />
                <Route exact path="examenes" element={<ExamsExistence />} />
                <Route exact path="vacunas" element={<VaccinesExistence />} />
                <Route exact path="recordatorios" element={<Recordatorios />} />

                <Route exact path="expediente">
                  <Route index exact path="inmunizaciones" element={<Inmunizations />} />
                  <Route index exact path="Examenes-realizados" element={<Tests />} />
                  <Route index exact path="citas-previas" element={<PrevAppointments/>} />
                </Route>
                {/*TODO app routes*/}
              </Route>
            </Routes>
          </Router>
        </Suspense>
      </UserState>
    </MenuState>
  );
}

export default App;
