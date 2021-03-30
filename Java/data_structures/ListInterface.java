package data_structures;

public interface ListInterface {

	/**
	 * Task: adds a new entry to the end of the list
	 * 
	 * @param newEntry the object to be added as a new entry
	 * @return true if the addition is successful; of false if not
	 */
	public boolean add(Object newEntry);

	public boolean add(int newPosition, Object newEntry);

	public Object remove(int givenPosition);

	public void clear();

	public boolean replace(int givenPosition, Object newEntry);

	public Object getEntry(int givenPosition);

	public boolean contains(Object anEntry);

	public int getLength();

	public boolean isEmpty();

	public boolean isFull();

	public void display();
}
