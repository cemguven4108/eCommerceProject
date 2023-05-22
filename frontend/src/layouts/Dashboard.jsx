import React, { Fragment } from "react";
import Categories from "./Categories";
import ProductList from "../pages/ProductList";
import CartDetail from '../pages/CartDetail'
import ProductDetail from '../pages/ProductDetail'
import { Grid } from "semantic-ui-react";
import { Route, Routes } from "react-router-dom";
import { ToastContainer } from "react-toastify";

export default function Dashboard() {
  return (
    <Fragment>
      <ToastContainer position="bottom-right"/>
      <Grid>
        <Grid.Row>
          <Grid.Column width={3}>
            <Categories />
          </Grid.Column>
          <Grid.Column width={12}>
            <Routes>
              <Route exact path="/" />
              <Route exact path="/products" Component={ProductList} />
              <Route exact path="/cart" Component={CartDetail} />
              <Route path="/products/:id" Component={ProductDetail} />
            </Routes>
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </Fragment>
  );
}
