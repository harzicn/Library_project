/*
Create new library object
*/

Library lib = new Library();

/*
Populate new library object with some test data
and then print out the results.
*/

lib.populateCardHolderLoans();
lib.printMap();

/*
Print out the values associated with the argument
*/

lib.printMapValue("D1234");
lib.printMapValue("Peter");
lib.printMapValue("");

/*
Attempt to add a new entry that replaces an existing
entry.
Then, attempt to add a new entry that does not replace
an existing entry.
*/

lib.addMapEntry("D1236", "Dangerous Liaisons");
lib.printMapValue("D1236");
lib.addMapEntry("D1237", "Clarissa");
lib.printMapValue("D1237");

/*
Delete the entry specified by the argument
*/

lib.deleteEntry("D1237");
lib.printMapValue("D1237");

/*
Return collection of card-holders that have the
same book on loan, as specified by the argument
*/

lib.selectValues("Clarissa");
lib.selectValues("");

/*
Find out which card-holders also have videos checked
out on loan.
*/

/*
First, create a second map containing vidoe rentals 
and populate this with values.
*/

	/*
	First, create a second map containing videjo rentals 
	and populate this with values.
	*/
	lib.populateVideoLibrary();

	/*
	Second, execute method to compare the two maps and
	and return a list of card-holders common to both.
	This collection is referenced by a local variable 
	named reducedMap.
	*/
	lib.createReducedMap();

/*
Insert a new value into a collection of values associated
with a key specified by the argument.
*/

	lib.addValue("D1234", "Uncle Tom's Cabin");
	lib.printMapValue("D1234");
