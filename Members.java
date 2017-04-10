package spies;

import java.util.ArrayList;

public class Members implements Observer
{
    private String name;
    private ArrayList <Message> messages;
    private Observable congress;

    public Members(String name, Congress congress)
    {
	this.name = name;
	this.congress = congress;
	messages = new ArrayList<>();
    }
     
    @Override
    public void getMessage(Message message)
    {
	messages.add(message);
	System.out.println("Member " + this.name + " has recieved message: " + message.getInfo());
    }
    
    @Override
    public String getName()
    {
	return name;
    }
    
}
