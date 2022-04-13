import { Divider, Grid, Link, Typography } from "@mui/material";
import React from "react";

export default function Footer() {
  function Copyright(props) {
    return (
      <Typography
        variant="body2"
        color="text.secondary"
        align="center"
        {...props}
      >
        {"Copyright © "}
        <Link href="https://mui.com/" color="inherit">
          Portfolio Tracker
        </Link>{" "}
        {new Date().getFullYear()}
        {"."}
      </Typography>
    );
  }

  return (
    <Grid container sx={{ flexDirection: "column" }}>
      <Divider sx={{ py: 1 }} />
      <Copyright />
    </Grid>
  );
}
