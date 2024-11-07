import axios from 'axios'
const REST_API_BASE_URL = 'http://localhost:8080/api/employees';
export const listEmployees = ()=>{
  return axios.get(REST_API_BASE_URL);
}
export const addemployee = (employee)=>{
  return axios.post(REST_API_BASE_URL, employee);
}
export const getemployee = (employeeId)=>{
  return axios.get(REST_API_BASE_URL + '/' + employeeId);
}
export const updateemployee = (employeeId,employee)=>{
  return axios.put(REST_API_BASE_URL + '/' + employeeId,employee);
}
export const deleteemployee = (employeeId)=>{
  return axios.delete(REST_API_BASE_URL + '/' + employeeId);
}