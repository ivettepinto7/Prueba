import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';

import CreateNewArea from "./EmergentWindows/CreateNewArea";
import EditAreaExistence from "./EmergentWindows/EditAreaExistence";
import DeleteOneArea from "./EmergentWindows/DeleteAreaExistence";

//Helpers imports
import { AreaExistenceList } from "../helpers/AreaExistenceList";

export default function AreaExistenceTable() {
    const menuContext = useContext(MenuContext);
    const areas = AreaExistenceList;
  
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
            onClick={() => menuContext.settingEmergentNewAreaState()} 
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
                setcodevar(rowData.id_area);
                console.log("Enviado: "+ codevar);
                menuContext.settingEmergentEditAreaState();
              }} 
             />
            <Button
               icon="pi pi-trash" 
               className="p-button-rounded p-button-warning"
               onClick={() => {
                 setnamevar(rowData.name);
                 setcodevar(rowData.id_area);
                 menuContext.settingEmergentDeleteOneAreaState();
               }} 
              />
          </>
        );
      }

    const header = (
        <div className="table-header">
        <h5 className="mx-0 my-1">Manejo de areas</h5>
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
            <CreateNewArea />
    
            {/*
              *User edit emergent window 
            */}
            <EditAreaExistence code={codevar}/>
    
             {/*
              *User deletion emergent window 
            */}
            <DeleteOneArea code={codevar} name={namevar}/>
    
          <div className="card">
    
            <Toolbar className="mb-4" left={leftToolbarTemplate} ></Toolbar>
    
            <DataTable showGridlines lazy={true} ref={dt} value={areas}
              dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
              paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
              currentPageReportTemplate="Showing {first} to {last} of {totalRecords} areas"
              globalFilter={globalFilter} header={header} responsiveLayout="scroll">

              <Column field="name" header="Nombre" sortable style={{ minWidth: '12rem' }}></Column>
              <Column field="start_age" header="Edad de inicio"  sortable style={{ minWidth: '12rem' }}></Column>
              <Column field="frequency" header="Frecuencia (días)" sortable style={{ minWidth: '8rem' }}></Column>
              <Column body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>

            </DataTable>
          </div>
        </div>
      )

}