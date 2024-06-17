package com.example.fullstackapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api_ex")
public class WebController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/data_ex")
    public Response submitData(@RequestBody Request request) {
        User user = new User();
        user.setName(request.getName());
        userRepository.save(user);
        return new Response("Data submitted successfully");
    }

    private static class Request {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private static class Response {
        private String message;

        public Response(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
