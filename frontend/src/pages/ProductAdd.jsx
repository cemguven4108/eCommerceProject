import { Form, Formik } from "formik";
import React, { Fragment } from "react";
import * as Yup from "yup";
import { Button } from "semantic-ui-react";
import DevsTextInput from "../utilities/customFormControls/DevsTextInput";

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
          <DevsTextInput name="name" placeholder="Product Name" />
          <DevsTextInput name="price" placeholder="Price" />
          <Button color="green" type="submit">
            Submit
          </Button>
        </Form>
      </Formik>
    </Fragment>
  );
}
