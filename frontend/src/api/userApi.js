import axios from "axios";

const BASE_URL = "http://localhost:8080/users";

export const getAllUsers = () => {
  return axios.get(BASE_URL);
};

export const createUser = (user) => {
  return axios.post(BASE_URL, user);
};

export const updateUser = (id, user) => {
  return axios.put(`${BASE_URL}/${id}`, user);
};

export const deleteUser = (id) => {
  return axios.delete(`${BASE_URL}/${id}`);
};
