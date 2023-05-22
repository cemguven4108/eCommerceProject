import React, { Fragment } from "react";
import { Button, Menu } from "semantic-ui-react";

export default function SignedOut({signIn}) {
  return (
    <Fragment>
      <Menu.Item>
        <Button primary onClick={signIn}>Sign In</Button>
        <Button primary style={{ marginLeft: "0.5em" }}>
          Sign Up
        </Button>
      </Menu.Item>
    </Fragment>
  );
}
