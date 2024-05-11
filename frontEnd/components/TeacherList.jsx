// eslint-disable-next-line no-unused-vars
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import AddTeacherForm from './AddTeacherForm';

const TeacherList = () => {
  const [teachers, setTeachers] = useState([]);
  const [searchName, setSearchName] = useState('');
  const [showAddForm, setShowAddForm] = useState(false);

  useEffect(() => {
    fetchTeachers();
  }, []);

  const fetchTeachers = async () => {
    try {
      let url = 'http://localhost:8099/api/teachers';
      if (searchName) {
        url = `http://localhost:8099/api/teachers/search/${searchName}`;
      }
      
      const response = await axios.get(url);
      setTeachers(response.data);
    } catch (error) {
      console.error('Error fetching teachers:', error);
    }
  };

  const handleSearch = () => {
    console.log("Searching...");
    fetchTeachers(); 
  };

  const handleInputChange = (event) => {
    setSearchName(event.target.value);
  };

  const handleAddTeacher = () => {
    setShowAddForm(true);
  };

  const handleAddFormClose = () => {
    setShowAddForm(false);
  };

  const handleTeacherAdded = (newTeacher) => {
    setTeachers([...teachers, newTeacher]);
    setShowAddForm(false);
  };

  return (
    <div className="container mt-4">
      <h1>Teacher List</h1>
      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Search by name"
          value={searchName}
          onChange={handleInputChange}
        />
        <button className="btn btn-primary mt-2" onClick={handleSearch}>
          Search
        </button>
      </div>
      <div className="mb-3">
        <button className="btn btn-success" onClick={handleAddTeacher}>
          Add Teacher
        </button>
      </div>
      {showAddForm && <AddTeacherForm onAddTeacher={handleTeacherAdded} onClose={handleAddFormClose} />}
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
          {teachers.map((teacher) => (
            <tr key={teacher.id}>
              <td>{teacher.id}</td>
              <td>{teacher.nom}</td>
              <td>{teacher.email}</td>
              <td>{teacher.classNom ? teacher.classNom : 'N/A'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default TeacherList;