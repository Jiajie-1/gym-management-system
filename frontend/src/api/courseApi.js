import axios from "./axios";

// Fetch all available courses
export const getAllCourses = async () => {
  const response = await axios.get("/courses");
  return response.data;
};

// Book a specific course
export const bookCourse = async (courseId) => {
  return axios.post(`/courses/${courseId}/book`);
};
