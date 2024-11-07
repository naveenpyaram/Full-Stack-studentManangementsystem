import React, { useEffect, useState } from 'react'
import { addemployee, getemployee, updateemployee } from '../services/EmployeeService';
import {useNavigate, useParams} from 'react-router-dom'

const Employee = () => {
  const [firstnme, setFirstnme] = useState('');
  const [lastlname, setLastname] = useState('');
  const [email, setEmail] = useState('');
  const [errors,setErrors] = useState({
    firstnme : '',
    lastlname : '',
    email : ''
  })
 const {id}  = useParams();
  const navigator = useNavigate();
  useEffect(() => {
   if(id){
    getemployee(id).then((response)=>{
      setFirstnme(response.data.firstnme);
      setLastname(response.data.lastlname);
      setEmail(response.data.email);
    }).catch((error)=>{
      console.log(error);
    })
   }
  }, [id])
  
  const saveorupdateemployee = (e)=>{
    e.preventDefault();
    if(formvalidation()){
      const employee = {
        firstnme,lastlname,email
      }
      if(id){
        updateemployee(id,employee).then((response)=>{
          console.log(response.data);
          navigator('/students');
        }).catch(error =>{
          console.log(error);
        })
      }else{
        addemployee(employee).then((response) =>{
          console.log(response.data)
          navigator('/students')
        }).catch(error =>
          console.log(error));
      }
     
     
      setFirstnme('')
      setLastname('')
      setEmail('')
    }
   
  }
  const formvalidation = ()=>{
    let valid = true;
    const errorscopy = {...errors};
    if(firstnme.trim()){
      errorscopy.firstnme = ''
    }
    else{
      errorscopy.firstnme = 'first name is required';
      valid = false;
    }
    if(lastlname.trim()){
      errorscopy.lastlname = ''
    }
    else{
      errorscopy.lastlname = 'last name is required';
      valid = false;
    }
    if(email.trim()){
      errorscopy.email = ''
    }
    else{
      errorscopy.email = 'email name is required';
      valid = false;
    }
    setErrors(errorscopy);
    return valid;
  }
  const pageTitle = ()=>{
    if(id){
      return <h1 className='text-center add'>UPDATE STUDENT</h1>
    }
    else{
      return <h1 className='text-center add'>ADD STUDENT</h1>
    }
  }
  return (
    <div className='card col-md-6 offset-md-3 mt-2 align-items-center pb-3 shadow-lg'>
      <form className=' w-75 mt-2' onSubmit={saveorupdateemployee}>
        {
          pageTitle()
        }
        <div className="mb-3">
          <label htmlFor ="exampleInputfname" className="form-label">First Name</label>
          <input type="text" className={`form-control ${errors.firstnme ? "is-invalid" : ''}`} id="exampleInputfname" placeholder='enter your first name' 
           value={firstnme}
           onChange={(e)=>setFirstnme(e.target.value)}
           />
             {errors.firstnme && <div className='invalid-feedback'>{errors.firstnme}</div>}
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputlname" className="form-label">Last Name</label>
          <input type="text" className={`form-control ${errors.lastlname ? "is-invalid" : ''}`} id="exampleInputlname"  placeholder='enter your last name' 
           value={lastlname}
           onChange={(e)=>setLastname(e.target.value)}
          />
            {errors.lastlname && <div className='invalid-feedback'>{errors.lastlname}</div>}
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputEmail1" className="form-label">Email Address</label>
          <input type="email" className={`form-control ${errors.email ? "is-invalid" : ''}`} id="exampleInputEmail1" aria-describedby="emailHelp" placeholder='enter your email'  
            value={email}
            onChange={(e)=>setEmail(e.target.value)}
          /> 
           {errors.email && <div className='invalid-feedback'>{errors.email}</div>}
        </div>
        <button type="submit" className="btn btn-success">SUBMIT</button>
      </form>
    </div>
  )
}

export default Employee
