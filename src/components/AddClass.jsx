import React, { useState, useEffect } from 'react';
import axios from 'axios';

function AddClass() {
  const [nom, setNom] = useState('');
  const [message, setMessage] = useState('');
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

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // Envoie des données du formulaire au backend
      await axios.post('http://localhost:8099/api/classes', {
        nom: nom
      });
      // Affiche un message de succès
      setMessage('La classe a été ajoutée avec succès.');
      // Réinitialise le formulaire
      setNom('');
    } catch (error) {
      console.error('Erreur lors de l\'ajout de la classe :', error);
      // Affiche un message d'erreur
      setMessage('Une erreur s\'est produite lors de l\'ajout de la classe.');
    }
  };

  return (
    <div className="container">
      <h2>Ajouter une classe</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="nom" className="form-label">Nom de la classe</label>
          <input
            type="text"
            className="form-control"
            id="nom"
            value={nom}
            onChange={(e) => setNom(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">Ajouter</button>
      </form>
      {message && <div className="mt-3">{message}</div>}

      <div className="mt-4">
        <h3>Liste des classes</h3>
        <ul>
          {classes.map((classe) => (
            <li key={classe.id}>{classe.nom}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default AddClass;
