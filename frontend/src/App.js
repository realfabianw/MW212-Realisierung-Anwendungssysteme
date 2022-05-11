import { Box, createTheme, CssBaseline, ThemeProvider } from "@mui/material";
import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./components/navbar/Navbar";
import Footer from "./components/footer/Footer";
import Overview from "./pages/Overview";
import StocksPage from "./pages/StocksPage";
import Account from "./pages/Account";
import Profile from "./pages/Profile";
import Portfolio from "./pages/Portfolio";
import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import StockDetailPage from "./pages/StockDetailPage";

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
        <Navbar />
        <Box sx={{ pt: "2rem", height: "90vh" }}>
          <Routes>
            <Route exact path="/" element={<Overview />} />
            <Route path="register" element={<RegisterPage />} />
            <Route path="login" element={<LoginPage />} />
            <Route path="stocks" element={<StocksPage />} />
            <Route path="stocks/:stockId" element={<StockDetailPage />} />
            <Route path="account" element={<Account />} />
            <Route path="profile" element={<Profile />} />
            <Route path="portfolio" element={<Portfolio />} />
          </Routes>
        </Box>
        <Footer />
      </BrowserRouter>
    </ThemeProvider>
  );
}
