import { Grid, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import StockAreaChart from "../components/charts/StockAreaChart";
import StockElement from "../components/stocks_overview/StockElement";
import StockService from "../services/StockService";

export default function StockDetailPage() {
  const params = useParams();
  const [stock, setStock] = useState(undefined);
  const [tickData, setTickData] = useState(undefined);

  console.log(params.stockId);

  useEffect(() => {
    async function fetchData() {
      // Fetch Stock Information
      let result = await StockService.getInstance().getStockById(
        params.stockId
      );
      setStock(result);

      // Fetch Tick Information
      let ticks = await StockService.getInstance().getTicks(params.stockId);
      setTickData(ticks);
    }
    fetchData();
  }, []);

  return (
    <Grid
      container
      sx={{
        justifyContent: "center",
        alignItems: "flex-start",
      }}
    >
      <Grid container xs={10}>
        {/* <Grid xs={6} sx={{ pl: "1rem" }}>
          <Typography variant="h3">Stocks</Typography>
        </Grid> */}
        <Grid item xs={12}>
          {stock && <StockElement stock={stock} />}
        </Grid>
        <Grid item xs={12}>
          {tickData && <StockAreaChart data={tickData} />}
        </Grid>
      </Grid>
    </Grid>

    // <Grid>
    //   <Typography>Hello</Typography>
    //   {stock && <StockElement stock={stock} />}
    //   {tickData && <StockAreaChart data={tickData} />}
    // </Grid>
  );
}
