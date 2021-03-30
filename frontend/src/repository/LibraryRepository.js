import axios from "../custom-axios/axios"

// ova se pravi za sekogas da odi na api url

const LibraryService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    deleteProduct: (id) => {
        return axios.delete(`/books/delete/${id}`);
    },
    addProduct: (name, author, availableCopies, bookCategory) => {
        return axios.post("/books/add", {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "bookCategory" : bookCategory
        });
    },
    editProduct: (id,name, author, availableCopies, bookCategory) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "author" : author,
            "availableCopies" : availableCopies,
            "bookCategory" : bookCategory
        });
    },
    getProduct: (id) => {
        return axios.get(`/books/${id}`);
    }

}

export default LibraryService;