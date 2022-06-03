import { React, useState, useEffect } from "react";
import Grid from "@mui/material/Grid";
import Headline from "../components/headline/Headline";
import StockService from "../services/StockService";
import Button from "@mui/material/Button";
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogContentText,
  DialogTitle,
  TextField,
  Typography,
} from "@mui/material";
import StockElement from "../components/stocks_overview/StockElement";

export default function StocksPage() {
  const [stocks, setStocks] = useState(undefined);
  const [open, setOpen] = useState(false);

  const [stockName, setStockName] = useState("");
  const [stockSymbol, setStockSymbol] = useState("");
  const [stockISIN, setStockISIN] = useState("");
  const [stockWKN, setStockWKN] = useState("");
  const [reload, setReload] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleCancel = () => {
    setOpen(false);
  };

  const handleSubmit = async () => {
    console.log(stockName);
    await StockService.getInstance().addStock(
      stockName,
      stockSymbol,
      stockISIN,
      stockWKN
    );
    setOpen(false);
    setReload(true);
  };

  useEffect(() => {
    async function fetchData() {
      let result = await StockService.getInstance().getAllStocks();
      setStocks(result);
    }
    fetchData();
    console.log(stocks);
    setReload(false);
  }, [reload]);

  const handleClick = async () => {
    await StockService.getInstance().getAllStocks();
  };

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
          <Button onClick={handleClickOpen} variant="outlined">
            Add Stock
          </Button>
        </Grid>

        {stocks &&
          stocks.map((stock) => (
            <Grid key={stock.id} xs={6} sx={{ p: "1rem" }}>
              <StockElement stock={stock} />
            </Grid>
          ))}
      </Grid>

      <Dialog open={open}>
        <DialogTitle>Add a Stock</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Please fill out all fields below.
          </DialogContentText>
          <TextField
            fullWidth
            margin="dense"
            label="Name"
            variant="standard"
            value={stockName}
            onChange={(e) => setStockName(e.target.value)}
          />
          <TextField
            fullWidth
            margin="dense"
            label="Symbol"
            variant="standard"
            value={stockSymbol}
            onChange={(e) => setStockSymbol(e.target.value)}
          />
          <TextField
            fullWidth
            margin="dense"
            label="ISIN"
            variant="standard"
            value={stockISIN}
            onChange={(e) => setStockISIN(e.target.value)}
          />
          <TextField
            fullWidth
            margin="dense"
            label="WKN"
            variant="standard"
            value={stockWKN}
            onChange={(e) => setStockWKN(e.target.value)}
          />
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCancel}>Cancel</Button>
          <Button onClick={handleSubmit}>Add Stock</Button>
        </DialogActions>
      </Dialog>
    </Grid>
  );
}
