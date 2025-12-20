import { Link, useNavigate } from "react-router-dom";
import "../css/layout.css";

export default function Layout({ children }) {
  const navigate = useNavigate();

  // Clear auth token and redirect to login
  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  return (
    <div className="app-layout">
      {/* Top navigation bar */}
      <header className="topbar">
        <h1>Gym Management System</h1>
        <button className="logout-btn" onClick={handleLogout}>
          Logout
        </button>
      </header>

      <div className="layout-body">
        {/* Sidebar navigation */}
        <aside className="sidebar">
          <nav>
            <ul>
              <li><Link to="/dashboard">Dashboard</Link></li>
              <li><Link to="/courses">Courses</Link></li>
              <li><Link to="/trainers">Trainers</Link></li>
              <li><Link to="/bookings">Bookings</Link></li>
              <li><Link to="/profile">Profile</Link></li>
              <li><Link to="/users">Users</Link></li>
            </ul>
          </nav>
        </aside>

        {/* Main content area */}
        <main className="main-content">
          {children}
        </main>
      </div>
    </div>
  );
}
