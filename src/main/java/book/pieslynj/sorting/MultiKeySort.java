package book.pieslynj.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MultiKeySort {

	public class Employee {
		public String extension;
		public String givenname;
		public String surname;
	}

	// A comparator for Employee instances.
	public class EmployeeNameComparator implements Comparator<Employee> {

		public int compare(Employee e1, Employee e2) {
			// Compare surnames
			int ret = e1.surname.compareToIgnoreCase(e2.surname);

			if (ret == 0) { // Compare givennames if surnames are the same
				ret = e1.givenname.compareToIgnoreCase(e2.givenname);
			}
			return ret;
		}
	}

	public void sortEmployees(Employee[] employees) {
		Arrays.sort(employees, new EmployeeNameComparator());
	}

}
