import { React, useState } from "react";
import Grid from "@mui/material/Grid";
import Headline from "../components/headline/Headline";

export default function Stocks() {
  const [headline] = useState('Suche');

  return (
    <Grid container sx={{ justifyContent: "center", alignItems: "center" }}>
      <Headline headline={headline}/>
    </Grid>
    );
}
