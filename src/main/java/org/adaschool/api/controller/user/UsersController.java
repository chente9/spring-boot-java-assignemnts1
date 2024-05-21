package org.adaschool.api.controller.user;

import org.adaschool.api.exception.UserNotFoundException;
import org.adaschool.api.repository.user.User;
import org.adaschool.api.service.user.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/users/")
public class UsersController {

    private final UsersService usersService;

    public UsersController(@Autowired UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        // Utilize the UserService to create the new user
        User createdUser = usersService.createUser(user);

        // Create the URI of the created resource
        URI createdUserUri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        // Return a response with status code 201 Created and the created user in the body of the response
        return ResponseEntity.created(createdUserUri).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        //Me from here
        List<User> users = usersService.getAllUsers();
        //To here
        return ResponseEntity.ok(null);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        //Me from here
        User user = usersService.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        //To here
        // Devolver una respuesta con código de estado 200 OK y el usuario en el cuerpo de la respuesta
        return ResponseEntity.ok(null);

    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        //Me from here
        User user = UsersService.updateUser(updatedUser);
          // return usersService.updateUser(updatedUser);

            //if (user != null) {
            //  return ResponseEntity.ok(user);
            //} else {
            //To here
            return ResponseEntity.ok(null);
        }


    @DeleteMapping
    public ResponseEntity<Void> deleteUser(String id) {
        //Me from here
        UsersService.deleteUser(id);
        //To here
        return ResponseEntity.ok().build();
    }
}







