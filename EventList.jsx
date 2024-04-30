// EventList.jsx
import  { useState, useEffect } from 'react';
import axios from 'axios';
import './EventList.css'; // Importer le fichier de styles CSS

const EventList = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8099/api/data');
        setData(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();

    return () => {
      // Nettoyage des ressources si nécessaire
    };
  }, []);

  return (
    <div className="event-list-container">
      <h2>Événements :</h2>
      <ul className="event-list">
        {data.map((event, index) => (
          <li key={index} className="event-item">
            <p className="event-name">{event.name}</p>
            <p className="event-date">Date: {event.date}</p>
            <p className="event-message">Message: {event.message}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default EventList;
