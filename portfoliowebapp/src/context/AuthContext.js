import React, { createContext, useContext, useEffect, useState } from "react";
import Cookies from "js-cookie";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  useEffect(() => {
    const loggedIn = Cookies.get("isLoggedIn") === "true";
    setIsAuthenticated(loggedIn);
  }, []);

  const login = () => {
    Cookies.set("isLoggedIn", "true");
    setIsAuthenticated(true);
  };

  const logout = () => {
    Cookies.remove("isLoggedIn");
    setIsAuthenticated(false);
  };

  return (
    <AuthContext.Provider value={{ isAuthenticated, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

export const useAuth = () => useContext(AuthContext);
