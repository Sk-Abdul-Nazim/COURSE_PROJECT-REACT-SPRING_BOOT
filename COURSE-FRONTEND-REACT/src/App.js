import React from 'react';
import './App.css';
import { ToastContainer, toast } from 'react-toastify';
import Home from './components/Home';
import AllCourse from './components/AllCourse';
import AddCourse from './components/AddCourse';
import { Col, Container, Row } from 'reactstrap';
import Header from './components/Header';
import Menues from './components/Menues';
import UpdateCourse from './components/UpdateCourse';
import {BrowserRouter as Router, Route } from 'react-router-dom';

const App = () =>{

  const btnHandle = () =>{
    toast.success("This is first toast",{position:"top-center"});
  }

  return (
    <div>
      <Router>
      <ToastContainer/>
      <Header/>
       <Container>
         <Row>
           <Col md={4}>
            <Menues/>
           </Col>
           <Col md={8}>
            
            <Route path="/" component={Home} exact/>
            <Route path="/addCourse" component={AddCourse} exact/>
            <Route path="/viewCourse" component={AllCourse} exact/>

            {/* catch course.js id from Course.js and catch like: path="/updateCourse/:id" and send to UpdateCourse.js function like render={(props) => <UpdateCourse  courseId={props.match.params.id}/>} using props */}
            <Route path="/updateCourse/:id"  render={(props) => <UpdateCourse  courseId={props.match.params.id}/>} exact/>
            
           </Col>
         </Row>
       </Container>
       </Router>
    </div>
  );
}

export default App;
