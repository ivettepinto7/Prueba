import React, { useRef } from 'react'
import { Toast } from 'primereact/toast';

import UsersTable from '../components/UsersTable';

//Helpers imports

export default function Users() {
  const toast = useRef(null);

  return (
    <div className="datatable-crud-demo">
      <Toast ref={toast} />

      <UsersTable />
    </div>
  );
}