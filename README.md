## Routes
- Create a route to get all doctors.
```sh
/employees
```
- Create a route to get a doctor by employee_id.
```sh
/employees/employee/{id}
```
- Create a route to get doctors by status.
```sh
/employees/status/{status}
```
- Create a route to get doctors by department.
```sh
/employees/department/{department}
```
- Create a route to get all patients.
```sh
/patients
```
- Create a route to get a patient by patient_id.
```sh
/patients/patient/{id}
```
- Create a route to get patients date of birth within a specified range.
```sh
/patients/dob/{from}/{till}
```
- Create a route to get patients by the department that their admitting doctor is in (For example, get all patients admitted by a doctor in cardiology).
```sh
/patients/employee/department/{department}
```
- Create a route to get all patients with a doctor whose status is OFF.
```sh
/patients/employee/status/off
```

