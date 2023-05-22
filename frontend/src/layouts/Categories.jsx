import React, { Fragment } from 'react'
import { Menu } from 'semantic-ui-react'

export default function Categories() {
  return (
    <Fragment>
      <Menu pointing vertical>
        <Menu.Item
          name='home'
        />
        <Menu.Item
          name='messages'
        />
        <Menu.Item
          name='friends'
        />
      </Menu>
    </Fragment>
  )
}
