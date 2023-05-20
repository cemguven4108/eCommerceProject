import React, { Fragment } from 'react'
import { Button, Container, Menu } from 'semantic-ui-react'
import CartSummary from './CartSummary'

export default function Navi() {
  return (
    <Fragment>
      <Menu size='small' inverted fixed='top'>
        <Container>
          <Menu.Item
            name='home'
          />
          <Menu.Item
            name='messages'
          />
          <Menu.Menu position='right'>
            <CartSummary />
            <Menu.Item>
              <Button primary>Sign Up</Button>
            </Menu.Item>
          </Menu.Menu>
        </Container>
      </Menu>
    </Fragment>
  )
}
