import React from "react"
import {Link} from 'react-router-dom';
import BookTerm from "./bookTerm";

const Books = (props) => {
    return (
        <div className={"container mm-4 mm-5"}>
            <div className={"row"}>
                <div className={"row"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Author</th>
                            <th scope={"col"}>Available copies</th>
                            <th scope={"col"}>Book category</th>
                        </tr>
                        </thead>
                        <tbody>

                        {props.books.map((book) => (
                            <BookTerm term={book} onDelete={props.onDelete} onEdit={props.onEdit}/>
                        ))}
                        </tbody>
                    </table>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/books/add"}>Add new book</Link>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    );
}

export default Books;  //mora da se eksportira komponentata