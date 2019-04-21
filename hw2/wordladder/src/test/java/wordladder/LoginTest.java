package wordladder;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

/**
 * SpringSecurity的用户登录模拟
 */
@RunWith(SpringRunner.class)
@SpringBootTest

@Rollback(true)// 事务自动回滚，默认是true。可以不写
public class LoginTest {


    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(springSecurity()).build();
    }


    @Test
    public void testFormLoginSuccess() throws Exception {

        // 测试登录成功
        mockMvc
                .perform(formLogin("/login").user("user").password("123456"))
                .andExpect(authenticated());
    }

    @Test
    public void testFormLoginFail() throws Exception {
        // 测试登录失败
        mockMvc
                .perform(formLogin("/login").user("user").password("invalid"))
                .andExpect(unauthenticated());
        mockMvc
                .perform(formLogin("/login").user("yxh").password("123456"))
                .andExpect(unauthenticated());
    }

    @Test
    public void testLogoutFail() throws Exception {
        // 测试退出登录
        mockMvc.perform(logout("/logout")).andExpect(unauthenticated());
    }
}