employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

promotion_eligible(Name) :-
    employee(Name, Experience, Training, Rating),
    Experience >= 5,
    Training == completed,
    Rating >= 4.