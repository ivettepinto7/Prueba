import React, { useState, useRef } from "react";

import {PrevAppointmentsTable } from "../components/PrevAppointmentsTable";


export default function Users() {
    return (
      <div className="datatable-crud-demo">
        <PrevAppointmentsTable />
      </div>
    );
  }