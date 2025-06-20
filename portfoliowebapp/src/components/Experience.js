import { useEffect, useState } from "react";
import axios from "axios";

const Experience = () => {
  const [experiences, setExperiences] = useState([]);

  useEffect(() => {
    axios.get("https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api/experience").then((res) => {
      setExperiences(res.data);
    });
  }, []);

  return (
    <section>
      <h2>Experience</h2>
      {experiences.map((exp) => (
        <div key={exp.id}>
          <h4>{exp.company} - {exp.role}</h4>
          <p>{exp.duration}</p>
          <p>{exp.description}</p>
        </div>
      ))}
    </section>
  );
};

export default Experience;
