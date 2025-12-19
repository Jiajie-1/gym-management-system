import axios from "./axios";

export const getUsersPage = async ({ page = 0, size = 5, keyword = "" }) => {
  const params = { page, size };

  if (keyword) {
    params.keyword = keyword;
  }

  const response = await axios.get("/users/page", { params });
  return response.data;
};
