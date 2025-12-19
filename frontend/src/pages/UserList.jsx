import { useEffect, useState } from "react";
import { getUsersPage } from "../api/userApi";
import "../css/userlist.css";

export default function UserList() {
  const [users, setUsers] = useState([]);
  const [page, setPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);
  const [keyword, setKeyword] = useState("");

  const loadUsers = async () => {
    const data = await getUsersPage({
      page,
      size: 5,
      keyword,
    });
    setUsers(data.content);
    setTotalPages(data.totalPages);
  };

  useEffect(() => {
    loadUsers();
  }, [page]);

  const handleSearch = () => {
    setPage(0);
    loadUsers();
  };

  return (
    <div className="users-page">
      <h2>Users</h2>

      {/*  Search */}
      <div className="users-toolbar">
        <input
          type="text"
          placeholder="Search by username or email"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />
        <button onClick={handleSearch}>Search</button>
      </div>

      {/*  Table */}
      <table className="users-table">
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
              <td>{u.role}</td>
            </tr>
          ))}
        </tbody>
      </table>

      {/*  Pagination */}
      <div className="pagination">
        <button
          disabled={page === 0}
          onClick={() => setPage(page - 1)}
        >
          Prev
        </button>

        <span>
          Page {page + 1} / {totalPages}
        </span>

        <button
          disabled={page + 1 >= totalPages}
          onClick={() => setPage(page + 1)}
        >
          Next
        </button>
      </div>
    </div>
  );
}
