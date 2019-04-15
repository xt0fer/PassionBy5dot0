package com.shoppingplanner.server.service;

import com.shoppingplanner.server.ServerappApplicationTests;
import com.shoppingplanner.server.model.Account;
import com.shoppingplanner.server.model.User;
import com.shoppingplanner.server.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServerappApplicationTests.class)
public class UserServiceTest {
    @MockBean
    private UserRepository repository;

    private UserService service;

    @Before
    public void setup(){
        this.service = new UserService(repository);
    }

    @Test
    public void isValidLoginTest() throws Exception {
        User user = new User("UserName", "password",null);
        user.setUserName(user.getUserName().toLowerCase());
        BDDMockito
                .given(repository.findByUserNameAndPassword(user.getUserName(),user.getPassword()))
                .willReturn(new User(user.getUserName(), user.getPassword(), 1L));

        User returnedUser = service.isValidLogin(user);
        Assert.assertEquals(returnedUser.getId().longValue(), 1L);

    }

    @Test
    public void createUserTest() throws Exception {
        User user = new User("UserName", "password",null);
        user.setUserName(user.getUserName().toLowerCase());

        BDDMockito
                .given(repository.save(user))
                .willReturn(new User(user.getUserName(), user.getPassword(), 1L));

        User returnedUser = service.createUser(user);
        Assert.assertEquals(returnedUser.getId().longValue(), 1L);

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

        Account account = new Account();
        account.setAccountName("pandaFamily");

        User returnedUser = service.setAccount(1L, account);
        Assert.assertEquals(returnedUser.getId().longValue(), 1L);
        Assert.assertEquals(returnedUser.getAccount().getAccountName(), account.getAccountName());


    }

}
