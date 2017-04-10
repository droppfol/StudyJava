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
    
    public static void act(Congress congress, Agency agency)
    {
	agency.sendSpies(congress);
	congress.giveInfoToMembers();
    }
    
    public static void runAct(String congressName, String agencyName)
    {
	act(createCongress(congressName), createAgency(agencyName));
    }

    public static void main(String[] args)
    {
	runAct("CONGRESS", "AGENCY");
    }
    
}
