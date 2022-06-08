import { React, useState } from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Button from "@mui/material/Button";
import MenuItem from "@mui/material/MenuItem";
import { Link } from "react-router-dom";

const pages = [
  { title: "Stocks", route: "stocks" },
  { title: "Register/Login", route: "login" },
];

const linkStyle = {
  color: "inherit",
  textDecoration: "none",
};

export default function Navbar() {
  const [anchorElNav, setAnchorElNav] = useState(null);

  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  return (
    <AppBar position="static">
      <Container maxWidth="xl">
        <Toolbar disableGutters>
          <Typography variant="h5">💸</Typography>
          <Link key={"Overview"} to={"/"} style={linkStyle}>
            <Typography
              variant="h6"
              noWrap
              component="div"
              sx={{ ml: 1, mr: 2, display: { xs: "none", md: "flex" } }}
            >
              Portfolio Tracker
            </Typography>
          </Link>

          <Box sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}>
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            {pages && <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: "bottom",
                horizontal: "left",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "left",
              }}
              open={Boolean(anchorElNav)}
              onClose={handleCloseNavMenu}
              sx={{
                display: { xs: "block", md: "none" },
              }}
            >
              {pages.map((page) => (
                <Link key={page.title} to={"/" + page.route} style={linkStyle}>
                  <MenuItem
                    to={"/" + page.route}
                    key={page.title}
                    onClick={handleCloseNavMenu}
                  >
                    <Typography textAlign="center">{page.title}</Typography>
                  </MenuItem>
                </Link>
              ))}
            </Menu>}
          </Box>
          <Typography
            variant="h6"
            noWrap
            component="div"
            sx={{ flexGrow: 1, display: { xs: "flex", md: "none" } }}
          >
            Portfolio Tracker
          </Typography>
          <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" } }}>
              <Link key={pages[0].title} to={"/" + pages[0].route} style={linkStyle}>
                <Button
                  key={pages[0].title}
                  onClick={handleCloseNavMenu}
                  sx={{ my: 2, color: "white", display: "block" }}
                >
                  {pages[0].title}
                </Button>
              </Link>
          </Box>
          <Box sx={{ flexGrow: 1, display: { xs: "none", md: "flex" }, justifyContent: "end" }}>
              <Link key={pages[1].title} to={"/" + pages[1].route} style={linkStyle}>
                <Button
                  key={pages[1].title}
                  onClick={handleCloseNavMenu}
                  sx={{ my: 2, color: "white", display: "block" }}
                >
                  {pages[1].title}
                </Button>
              </Link>
          </Box>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
