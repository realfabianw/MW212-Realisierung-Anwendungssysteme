import {
  Box,
  createTheme,
  CssBaseline,
  ThemeProvider,
  Typography,
} from "@mui/material";
import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Navbar from "./components/navbar/Navbar";
import Footer from "./components/footer/Footer";
import Overview from "./pages/Overview";
import SignIn from "./pages/SignIn";
import SignUp from "./pages/SignUp";
import Stocks from "./pages/Stocks";
import Account from "./pages/Account";
import Profile from "./pages/Profile";
import Portfolio from "./pages/Portfolio";

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
        <Box sx={{ height: "90vh" }}>
          <Routes>
            <Route exact path="/" element={<Overview />} />
            <Route path="stocks" element={<Stocks />} />
            <Route path="signup" element={<SignUp />} />
            <Route path="signin" element={<SignIn />} />
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
