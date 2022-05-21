import React, { useState, useRef } from "react";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { InputText } from "primereact/inputtext"
import './cssFiles/DataTable.css';

//Helpers imports
import { UserPrescriptionsList } from "../helpers/UserPrescriptionsList";

export default function UserPrescriptionTable() {
  const prescriptions = UserPrescriptionsList;
  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);

  const header = (
    <div className="table-header">
      <h5 className="mx-0 my-1">Recetas médicas</h5>
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  return (
    <div className="w-full overflow-hidden">
      <div className="card">
        <DataTable showGridlines lazy={true} ref={dt} value={prescriptions}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} prescriptions"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column field="name" header="Nombre"  sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="date" header="Fecha"  sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="daily_amount" header="Cantidad diaria" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="quantity" header="Cantidad total" sortable style={{ minWidth: '10rem' }}></Column>
          <Column field="indication" header="Indicación" sortable style={{ minWidth: '10rem' }}></Column>
        </DataTable>
      </div>
    </div>
  )
}