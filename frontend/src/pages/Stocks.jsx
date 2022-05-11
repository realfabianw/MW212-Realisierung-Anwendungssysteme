import { React, useState, useEffect } from "react";
import Grid from "@mui/material/Grid";
import Headline from "../components/headline/Headline";
import StockService from "../services/StockService";
import Button from '@mui/material/Button';
import { Typography } from "@mui/material";

export default function Stocks() {
  const [stocks, setStocks] = useState([]);

  const handleClick = async () => {
    await StockService.getAllStocks();
  };

  const handleClick2 = async () => {
    await StockService.getStockById("62729c9b21424b64d01ce5e3");
  };

  useEffect(() => {
    async function fetchData() { 
      return await StockService.getAllStocks();
    }
    setStocks(fetchData());
    console.log(stocks);
  }, []);

  return (
    <Grid container sx={{ justifyContent: "center", alignItems: "center" }}>
      <Typography variant="h3">Stocks</Typography>
      <Button onClick={handleClick} variant="outlined">Add Stock</Button>
      {/* <Headline headline={headline} />
      <Button onClick={handleClick} variant="outlined">Get all Stocks</Button>
      <Button onClick={handleClick2} variant="outlined">Get TSLA Stock</Button> */}
    </Grid>
  );
}
