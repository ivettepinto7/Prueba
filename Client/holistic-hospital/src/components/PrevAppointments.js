import React, { useState, useRef } from "react";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { InputText } from "primereact/inputtext";
import './cssFiles/DataTable.css';

import { PrevAppointments } from "../helpers/PrevAppointmentList";

export default function TestTable() {
    const prevAppointments = PrevAppointments;
    
    const [globalFilter, setGlobalFilter] = useState(null);
    const dt = useRef(null);
  
    const header = (
      <div className="table-header">
        <h5 className="mx-0 my-1">Citas previas</h5>
        <span className="p-input-icon-left">
          <i className="pi pi-search" />
          <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
        </span>
      </div>
    );
  
    return (
      <div className="w-full overflow-hidden">
        <div className="card">
          <DataTable showGridlines lazy={true} ref={dt} value={prevAppointments}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} products"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column field="appointment_time" header="Fecha de la cita"  sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="appointment_details" header="Descripción" sortable style={{ minWidth: '12rem' }}></Column>
        </DataTable>
        </div>
      </div>
    )
  }