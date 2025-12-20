import { useEffect, useState } from "react";
import { getDashboardStats } from "../api/dashboardApi";
import "../css/dashboard.css";

export default function Dashboard() {
  const [stats, setStats] = useState({
    total: 0,
    admins: 0,
    members: 0,
  });

  useEffect(() => {
    getDashboardStats().then(setStats);
  }, []);

  return (
    <div className="dashboard">
      <h2>Dashboard</h2>

      <div className="dashboard-cards">
        <div className="card">
          <h3>Total Users</h3>
          <p>{stats.total}</p>
        </div>

        <div className="card">
          <h3>Admins</h3>
          <p>{stats.admins}</p>
        </div>

        <div className="card">
          <h3>Members</h3>
          <p>{stats.members}</p>
        </div>
      </div>
    </div>
  );
}