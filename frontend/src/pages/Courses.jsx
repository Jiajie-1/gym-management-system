import { useEffect, useState } from "react";
import { getAllCourses, bookCourse } from "../api/courseApi";
import "../css/coures.css";

export default function Courses() {
  const [courses, setCourses] = useState([]);

  // Load course list from backend
  const loadCourses = async () => {
    const data = await getAllCourses();
    setCourses(data);
  };

  useEffect(() => {
    loadCourses();
  }, []);

  // Handle course booking action
  const handleBook = async (courseId) => {
    await bookCourse(courseId);
    loadCourses();
  };

  return (
    <div className="courses-page">
      <h2>Courses</h2>

      <div className="courses-grid">
        {courses.map((course) => {
          const isPrivate = course.type === "PRIVATE";
          const isBooked = course.bookedCount >= course.capacity;

          return (
            <div className="course-card" key={course.id}>
              <h3>{course.title}</h3>

              <p><strong>Trainer:</strong> {course.trainerName}</p>
              <p><strong>Type:</strong> {course.type}</p>
              <p>
                <strong>Time:</strong>{" "}
                {course.startTime} - {course.endTime}
              </p>

              {course.type === "GROUP" && (
                <p>
                  <strong>Slots:</strong>{" "}
                  {course.capacity - course.bookedCount} / {course.capacity}
                </p>
              )}

              {isBooked ? (
                <button className="btn-disabled" disabled>
                  Booked
                </button>
              ) : (
                <button
                  className="btn-primary"
                  onClick={() => handleBook(course.id)}
                >
                  Book
                </button>
              )}
            </div>
          );
        })}
      </div>
    </div>
  );
}
