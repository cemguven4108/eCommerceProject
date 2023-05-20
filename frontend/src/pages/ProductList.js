import React, { Fragment, useEffect, useState } from 'react'
import { Icon, Label, Menu, Table } from 'semantic-ui-react'
import ProductService from '../services/productService'

export default function ProductList() {

  const [products, setProducts] = useState([]);

  useEffect(() => {
    let productService = new ProductService()
    productService.getProducts().then(result => setProducts(result.data))
  }, [products])

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
          </Table.Row>
        </Table.Header>

        <Table.Body>
          {
            products.map(product => (
              <Table.Row key={product.id}>
                <Table.Cell>{product.name}</Table.Cell>
                <Table.Cell>{product.price}</Table.Cell>
                <Table.Cell>{product.stock}</Table.Cell>
                <Table.Cell>{product.subCategory.name}</Table.Cell>
                <Table.Cell>{product.subCategory.category.name}</Table.Cell>
              </Table.Row>
            ))
          }
        </Table.Body>

        <Table.Footer>
          <Table.Row>
            <Table.HeaderCell colSpan='3'>
              <Menu floated='right' pagination>
                <Menu.Item as='a' icon>
                  <Icon name='chevron left' />
                </Menu.Item>
                <Menu.Item as='a'>1</Menu.Item>
                <Menu.Item as='a'>2</Menu.Item>
                <Menu.Item as='a'>3</Menu.Item>
                <Menu.Item as='a'>4</Menu.Item>
                <Menu.Item as='a' icon>
                  <Icon name='chevron right' />
                </Menu.Item>
              </Menu>
            </Table.HeaderCell>
          </Table.Row>
        </Table.Footer>
      </Table>
    </Fragment>
  )
}
