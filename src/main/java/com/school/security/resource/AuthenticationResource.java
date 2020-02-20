package com.school.security.resource;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.school.entities.Admin;
import com.school.entities.Student;
import com.school.repository.AdminRepository;
import com.school.repository.StudentRepository;
import com.school.security.model.AuthenticationRequest;
import com.school.security.model.AuthenticationResponse;
import com.school.security.service.MyUserDetailsService;
import com.school.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping("/hello")
    public String hello() {
        return "Hello String Security";
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public List<Student> fetchAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping("/students/{id}")
    public Student getOne(@PathVariable(name = "id") Integer id) {
        return studentRepository.findById(id).get();
    }
}
