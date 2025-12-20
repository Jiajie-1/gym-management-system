import axios from "./axios";

export const getDashboardStats = async () => {
  const response = await axios.get("/users");
  const users = response.data;

  const total = users.length;
  const admins = users.filter(u => u.role === "ADMIN").length;
  const members = users.filter(u => u.role === "MEMBER").length;

  return { total, admins, members };
};
