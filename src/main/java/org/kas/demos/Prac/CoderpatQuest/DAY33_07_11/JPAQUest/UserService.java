package org.kas.demos.Prac.CoderpatQuest.DAY33_07_11.JPAQUest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserSubjectsDTO getUserDetailsWithSubjects(Long userId) {
        Optional<User> userOptional = userRepository.findUserWithSubjectsByUserId(userId);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Map the entity to the DTO
            List<SubjectDTO> subjectDTOs = user.getSubjects().stream()
                .map(subject -> new SubjectDTO(subject.getSubjectName(), subject.getMarks()))
                .collect(Collectors.toList());

            return new UserSubjectsDTO(user.getUserId(), user.getUsername(), subjectDTOs);
        } else {
            return null; // Or throw an exception
        }
    }
}
