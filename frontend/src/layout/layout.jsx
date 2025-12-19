import "../css/layout.css";

export default function Layout({ children, onLogout }) {
  return (
    <div className="app-layout">
      {/* Top Bar */}
      <header className="topbar">
        <div className="topbar-left">Gym Management System</div>
        <div className="topbar-right">
          <button className="logout-btn" onClick={onLogout}>
            Logout
          </button>
        </div>
      </header>

      {/* Body */}
      <div className="layout-body">
        {/* Sidebar */}
        <aside className="sidebar">
          <div className="sidebar-title">Admin Panel</div>
          <nav>
            <div className="nav-item active">Users</div>
            {}
          </nav>
        </aside>

        {/* Main Content */}
        <main className="main-content">
          {children}
        </main>
      </div>
    </div>
  );
}
