import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';


import CreateNewDrug from "./EmergentWindows/CreateNewDrug";
import EditDrugExistence from "./EmergentWindows/EditDrugExistence";
import DeleteOneDrugExistence from "./EmergentWindows/DeleteDrugExistence";

//Helpers imports
import { DrugExistenceList } from "../helpers/DrugExistenceList";

export default function DrugExistenceTable() {
    const menuContext = useContext(MenuContext);
    const drugs = DrugExistenceList;
  
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
              onClick={() => menuContext.settingEmergentNewDrugState()} 
              />
          </>
        )
    }

    const actionBodyTemplate = (rowData) => {
        return (
          <>
            <Button 
              icon="pi pi-pencil" 
              className="p-button-rounded p-button-success mr-2"
              onClick={() => {
                setcodevar(rowData.id_drug);
                console.log("Enviado: "+ codevar);
                menuContext.settingEmergentEditDrugState();
              }} 
             />
            <Button
               icon="pi pi-trash" 
               className="p-button-rounded p-button-warning"
               onClick={() => {
                 setnamevar(rowData.name);
                 setcodevar(rowData.id_drug);
                 menuContext.settingEmergentDeleteOneDrugState();
               }} 
              />
          </>
        );
    }

    const header = (
        <div className="table-header">
        <h5 className="mx-0 my-1">Manejo de medicamentos</h5>
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
            <CreateNewDrug />
    
            {/*
              *User edit emergent window 
            */}
            <EditDrugExistence code={codevar}/>
    
             {/*
              *User deletion emergent window 
            */}
            <DeleteOneDrugExistence code={codevar} name={namevar}/>
    
          <div className="card">
    
            <Toolbar className="mb-4" left={leftToolbarTemplate} ></Toolbar>
    
            <DataTable showGridlines lazy={true} ref={dt} value={drugs}
              dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
              paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
              currentPageReportTemplate="Showing {first} to {last} of {totalRecords} drugs"
              globalFilter={globalFilter} header={header} responsiveLayout="scroll">

              <Column field="name" header="Nombre" sortable style={{ minWidth: '12rem' }}></Column>
              <Column field="drug_lab" header="Laboratorio" sortable style={{ minWidth: '12rem' }}></Column>
              <Column field="active" header="Activo"  sortable style={{ minWidth: '12rem' }}></Column>
              <Column field="active_percentage" header="Porcentaje activo" sortable style={{ minWidth: '8rem' }}></Column>
              <Column body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>
            </DataTable>
          </div>
        </div>
      )
}