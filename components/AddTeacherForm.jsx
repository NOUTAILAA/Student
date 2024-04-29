import React, { useState } from 'react';
import axios from 'axios';

const AddTeacherForm = ({ onAddTeacher, classes }) => {
  const [teacherData, setTeacherData] = useState({
    nom: '',
    email: '',
    cin: '',
    mdp: ''
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setTeacherData({
      ...teacherData,
      [name]: value,
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8099/api/teachers', teacherData);
      onAddTeacher(response.data);
      // Réinitialisez les champs après l'ajout réussi
      setTeacherData({
        nom: '',
        email: '',
        cin: '',
        mdp: ''
      });
    } catch (error) {
      console.error('Error adding teacher:', error);
    }
  };

  return (
    <div className="container mt-4">
      <h2>Add Teacher</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="nom" className="form-label">Name</label>
          <input
            type="text"
            className="form-control"
            id="nom"
            name="nom"
            value={teacherData.nom}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="email" className="form-label">Email</label>
          <input
            type="email"
            className="form-control"
            id="email"
            name="email"
            value={teacherData.email}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="cin" className="form-label">CIN</label>
          <input
            type="text"
            className="form-control"
            id="cin"
            name="cin"
            value={teacherData.cin}
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="mdp" className="form-label">Password</label>
          <input
            type="password"
            className="form-control"
            id="mdp"
            name="mdp"
            value={teacherData.mdp}
            onChange={handleInputChange}
            required
          />
        </div>
        
        {/* Ajoutez d'autres champs du formulaire si nécessaire */}
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
};

export default AddTeacherForm;
