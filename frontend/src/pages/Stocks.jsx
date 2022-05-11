import { React, useState, useEffect } from "react";
import Grid from "@mui/material/Grid";
import Headline from "../components/headline/Headline";
import StockService from "../services/StockService";
import Button from "@mui/material/Button";
import { Typography } from "@mui/material";
import StockElement from "../components/stocks_overview/StockElement";

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
      let result = await StockService.getAllStocks();
      setStocks(result);
    }
    fetchData();
    console.log(stocks);
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
        <Grid xs={6} sx={{ pl: "1rem" }}>
          <Typography variant="h3">Stocks</Typography>
        </Grid>

        <Grid container xs={6} sx={{ justifyContent: "flex-end", pr: "1rem" }}>
          <Button onClick={handleClick} variant="outlined">
            Add Stock
          </Button>
        </Grid>

        {stocks.map((stock) => (
          <Grid key={stock.id} xs={6} sx={{ p: "1rem" }}>
            <StockElement stock={stock} />
          </Grid>
        ))}

        {/* <Headline headline={headline} />
      <Button onClick={handleClick} variant="outlined">Get all Stocks</Button>
      <Button onClick={handleClick2} variant="outlined">Get TSLA Stock</Button> */}
      </Grid>
    </Grid>
  );
}
