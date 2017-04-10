package spies;

import java.util.ArrayList;

public class Spy implements Observer
{
    private String name;
    //private ArrayList <Message> messages;
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
    
//    @Override
//    public void notifyObserver(Observer observer, Message message)
//    {
//	observer.getMessage(message);
//	System.out.println( "Agent " + this.name + ": Message - " + message.getInfo() + " - have been sent to Agency");
//	    
//    }
//    
//    @Override
//    public void addObserver(Observer observer)
//    {
//	System.out.println(this.name + ": " + "Sorry, I can't have more observers");
//    }
//    
//    @Override
//    public void removeObserver(Observer observer)
//    {
//	if ( observer.equals(chief))
//	{
//	    chief = null;
//	    System.out.println(this.name + ": " + "Sorry, I'm not a spy already");
//	}
//	else System.out.println(this.name + ": " + "Sorry, I haven't such observer");
//    }
    
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
	    System.out.println( "Agent " + this.name + ": Message - " + message.getInfo() + " - have been sent to Agency");
	}
    }
}
