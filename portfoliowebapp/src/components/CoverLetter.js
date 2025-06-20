import { useEffect, useState } from "react";
import axios from "axios";

const CoverLetter = () => {
  const [content, setContent] = useState("");

  useEffect(() => {
    axios.get("https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api/coverletter").then((res) => {
      if (res.data) setContent(res.data.content);
    });
  }, []);

  return (
    <section>
      <h2>Cover Letter</h2>
      <p>{content}</p>
    </section>
  );
};

export default CoverLetter;
