import { Grid, Paper, Typography } from "@mui/material";
import React from "react";
import { Link } from "react-router-dom";

export default function StockElement({ stock }) {
  return (
    <Link to={"/stocks/" + stock.id} style={{ textDecoration: "none" }}>
      <Paper>
        <Grid container sx={{ alignItems: "center" }}>
          <Grid item xs={8} sx={{ pl: "1rem" }}>
            <Typography variant="h4">{stock.name}</Typography>
          </Grid>
          <Grid item xs={4}>
            <Grid item xs={12}>
              <Typography variant="overline">Symbol: </Typography>
              <Typography variant="button">{stock.symbol}</Typography>
            </Grid>
            <Grid item xs={12}>
              <Typography variant="overline">ISIN: </Typography>
              <Typography variant="button">{stock.isin}</Typography>
            </Grid>
            <Grid item xs={12}>
              <Typography variant="overline">WKN: </Typography>
              <Typography variant="button">{stock.wkn}</Typography>
            </Grid>
          </Grid>
        </Grid>
      </Paper>
    </Link>
  );
}
