import java.util.*;
import ou.*;

/**
 * A class which simulates an online library system.
 * Where card holders may check out books or other items
 * available for loan in the library.
 * As the publications are eletronic assets, card-holders
 * may take out multiple copies of the same item.
 * 
 * @author Natalie Harzic
 * @version TMA02 Question 2 Final Submission
 */

public class Library
{
   /*Question 2(ii)1 Collection Instance Variable
   An instance variable of the Map interface type
   used to reference an instance of the HashMap
   implementing class
    */
   private Map<String, Set<String>> cardHolderLoans;
   private Map<String, Set<String>> videoLoans;

   /**
    * Question 2(ii)2 Constructor
    * Library Constructor that creates an empty
    * map object of the type HashMap and assigns it to
    * the cardHolderLoans Map-type instance variable
    */
   public Library()
   {
      super();
      cardHolderLoans = new HashMap<String, Set<String>>();
   }

   //    public Map<String, Set<String>> getMap()
   //    {
   //       return this.cardHolderLoans;
   //    }

   /**
    * Question 2(ii)3 populateCardHolderLoans()
    * A public instance method to populate the cardHolderLoans
    * map with some test data: a collection of card-holder 
    * reference numbers along with its associated loan items.
    * This method takes no arguments and returns no values.
    */
   public void populateCardHolderLoans()
   {
      //create an instance of cardHolderLoans to hold the
      //values associated with each key
      cardHolderLoans = new HashMap<>();
      //create an instance of TreeSet to hold the collection
      //of values for each card holder
      Set<String> publications = new TreeSet<>();

      //add 5 values to 1st map element D1231
      publications.add("Don Quixote");
      publications.add("Gulliver's Travels");
      publications.add("Pilgrim's Progress");
      publications.add("Robinson Crusoe");
      publications.add("Tom Jones");
      cardHolderLoans.put("D1231", publications);

      //add 4 values to 2nd  map element D1232
      publications = new TreeSet<>();
      publications.add("Frankenstein");
      publications.add("Gulliver's Travels");
      publications.add("Robinson Crusoe");
      publications.add("Tom Jones");
      cardHolderLoans.put("D1232", publications);

      //add 5 values to 3rd  map element D1233
      publications = new TreeSet<>();
      publications.add("Clarissa");
      publications.add("Dangerous Liaisons");
      publications.add("Emma");
      publications.add("Frankenstein");
      publications.add("Tom Jones");
      cardHolderLoans.put("D1233", publications);

      //add 4 values to 4th  map element D1234
      publications = new TreeSet<>();
      publications.add("Clarissa");
      publications.add("Dangerous Liaisons");
      publications.add("Emma");
      publications.add("Tristram Shandy");
      cardHolderLoans.put("D1234", publications);

      //add 1 value to 5th  map element D1235
      publications = new TreeSet<>();
      publications.add("Frankenstein");
      cardHolderLoans.put("D1235", publications);

      //create a key with an empty value
      // for 6th  map element D1236   
      publications = new TreeSet<>();
      cardHolderLoans.put("D1236", publications);

   }

   /**
    * Question 2(iii) printMap()
    * A public instance method to iterate over the map and
    * print out a meaningful representation of its contents:
    * A list of each card-holder number along with its
    * associated values and a summary saying how many
    * items the card-holder has on loan.
    */
   public void printMap()
   {
      //iterate through each map element
      for(String cardHolder: cardHolderLoans.keySet())
      {
         System.out.println(cardHolder
            + " has checked out the following library item(s): ");
         //iterate through set values associated with each map element
         for(String eachLoanItem: cardHolderLoans.get(cardHolder))
         {   
            if(eachLoanItem != null)
            {
               System.out.println("- " + eachLoanItem);
            }
         }
         System.out.println("Total item(s) on loan: " 
            + cardHolderLoans.get(cardHolder).size());
         System.out.println("");
      }

   }

   /**
    * Question 2(iii) printMapValue()
    * A public instance method to print a meaningful textual
    * representation of the values associated with the 
    * key provided by the argument.
    * If no occurance of the key is found, a dialogue
    * box informs the user it is not present.
    * 
    * @param aCardHolder the key for which values are to be printed
    */
   public void printMapValue(String aCardHolder)
   {
      //print values for a key found in the map
      if(cardHolderLoans.containsKey(aCardHolder))
      {
         //copy found values to a new set
         Set<String> loanItems = cardHolderLoans.get(aCardHolder);

         //if at least one loan item is found print items
         if(cardHolderLoans.get(aCardHolder).size() > 0)
         {
            System.out.println("These are " + aCardHolder 
               + "'s loan items:");
            for(String eachLoanItem : loanItems)
            {
               System.out.println("- " + eachLoanItem);
            }
         }
         //if no assosiated values are present, inform user
         else
         {
            System.out.println(aCardHolder
               + " currently has no books on loan." );
         }
      }
      //inform user that no such key is present in the map
      else
      {
         OUDialog.alert("There is no record in the system for card-holder: " 
            + aCardHolder);
      }

   }

   /**
    * Question 2(iii) addMapEntry()
    * A public instance method to add a key and one associated
    * value provided by the method arguments.
    * Before the new key is added, performs check to 
    * discover whether the key already occurs in the map.
    * If they key already exists, the user is asked to 
    * confirm whether the existing key should be over-written
    * (by way of a confirm dialogue box) or 
    * whether the existing key should not be replaced, in 
    * which case no further action is taken.
    * If key does not exist, add new key-value pair to the map.
    * 
    * @param aCardHolderAccount the key to which a value should be added
    * @param aPublication the value which should be added to aCardHolderAccount
    */
   public void addMapEntry(String aCardHolderAccount, String aPublication)
   {
      if(cardHolderLoans.containsKey(aCardHolderAccount))
      {
         //if key exists offer option to replace value or cancel operation
         boolean addNew = OUDialog.confirm("Warning! Card-holder account "
               + aCardHolderAccount + " already appears in the system.\n\n"
               + "Select \'Yes\' to replace all publications recorded"
               + " for " + aCardHolderAccount + " with the new value.\n\n"
               + " Otherwise, select \'No\' to leave"
               + " the current record unchanged."
            );
         if(addNew)
         {
            //replace the key-value set
            //create new set to contain value and add key-value to map
            Set<String> publications = cardHolderLoans.get(aCardHolderAccount);
            publications.add(aPublication);
            cardHolderLoans.put(aCardHolderAccount, publications);
         }
         else
         {
            //user does not want to replace key-value, take no further action
         }
      }
      //if no such card holder account exists add new key-value to the map
      else
      {
         // create new set to contain value and add key-set to map  
         Set<String> publications = new TreeSet<>();
         publications.add(aPublication);
         cardHolderLoans.put(aCardHolderAccount, publications);
      }
   }

   /**
    * Question 2(iv) deleteEntry()
    * Method deleteEntry allows the librarian to remove a
    * card-holder from the list if the key provided by the 
    * argument exists. If no matching key exists,
    * take no further action.
    * 
    * @param aCardHolderAccount the key to be deleted from the map
    *
    */
   public void deleteEntry(String aCardHolderAccount)
   {
      if(cardHolderLoans.containsKey(aCardHolderAccount))
      {
         cardHolderLoans.remove(aCardHolderAccount);
      }
      else
      {
         //aCardHolderAccount is not in map, do nothing
      }
   }

   /**
    * Question 2(iv) selectValues()
    * Returns a new collection of all keys that contain
    * a value that matches the argument.
    * An instance of a String set is created to hold
    * the list of keys that satisfy the selection
    * criterion. 
    * This method will allow the librarian to discover 
    * which card-holders have checked out the publication
    * provided by the argument.
    *
    * @param  aPublication the map value that must be matched
    * @return a collection of keys, one of whose values
    *         match the argument
    */
   public Set<String> selectValues(String aPublication)
   {
      //create a new set to hold the collection of matching keys
      Set<String> results = new TreeSet<>();

      //iterate through the map keys
      for(String eachKey : cardHolderLoans.keySet())
      {
         //for each key, iterate through its associated values
         for(String eachValue : cardHolderLoans.get(eachKey))
         {
            //test for matches to the argument in each element
            if(eachValue != null && eachValue.equals(aPublication))
            {
               results.add(eachKey);
            }
         }
      }
      if(results.size() == 0)
      {
         System.out.println("This publication has not been checked out.");
      }
      return results;
   }

   /**
    * Question 2(iv) createReducedMap()
    * 
    *
    * @param  aPublication the map value that must be matched
    * @return a collection of keys, one of whose values
    *         match the argument
    */
   public Map<String, Set<String>> createReducedMap()
   {
      Map<String, Set<String>> reducedMap = new TreeMap<>();

      Set<String> reducedCardHolderLoans = cardHolderLoans.keySet();
      Set<String> videoLibraryKeys = videoLoans.keySet();
      reducedCardHolderLoans.retainAll(videoLibraryKeys);

      for(String eachCardHolder : reducedCardHolderLoans)
      {
         reducedMap.put(eachCardHolder, cardHolderLoans.get(eachCardHolder));
      }

      return reducedMap;

   }

   /**
    * Question 2(iv) addValue()
    * Inserts a new value, as specified by the arguments,
    * into the collection of values for the key also specified 
    * by the arguments. 
    * 
    * It is assumed the particular key is
    * present within the map.
    * 
    * @param aCardHolder particular key into which new value must 
    * be added
    * @param aPublication new value to be added into the collection
    * of values currently held for the argument
    * @return boolean return false if value cannot be added
    *
    */
   public boolean addValue(String aCardHolder, String aPublication)
   {

      //String aCardHolder = OUDialog.request("Please enter the card-holder number");
      //iterate through each key-value pair
      for(String eachKey : cardHolderLoans.keySet())
      {
         //check to find out whether the current key matches the selected key
         if(eachKey != null && eachKey.equals(aCardHolder))
         {
            //create copy of the values-set currently associated with this key
            Set<String> publications = new TreeSet<>(cardHolderLoans.get(eachKey));
            //add the new value to this set and put the key-value set back into the map
            publications.add(aPublication);
            cardHolderLoans.put(eachKey, publications);
            return true;
         }
      }
      return false;
   }
   
   /**
    * Question 2(ii)3 supplement to createReducedMap() method
    * A public instance method to populate the video library
    * map with some test data: a collection of card-holder 
    * reference numbers along with its associated loan items.
    * This method takes no arguments and returns no values.
    * 
    * This map represents values taken from the video library
    * part of the online library. Certain card holders have
    * not only taken out electronic books, but also online
    * video rentals.
    */
   public Map<String, Set<String>> populateVideoLibrary()
   {
      //create an instance of cardHolderLoans to hold the
      //values associated with each key
      videoLoans = new TreeMap<>();
      //create an instance of TreeSet to hold the collection
      //of values for each card holder
      Set<String> videos = new TreeSet<>();

      //add 4 values to map element D1232
      videos = new TreeSet<>();
      videos.add("Citizen Kane");
      videos.add("The Shawshank Redemption");
      videos.add("Vitigo");
      videos.add("The Godfather");
      videoLoans.put("D1232", videos);

      //add 4 values to map element D1234
      videos = new TreeSet<>();
      videos.add("Schindler's List");
      videos.add("Dangerous Liaisons");
      videos.add("To Kill a Mockingbird");
      videos.add("Star Wars");
      videoLoans.put("D1234", videos);

      //add 3 values to map element D1235
      videos = new TreeSet<>();
      videos.add("Frankenstein");
      videos.add("One Flew Over the Cuckkoo's Nest");
      videos.add("Dangerous Liaisons");
      videoLoans.put("D1235", videos);

      //add 2 values to map element D1265
      videos = new TreeSet<>();
      videos.add("Pulp Fiction");
      videos.add("Taxi Driver");
      videoLoans.put("D1265", videos);

      return videoLoans;
   }
}