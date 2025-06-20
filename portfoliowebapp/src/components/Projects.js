import { useEffect, useState } from "react";
import axios from "axios";

const Projects = () => {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    axios.get("https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api/projects").then((res) => setProjects(res.data));
  }, []);

  return (
    <section>
      <h2>Projects</h2>
      {projects.map((project) => (
        <div key={project.id}>
          <h4>{project.title}</h4>
          <p>{project.description}</p>
          <img src={project.snapshotUrl} alt="Snapshot" style={{ maxWidth: "300px" }} />
        </div>
      ))}
    </section>
  );
};

export default Projects;
