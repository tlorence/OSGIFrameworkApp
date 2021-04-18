package checkoffencefinepublisher;

import java.util.HashMap;

public class CheckOffenceFineImpl implements CheckOffenceFine {
	HashMap<String, Boolean> offenceDetails = new HashMap<>();

	public void setDetails() {
		// If offense committed boolean value is set to true
		offenceDetails.put("DL111", true);
		offenceDetails.put("DL222", true);
		offenceDetails.put("DL213", false);
		offenceDetails.put("DL112", true);
		offenceDetails.put("DL211", false);
	}

	@Override
	public String getFineForOffence(int offenceId, String licenceId) {
		double fine = 0;

		if (offenceDetails.containsKey(licenceId)) {
			if (offenceId == 1) {
				fine = 500;
			} else if (offenceId == 2) {
				fine = 1000;
			} else if (offenceId == 3) {
				fine = 2000;
			}

			if (offenceDetails.equals(true)) {
				return "The fine is: " + (fine * 1.5);
			} else {
				return "The fine is: " + fine;
			}
		} else {
			return "Licence ID does not exist. Contact local authorities.";
		}
	}
}
