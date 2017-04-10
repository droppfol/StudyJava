package spies;

import java.util.ArrayList;

public class Spy implements Observer
{
    private String name;
    private Observer chief;

    public Spy(String name, Agency agency)
    {
	this.name = name;
	chief = agency;
    }
     
    @Override
    public void getMessage(Message message)
    {
	notifyAgency(message);
    }
    
    @Override
    public String getName()
    {
	return name;
    }
    
    public void notifyAgency(Message message)
    {
	if ( message.getInfo().contains("1") || message.getInfo().contains("4") || message.getInfo().contains("7"))
	{
	    chief.getMessage(message);
	    System.out.println( "Agent " + this.name + ": Message - " + message.getInfo() + " - have been sent to Agency\n");
	}
    }
}
