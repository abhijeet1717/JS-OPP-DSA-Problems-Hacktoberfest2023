class RemoveExtraSpace{
public static String removeSpaces(String s) {
	int n = s.length();
	int i = 0, j = -1;
	boolean spaceFound = false;
	
	// Handles leading spaces
	while (j < n - 1 && s.charAt(j + 1) == ' ') {
		j++;
	}
	
	// read all characters of original string
	while (j < n) {
		// if current characters is non-space
		if (s.charAt(j) != ' ') {
			// remove preceding spaces before dot,
			// comma & question mark
			if ((s.charAt(j) == '.' || s.charAt(j) == ',' ||
				s.charAt(j) == '?') && i - 1 >= 0 && 
				s.charAt(i - 1) == ' ') {
				s = s.substring(0, i - 1) + s.charAt(j) + s.substring(i);
				j++;
			} else {
				// copy current character at index i
				// and increment both i and j
				s = s.substring(0, i) + s.charAt(j) + s.substring(i + 1);
				i++;
				j++;
			}
			
			// set space flag to false when any
			// non-space character is found
			spaceFound = false;
		} else if (s.charAt(j) == ' ') {
			// If space is encountered for the first
			// time after a word, put one space in the
			// output and set space flag to true
			if (!spaceFound) {
				s = s.substring(0, i) + ' ' + s.substring(i + 1);
				i++;
				spaceFound = true;
			}
			j++;
		}
	}
	
	// Remove trailing spaces
	if (i <= 1) {
		s = s.substring(0, i);
	} else {
		s = s.substring(0, i - 1);
	}
	return s;
}

// Driver code
public static void main(String[] args) {
	String str = " Hello Geeks . Welcome to"
			+ " GeeksforGeeks . ";
	str = removeSpaces(str);
	System.out.println(str);
}


}
