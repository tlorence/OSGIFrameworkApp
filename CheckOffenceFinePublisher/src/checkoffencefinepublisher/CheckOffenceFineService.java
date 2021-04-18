package checkoffencefinepublisher;

public interface CheckOffenceFineService {
	
 
    public void registerCheckOffenceFine(CheckOffenceFine ob);
    
    public void unregisterCheckOffenceFine(CheckOffenceFine ob);
	
    public String getFineForOffence (int offenceId, String licenceId);


}
