import axios from "axios";
import { useState } from "react";
import ForceGraph2D from "react-force-graph-2d";

export default function FlightGraph() {
  const [graph, setGraph] = useState(null);

  const loadGraph = async () => {
    const res = await axios.get(
      "http://localhost:8080/api/flights/graph?from=AMS&to=LHR&date=2026-05-01"
    );

    setGraph(res.data);
  };

  return (
    <div>
      <button onClick={loadGraph}>Load Graph</button>

      {graph && <ForceGraph2D graphData={graph} nodeLabel="id" />}
    </div>
  );
}