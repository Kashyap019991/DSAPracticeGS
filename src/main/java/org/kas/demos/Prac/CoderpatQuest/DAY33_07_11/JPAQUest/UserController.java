package org.kas.demos.Prac.CoderpatQuest.DAY33_07_11.JPAQUest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}/subjects")
    public ResponseEntity<UserSubjectsDTO> getUserSubjects(@PathVariable Long userId) {
        UserSubjectsDTO userSubjects = userService.getUserDetailsWithSubjects(userId);
        if (userSubjects != null) {
            return ResponseEntity.ok(userSubjects);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
