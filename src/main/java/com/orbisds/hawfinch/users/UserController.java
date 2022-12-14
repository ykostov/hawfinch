package com.orbisds.hawfinch.users;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public void updateUser(@RequestBody User user, @PathVariable String id) {
        userService.updateUser(id, user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/langs/{langId}")
    public User enrollLangToUser(@PathVariable String userId,
                                 @PathVariable String langId) {
        return userService.enrollLangToUser(userId, langId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{userId}/position/{positionId}")
    public User enrollPositionToUser(@PathVariable String userId,
                                 @PathVariable String positionId) {
        return userService.enrollPositionToUser(userId, positionId);
    }

}
