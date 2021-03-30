import React from 'react';
import {useHistory} from 'react-router-dom';

const BookEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        author: "",
        availableCopies: 0,
        bookCategory: 0,
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name !== ""? formData.name : props.book.name;
        const author = formData.author !== "" ? formData.author : props.book.author.authorName;
        const availableCopies =  formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        const bookCategory = formData.bookCategory !== 0 ? formData.bookCategory : props.book.bookCategory


        props.onEdit(props.book.id, name, author, availableCopies, bookCategory);
        history.push("/books");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.book.name}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="author">Author</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="author"
                               placeholder={props.book.author?.authorName}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="availableCopies">Quantity</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Category</label>
                        <select name="bookCategory" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                                if(props.book.bookCategory !== undefined &&
                                    props.book.bookCategory === term)
                                    return <option selected={props.book.bookCategory} value={term.id}>{term}</option>
                                else return <option value={term.id}>{term}</option>
                            })}
                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BookEdit;
