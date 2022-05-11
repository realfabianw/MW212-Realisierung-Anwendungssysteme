import { Grid, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import StockService from "../services/StockService";

export default function StockDetailPage(props) {
  const params = useParams();
  const [stock, setStock] = useState(undefined);
  const [tickData, setTickData] = useState(undefined);

  console.log(params.stockId);

  useEffect(() => {
    async function fetchData() {
      let result = await StockService.getStockById(params.stockId);
      setStock(result);
    }
    fetchData();
    console.log(stock);
  }, []);

  return (
    <Grid container>
      <Typography>Hello</Typography>
    </Grid>
  );
}
