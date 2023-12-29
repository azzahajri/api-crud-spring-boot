Api
http://localhost:8081/classrooms/add
{
  "name": "Anglish Class"
}

http://localhost:8081/club/add

{
  "name": "Chess Club",
  "creationDate": "2023-01-01" ,
	"nsc":2
	
}
http://localhost:8081/students/add

{
  "email": "azzat@gmail.com",
  "classroom": {
    "id": 2
  }
}

http://localhost:8081/students/add

{
  "nsc": 123456,
  "email": "azza@azza.com",
  "classroom": {
    "id": 1,
    "name": "Math Class"
  },
  "clubs": [
    {
      "ref": 1,
      "creationDate": "2023-01-01"
    },
    {
      "ref": 2,
      "creationDate": "2023-02-01"
    }
  ]
}
http://localhost:8081/students/all

http://localhost:8081/students/updateStudent/4

{
  "nsc": 4,
  "email":"azza20@egmail.com",
  "classroom": {
    "id": 2,
    "name": "Updated Classroom"
  },
  "clubs": [
    {
      "ref": 3,
      "creationDate": "2023-03-01"
    },
    {
      "ref": 4,
      "creationDate": "2023-04-01"
    }
  ]
}

http://localhost:8081/students/deleteStudentById/4


http://localhost:8081/students/deleteAllStudents

