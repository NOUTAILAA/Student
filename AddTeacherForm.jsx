import { useState, useEffect } from 'react';
import axios from 'axios';

// eslint-disable-next-line react/prop-types
const AddTeacherForm = ({ onAddTeacher }) => {
  const [teacherData, setTeacherData] = useState({
    nom: '',
    email: '',
    cin: '',
    mdp: '',
    classeId: '', // Ajout de l'ID de la classe associée
    classeNom: 'N/A' // Ajout du nom de la classe associée (par défaut "N/A")
  });

  const [classes, setClasses] = useState([]);

  useEffect(() => {
    fetchClasses();
  }, []);

  const fetchClasses = async () => {
    try {
      const response = await axios.get('http://localhost:8099/api/classes');
      setClasses(response.data);
    } catch (error) {
      console.error('Error fetching classes:', error);
    }
  };

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setTeacherData({
      ...teacherData,
      [name]: value,
    });
  };

  const handleClassChange = (event) => {
    const classId = event.target.value;
    const selectedClass = classes.find((classe) => classe.id === classId);
    setTeacherData({
      ...teacherData,
      classeId: classId,
      classeNom: selectedClass ? selectedClass.nom : 'N/A' // Mise à jour du nom de la classe associée
    });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      const response = await axios.post('http://localhost:8099/api/teachers', teacherData);
      onAddTeacher(response.data);
      // Réinitialisation des champs après l'ajout réussi
      setTeacherData({
        nom: '',
        email: '',
        cin: '',
        mdp: '',
        classeId: '', // Réinitialisation de l'ID de la classe associée
        classeNom: 'N/A' // Réinitialisation du nom de la classe associée
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
        {/* Ajout du champ pour la classe associée */}
        <div className="mb-3">
          <label htmlFor="classeId" className="form-label">Associated Class</label>
          <select
            className="form-control"
            id="classeId"
            name="classeId"
            value={teacherData.classeId}
            onChange={handleClassChange}
            required
          >
            <option value="">Select a Class</option>
            {classes.map((classe) => (
              <option key={classe.id} value={classe.id}>{classe.nom}</option>
            ))}
          </select>
        </div>
        {/* Affichage du nom de la classe associée */}
        <div className="mb-3">
          <label htmlFor="classeNom" className="form-label">Associated Class Name</label>
          <input
            type="text"
            className="form-control"
            id="classeNom"
            name="classeNom"
            value={teacherData.classeNom}
            readOnly // Pour éviter que l'utilisateur modifie le nom de la classe
          />
        </div>
        <button type="submit" className="btn btn-primary">Submit</button>
      </form>
    </div>
  );
};

export default AddTeacherForm;
