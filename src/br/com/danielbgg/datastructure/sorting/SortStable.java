package br.com.danielbgg.datastructure.sorting;

import java.util.Comparator;

//What’s the complexity of making shakySort() stable? Assigning the sequence numbers takes O(n) time, but because no comparison sort can be more efficient than O(n log(n)), the asymptotic running time is not increased ( O(n + n log(n)) = O(n log(n)) ). There’s one sequence number for each element, so this approach requires O(n) additional memory.
public class SortStable {

	public class Employee {
		public String extension;
		public String givenname;
		public String surname;
		public int sequence;
	}

	public void sortEmployeesStable(Employee[] employees) {
		for (int i = 0; i < employees.length; ++i) {
			employees[i].sequence = i;
		}
		shakySort(employees, new EmployeeSequenceComparator());
	}

	// A comparator for Employee instances.
	public class EmployeeSequenceComparator implements Comparator<Employee> {

		public int compare(Employee e1, Employee e2) {
			// Compare surname first.
			int ret = e1.surname.compareToIgnoreCase(e2.surname);

			// Ensure stability
			if (ret == 0) {
				ret = e1.sequence - e2.sequence;
			}

			return ret;
		}
	}

	private void shakySort(Object[] o, Comparator c) {
	}
}
