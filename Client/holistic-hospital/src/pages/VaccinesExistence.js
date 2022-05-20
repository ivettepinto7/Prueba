import React, { useState, useRef } from "react";
import VaccineExistenceTable from "../components/VaccineExistenceTable";
export default function VaccinesExistence() {
  return (
    <div className="datatable-crud-demo">
      <VaccineExistenceTable />
    </div>
  );
}