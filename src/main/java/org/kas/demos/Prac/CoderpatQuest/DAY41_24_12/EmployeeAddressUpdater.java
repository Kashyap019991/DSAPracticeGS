package org.kas.demos.Prac.CoderpatQuest.DAY41_24_12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeAddressUpdater {

    // A mock AddressService implementation for testing purposes
    static class MockAddressService implements AddressService {
        private final Map<Long, Address> addressMap;

        public MockAddressService() {
            addressMap = new HashMap<>();
            addressMap.put(1L, new Address("New York", "Main St", "USA"));
            addressMap.put(2L, new Address("London", "Baker St", "UK"));
            addressMap.put(3L, new Address("Tokyo", "Shibuya Crossing", "Japan"));
        }

        @Override
        public Address getAddressByEmployeeId(Long empId) {
            // Simulate fetching from an external service
            return addressMap.get(empId);
        }
    }

    /**
     * Updates employees in a map with their addresses fetched from an external service
     * and returns a list of the updated employee objects.
     *
     * @param employeesMap The map of employees (ID -> Employee object).
     * @param addressService The service to fetch addresses.
     * @return A list of updated employee objects with addresses populated.
     */
    public List<Employee> updateEmployeesWithAddresses(
            Map<Long, Employee> employeesMap,
            AddressService addressService) {

        List<Employee> updatedEmpList = employeesMap.values().stream().
                map(employee -> {
                    Address currAddr = addressService.getAddressByEmployeeId(employee.getId());
                    employee.setAddress(currAddr);
                    return employee;
                })
                .collect(Collectors.toUnmodifiableList());
        return updatedEmpList;
    }

    // Main method to demonstrate the solution
    public static void main(String[] args) {
        // 1. Setup initial employee data
        Map<Long, Employee> employees = new HashMap<>();
        employees.put(1L, new Employee(1L, "Alice"));
        employees.put(2L, new Employee(2L, "Bob"));
        employees.put(3L, new Employee(3L, "Charlie"));

        // 2. Initialize the mock service
        MockAddressService service = new MockAddressService();

        // 3. Create the updater instance and run the logic
        EmployeeAddressUpdater updater = new EmployeeAddressUpdater();
        List<Employee> updatedEmployees = updater.updateEmployeesWithAddresses(employees, service);

        // 4. Print the result
        System.out.println("Updated Employee List:");
        updatedEmployees.forEach(System.out::println);
    }
}
