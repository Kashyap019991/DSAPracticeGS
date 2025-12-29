Consider the following database schema:

1. Customer (CustomerID INT, CustomerName VARCHAR(100), City VARCHAR(100))

CustomerID is the primary key.


2. Order (OrderID INT, CustomerID INT, ProductID INT, Quantity INT)

OrderID is the primary key.

CustomerID is a foreign key referencing Customer(CustomerID).

ProductID is a foreign key referencing Product(ProductID).

Quantity represents how many units of a product were ordered.


3. Product (ProductID INT, ProductName VARCHAR(100))

ProductID is the primary key.

Write an SQL query to retrieve each customer’s city,
each product’s name, and
 the total quantity of that product ordered by the customer
 from a specific city .

SELECT
    C.City,
    P.ProductName,
    SUM(O.Quantity) AS TotalQuantityOrdered
FROM
    Customer AS C
JOIN
    "Order" AS O ON C.CustomerID = O.CustomerID
JOIN
    Product AS P ON O.ProductID = P.ProductID
WHERE
    C.City = 'SpecificCityName' -- Replace 'SpecificCityName' with the desired city
GROUP BY
    C.City,
    P.ProductName
ORDER BY
    C.City,
    P.ProductName;
