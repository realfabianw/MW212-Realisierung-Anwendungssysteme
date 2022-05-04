import React from "react";
import '@fontsource/roboto/300.css';
import { Grid, Typography } from "@mui/material";

export default function Headline({
  headline
}) {
  return (
    <Grid container style={{paddingLeft: "50px", paddingTop: "25px"}} sx={{ justifyContent: "left", alignItems: "left" }}>
      <Typography variant="h4" component="div" gutterBottom>
        {headline}
      </Typography>
    </Grid>
  );
}
