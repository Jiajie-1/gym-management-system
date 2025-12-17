import { useState } from "react";
import UserForm from "./components/UserForm";
import UserList from "./components/UserList";

function App() {
  const [editingUser, setEditingUser] = useState(null);
  const [refreshKey, setRefreshKey] = useState(0);

  const refresh = () => {
    setEditingUser(null);
    setRefreshKey((prev) => prev + 1);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Gym Management System</h1>

      <UserForm selectedUser={editingUser} onSuccess={refresh} />
      <UserList key={refreshKey} onEdit={setEditingUser} />
    </div>
  );
}

export default App;
