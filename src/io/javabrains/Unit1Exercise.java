package io.javabrains;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.javabrains.Person.NameSort;
import io.javabrains.Person.PrintList;

public class Unit1Exercise 
{

	public static void main( String[] args ) 
	{
		List<Person> people = Arrays.asList(
						new Person( "Charles", "Dickens", 60 ),
						new Person( "Lewis", "Carroll", 42 ),
						new Person( "Thomas", "Carlyle", 51 ),
						new Person( "Charlotte", "Bronte", 45 ),
						new Person( "Matthew", "Arnold", 39 )
						);
	
		// Step 1: Sort list by last name
		
		// Compare two given strings find if they should be swapped
		NameSort<Person> sort = ( String name1, String name2, List<Person> list, int position ) -> 
		{
			if ( name1.compareTo( name2 ) > 0 )
			{
				// Swap name1 and name2
				Collections.swap( list, position, position + 1 );
			}
		};
		
		// Simple bubble sort using lambda variables
		for ( int i = 0; i < people.size(); i++ )
		{
			for ( int j = 1; j < people.size() - i; j++ )
			{
				sort.sortTwoStrings( people.get( j - 1 ).getLastName(), people.get( j ).getLastName(), people, j - 1 ); 
			}
		}
		
		// Step 2: Create a method that prints all elements in the list
		
		PrintList printer = ( List<Person> list, String beginsWith ) ->
		{
			// Iterate through the list and print every person
			for ( Person p : list )
			{
				System.out.println( p );
			}
		};
		
		System.out.println( "Printing all people in the list\n" );
		printer.print( people, "" );
		
		// Step 3: Create a method that prints all the people that have a last name beginning with C
		
		PrintList printerBeginsWith = ( List<Person> list, String beginsWith ) ->
		{
			for ( Person p : list )
			{
				// Only print names that begin with our provided parameter
				if ( p.getLastName().startsWith( beginsWith ) )
					System.out.println( p );
			}
		};
		
		System.out.println( "\nPrinting all people whose last name begins with \"C\"\n" );
		printerBeginsWith.print( people, "C" );
	}
}
