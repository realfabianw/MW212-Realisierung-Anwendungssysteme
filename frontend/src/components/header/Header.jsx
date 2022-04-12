import { Grid, Typography } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

export default function Header() {
  return (
    <Grid container sx={{ justifyContent: "space-between" }}>
      <Grid item xs={5}>
        <Link to="/">
          <Typography>Portfolio Tracker</Typography>
        </Link>
      </Grid>

      <Link to="/">
        <Typography>💸</Typography>
      </Link>

      <Grid container xs={5} sx={{ justifyContent: "flex-end" }}>
        <Link to="/stocks">
          <Typography>Stocks</Typography>
        </Link>
      </Grid>
    </Grid>
  );
}
