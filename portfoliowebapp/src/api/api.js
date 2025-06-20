import axios from "axios";

const api = axios.create({
  baseURL: "https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api", // Change if your backend runs elsewhere
  headers: {
    "Content-Type": "application/json"
  },
  withCredentials: true // if you’re using cookies for auth
});

/* ---------------------- COVER LETTER ---------------------- */

export const getCoverLetter = () => api.get("/coverletter");
export const updateCoverLetter = (data) => api.put("/coverletter", data);

/* ---------------------- EXPERIENCE ------------------------ */

export const getExperiences = () => api.get("/experience");
export const addExperience = (data) => api.post("/experience", data);
export const updateExperience = (data) => api.put("/experience", data);
export const deleteExperience = (id) => api.delete(`/experience/${id}`);

/* ---------------------- SKILLS ---------------------------- */

export const getSkills = () => api.get("/skills");
export const addSkill = (data) => api.post("/skills", data);
export const updateSkill = (data) => api.put("/skills", data);
export const deleteSkill = (id) => api.delete(`/skills/${id}`);

/* ---------------------- PROJECTS -------------------------- */

export const getProjects = () => api.get("/projects");
export const addProject = (data) => api.post("/projects", data);
export const updateProject = (data) => api.put("/projects", data);
export const deleteProject = (id) => api.delete(`/projects/${id}`);

/* ---------------------- CONTACT --------------------------- */

export const submitContactRequest = (data) => api.post("/contact", data);
export const getContactRequests = () => api.get("/contact");
export const deleteContactRequest = (id) => api.delete(`/contact/${id}`);

export default api;
