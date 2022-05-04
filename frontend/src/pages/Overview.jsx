import { React, useState } from "react";
import Headline from "../components/headline/Headline";

export default function Overview() {
  const [headline] = useState('Tracke deine Aktien und behalte den Überblick deines Portfolios!');

  return (
    <Headline headline={headline}/>
  );
}
