-- Create a database to store our tables:
CREATE DATABASE IF NOT EXISTS Databricks


-- Select the database to start performing operations
USE Databricks


-- Create a table based on the file provided as a mount
DROP TABLE IF EXISTS fireCalls;

CREATE TABLE IF NOT EXISTS fireCalls
USING csv
OPTIONS (
  header "true",
  path "/mnt/davis/fire-calls/fire-calls-truncated-comma.csv",
  inferSchema "true"
)


-- First data visualization query
SELECT * FROM fireCalls LIMIT 10


-- Most firecall neighborhoods
SELECT `Neighborhooods - Analysis Boundaries` as neighborhood,
  COUNT(`Neighborhooods - Analysis Boundaries`) as count
FROM FireCalls
GROUP BY `Neighborhooods - Analysis Boundaries`
ORDER BY count DESC
