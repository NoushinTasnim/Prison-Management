package parole;

public class ParoleInfos {
	
	public String parId;
	public String parNm; 
	public String parDob;
	public String parHgt;
	public String parBg;
	public String parGen; 
	public String parCrm;
	public String parEnt;
	public String parCell;
	public String parSt;
	public String parEnd;

	public ParoleInfos() {
		// TODO Auto-generated constructor stub
		this.parId = new String();
		this.parNm = new String();
		this.parDob = new String();
		this.parHgt = new String();
		this.parBg = new String();
		this.parGen = new String();
		this.parCrm = new String();
		this.parCell = new String();
		this.parEnt = new String();
		this.parSt = new String();
		this.parEnd = new String();
	}
	
	public void setParId(String priN)
	{
		this.parId = (priN);
	}
	
	public String getParId()
	{
		return parId;
	}

	public void setParNm(String priN)
	{
		this.parNm = (priN);
	}
	
	public String getParNm()
	{
		return parNm;
	}
	public void setParDob(String priN)
	{
		this.parDob = (priN);
	}
	
	public String getParDob()
	{
		return parDob;
	}
	
	public void setParHgt(String priN)
	{
		this.parHgt = (priN);
	}
	
	public String getParHgt()
	{
		return parHgt;
	}
	
		
	public void setParGen(String priD)
	{
		this.parGen = (priD);
	}
	
	public String getParGen()
	{
		return parGen;
	}
	public void setParBg(String priN)
	{
		this.parBg = (priN);
	}
	
	public String getParBg()
	{
		return parBg;
	}	
	
	public void setParCrm(String priN)
	{
		this.parCrm = (priN);
	}
	
	public String getParCrm()
	{
		return parCrm;
	}
	
	public void setParCell(String priN)
	{
		this.parCell = (priN);
	}
	public String getParCell()
	{
		return parCell;
	}
	public void setParEnt(String priN)
	{
		this.parEnt = (priN);
	}
	
	
	public String getParEnt()
	{
		return parEnt;
	}
		
	public void setParSt(String priD)
	{
		this.parSt = (priD);
	}

	public String getParSt()
	{
		return parSt;
	}
	
	public void setParEn(String priD)
	{
		this.parEnd = (priD);
	}
	
	public String getParEn()
	{
		return parEnd;
	}
}
