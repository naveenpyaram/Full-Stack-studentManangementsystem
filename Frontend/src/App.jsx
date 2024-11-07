
import './App.css'
import Employee from './components/Employee'
import Footer from './components/Footer'
import Header from './components/Header'
import Listemployees from './components/Listemployees'
import {BrowserRouter,Route,Routes} from 'react-router-dom'
function App() {

  return (
    <>
    <BrowserRouter>
    <Header />
    <Routes>
      <Route path='/' element = {<Listemployees />} />
      <Route path='/students' element = {<Listemployees />} />
      <Route path='/addstudent' element = {<Employee />} />
      <Route path='/updatestudent/:id' element = {<Employee />} />
    </Routes>
    <Footer />
    </BrowserRouter>
   
    </>
  )
}

export default App
