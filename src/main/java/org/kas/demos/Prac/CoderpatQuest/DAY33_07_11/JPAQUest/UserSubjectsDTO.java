package org.kas.demos.Prac.CoderpatQuest.DAY33_07_11.JPAQUest;

import java.util.List;

public class UserSubjectsDTO {
    private Long userId;
    private String username;
    private List<SubjectDTO> subjects;

    // Constructor, getters, and setters
    public UserSubjectsDTO(Long userId, String username, List<SubjectDTO> subjects) {
        this.userId = userId;
        this.username = username;
        this.subjects = subjects;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public List<SubjectDTO> getSubjects() { return subjects; }
    public void setSubjects(List<SubjectDTO> subjects) { this.subjects = subjects; }
}

// You might also need a DTO for subjects if you want to be more selective, 
// but using the entity directly here is an option.
// Or define a SubjectDTO with just name and marks.
public class SubjectDTO {
    private String subjectName;
    private int marks;

    // Getters and setters
    public String getSubjectName() { return subjectName; }
    public void setSubjectName(String subjectName) { this.subjectName = subjectName; }
    public int getMarks() { return marks; }
    public void setMarks(int marks) { this.marks = marks; }
}
