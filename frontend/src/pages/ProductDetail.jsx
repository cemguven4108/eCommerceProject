import React, { Fragment, useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import { Button, Card } from "semantic-ui-react";
import ProductService from "../services/productService";

export default function ProductDetail() {
  const [product, setProduct] = useState([]);
  let { id } = useParams();

  useEffect(() => {
    let productService = new ProductService();
    productService.getProductById(id).then((result) => setProduct(result.data));
  }, [id]);

  return (
    <Fragment>
      <Card.Group>
        <Card fluid>
          <Card.Content>
            <Card.Header>{product.name}</Card.Header>
            <Card.Meta>${product.price}</Card.Meta>
            <Card.Description>{product.description}</Card.Description>
          </Card.Content>
          <Card.Content extra>
            <div className="ui two buttons">
              <Button basic color="green">
                Add To Cart
              </Button>
              <Button basic color="red">
                Add To Favorites
              </Button>
            </div>
          </Card.Content>
        </Card>
      </Card.Group>
    </Fragment>
  );
}
