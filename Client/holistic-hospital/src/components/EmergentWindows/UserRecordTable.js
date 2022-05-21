import React, { useState,useEffect, useContext, useRef } from "react";
import MenuContext from "../../contexts/MenuContext/MenuContext";

//Components imports
import { DataTable } from "primereact/datatable";
import { Column } from 'primereact/column';
import { InputText } from "primereact/inputtext"
import { Button } from 'primereact/button';
import { Dialog } from 'primereact/dialog';
import '../cssFiles/DataTable.css';

//Helpers imports
import { UserRecord } from "../../helpers/UserRecord";

export default function UserRecordTable() {
  const record = UserRecord;
  const [globalFilter, setGlobalFilter] = useState(null);
  const dt = useRef(null);
  const { emergentShowRecordState } = useContext(MenuContext);
  const [display, setDisplay] = useState(false);
  const menuContext = useContext(MenuContext);

  useEffect(() => {
    setDisplay(emergentShowRecordState);
  }, [emergentShowRecordState]);

  const dialogFuncMap = {
    display: setDisplay,
  };

  const onHide = (name) => {
    menuContext.settingEmergentShowRecordState();
    dialogFuncMap[`${name}`](false);
  };

  const header = (
    <div className="table-header">
      <span className="p-input-icon-left">
        <i className="pi pi-search" />
        <InputText type="search" onInput={(e) => setGlobalFilter(e.target.value)} placeholder="Buscar..." />
      </span>
    </div>
  );

  const dialogFooter = <div className="flex justify-content-center"><Button label="OK" className="p-button-text" autoFocus  /></div>;


  const typeBodyTemplate = (rowData) => {
    if (rowData.appointment_type === 1)
      return 'Imunización';
    else if (rowData.appointment_type === 2)
      return 'Examen';
    else
      return 'Cita'
  }

  return (
    <div className="flex flex-col">
      <Dialog
        breakpoints={{ '960px': '75vw', '640px': '100vw' }}
        header="Expediente paciente"
        visible={display}
        style={{ width: '50vw' }}
        
        onHide={() => onHide('display')}
      >
        <div className="form-demo w-full">
          

          <div className="m-1 w-full flex justify-content-center">

            <div className="card w-full">
              <div className="w-full overflow-hidden">
                <div className="card">
                  <DataTable showGridlines lazy={true} ref={dt} value={record}
                    dataKey="id" paginator rows={10} rowsPerPageOptions={[5, 10, 25]}
                    paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                    currentPageReportTemplate="Mostrando {first} de {last} del {totalRecords} records"
                    globalFilter={globalFilter} header={header} responsiveLayout="scroll">
                    <Column field="appointment_time" header="Fecha" sortable style={{ minWidth: '12rem' }}></Column>
                    <Column field="appointment_type" header="Tipo" body={typeBodyTemplate} sortable style={{ minWidth: '10rem' }}></Column>
                    <Column field="appointment_detail" header="Detalles de la cita" sortable style={{ minWidth: '12rem' }}></Column>
                  </DataTable>
                </div>
              </div>
            </div>
          </div>
        </div>

      </Dialog>
    </div>



  )
}