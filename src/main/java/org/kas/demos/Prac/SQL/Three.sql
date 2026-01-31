You have a table called scores
The table looks like <student_id,date_of_exam,subject_id,score>
Find the highest score that any student has achieved in the last 1 year.
In case there is a clash, use the candidate who scored the highest first


SELECT
  student_id,
  date_of_exam,
  subject_id,
  score
FROM
  scores
WHERE
  date_of_exam >= DATE('now', '-1 year')
ORDER BY
  score DESC,
  date_of_exam ASC
LIMIT 1;
