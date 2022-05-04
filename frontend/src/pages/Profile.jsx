import { React, useState } from "react";
import Grid from "@mui/material/Grid";
import Headline from "../components/headline/Headline";

export default function Profile() {
  const [headline] = useState('Mein Profil');

  return (
    <Grid container sx={{ justifyContent: "center", alignItems: "center" }}>
      <Headline headline={headline}/>
    </Grid>
  );
}
