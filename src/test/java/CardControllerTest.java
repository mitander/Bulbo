package sysjm3.bulbo.bulbo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import sysjm3.bulbo.bulbo.controllers.CardController;
import sysjm3.bulbo.bulbo.controllers.WorkspaceController;
import sysjm3.bulbo.bulbo.model.Workspace;
import sysjm3.bulbo.bulbo.repositories.CardRepository;
import sysjm3.bulbo.bulbo.repositories.WorkspaceRepository;

/**
 *
 *
 * @author Christoffer Hansen
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mvc;
    
    private final Workspace ws = new Workspace("TEST_WSER");

        public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    
    @Test
    public void createWorkspace() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/workspaces")
                .content(asJsonString(ws))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists());
    }

}
