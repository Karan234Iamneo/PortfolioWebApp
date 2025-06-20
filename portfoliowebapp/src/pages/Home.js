import CoverLetter from "../components/CoverLetter";
import Experience from "../components/Experience";
import Skills from "../components/Skills";
import Projects from "../components/Projects";

const Home = () => {
  return (
    <div className="container">
      <h1>Welcome to My Portfolio</h1>
      <CoverLetter />
      <Experience />
      <Skills />
      <Projects />
    </div>
  );
};

export default Home;
