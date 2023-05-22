import axios from 'axios';

export default class ProductService {

    getProductById(id) {
        return axios.get(`http://localhost:8080/api/v1/products/get/${id}`)
    }

    getProducts() {
        return axios.get("http://localhost:8080/api/v1/products/getAll");
    }
}