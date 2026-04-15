A full-stack distributed system that searches real-time flight data and visualizes flight routes as an interactive network graph.

It combines Spring Boot, React, and NetworkX to demonstrate backend engineering, data processing, caching, and graph visualization.


Architecture
Frontend (React)
        ↓
Spring Boot Backend
        ↓
FlightLabs API
        ↓
PostgreSQL (Search History)
        ↓
Python Graph Service (NetworkX)
        ↓
Graph JSON → React Visualization

 Features

Flight Search
Search flights by origin, destination, and date
Real-time data via FlightLabs API
Clean DTO-based response

Performance
Caching using Spring Cache
Reduced external API calls

Persistence
Stores flight search history in PostgreSQL

Graph Visualization
Converts flights into a directed graph
Airports = nodes
Flights = edges
Interactive visualization

Frontend UI
React-based interface
Flight results display
Interactive graph rendering

Tech Stack
Backend
Spring Boot
Spring Web
Spring Data JPA
Spring Cache
Frontend
React
Axios
React Force Graph
Graph Engine
NetworkX
Flask (microservice)
Database
PostgreSQL

Project Structure
flight-network-app/
│
├── backend (Spring Boot)
│   ├── controller
│   ├── service
│   ├── client
│   ├── dto
│   ├── entity
│   └── repository
│
├── frontend (React)
│   ├── components
│   └── App.js
│
├── graph-service (Python)
│   └── app.py
│
└── README.md
