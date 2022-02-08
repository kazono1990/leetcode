SELECT a.Name AS Employee
FROM Employee AS a, Employee as b
WHERE a.ManagerId = b.Id AND a.Salary > b.Salary;
