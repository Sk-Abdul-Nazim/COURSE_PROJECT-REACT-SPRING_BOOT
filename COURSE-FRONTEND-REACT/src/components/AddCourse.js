
import React, { Fragment, useEffect, useState } from 'react';
import { Container, Form, FormGroup, Button } from 'reactstrap';
import axios from 'axios';
import base_url from './../api/SpringBootApi'
import { toast } from 'react-toastify';
import { useHistory } from "react-router-dom";


const AddCourse = () =>{

    const[courses,setCourses] = useState({});

    useEffect(() =>{
        document.title = "Add Course App";
      },[]);
  
     
      let history = useHistory();

    const onSubmitHandle = (e) =>{
        e.preventDefault();
        postAllCoursesFromServer(courses);
    console.log(courses);
    }

    const postAllCoursesFromServer = (data) =>{
        axios.post(`${base_url}/course`,data).then(
            (response) =>{
                // console.log(response);
                
                toast.success("1 Courses Added",{
                    position:'top-center'
                });

                history.push("/viewCourse");
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
                    <label for="courseId">Coursr ID</label>
                    <br/>
                    <input type="text" 
                    name="id" 
                    id="id" 
                    
                    placeholder="Enter Course ID"
                    onChange={(e)=>{
                        setCourses({...courses,id:e.target.value});
                    }}
                    />
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
                    <Button type="submit" color="success">Add Course</Button>
                    <Button type="reset" color="warning ml-2">Clear</Button>
                </Container>
            </Form>
        </Fragment>
     </div>
    );
}

export default AddCourse;