import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Login from "./pages/Login";

function Users() {
  return <h2>User List (Admin Only)</h2>;
}

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/login" />} />
        <Route path="/login" element={<Login />} />
        <Route path="/users" element={<Users />} />
      </Routes>
    </BrowserRouter>
  );
}
