import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";
import { UserContext } from "../contexts/UserContext/UserContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';


//Helpers imports
import { CitasDiaList } from "../helpers/CitasDiaList";
import { useNavigate } from "react-router-dom";


export default function CitasDiaTable() {
  const menuContext = useContext(MenuContext);
  const people = CitasDiaList;
  const navigate = useNavigate();
  
  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);


  const actionBodyTemplate = (rowData) => {
    return (
      <>
        <Button 
          icon="pi pi-book" 
          className="p-button-rounded p-button-success mr-2"
          onClick={() => {
            navigate("/landing/citas-dia/consulta")
          }} 
         />
      </>
    );
  }

  const header = (
    <div className="table-header">
      <h5 className="mx-0 my-1">Manejo de citas</h5>
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  const nameBodyTemplate = (rowData) => {
    return rowData.name + ' ' + rowData.last_name;
  }
  const genderBodyTemplate = (rowData) => {
    if (rowData.gender === 'f')
      return 'Femenino';
    else if(rowData.gender ==='m')
      return 'Masculino';
    else
      return 'Indiferente';
  }
  return (
    <div className="w-full overflow-hidden">
      

      <div className="card">


        <DataTable showGridlines lazy={true} ref={dt} value={people}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Mostrando {first} de {last} para {totalRecords} usuarios a atender"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column field="name" header="Nombre" body={nameBodyTemplate} sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="age" header="Edad" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="gender" header="Género" body={genderBodyTemplate} sortable style={{ minWidth: '8rem' }}></Column>
          <Column header="Atender al paciente" body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>
        </DataTable>
      </div>
    </div>
  )
}