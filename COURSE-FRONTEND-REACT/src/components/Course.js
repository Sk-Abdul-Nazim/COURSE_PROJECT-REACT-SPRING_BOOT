import axios from 'axios';
import React from 'react';
import { toast } from 'react-toastify';
import {  Form, FormGroup, Card, CardTitle, Button, CardHeader, CardFooter, CardBody, CardText, Container } from 'reactstrap';
import { Fragment, useEffect, useState } from 'react';
import base_url from './../api/SpringBootApi';
import { useHistory } from "react-router-dom";




const Course = ({course, update}) =>{

  let history = useHistory();

  const deleteCourse = (id) =>{

    axios.delete(`${base_url}/delete/${id}`).then(
      (response) =>{
         toast.success("Delete Successful",{
          position:'top-center'
      });
      update(id);
      },
      (error) =>{
        console.log(error);
        toast.error("Delete unSuccessful");
      }
    );
  }


  const updateCourse = (id) =>{

// send to App.js with course id
history.push({
      pathname: "/updateCourse/"+id,
      
    });

  }

  return(
        <div>
        <Card className="text-center">
        <CardBody >
          <CardTitle className="font-weight-bold">{course.courseName}</CardTitle>
          <CardText>{course.courseDiscription}</CardText>
          <Container className="text-center">
              <Button color="danger" onClick={(e)=>deleteCourse(course.id)}>Delete</Button>
              <Button color="warning ml-3" onClick={(e)=>updateCourse(course.id)}>Update</Button>
          </Container>
        </CardBody>
        </Card>
        </div>
  );
}

export default Course;