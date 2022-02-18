
import React from 'react';
import { Button, Container, Jumbotron } from 'reactstrap';
import {useEffect} from 'react';
const Home = () =>{
   useEffect(() =>{
      document.title = "Home App";
    },[]);

    return(
     <div className="text-center">
        <Jumbotron className="text-center">
        <h1 className="display-3">Learn Of React App </h1>
        <p>All Language are fun Bro...</p>
        <Container>
           <Button color="success" outline> Start Using Nazim</Button>
        </Container>
       </Jumbotron>
     </div>
    );
}

export default Home;