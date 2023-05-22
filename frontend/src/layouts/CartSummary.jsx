import React, { Fragment } from "react";
import { useSelector } from "react-redux";
import { NavLink } from "react-router-dom";
import { Dropdown, Label } from "semantic-ui-react";

export default function CartSummary() {
  const { cartItems } = useSelector((state) => state.cart);

  return (
    <Fragment>
      <Dropdown item text="Cart">
        <Dropdown.Menu>
          {cartItems.map((cartItem) => (
            <Dropdown.Item>
              {cartItem.product.name}
              <Label>{cartItem.quantity}</Label>
            </Dropdown.Item>
          ))}
          <Dropdown.Divider />
          <Dropdown.Item as={NavLink} to="/cart">
            Order
          </Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
    </Fragment>
  );
}
