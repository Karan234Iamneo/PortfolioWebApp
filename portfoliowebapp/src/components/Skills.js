import { useEffect, useState } from "react";
import axios from "axios";

const Skills = () => {
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    axios.get("https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api/skills").then((res) => setSkills(res.data));
  }, []);

  return (
    <section>
      <h2>Skills</h2>
      <ul>
        {skills.map((skill) => (
          <li key={skill.id}>{skill.name} - {skill.proficiency}</li>
        ))}
      </ul>
    </section>
  );
};

export default Skills;
