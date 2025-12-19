import { Navigate } from "react-router-dom";

export default function ProtectedRoute({ children }) {
  const token = localStorage.getItem("token");

  // 没 token -> 回登录页
  if (!token) {
    return <Navigate to="/login" replace />;
  }

  return children;
}
