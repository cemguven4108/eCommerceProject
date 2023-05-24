export default class ProductService {

    getProductById(id) {
        return fetch(`http://localhost:8080/api/v1/products/get/${id}`);
    }

    async getProducts() {
        return await fetch("http://localhost:8080/api/v1/products/getAll");
    }
}