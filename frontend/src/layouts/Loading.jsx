import React, { Fragment } from "react";
import { Dimmer, Loader, Segment } from "semantic-ui-react";

export default function Loading() {
  return (
    <Fragment>
      <Segment>
        <Dimmer active inverted>
          <Loader inverted>
            Loading
          </Loader>
        </Dimmer>
        <h1> </h1>
      </Segment>
    </Fragment>
  );
}
