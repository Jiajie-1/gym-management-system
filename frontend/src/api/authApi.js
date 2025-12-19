import publicApi from "./publicApi";

export const login = (data) => {
  return publicApi.post("/auth/login", data);
};
