package com.jewellery.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jewellery.entity.User;
import com.jewellery.service.AdminService;

public class AdminControllerTest {
	
	@Mock
    private AdminService adminService;

    @InjectMocks
    private AdminController adminController;

    @Test
    public void testUpdateVendor() throws Exception {
        // Create a mock User object for the request body
        User user = new User();
        user.setId(1);
        user.setFirstName("John Smith");
        user.setLastName(null);
        user.setAddress(null);
        user.setPassword(null);
        user.setConfirmPassword(null);
        user.setEmail(null);
        user.setPhoneNumber(null);
        user.setUsername(null);
        user.setRole(null);
        

        // Create a mock User object for the response
        User updatedUser = new User();
        updatedUser.setId(1);
        updatedUser.setName("John Doe");
        updatedUser.setEmail("john.doe@example.com");

        // Define the behavior of the adminService mock
        when(adminService.updateVendor(user)).thenReturn(updatedUser);

        // Create a mock HTTP request with the user object as the request body
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);
        MockHttpServletResponse response = new MockHttpServletResponse();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
        mockMvc.perform(MockMvcRequestBuilders.put("/updateVendor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().json(mapper.writeValueAsString(updatedUser)));

        // Verify that the adminService method was called with the expected argument
        verify(adminService).updateVendor(user);
    }

}
