import React, { Fragment } from "react";
import { Dropdown, Menu, Image } from "semantic-ui-react";
import imageUrl from '../assets/Warframe0000.jpg'

export default function SignedIn({signOut}) {
  return (
    <Fragment>
      <Menu.Item>
        <Image avatar spaced="right" src={imageUrl} />
        <Dropdown pointing="top left" text="Cem">
          <Dropdown.Menu>
            <Dropdown.Item text="Profile" icon="info" />
            <Dropdown.Item onClick={signOut} text="Sign Out" icon="sign-out" />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </Fragment>
  );
}