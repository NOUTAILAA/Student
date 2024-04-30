// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    fetchStudents();
  }, []);

  const fetchStudents = async () => {
    try {
      const response = await axios.get('http://localhost:8099/api/students');
      setStudents(response.data);
    } catch (error) {
      console.error('Error fetching students:', error);
    }
  };

  return (
    <div className="container mt-4">
      <h1>Student List</h1>
      <table className="table table-striped">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Class</th>
          </tr>
        </thead>
        <tbody>
          {Array.isArray(students) && students.length > 0 ? (
            students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.nom}</td>
                <td>{student.email}</td>
                <td>{student.classNom ? student.classNom : 'N/A'}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan="4">No students found</td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default StudentList;