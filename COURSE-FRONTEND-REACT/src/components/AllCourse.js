import React, { useEffect, useState } from 'react';
import Course from './Course';
import base_url from './../api/SpringBootApi';
import axios from "axios";
import { toast } from 'react-toastify';

const AllCourse = () =>{

    const[courses,setCourses] = useState([]);

    useEffect(() =>{
        getAllCoursesFromServer();
      },[]);

    const getAllCoursesFromServer = () =>{
        axios.get(`${base_url}/course`).then(
            (response) =>{
                console.log(response);
                setCourses(response.data)
                toast.success("All Courses are Loaded",{
                    position:'top-center'
                });
            },
            (error) =>{
                console.log(error);
                toast.error("Something went wrong");
            }

        );
    };

    useEffect(() =>{
      document.title = "Course App";
    },[]);

    const updateCourseWhenDeleteCourseBecauseDeleteTheObjectFromAllCoursesFunction = (id) =>{
        setCourses(courses.filter((c) => c.id != id));
    }

   return(

    <div className="text-center">
          <h1>All Courses</h1>
          <p>List Of All Courses</p>
             {
                 courses.length > 0
                 ? courses.map((item) => <Course key={item.id} course={item} update={updateCourseWhenDeleteCourseBecauseDeleteTheObjectFromAllCoursesFunction}/>)
                 : "No Course"
             }
    </div>
   );
}



export default AllCourse;