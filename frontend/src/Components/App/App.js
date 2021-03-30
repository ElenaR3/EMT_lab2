import './App.css';
import React, {Component} from "react"
import Books from "../Book/bookList"
import LibraryService from "../../repository/LibraryRepository";
import {BrowserRouter as Router, Redirect, Route} from "react-router-dom";
import BookEdit from "../Book/bookEdit";
import BookAdd from "../Book/addBook";
import Header from "../Header/Header";
import Categories from "../Categories/categories";
import EShopService from "../../repository/LibraryRepository";

class App extends Component {    // klasna komponenta

  constructor(props) {
    super(props);
    this.state = {           // sostojbata sekogas e nekoj objekt
      books: [],
      categories: [],
      selectedProduct: {}
    }
  }

  render() {
    return (
        <Router>
          <Header/>
          <main>
            <div className="container">
              <Route path={"/categories"} exact render={() =>
                  <Categories categories={this.state.categories}/>}/>
              <Route path={"/books/add"} exact render={() =>
                  <BookAdd categories={this.state.categories}
                              books={this.state.books}
                              onAddProduct={this.addProduct}/>}/>
              <Route path={"/books/edit/:id"} exact render={() =>
                  <BookEdit categories={this.state.categories}
                               books={this.state.books}
                               onEdit={this.editProduct}
                               book={this.state.selectedProduct}/>}/>
                <Route path={"/books"} exact render={() =>
                    <Books books={this.state.books}
                              onDelete={this.deleteProduct}
                              onEdit={this.getProduct}/>}/>

                <Redirect to={"/books"}/>
            </div>
          </main>
        </Router>

    );
  }

  loadBooks = () => {
    LibraryService.fetchBooks().then((data) => {
      this.setState({
        books: data.data
      })
    })
  }

  loadCategories = () => {
    LibraryService.fetchCategories().then((data) => {
      this.setState({
        categories: data.data
      })
    })
  }


  deleteProduct = (id) => {
    EShopService.deleteProduct(id)
        .then(() => {
          this.loadBooks();
        });
  }

  addProduct = (name, author, availableCopies, bookCategory) => {
    EShopService.addProduct(name, author, availableCopies, bookCategory)
        .then(() => {
          this.loadBooks();
        });
  }

  getProduct = (id) => {
    EShopService.getProduct(id)
        .then((data) => {
          this.setState({
            selectedProduct: data.data
          })
        })
  }

  editProduct = (id, name, author, availableCopies, bookCategory) => {
    EShopService.editProduct(id, name, author, availableCopies, bookCategory)
        .then(() => {
          this.loadBooks();
        });
  }


  componentDidMount() {
    this.loadBooks();
    this.loadCategories();
  }
}

export default App;