import React, { useState } from "react";
import { useSelector } from "react-redux";
import { Container, Menu } from "semantic-ui-react";
import CartSummary from "./CartSummary";
import SignedOut from "./SignedOut";
import SignedIn from "./SignedIn";

export default function Navi() {
  const { cartItems } = useSelector((state) => state.cart);
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  function isAuthenticatedHandler() {
    if (isAuthenticated) {
      setIsAuthenticated(false);
    } else {
      setIsAuthenticated(true);
    }
  }

  return (
    <Menu size="small" inverted fixed="top">
      <Container>
        <Menu.Item name="Home" />
        <Menu.Item name="messages" />
        <Menu.Menu position="right">
          {cartItems.length > 0 && <CartSummary />}
          {isAuthenticated ? (
            <SignedIn signOut={isAuthenticatedHandler} />
          ) : (
            <SignedOut signIn={isAuthenticatedHandler} />
          )}
        </Menu.Menu>
      </Container>
    </Menu>
  );
}
