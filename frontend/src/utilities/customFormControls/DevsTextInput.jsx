import { useField } from "formik";
import React, { Fragment } from "react";
import { FormField, Label } from "semantic-ui-react";

export default function DevsTextInput(props) {
  const [field, meta] = useField(props);

  return (
    <Fragment>
      <FormField error={meta.touched && !!meta.error}>
        <input {...field} {...props} />
        {meta.touched && !!meta.error ? (
          <Label pointing basic color="red" content={meta.error} />
        ) : null}
      </FormField>
    </Fragment>
  );
}