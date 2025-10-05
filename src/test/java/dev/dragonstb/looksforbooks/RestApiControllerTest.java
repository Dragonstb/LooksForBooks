package dev.dragonstb.looksforbooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dragonstb.looksforbooks.projections.AuthorProjection;
import dev.dragonstb.looksforbooks.repositories.AuthorRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Dragonstb
 */
@WebMvcTest(RestApiController.class)
public class RestApiControllerTest {

    private static final String AUTHOR_1_FIRSTNAME = "John";
    private static final String AUTHOR_1_LASTNAME = "One";
    private static final String AUTHOR_1_AID = "abc123";
    private static final String AUTHOR_2_FIRSTNAME = "Jane";
    private static final String AUTHOR_2_LASTNAME = "Two";
    private static final String AUTHOR_2_AID = "abc456";

    @MockitoBean
    private AuthorRepository repo;

    private AuthorProjection author1;

    private AuthorProjection author2;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private List<AuthorProjection> authors;

    public RestApiControllerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        author1 = new MockAuthorProjection(AUTHOR_1_FIRSTNAME, AUTHOR_1_LASTNAME, AUTHOR_1_AID);
        author2 = new MockAuthorProjection(AUTHOR_2_FIRSTNAME, AUTHOR_2_LASTNAME, AUTHOR_2_AID);
        authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        // TODO: update test, as return has been changed from List<AuthorProjection> to Page<AuthorProjection>
        String expected = objectMapper.writeValueAsString(authors);
        when( repo.getAllNamesOnly() ).thenReturn(authors);
        RequestBuilder request = get("/rest/authors").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    @Test
    public void testGetAllAuthorsWithCypherDSL() throws Exception {
        String expected = objectMapper.writeValueAsString(authors);
        when( repo.findAll(CypherDslStatements.getAllAuthorsButNamesOnly(), AuthorProjection.class) ).thenReturn(authors);
        RequestBuilder request = get("/rest/authors-with-cdsl").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andReturn();
    }

    /**
     * When using Mockito for mocking the AuthorProjections, you have mocks in a mock (the mocked AuthorProjections
     * in the mocked date repository. This causes the automatic type conversion to fail. Using these real
     * implementation of AuthorRepository solves this problem.
     */
    class MockAuthorProjection implements AuthorProjection {
        private final String firstName;
        private final String lastName;
        private final String aid;

        public MockAuthorProjection(String firstName, String lastName, String aid) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.aid = aid;
        }

        @Override
        public String getFirstName() {
            return firstName;
        }

        @Override
        public String getLastName() {
            return lastName;
        }

        @Override
        public String getAid() {
            return aid;
        }

    }
}
