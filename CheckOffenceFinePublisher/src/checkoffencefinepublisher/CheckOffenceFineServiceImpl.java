package checkoffencefinepublisher;

import java.util.ArrayList;
import java.util.List;

public class CheckOffenceFineServiceImpl implements CheckOffenceFineService {

	private List<CheckOffenceFine> offences = new ArrayList<>();

	@Override
	public void registerCheckOffenceFine(CheckOffenceFine ob) {
		// TODO Auto-generated method stub
		offences.add(ob);
	}

	@Override
	public void unregisterCheckOffenceFine(CheckOffenceFine ob) {
		// TODO Auto-generated method stub
		offences.remove(ob);
	}

	@Override
	public String getFineForOffence(int offenceId, String licenceId) {
		String status = null;
		// TODO Auto-generated method stub
		for (int i = 0; i < offences.size(); i++) {
			CheckOffenceFine ob = (CheckOffenceFine) offences.get(i);

			status = ob.getFineForOffence(offenceId, licenceId);

		}
		return status;
	}

}
