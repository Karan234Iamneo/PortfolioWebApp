import { useAuth } from "../context/AuthContext";
import CoverLetter from "../components/CoverLetter";
import Experience from "../components/Experience";
import Skills from "../components/Skills";
import Projects from "../components/Projects";

const Settings = () => {
  const { logout } = useAuth();

  return (
    <div className="container">
      <h1>Admin Settings</h1>
      <button onClick={logout}>Logout</button>
      <h2>Edit Cover Letter</h2>
      <CoverLetter />
      <h2>Edit Experience</h2>
      <Experience />
      <h2>Edit Skills</h2>
      <Skills />
      <h2>Edit Projects</h2>
      <Projects />
    </div>
  );
};

export default Settings;
