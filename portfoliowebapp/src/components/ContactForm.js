import { useState } from "react";
import axios from "axios";

const ContactForm = () => {
  const [form, setForm] = useState({ name: "", email: "", message: "" });
  const [submitted, setSubmitted] = useState(false);

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("https://8080-ecedebeafdd329137504ebaccebeedcone.project.examly.io/api/contact", form).then(() => {
      setSubmitted(true);
      setForm({ name: "", email: "", message: "" });
    });
  };

  return (
    <section>
      <h2>Contact Me</h2>
      {submitted && <p>Thanks! We'll get back to you.</p>}
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
        <input name="email" placeholder="Email" value={form.email} onChange={handleChange} required />
        <textarea name="message" placeholder="Your message" value={form.message} onChange={handleChange} required />
        <button type="submit">Send</button>
      </form>
    </section>
  );
};

export default ContactForm;
