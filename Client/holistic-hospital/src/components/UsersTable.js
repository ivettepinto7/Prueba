import React, { useState, useContext, useRef } from "react";
import MenuContext from "../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { Toolbar } from 'primereact/toolbar';
import { InputText } from "primereact/inputtext";
import { Button } from "primereact/button";
import './cssFiles/DataTable.css';

//Helpers imports
import { People } from "../helpers/UsersList";
import CreateNewUser from "./EemergentWindows/CreateNewUser";
import EditUser from "./EemergentWindows/EditUser";

export default function UsersTable() {
  const menuContext = useContext(MenuContext);
  const people = People;

  const [selectedProducts, setSelectedProducts] = useState(null);
  
  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);

  const leftToolbarTemplate = () => {
    return (
      <>
        <Button
          label="Nuevo"
          icon="pi pi-plus"
          className="p-button-success mr-2"
          onClick={() => menuContext.settingEmergentNewUserState()} 
          />
        <Button
          label="Eliminar"
          icon="pi pi-trash"
          className="p-button-danger"
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
            menuContext.settingUserCode(rowData.code);
            menuContext.settingEmergentEditUserState();
          }} 
         />
        <Button
           icon="pi pi-trash" 
           className="p-button-rounded p-button-warning" 
          />
      </>
    );
  }

  const header = (
    <div className="table-header">
      <h5 className="mx-0 my-1">Manejo de usuarios</h5>
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  const statusBodyTemplate = (rowData) => {
    if (rowData.status === true)
      return 'Activo';
    else
      return 'Inactivo';
  }

  const nameBodyTemplate = (rowData) => {
    return rowData.name + ' ' + rowData.lastname;
  }

  return (
    <div className="w-full overflow-hidden">
      {/*
        *User creation emergent window 
      */}
        <CreateNewUser />

        {/*
          *User edit emergent window 
        */}
        <EditUser />

      <div className="card">

        <Toolbar className="mb-4" left={leftToolbarTemplate} ></Toolbar>

        <DataTable showGridlines lazy={true} ref={dt} value={people} selection={selectedProducts} onSelectionChange={(e) => setSelectedProducts(e.value)}
          dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
          paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
          currentPageReportTemplate="Showing {first} to {last} of {totalRecords} products"
          globalFilter={globalFilter} header={header} responsiveLayout="scroll">
          <Column selectionMode="multiple" headerStyle={{ width: '3rem' }} exportable={false}></Column>
          <Column field="code" header="Código" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="name" header="Nombre" body={nameBodyTemplate} sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="email" header="Correo" sortable style={{ minWidth: '12rem' }}></Column>
          <Column field="rol" header="Rol" sortable style={{ minWidth: '8rem' }}></Column>
          <Column field="status" header="Estado" body={statusBodyTemplate} sortable style={{ minWidth: '10rem' }}></Column>
          <Column body={actionBodyTemplate} exportable={false} style={{ minWidth: '8rem' }}></Column>
        </DataTable>
      </div>
    </div>
  )
}