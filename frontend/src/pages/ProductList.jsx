import React, { Fragment, useEffect, useState } from "react";
import { Button, Icon, Menu, Table, Message } from "semantic-ui-react";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { addToCart } from "../store/actions/cartAction";
import { toast } from "react-toastify";
import Loading from "../layouts/Loading";

export default function ProductList() {
  const dispatch = useDispatch();
  const [products, setProducts] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [httpError, setHttpError] = useState();

  useEffect(() => {
    const fetchProducts = async () => {
      const response = await fetch(
        "http://localhost:8080/api/v1/products/getAll"
      );

      if (!response.ok) {
        throw new Error();
      }

      const responseData = await response.json();
      const loadedMeals = [];

      for (const key in responseData) {
        loadedMeals.push({
          id: key,
          name: responseData[key].name,
          price: responseData[key].price,
          stock: responseData[key].stock,
          subCategory: responseData[key].subCategory.name,
          category: responseData[key].subCategory.category.name,
        });
      }

      setProducts(loadedMeals);
      setIsLoading(false);
    };

    fetchProducts().catch((error) => {
      setIsLoading(false);
      setHttpError(error.message);
    });
  }, []);

  function addToCartHandler(product) {
    dispatch(addToCart(product));
    toast.success(`${product.name} Added To Cart`);
  }

  if (isLoading) {
    return <Loading />;
  }

  if (httpError) {
    return (
      <Message negative>
        <Message.Header>{httpError}</Message.Header>
      </Message>
    );
  }

  return (
    <Fragment>
      <Table celled>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell>Name</Table.HeaderCell>
            <Table.HeaderCell>Price</Table.HeaderCell>
            <Table.HeaderCell>Stock</Table.HeaderCell>
            <Table.HeaderCell>SubCategory</Table.HeaderCell>
            <Table.HeaderCell>Category</Table.HeaderCell>
            <Table.HeaderCell></Table.HeaderCell>
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {products.map((product) => (
            <Table.Row key={product.id}>
              <Table.Cell>
                <Link to={`/products/${product.id}`}>{product.name}</Link>
              </Table.Cell>
              <Table.Cell>{product.price}</Table.Cell>
              <Table.Cell>{product.stock}</Table.Cell>
              <Table.Cell>{product.subCategory}</Table.Cell>
              <Table.Cell>{product.category}</Table.Cell>
              <Table.Cell>
                <Button onClick={() => addToCartHandler(product)}>
                  Add To Cart
                </Button>
              </Table.Cell>
            </Table.Row>
          ))}
        </Table.Body>

        <Table.Footer>
          <Table.Row>
            <Table.HeaderCell colSpan="3">
              <Menu floated="right" pagination>
                <Menu.Item as="a" icon>
                  <Icon name="chevron left" />
                </Menu.Item>
                <Menu.Item as="a">1</Menu.Item>
                <Menu.Item as="a">2</Menu.Item>
                <Menu.Item as="a">3</Menu.Item>
                <Menu.Item as="a">4</Menu.Item>
                <Menu.Item as="a" icon>
                  <Icon name="chevron right" />
                </Menu.Item>
              </Menu>
            </Table.HeaderCell>
          </Table.Row>
        </Table.Footer>
      </Table>
    </Fragment>
  );
}
