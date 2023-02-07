## Routes
- Create a route to add a new patient.
```sh
/patients/   (POST)
```
- Create a route to add a new doctor.
```sh
/employees/    (POST)
```
- Create a route to change a doctor’s status.
```sh
/employees/{employeeId}/status   (PATCH)
```
- Create a route to update a doctor’s department.
```sh
/employees/{employeeId}/department   (PATCH)
```
- Create a route to update patient’s information (the user should be able to update any patient information through this route)
```sh
/patients/{patientId}   (PUT)
```
- Create a route to get a patient by patient_id.
```sh
/patients/patient/{id}
```
- Did you use the same type of route to update patient information and to update an employee department?
```sh
No, I use DTO to update the employee department with PATCH and use PUT to update the patient information.
```
- Why did you choose the strategy that you chose?
```sh
Using DTO is more secure and helps to keep things ordered. Using PUT you make use the whole element of patient will be updated. (except for the id).
```
- What are the pros and cons of the strategies you chose for creating these routes?
```sh
Using DTO represent more steps but you will keep your code more ordered.
```
- What are the tradeoffs between PUT and PATCH?
```sh
You have more controll on what is the elements that will be updated. With PUT you need to update all the element even if the info is the same in some columns.
```
