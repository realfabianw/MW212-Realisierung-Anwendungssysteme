import {
  createTheme,
  CssBaseline,
  ThemeProvider,
  Typography,
} from "@mui/material";
import React from "react";

export default function App() {
  const theme = createTheme({
    palette: {
      mode: "dark",
    },
  });

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Typography variant="h1">
        Ich bin eine H1 Überschrift. Bitte immer die Doku der Komponenten lesen.
      </Typography>
    </ThemeProvider>
  );
}
