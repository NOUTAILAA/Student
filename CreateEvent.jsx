// CreateEvent.jsx
import { useState } from 'react';
import axios from 'axios';
import './CreateEvent.css'; // Fichier de styles CSS pour le formulaire

const CreateEvent = () => {
  const [eventName, setEventName] = useState('');
  const [eventDate, setEventDate] = useState('');
  const [message, setMessage] = useState(''); // Ajout de l'état pour le message
  const [loading, setLoading] = useState(false); // Ajout de l'état pour le chargement

  const handleEventNameChange = (e) => {
    setEventName(e.target.value);
  };

  const handleEventDateChange = (e) => {
    setEventDate(e.target.value);
  };

  const handleMessageChange = (e) => {
    setMessage(e.target.value);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setLoading(true); // Définir l'état de chargement sur vrai pendant la soumission

    try {
      // Envoyer les données de l'événement au backend pour création
      await axios.post('http://localhost:8099/api/events', {
        name: eventName,
        date: eventDate,
        message: message, // Ajout du message
      });
      // Réinitialiser les champs après la création de l'événement
      setEventName('');
      setEventDate('');
      setMessage('');
      alert('Événement créé avec succès!');
    } catch (error) {
      console.error('Error creating event:', error);
      alert('Erreur lors de la création de l\'événement');
    } finally {
      setLoading(false); // Définir l'état de chargement sur faux après la soumission
    }
  };

  return (
    <div className="create-event-container">
      <h2>Créer un nouvel événement :</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Nom de lévénement:</label>
          <input
            type="text"
            value={eventName}
            onChange={handleEventNameChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Date de lévénement:</label>
          <input
            type="date"
            value={eventDate}
            onChange={handleEventDateChange}
            required
          />
        </div>
        <div className="form-group">
          <label>Message:</label>
          <textarea
            value={message}
            onChange={handleMessageChange}
            rows={4}
            required
          />
        </div>
        <button type="submit" className="submit-btn" disabled={loading}>
          {loading ? 'En cours...' : 'Créer l\'événement'}
        </button>
      </form>
    </div>
  );
};

export default CreateEvent;
