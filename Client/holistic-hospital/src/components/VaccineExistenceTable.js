import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';



import DeleteOneVaccine from "./EmergentWindows/DeleteVaccineExistence";

import CreateNewVaccine from "./EmergentWindows/CreateNewVaccine";
import EditVaccineExistence from "./EmergentWindows/EditVaccineExistence";
//Helpers imports
import { VaccinesExistenceList } from "../helpers/VaccinesExistenceList";

export default function VaccineExistenceTable() {
  const menuContext = useContext(MenuContext);
  const vaccines = VaccinesExistenceList;

  const [codevar,setcodevar] = useState("");
  const [namevar,setnamevar] = useState("");
  
  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);

  const leftToolbarTemplate = () => {
    return (
      <>
        <Button
          label="Nuevo"
          icon="pi pi-plus"
          className="p-button-success mr-2"
          onClick={() => menuContext.settingEmergentNewVaccineState()} 
          />
      </>
    )
  }


  const actionBodyTemplate = (rowData) => {
    return (
      <>
        <Button 
          icon="pi pi-pencil"
          tooltip="Editar"
          tooltipOptions={{position: 'bottom'}} 
          className="p-button-rounded p-button-success mr-2"
          onClick={() => {
            setcodevar(rowData.id_vaccine);
            console.log("Enviado: "+ codevar);
            menuContext.settingEmergentEditVaccineState();
          }} 
         />
        <Button
           icon="pi pi-trash"
           tooltip="Eliminar"
          tooltipOptions={{position: 'bottom'}} 
           className="p-button-rounded p-button-warning"
           onClick={() => {
             setnamevar(rowData.name);
             setcodevar(rowData.id_vaccine);
             menuContext.settingEmergentDeleteOneVaccineState();
           }} 
          />
      </>
    );
  }

  const header = (
    <div className="table-header">
      <h5 className="mx-0 my-1">Manejo de vacunas</h5>
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  return (
    <div className="w-full overflow-hidden">
      {/*
        *User creation emergent window 
      */}
        <CreateNewVaccine />

        {/*
          *User edit emergent window 
        */}
        <EditVaccineExistence code={codevar}/>

         {/*
          *User deletion emergent window 
        */}
        <DeleteOneVaccine code={codevar} name={namevar}/>

      <div className="card">

        <Toolbar className="mb-4" left={leftToolbarTemplate} ></Toolbar>

        <DataTable showGridlines lazy={true} ref={dt} value={vaccines}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} vaccines"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column field="name" header="Nombre" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="required_doses" header="Dosis requeridas"  sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="frequency" header="Frecuencia (días)" sortable style={{ minWidth: '8rem' }}></Column>
          <Column body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>
        </DataTable>
      </div>
    </div>
  )
}