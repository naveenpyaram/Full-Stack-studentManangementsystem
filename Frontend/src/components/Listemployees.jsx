import React, { useEffect, useState } from 'react'
import { deleteemployee, listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom'


const Listemployees = () => {
  const [employees, setEmployees] = useState([]);
  const [page, setPages] = useState(1);
  const navigator = useNavigate();
  useEffect(() => {
    getallemployees();
  }, [])
  const getallemployees = () => {
    listEmployees().then((response) => {
      setEmployees(response.data)
    }).catch(error => {
      console.log(error);
    })
  }
  const handleaddstudent = () => {
    navigator('/addstudent')
  }
  const updatehandler = (id) => {
    navigator(`/updatestudent/${id}`)
    setStatus(true);
  }
  const deletehandler = (id) => {
    deleteemployee(id).then((response) => {
      getallemployees()
    }).catch(error => {
      console.log(error);
    })
  }
const selectPageHandler = (select)=>{
  setPages(select);
}
  return (
    <div className='container'>
      <h1 className="text-center add">STUDENTS LIST</h1>
      <button className='btn btn-primary mb-2' onClick={handleaddstudent}>ADD STUDENT</button>
      <table className='table table-bordered table-striped text-center'>
        <thead>
          <tr>

            <th>
              FIRST NAME
            </th>
            <th>
              LAST NAME
            </th>
            <th>
              EMAIL
            </th>
            <th>
              ACTIONS
            </th>
          </tr>
        </thead>
        <tbody>
          {employees.slice((page * 5) - 5, page * 5).map((emp) => {
            return <tr key={emp.id}>

              <td>{emp.firstnme}</td>
              <td>{emp.lastlname}</td>
              <td>{emp.email}</td>
              <td className='d-flex flex-row gap-3'>
                <button className='btn btn-info' onClick={() => updatehandler(emp.id)}>UPDATE</button>
                <button className='btn btn-danger' onClick={() => deletehandler(emp.id)}>DELETE</button>
              </td>
            </tr>
          })}
        </tbody>
      </table>
      <nav aria-label="Page navigation example" className='align-items-center pagecard'>
        <ul className="pagination">
          <li className="page-item">
            <a className="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true"  onClick={() => selectPageHandler(page - 1)} className={page > 1 ? "" : "pagination__disable"}>&laquo;</span>
            </a>
          </li>
          {[...Array(Math.ceil(employees.length / 5))].map((_, i) => {
          return <span key={i} onClick={() => selectPageHandler(i + 1)} className='pageselected'>{i + 1}</span>
        })}

          <li className="page-item">
            <a className="page-link" href="#" aria-label="Next">
              <span aria-hidden="true" onClick={() => selectPageHandler(page + 1)} className={page < Math.ceil(employees.length / 5)? "" : "pagination__disable"}>&raquo;</span>
            </a>
          </li>
        </ul>
      </nav>

    </div>
  )
}

export default Listemployees
