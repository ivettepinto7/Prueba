import React, { useRef } from 'react'
import { Outlet } from 'react-router-dom';

import CitasDiaTable from '../components/CitasDiaTable';
export default function CitasDia() {
  return (
    <div className="datatable-crud-demo">

      <CitasDiaTable />
    </div>
    
  );
}