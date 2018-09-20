# student-data
CRUD operations on student-data

# API end points designed-

1) /student/details - GET request to extract all student data
2) /student/details/{id} - search for a specific id

3) /student/data - POST request to store student data.

Request body format-
{
    "studentData": [
        {
            "id": 3,
            "name": "Tom"
        },
        {
            "id": 4,
            "name": "Harry"
        }
    ]
}


4) /student/data/{id} - PUT request to update student data

Request body format-
{
   "name": "Amazon"
}

5) /student/data/{id} - DELETE request to delete student

6) /student/integer-to-binary/{number} - GET request to convert decimal to binary number


