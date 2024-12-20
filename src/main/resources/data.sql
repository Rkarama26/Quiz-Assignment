INSERT INTO QUESTION (question_text, correct_answer) VALUES
('What is the capital of France?', 'Paris'),
('What is 2 + 2?', '4'),
('What is the largest planet in our solar system?', 'Jupiter'),
('Which programming language is known as JS?', 'JavaScript'),
('What is the boiling point of water in Celsius?', '100');

INSERT INTO QUESTION_OPTIONS (question_id, options) VALUES
(1, 'Paris'), (1, 'London'), (1, 'Berlin'), (1, 'Madrid'),
(2, '3'), (2, '4'), (2, '5'), (2, '6'),
(3, 'Mars'), (3, 'Earth'), (3, 'Jupiter'), (3, 'Venus'),
(4, 'Java'), (4, 'Python'), (4, 'JavaScript'), (4, 'C++'),
(5, '50'), (5, '100'), (5, '0'), (5, '150');