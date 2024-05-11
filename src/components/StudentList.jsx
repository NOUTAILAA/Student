// StudentList.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './StudentList.css'; // Assurez-vous d'avoir un fichier CSS pour le style de la liste des étudiants

const StudentList = () => {
  const [students, setStudents] = useState([]);
  const [newStudent, setNewStudent] = useState({ nom: '', email: '', classNom: '' });

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

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('http://localhost:8099/api/students', newStudent);
      alert('Student added successfully.');
      // Fetch students again to update the list
      fetchStudents();
      // Clear the form
      setNewStudent({ nom: '', email: '', classNom: '' });
    } catch (error) {
      console.error('Error adding student:', error);
    }
  };

  return (
    <div className="student-list-container">
      <h1>Student List</h1>
      <table className="student-table">
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

      {/* Add Student Form */}
      <form className="add-student-form" onSubmit={handleSubmit}>
        <h2>Add Student</h2>
        <input type="text" name="nom" placeholder="Name" value={newStudent.nom} onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" value={newStudent.email} onChange={handleChange} required />
        <input type="text" name="classNom" placeholder="Class" value={newStudent.classNom} onChange={handleChange} required />
        <button type="submit">Add Student</button>
      </form>
    </div>
  );
};

export default StudentList;
