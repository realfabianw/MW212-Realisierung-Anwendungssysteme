import {
  createTheme,
  CssBaseline,
  ThemeProvider,
  Typography,
} from "@mui/material";
import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./components/header/Header";
import Overview from "./pages/Overview";
import Stocks from "./pages/Stocks";

export default function App() {
  const theme = createTheme({
    palette: {
      mode: "dark",
    },
  });

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<Overview />} />
          <Route path="stocks" element={<Stocks />} />
        </Routes>
      </BrowserRouter>
    </ThemeProvider>
  );
}
