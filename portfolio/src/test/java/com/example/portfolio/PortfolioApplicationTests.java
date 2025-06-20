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
		// First insert
		CoverLetter created = new CoverLetter();
		created.setContent("Original content");

		String response = mockMvc.perform(put("/api/coverletter")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(created)))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		CoverLetter saved = objectMapper.readValue(response, CoverLetter.class);

		// Then update
		saved.setContent("Updated cover letter content");

		mockMvc.perform(put("/api/coverletter")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(saved)))
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

	@Test
	void testDeleteExperience() throws Exception {
		// Create Experience first
		Experience experience = new Experience(null, "Test Corp", "QA", "2021-2023", "Testing stuff");
		String response = mockMvc.perform(post("/api/experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(experience)))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		Experience saved = objectMapper.readValue(response, Experience.class);

		// Now delete it
		mockMvc.perform(delete("/api/experience/" + saved.getId()))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllSkills() throws Exception {
		// Add a Skill first
		Skill skill = new Skill(null, "React", "Intermediate");
		mockMvc.perform(post("/api/skills")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(skill)))
				.andExpect(status().isOk());

		// Fetch all skills
		mockMvc.perform(get("/api/skills"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").exists());
	}

	@Test
	void testGetAllExperiences() throws Exception {
		mockMvc.perform(get("/api/experience"))
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateExperience() throws Exception {
		// Create first
		Experience exp = new Experience(null, "Test Ltd", "Dev", "2021-2022", "Init desc");
		String res = mockMvc.perform(post("/api/experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(exp)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Experience saved = objectMapper.readValue(res, Experience.class);
		saved.setDescription("Updated desc");

		mockMvc.perform(put("/api/experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(saved)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.description").value("Updated desc"));
	}

	@Test
	void testUpdateSkill() throws Exception {
		Skill skill = new Skill(null, "Spring Boot", "Beginner");
		String res = mockMvc.perform(post("/api/skills")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(skill)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Skill saved = objectMapper.readValue(res, Skill.class);
		saved.setProficiency("Advanced");

		mockMvc.perform(put("/api/skills")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(saved)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.proficiency").value("Advanced"));
	}

	@Test
	void testDeleteSkill() throws Exception {
		Skill skill = new Skill(null, "NodeJS", "Intermediate");
		String res = mockMvc.perform(post("/api/skills")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(skill)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Skill saved = objectMapper.readValue(res, Skill.class);

		mockMvc.perform(delete("/api/skills/" + saved.getId()))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllProjects() throws Exception {
		mockMvc.perform(get("/api/projects"))
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateProject() throws Exception {
		Project project = new Project(null, "Old Title", "Desc", "img.jpg");
		String res = mockMvc.perform(post("/api/projects")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(project)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Project saved = objectMapper.readValue(res, Project.class);
		saved.setTitle("Updated Title");

		mockMvc.perform(put("/api/projects")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(saved)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.title").value("Updated Title"));
	}

	@Test
	void testDeleteProject() throws Exception {
		Project project = new Project(null, "Temp Project", "Desc", "img.jpg");
		String res = mockMvc.perform(post("/api/projects")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(project)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		Project saved = objectMapper.readValue(res, Project.class);

		mockMvc.perform(delete("/api/projects/" + saved.getId()))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteContactRequest() throws Exception {
		ContactRequest contact = new ContactRequest(null, "Mark", "mark@example.com", "Delete me");
		String res = mockMvc.perform(post("/api/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(contact)))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();

		ContactRequest saved = objectMapper.readValue(res, ContactRequest.class);

		mockMvc.perform(delete("/api/contact/" + saved.getId()))
				.andExpect(status().isOk());
	}

	@Test
	void testSubmitMultipleContactRequestsAndFetchAll() throws Exception {
		// Submit 2 contact requests
		ContactRequest c1 = new ContactRequest(null, "Alice", "alice@mail.com", "Interested in collaboration");
		ContactRequest c2 = new ContactRequest(null, "Bob", "bob@mail.com", "Just saying hi");

		mockMvc.perform(post("/api/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(c1)))
				.andExpect(status().isOk());

		mockMvc.perform(post("/api/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(c2)))
				.andExpect(status().isOk());

		// Retrieve all and check size >= 2
		mockMvc.perform(get("/api/contact"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(org.hamcrest.Matchers.greaterThanOrEqualTo(2)));
	}

	@Test
	void testExperienceOrderingByDuration() throws Exception {
		// ✅ Clean up before test
		mockMvc.perform(delete("/api/experience"))
				.andExpect(status().isOk());

		// ✅ Insert two experiences
		Experience exp1 = new Experience(null, "A", "Engineer", "2019-2020", "Old job");
		Experience exp2 = new Experience(null, "B", "Lead", "2022-2023", "Recent job");

		mockMvc.perform(post("/api/experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(exp1)))
				.andExpect(status().isOk());

		mockMvc.perform(post("/api/experience")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(exp2)))
				.andExpect(status().isOk());

		// ✅ Fetch and verify order (assuming repository default orders by latest)
		mockMvc.perform(get("/api/experience"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].company").value("B"))
				.andExpect(jsonPath("$[1].company").value("A"));
	}

	// ✅ Base Test
	@Test
	void contextLoads() {
	}
}
