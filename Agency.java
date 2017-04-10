package spies;

import java.util.ArrayList;

public class Agency implements Observer
{
    private ArrayList <Message> messBase;
    private Spy[] spies = new Spy[10];
    private final String[] spyNames = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
    private String name;
    
    public Agency(String name)
    {
	this.name = name;
	System.out.println("There was created anti corruption agency: " + this.name);
	messBase = new ArrayList<>();
    }
    
    @Override
    public void getMessage(Message message)
    {
	if ( !messBase.contains(message))
	{
	    messBase.add(message);
	System.out.println(this.name + ": The message - " + message.getInfo() + " - has been recieved");
	}
    }
    
    @Override
    public String getName()
    {
	return  name;
    }
    
    public void createSpies()
    {
	for ( int i = 0; i < spies.length; i++ )
	{
	    spies[i] = new Spy(spyNames[i], this);
	}
	System.out.println( this.name + " has ten agents:");
	for ( int i = 0; i < spies.length; i++ )
	{
	    System.out.print(spies[i].getName() + ", ");
	}
	System.out.println();
    }
    
    public void sendSpies(Observable congress)
    {
	System.out.println(this.name + " has sent spies to corruption congress");
	for ( int i = 0; i < spies.length; i++ )
	{
	    congress.addObserver(spies[i]);
	}
    }
}
