import React from 'react';
import { Link } from 'react-router-dom';
import { ListGroup } from 'reactstrap';

const Menues = () =>{

    return(
        <div>
            <ListGroup>
                <Link className="list-group-item list-group-item-action" to="/" tag="a" action>
                    Home
                </Link>
                <Link className="list-group-item list-group-item-action" to="/addCourse" tag="a" action>
                    Add Course
                </Link>

                <Link className="list-group-item list-group-item-action" to="/viewCourse" tag="a" action>
                    View Course
                </Link>
                <Link className="list-group-item list-group-item-action" to="#!" tag="a" action>
                    About
                </Link>
                <Link className="list-group-item list-group-item-action" to="#!" tag="a" action>
                    Contact
                </Link>
            </ListGroup>
        </div>
    );
}

export default Menues;