package nl.fam_krijgsman.zovoc.model;


import java.time.Year;

public class Team {
    private String naam;
    private eKlasse klasse;
    private eGeslacht geslacht;

    public Team(String naam, eKlasse klasse, eGeslacht geslacht) {
        this.setNaam(naam);
        this.klasse = klasse;
        this.geslacht = geslacht;
    }

    public String getNaam() {
        return this.naam;
    }

    public eKlasse getKlasse() {
        return this.klasse;
    }

    public eGeslacht getGeslacht() {
        return this.geslacht;
    }

    public void setKlasse(eKlasse klasse) {
        this.klasse = klasse;
    }

    public void setGeslacht(eGeslacht geslacht) {
        this.geslacht = geslacht;
    }

	// Misschien volgorde van getters aanhouden?
    public void setNaam(String naam) {
        if ((naam == null) || (naam.isEmpty())) {
            throw new IllegalArgumentException("Team naam mag niet leeg zijn");
        } else {
            this.naam = naam;
        }
    }

    public boolean magInTeam(eGeslacht geslacht, int geboorteJaar) {
		// Lid moet van geslacht zijn dat aan het team is toegekend of het moet een eGeslacht.MIX team zijn
		if (!this.geslacht.equals(geslacht) && !this.geslacht.equals(eGeslacht.MIX)) {
			// early return voorkomt onnodige executie van resterende code
			return false;
		}

		if (this.klasse.equals(eKlasse.JUNIOR)) {
            // Lid moet jonger zijn dan 18 voor junior klasse
			// DK: geen exacte datum nodig?
            int currentYear = Year.now().getValue();
            return (currentYear - geboorteJaar) < 18
        }

		return true
    }
}
