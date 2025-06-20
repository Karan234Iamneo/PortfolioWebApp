package com.example.portfolio;

import com.example.portfolio.entity.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PortfolioApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    // ✅ Test: Cover Letter - GET
    @Test
    void testGetCoverLetters() throws Exception {
        mockMvc.perform(get("/api/coverletter"))
                .andExpect(status().isOk());
    }

    // ✅ Test: Cover Letter - PUT
    @Test
    void testUpdateCoverLetter() throws Exception {
        CoverLetter letter = new CoverLetter(1L, "Updated cover letter content");
        mockMvc.perform(put("/api/coverletter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(letter)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Updated cover letter content"));
    }

    // ✅ Test: Experience - POST
    @Test
    void testAddExperience() throws Exception {
        Experience experience = new Experience(null, "ABC Corp", "Developer", "2020-2022", "Worked on backend");
        mockMvc.perform(post("/api/experience")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(experience)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.company").value("ABC Corp"));
    }

    // ✅ Test: Skill - POST
    @Test
    void testAddSkill() throws Exception {
        Skill skill = new Skill(null, "Java", "Expert");
        mockMvc.perform(post("/api/skills")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(skill)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Java"));
    }

    // ✅ Test: Project - POST
    @Test
    void testAddProject() throws Exception {
        Project project = new Project(null, "Portfolio Site", "React + Spring Boot", "http://image.com/snap.jpg");
        mockMvc.perform(post("/api/projects")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Portfolio Site"));
    }

    // ✅ Test: Contact Request - POST
    @Test
    void testSubmitContactRequest() throws Exception {
        ContactRequest request = new ContactRequest(null, "Jane", "jane@example.com", "Looking to collaborate");
        mockMvc.perform(post("/api/contact")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("jane@example.com"));
    }

    // ✅ Test: Contact Request - GET
    @Test
    void testGetAllContactRequests() throws Exception {
        mockMvc.perform(get("/api/contact"))
                .andExpect(status().isOk());
    }

    // ✅ Base Test
    @Test
    void contextLoads() {
    }
}
