import { ErrorMessage, Field, Form, Formik } from "formik";
import React, { Fragment } from "react";
import * as Yup from "yup";
import { Button, FormField, Label } from "semantic-ui-react";

export default function ProductAdd() {
  const initialValues = { name: "", price: 0 };
  const schema = Yup.object({
    name: Yup.string().min(3).required("Product Name Is Required"),
    price: Yup.number().required("Product Price Is Required"),
  });

  function onSubmitHandler(values) {
    console.log(values);
  }

  return (
    <Fragment>
      <Formik
        initialValues={initialValues}
        validationSchema={schema}
        onSubmit={onSubmitHandler}
      >
        <Form className="ui form">
          <FormField>
            <Field name="name" placeholder="Name"></Field>
            <ErrorMessage
              name="name"
              render={(error) => (
                <Label pointing basic color="red" content={error}></Label>
              )}
            />
          </FormField>
          <FormField>
            <Field name="price" placeholder="Price"></Field>
            <ErrorMessage
              name="price"
              render={(error) => (
                <Label pointing basic color="red" content={error}></Label>
              )}
            />
          </FormField>
          <Button color="green" type="submit">
            Submit
          </Button>
        </Form>
      </Formik>
    </Fragment>
  );
}
