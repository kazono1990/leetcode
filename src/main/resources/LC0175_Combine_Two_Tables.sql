SELECT firstName, lastName, city, state
FROM Person LEFT JOIN Address
on Person.PersonId = Address.PersonId;
