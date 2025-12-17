import { useEffect, useState } from "react";
import { getAllUsers, deleteUser } from "../api/userApi";

function UserList({ onEdit }) {
  const [users, setUsers] = useState([]);

  const loadUsers = () => {
    getAllUsers().then((res) => {
      setUsers(res.data);
    });
  };

  useEffect(() => {
    loadUsers();
  }, []);

  const handleDelete = (id) => {
    deleteUser(id).then(() => loadUsers());
  };

  return (
    <div>
      <h2>User List</h2>
      <ul>
        {users.map((u) => (
          <li key={u.id}>
            {u.username} ({u.email}) [{u.role}]
            <button onClick={() => onEdit(u)}>Edit</button>
            <button onClick={() => handleDelete(u.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default UserList;
