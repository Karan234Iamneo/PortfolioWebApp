import { useState } from "react";
import { useAuth } from "../context/AuthContext";

const Login = () => {
  const [password, setPassword] = useState("");
  const { login } = useAuth();

  const handleLogin = () => {
    if (password === "admin123") {
      login();
    } else {
      alert("Incorrect password");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input
        type="password"
        placeholder="Enter admin password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
};

export default Login;
