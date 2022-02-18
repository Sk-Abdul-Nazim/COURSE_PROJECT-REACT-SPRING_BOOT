import React from 'react';
import axios from 'axios';
import { toast } from 'react-toastify';
import {  Form, FormGroup, Card, CardTitle, Button, CardHeader, CardFooter, CardBody, CardText, Container } from 'reactstrap';
import { Fragment, useEffect, useState } from 'react';
import base_url from './../api/SpringBootApi';
import { useHistory } from "react-router-dom";


// catch course id from App.js like: {courseId} and set to courses using useState like: const[courses,setCourses] = useState({ id:courseId // for set id to passing courseId}); and set to courses variable after submit using setCourses({...courses,id:courseId});
const UpdateCourse = ({courseId}) =>
{

    const[courses,setCourses] = useState({
        id:courseId // for set id to courses variable passing courseId
    });

    let history = useHistory();

    const onSubmitHandle = (e) =>{
        e.preventDefault();
        setCourses({...courses,id:courseId}); // for set id to courses variable passing courseId
        updateCoursesToServer(courses);
    console.log(courses);
    }

    const updateCoursesToServer = (data) =>{

        axios.put(`${base_url}/update`,data).then(
            (response) =>{
                // console.log(response);
                
                toast.success("1 Courses Updated",{
                    position:'top-center'
                });

                history.push("/viewCourse"); // send to App.js to send AllCourses after submit button
            },
            (error) =>{
                console.log(error);
                toast.error("Something went wrong");
            }

        );
    };


    return(
        <div>
        <Fragment>
            <Form onSubmit={onSubmitHandle}>
                <h1>Fill Course Details</h1>
                <br/>
                <FormGroup>
                <input name="id" id="id" value={courseId} type="hidden"  onChange={(e)=>{
                         setCourses({...courses,id:e.target.value});
                    }}/>
                    
                </FormGroup>
               
                <FormGroup>
                    <label for="courseName">Course Name</label>
                    <br/>
                    <input type="text" 
                    name="courseName" 
                    id="courseName" 
                    placeholder="Enter Course Name"
                    onChange={(e)=>{
                        setCourses({...courses,courseName:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <label for="courseDis">Coursr Discription</label>
                    <br/>
                    <input type="textarea" 
                    name="courseDiscription" 
                    id="courseDiscription" 
                    placeholder="Enter Course Discription"
                    style={{height:100}}
                    onChange={(e)=>{
                        setCourses({...courses,courseDiscription:e.target.value});
                    }}
                    />
                </FormGroup>

                <Container classname="text-center">
                    <Button type="submit" color="success">Update Course</Button>
                    <Button type="reset" color="warning ml-2">Clear</Button>
                </Container>
            </Form>
        </Fragment>
     </div>
    );

}

export default UpdateCourse;