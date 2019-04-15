package com.shoppingplanner.server.controller;

import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserRepository repository;

    @Test
    public void isValidLoginTest() throws Exception {
        User user = new User("UserName", "password",0L);
        user.setUserName(user.getUserName().toLowerCase());
        BDDMockito
                .given(repository.findByUserNameAndPassword(user.getUserName(),user.getPassword()))
                .willReturn(new User(user.getUserName(), user.getPassword(), 1L));

        String expectedContent = "{\"id\":1,\"userName\":\""+ user.getUserName() +"\",\"password\":\"password\",\"accountType\":null,\"account\":null}";
        String input = "{\n" +
                "\"userName\" : \""+ user.getUserName() +"\",\n" +
                "\"password\" : \""+ user.getPassword() + "\"\n" +
                "}";

        this.mvc.perform(MockMvcRequestBuilders
                .put("/user/checklogin")
                .contentType(APPLICATION_JSON_UTF8)
                .content(input))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void createUserTest() throws Exception {
        User user = new User("UserName", "password",null);
        user.setUserName(user.getUserName().toLowerCase());

        BDDMockito
                .given(repository.save(user))
                .willReturn(new User(user.getUserName(), user.getPassword(), 1L));

        String expectedContent = "{\"id\":1,\"userName\":\""+ user.getUserName() + "\",\"password\":\"password\",\"accountType\":null,\"account\":null}";
        String input = "{\n" +
                "\"userName\" : \""+ user.getUserName() +"\",\n" +
                "\"password\" : \""+ user.getPassword() + "\"\n" +
                "}";
        this.mvc.perform(MockMvcRequestBuilders
                .post("/user/")
                .content(input)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }

    @Test
    public void setAccountForUserTest() throws Exception {
        User user = new User("UserName", "password",1L);
        user.setUserName(user.getUserName().toLowerCase());

        BDDMockito
                .given(repository.findById(1L))
                .willReturn(Optional.of(user));
        BDDMockito
                .given(repository.save(user))
                .willReturn(user);

        String expectedContent = "{\"id\":1," +
                "\"userName\":\""+ user.getUserName() +
                "\",\"password\":\"password\"," +
                "\"accountType\":null," +
                "\"account\":{\"id\":null,\"accountName\":\"pandaFamily\",\"registeredShops\":null}}";

        String input = "{\n" +
                "    \"accountName\": \"pandaFamily\",\n" +
                "    \"registeredShops\": null,\n" +
                "    \"users\": null,\n" +
                "    \"shoppingList\": null\n" +
                "}";
        this.mvc.perform(MockMvcRequestBuilders
                .put("/user/account/"+ user.getId())
                .content(input)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));

    }
}
