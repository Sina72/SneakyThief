package controller;

import model.Map;
import model.mapElements.agents.Guard;

public class MapBuilder 
{
	public MapBuilder(int width, int height, int guards, int thiefs, int sentries, int goalno)
	{
		Map map = new Map(width, height);
		
		for(int i=0; i<guards; i++)
		{
			//map.addAgent(new Guard(guardstartcoordiante))
		}
		for(int i=0; i<thiefs; i++)
		{
			//map.addAgent(new Intruder(intruderstartcoordiante))
		}
		for(int i=0; i<sentries; i++)
		{
			//map.addAgent(new Sentry(sentrycoordiante))
		}
		for(int i=0; i<goalno; i++)
		{
			//map.addAgent(new Goal(goalcoordiante))
		}
	}
	
	public void addGuards(int no)
	{
		for(int x = 0; x<no ; x++)
		{
			
		}
	}
	
	public void addThiefs()
	{
		
	}
	
	public void addSentries()
	{
		
	}
	
	public void addGoals()
	{
		
	}

}
