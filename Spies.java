package spies;

public class Spies
{
    public static Congress createCongress(String congressName)
    {
	Congress congress = new Congress(congressName);
	congress.createMembers();
	return congress;
    }
    
    public static Agency createAgency(String agencyName)
    {
	Agency agency = new Agency(agencyName);
	agency.createSpies();
	return agency;
    }
    
    public static void process(Congress congress, Agency agency)
    {
	agency.sendSpies(congress);
	congress.giveInfoToMembers();
    }
    
    public static void run()
    {
	process(createCongress("CONGRESS"), createAgency("AGENCY"));
    }

    public static void main(String[] args)
    {
	run();
    }
    
}
