// Importations nécessaires
import { useState, useEffect } from 'react';
import axios from 'axios';

const AssignCourseToClass = () => {
  // États pour stocker les cours, les classes et les sélections de l'utilisateur
  const [courses, setCourses] = useState([]);
  const [classes, setClasses] = useState([]);
  const [selectedCourse, setSelectedCourse] = useState('');
  const [selectedClass, setSelectedClass] = useState('');

  // Récupération des cours et des classes depuis le backend lors du chargement de la page
  useEffect(() => {
    fetchCourses();
    fetchClasses();
  }, []);

  // Fonction pour récupérer la liste des cours depuis le backend
  const fetchCourses = async () => {
    try {
      const response = await axios.get('http://localhost:8099/api/cours');
      setCourses(response.data);
    } catch (error) {
      console.error('Error fetching courses:', error);
    }
  };

  // Fonction pour récupérer la liste des classes depuis le backend
  const fetchClasses = async () => {
    try {
      const response = await axios.get('http://localhost:8099/api/classes');
      setClasses(response.data);
    } catch (error) {
      console.error('Error fetching classes:', error);
    }
  };

  // Fonction pour gérer le changement de cours sélectionné par l'utilisateur
  const handleCourseChange = (event) => {
    setSelectedCourse(event.target.value);
  };

  // Fonction pour gérer le changement de classe sélectionnée par l'utilisateur
  const handleClassChange = (event) => {
    setSelectedClass(event.target.value);
  };

  // Fonction pour gérer la soumission du formulaire d'attribution de cours à une classe
  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      // Envoi des données sélectionnées par l'utilisateur au backend
      await axios.put(`http://localhost:8099/api/teachers/${selectedCourse}/assign-class/${selectedClass}`);
      alert('Course assigned to class successfully.');
    } catch (error) {
      console.error('Error assigning course to class:', error);
      alert('An error occurred while assigning course to class.');
    }
  };

  return (
    <div className="container mt-4">
      <h2>Assign Course to Class</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="course" className="form-label">Select Course</label>
          <select
            className="form-control"
            id="course"
            value={selectedCourse}
            onChange={handleCourseChange}
            required
          >
            <option value="">Select a Course</option>
            {courses.map((course) => (
              <option key={course.id} value={course.id}>{course.nom}</option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label htmlFor="class" className="form-label">Select Class</label>
          <select
            className="form-control"
            id="class"
            value={selectedClass}
            onChange={handleClassChange}
            required
          >
            <option value="">Select a Class</option>
            {classes.map((classItem) => (
              <option key={classItem.id} value={classItem.id}>{classItem.nom}</option>
            ))}
          </select>
        </div>
        <button type="submit" className="btn btn-primary">Assign Course</button>
      </form>
    </div>
  );
};

export default AssignCourseToClass;
