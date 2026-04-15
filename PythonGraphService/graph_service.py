from flask import Flask, request, jsonify
import networkx as nx

app = Flask(__name__)

@app.route("/graph", methods=["POST"])
def build_graph():
    data = request.json

    G = nx.DiGraph()

    # Build graph from flights
    for f in data["flights"]:
        source = f["departure"]
        target = f["arrival"]
        airline = f["airline"]

        G.add_edge(source, target, airline=airline)

    nodes = [{"id": n} for n in G.nodes()]

    edges = []
    for u, v, d in G.edges(data=True):
        edges.append({
            "source": u,
            "target": v,
            "airline": d.get("airline")
        })

    return jsonify({
        "nodes": nodes,
        "links": edges
    })

if __name__ == "__main__":
    app.run(port=5001)