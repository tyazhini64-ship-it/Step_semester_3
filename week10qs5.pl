passed(arun, python).
passed(arun, data_structures).

passed(bala, python).
failed(bala, data_structures).

passed(charan, python).
passed(charan, data_structures).

failed(divya, python).
passed(divya, data_structures).

eligible(Student) :- 
    passed(Student, python), 
    passed(Student, data_structures).