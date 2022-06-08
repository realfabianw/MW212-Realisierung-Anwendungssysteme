import { Paper, Typography } from "@mui/material";
import React from "react";
import {
  Area,
  AreaChart,
  ResponsiveContainer,
  Tooltip,
  XAxis,
  YAxis,
} from "recharts";

export default function StockAreaChart({ data }) {
  const formatXAxis = (tickItem) => {
    return new Date(tickItem).toISOString().split("T")[0];
  };

  const formatYAxis = (data) => {
    return "$" + data;
  };

  const CustomTooltip = ({ active, payload, label }) => {
    if (active) {
      return (
        <Paper>
          <Typography>{new Date(label).toISOString().split("T")[0]}</Typography>
          <Typography variant="h6">{"$" + payload[0].value}</Typography>
        </Paper>
      );
    }
    return null;
  };

  return (
    <Paper sx={{ py: "2rem" }}>
      <ResponsiveContainer width="100%" height={300}>
        <AreaChart data={data}>
          <defs>
            <linearGradient id="colorUv" x1="0" y1="0" x2="0" y2="1">
              <stop offset="5%" stopColor="#8884d8" stopOpacity={0.8} />
              <stop offset="95%" stopColor="#8884d8" stopOpacity={0} />
            </linearGradient>
          </defs>
          <XAxis dataKey="timestamp" tickFormatter={formatXAxis} />
          <YAxis tickFormatter={formatYAxis} />

          <Tooltip content={<CustomTooltip />} />
          <Area
            type="monotone"
            dataKey="close"
            stroke="#8884d8"
            fillOpacity={1}
            fill="url(#colorUv)"
          />
        </AreaChart>
      </ResponsiveContainer>
    </Paper>
  );
}
