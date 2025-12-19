import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Layout from "../layout/layout";
import { getAllUsers } from "../api/userApi";
import "../css/userlist.css";

export default function UserList() {
  const [users, setUsers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    const res = await getAllUsers();
    setUsers(res.data);
  };

  const handleLogout = () => {
    localStorage.removeItem("token");
    navigate("/login");
  };

  return (
    <Layout onLogout={handleLogout}>
      <div className="page-header">
        <h2>Users</h2>
      </div>

      <div className="card">
        <table className="user-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Username</th>
              <th>Email</th>
              <th>Role</th>
            </tr>
          </thead>
          <tbody>
            {users.map((u) => (
              <tr key={u.id}>
                <td>{u.id}</td>
                <td>{u.username}</td>
                <td>{u.email}</td>
                <td>
                  <span className={`role ${u.role.toLowerCase()}`}>
                    {u.role}
                  </span>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </Layout>
  );
}
