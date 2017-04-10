package spies;

import java.util.ArrayList;
import java.util.Random;

public class Congress implements Observable
{
    private ArrayList<Observer> members;
    
    private String[] memberNames = new String[] { "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U","V", "W", "X", "Y", "Z" };
    
    private String name;
    
    private final String[] agenda = new String[]
	{
	"1. Expanding the ranks of corrupt.",
	"2. About something else.",
	"3. About something else.",
	"4. Methods of money laundering.",
	"5. About something else.",
	"6. About something else.",
	"7. New sources of bribes.",
	"8. About something else.",
	"9. About something else."
	};
    
    public Congress(String name)
    {
	this.name = name;
	members = new ArrayList<>();
	
	System.out.println("There was created corruption congress: " + this.name);
	
	System.out.println("At the Congress the following issues will be discussed:");
	for ( int i = 0; i < agenda.length; i++ )
	{
	    System.out.println(agenda[i]);
	}
	System.out.println();
    }
    
    @Override
    public void addObserver(Observer observer)
    {
	members.add(observer);
	System.out.println(observer.getName() + " has been added to conference");
    }
    
    @Override
    public void removeObserver(Observer observer)
    {
	if ( members.contains(observer))
	{
	    members.remove(observer);
	    System.out.println(observer.getName() + " has been removed");
	}
	System.out.println("");
    }
    
    @Override
    public void notifyObserver(Observer observer, Message message)
    {
	observer.getMessage(message);
    }
    
    public void createMembers()
    {
	System.out.println( this.name + " has sixteen members:");
	Members[] arr = new Members[memberNames.length];
	for ( int i = 0; i < arr.length; i++ )
	{
	    arr[i] = new Members(memberNames[i], this);
	    addObserver(arr[i]);
	}
	System.out.println();
	
    }
    
    public void giveInfoToMembers()
    {
	findSpy();
	for ( int i = 0; i < agenda.length; i++ )
	{
	    Message message = new Message(agenda[i]);
	    for ( Observer member : members )
	    {
		notifyObserver(member, message);
	    }
	}
    }
    
    public void findSpy()
    {
	System.out.println("\n" + this.name + " is finding spies:" + "\n");
	ArrayList <Observer> spies = new ArrayList<>();
	Random rnd = new Random();
	for ( Observer member : members )
	{
	    if ( member instanceof Spy)
	    {
		if ( rnd.nextInt(2) == 0) spies.add(member);
	    }
	}
	for ( Observer spy : spies )
	{
	    System.out.println(spy.getName() + " is a spy!");
	    removeObserver(spy);
	}
    }
    
}
