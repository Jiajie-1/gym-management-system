import api from "./axios";

export const getAllUsers = () => {
  return api.get("/users");
};

export const getUsersPaged = (page = 0, size = 10, keyword = "", sortBy = "id", direction = "asc") => {
  const params = new URLSearchParams();
  params.append("page", page);
  params.append("size", size);
  if (keyword) params.append("keyword", keyword);
  if (sortBy) params.append("sortBy", sortBy);
  if (direction) params.append("direction", direction);

  return api.get(`/users/page?${params.toString()}`);
};
