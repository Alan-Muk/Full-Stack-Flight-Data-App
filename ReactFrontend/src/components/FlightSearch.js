import { useState } from "react";
import axios from "axios";

export default function FlightSearch() {
  const [flights, setFlights] = useState([]);

  const search = async () => {
    const res = await axios.get(
      "http://localhost:8080/api/flights?from=AMS&to=LHR&date=2026-05-01"
    );
    setFlights(res.data);
  };

  return (
    <div>
      <button onClick={search}>Search Flights</button>

      {flights.map((f, i) => (
        <div key={i}>
          {f.airline} | {f.departure} → {f.arrival}
        </div>
      ))}
    </div>
  );
}