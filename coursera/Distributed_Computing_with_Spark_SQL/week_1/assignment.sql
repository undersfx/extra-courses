-- Create the table based on the file provided
CREATE TABLE IF NOT EXISTS fireIncidents
USING csv
OPTIONS (
  header "true",
  path "/mnt/davis/fire-incidents/fire-incidents-2016.csv",
  inferSchema "true"
)

-- Question 1
-- Return the first 10 lines of the data. On the Coursera platform, input the result to the following question:
-- What is the first value for "Incident Number"?
SELECT * FROM fireIncidents LIMIT 10

-- Question 2
-- Return all incidents that occurred on Conor's birthday in 2016. For those of you who forgot his birthday, it's April 4th. On the Coursera platform, input the result to the following question:
-- What is the first value for "Incident Number" on April 4th, 2016?
SELECT * FROM fireIncidents WHERE `Incident Date` = '04/04/2016'

-- Question 3
-- Return all incidents that occurred on Conor's or Brooke's birthday. For those of you who forgot her birthday too, it's 9/27.
-- Is the first fire call in this table on Brooke or Conor's birthday?
SELECT * FROM fireIncidents WHERE `Incident Date` like '04/04/%' or `Incident Date` like '09/27/%'

-- Question 4
-- Return all incidents on either Conor or Brooke's birthday where the Station Area is greater than 20.
-- What is the "Station Area" for the first fire call in this table?
SELECT * FROM fireIncidents WHERE (`Incident Date` like '04/04/%' or `Incident Date` like '09/27/%') AND `Station Area` > 20

-- Question 5
-- Count the incidents on Conor's birthday.
-- How many incidents were on Conor's birthday in 2016?
SELECT COUNT(1) FROM fireIncidents WHERE `Incident Date` = '04/04/2016'

-- Question 6
-- Return the total counts by Ignition Cause. Be sure to return the field Ignition Cause as well.
-- How many fire calls had an "Ignition Cause" of "4 act of nature"?
SELECT `Ignition Cause`, COUNT(1) FROM fireIncidents GROUP BY `Ignition Cause`

-- Question 7
-- Return the total counts by Ignition Cause sorted in ascending order.
-- What is the most common "Ignition Cause"? (Put the entire string)
SELECT `Ignition Cause`, COUNT(1) as total FROM fireIncidents GROUP BY `Ignition Cause` ORDER BY total DESC

-- Question 8
-- Create the table fireCalls if it doesn't already exist. The path is as follows: /mnt/davis/fire-calls/fire-calls-truncated-comma.csv
-- Join the two tables on Battalion by performing an inner join.
-- Count the total incidents from the two tables joined on Battalion.
-- What is the total incidents from the two joined tables?
CREATE TABLE IF NOT EXISTS fireCalls
USING csv
OPTIONS (
  header "true",
  path "/mnt/davis/fire-calls/fire-calls-truncated-comma.csv",
  inferSchema "true"
)

SELECT COUNT(1) FROM fireIncidents as fi INNER JOIN fireCalls as fc ON fi.Battalion = fc.Battalion
