import { useEffect, useState } from "react";
import { createUser, updateUser } from "../api/userApi";

function UserForm({ selectedUser, onSuccess }) {
  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
  });

  useEffect(() => {
    if (selectedUser) {
      setForm({
        username: selectedUser.username,
        email: selectedUser.email,
        password: "",
      });
    }
  }, [selectedUser]);

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (selectedUser) {
      updateUser(selectedUser.id, {
        username: form.username,
        email: form.email,
      }).then(onSuccess);
    } else {
      createUser(form).then(onSuccess);
    }

    setForm({ username: "", email: "", password: "" });
  };

  return (
    <div>
      <h2>{selectedUser ? "Edit User" : "Add User"}</h2>

      <form onSubmit={handleSubmit}>
        <input
          name="username"
          placeholder="Username"
          value={form.username}
          onChange={handleChange}
          required
        />

        <input
          name="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
          required
        />

        {!selectedUser && (
          <input
            name="password"
            placeholder="Password"
            type="password"
            value={form.password}
            onChange={handleChange}
            required
          />
        )}

        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default UserForm;
