import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';

import CreateNewUser from "./EmergentWindows/CreateNewUser";
import EditUser from "./EmergentWindows/EditUser";
import EditExamExistence from "./EmergentWindows/EditExamExistence";
import DeleteOneExam from "./EmergentWindows/DeleteExamExistence";

import CreateNewExam from "./EmergentWindows/CreateNewExam";

//Helpers imports
import { Exams } from "../helpers/ExamExistenceList";

export default function ExamExistenceTable() {
  const menuContext = useContext(MenuContext);
  const exams = Exams;
  const [codevar, setcodevar] = useState("");
  const [namevar, setnamevar] = useState("");

  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);

  const leftToolbarTemplate = () => {
    return (
      <>
        <Button
          label="Nuevo"
          icon="pi pi-plus"
          className="p-button-success mr-2"
          onClick={() => menuContext.settingEmergentNewExamState()}
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
          tooltipOptions={{ position: 'bottom' }}
          className="p-button-rounded p-button-success mr-2"
          onClick={() => {
            setcodevar(rowData.code);
            menuContext.settingEmergentEditExamState();
          }}
        />
        <Button
          icon="pi pi-trash"
          tooltip="Eliminar"
          tooltipOptions={{ position: 'bottom' }}
          className="p-button-rounded p-button-warning"
          onClick={() => {
            setnamevar(rowData.name);
            setcodevar(rowData.code);
            menuContext.settingEmergentDeleteOneExamState();
          }}
        />
      </>
    );
  }

  const header = (
    <div className="table-header">
      <h5 className="mx-0 my-1">Manejo de examenes</h5>
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  const genderBodyTemplate = (rowData) => {
    if (rowData.gender === 'f')
      return 'Femenino';
    else if (rowData.gender === 'm')
      return 'Masculino';
    else
      return 'Indiferente';
  }

  const nameBodyTemplate = (rowData) => {
    return rowData.name + ' ' + rowData.last_name;
  }

  return (
    <div className="w-full overflow-hidden">
      {/*
        *User creation emergent window 
      */}
      <CreateNewExam />

      {/*
          *User edit emergent window 
        */}
      <EditExamExistence code={codevar} />

      {/*
          *User deletion emergent window 
        */}
      <DeleteOneExam code={codevar} name={namevar} />

      <div className="card">

        <Toolbar className="mb-4" left={leftToolbarTemplate} ></Toolbar>

        <DataTable showGridlines lazy={true} ref={dt} value={exams}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} exams"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column field="name" header="Nombre" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="gender" header="Género" body={genderBodyTemplate} sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="start_age" header="Edad inicial" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="frequency" header="Frecuencia (días)" sortable style={{ minWidth: '8rem' }}></Column>
          <Column body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>
        </DataTable>
      </div>
    </div>
  )
}