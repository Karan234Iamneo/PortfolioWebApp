import { render, screen, fireEvent, waitFor } from "@testing-library/react";
import { MemoryRouter } from "react-router-dom";
import App from "../App";

// Utility to render with Router context
const renderWithRouter = (ui, { route = "/" } = {}) => {
  window.history.pushState({}, "Test page", route);
  return render(ui, { wrapper: MemoryRouter });
};

test("renders Home page with Cover Letter section", async () => {
  renderWithRouter(<App />, { route: "/" });

  const heading = await screen.findByRole("heading", { name: /cover letter/i });
  expect(heading).toBeInTheDocument();
});

test("navigates to Project page", async () => {
  renderWithRouter(<App />, { route: "/project" });

  const heading = await screen.findByRole("heading", { name: /all projects/i });
  expect(heading).toBeInTheDocument();
});

test("renders Contact form and submits it", async () => {
  renderWithRouter(<App />, { route: "/contact" });

  const nameInput = screen.getByPlaceholderText(/name/i);
  const emailInput = screen.getByPlaceholderText(/email/i);
  const messageInput = screen.getByPlaceholderText(/your message/i);
  const sendButton = screen.getByRole("button", { name: /send/i });

  expect(nameInput).toBeInTheDocument();
  expect(emailInput).toBeInTheDocument();
  expect(messageInput).toBeInTheDocument();
  expect(sendButton).toBeInTheDocument();

  fireEvent.change(nameInput, { target: { value: "Test User" } });
  fireEvent.change(emailInput, { target: { value: "test@example.com" } });
  fireEvent.change(messageInput, { target: { value: "This is a test message" } });

  fireEvent.click(sendButton);

  await waitFor(() => {
    expect(screen.getByText(/thanks/i)).toBeInTheDocument();
  });
});

test("redirects to home if not logged in and tries to access settings", async () => {
  renderWithRouter(<App />, { route: "/settings" });

  // Expect to be redirected to the home page
  const heading = await screen.findByRole("heading", { name: /cover letter/i });
  expect(heading).toBeInTheDocument();
});

test("shows login and logs in successfully", async () => {
  renderWithRouter(<App />, { route: "/settings" });

  const passwordInput = await screen.findByPlaceholderText(/enter admin password/i);
  const loginButton = screen.getByRole("button", { name: /login/i });

  fireEvent.change(passwordInput, { target: { value: "admin123" } });
  fireEvent.click(loginButton);

  await waitFor(() => {
    expect(screen.getByRole("heading", { name: /admin settings/i })).toBeInTheDocument();
  });
});
