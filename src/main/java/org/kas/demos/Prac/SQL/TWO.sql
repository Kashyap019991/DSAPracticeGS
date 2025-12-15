. Table Flights
	{
	Flight_no,
	Flight_name,
	source,
	destination,
	departure_time,
	arrival_time
	}

	a. Write an SQL query to give flights travelling from
	Mumbai to Delhi today.

	SELECT *
    FROM Flights
    WHERE source = 'Mumbai'
      AND destination = 'Delhi'
      AND CAST(departure_time AS DATE) = CURRENT_DATE;



	b. Write an SQL query to give flight info leaving
	from Mumbai to Kolkata, via layover at Delhi.

	SELECT
      F1.Flight_no AS first_flight_no,
      F1.Flight_name AS first_flight_name,
      F1.source AS first_leg_source,
      F1.destination AS first_leg_destination,
      F2.Flight_no AS connecting_flight_no,
      F2.Flight_name AS connecting_flight_name,
      F2.source AS second_leg_source,
      F2.destination AS second_leg_destination
    FROM Flights AS F1
    INNER JOIN Flights AS F2
      ON F1.destination = F2.source
    WHERE
      F1.source = 'Mumbai'
      AND F2.destination = 'Kolkata'
      AND F1.destination = 'Delhi'
      AND F1.arrival_time < F2.departure_time;



	c. Write an SQL query to find top 3 busiest routes.

	SELECT
      source,
      destination,
      COUNT(*) AS total_flights
    FROM Flights
    GROUP BY
      source,
      destination
    ORDER BY
      total_flights DESC
    LIMIT 3;

    d. how many flight round trip which source = dest

    select count(flight_no) from Flights Goup by flight_no having source = dest;

    SELECT
      COUNT(*)
    FROM Flights
    WHERE
      source = destination;



