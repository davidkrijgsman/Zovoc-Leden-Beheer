package nl.fam_krijgsman.zovoc.model;

import java.time.Year;

public class Lid {
    private String achterNaam, voorNaam, tussenVoegsel;
    private Email email;
    private TelefoonNummer telefoonNummer;
    private Team team;
    private int geboorteJaar;
    private eGeslacht geslacht;

    public Lid(String achterNaam, String voorNaam, String tussenVoegsel, String telefoonNummer, String email, Integer geboorteJaar, eGeslacht geslacht) {
        this.setAchterNaam(achterNaam);
        this.setVoorNaam(voorNaam);
        this.tussenVoegsel = tussenVoegsel;
        this.setTelefoonNummer(telefoonNummer);
        this.setEmail(email);
        this.geboorteJaar = geboorteJaar;
        this.setGeslacht(geslacht);
    }

    public String getAchterNaam() {
        return this.achterNaam;
    }

    public String getVoorNaam() {
        return this.voorNaam;
    }

    public String getTussenVoegsel() {
        return this.tussenVoegsel;
    }

    public String getTelefoonNummer() {
        return this.telefoonNummer.getTelefoonNummer();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    public Team getTeam() {
        return this.team;
    }

    public int getGeboorteJaar() {
        return this.geboorteJaar;
    }

    public void setTeam(Team team) {
        if (team == null) {
            this.team = null;
            return;
        }
        if (team.magInTeam(this.geslacht, this.geboorteJaar)) {
            this.team = team;
        } else {
            throw new IllegalArgumentException("Geen valide team voor dit lid");
        }
    }

    public void setAchterNaam(String achterNaam) {
		// Deze check wordt in verschillende setters gedaan, utility functie van maken?
        if ((achterNaam == null) || (achterNaam.isEmpty())) {
            throw new IllegalArgumentException("Achternaam mag niet leeg zijn");
        }
        this.achterNaam = achterNaam;
    }

    public void setVoorNaam(String voorNaam) {
        if ((voorNaam == null) || (voorNaam.isEmpty())) {
            throw new IllegalArgumentException("Voornaam mag niet leeg zijn");
        }
        this.voorNaam = voorNaam;
    }

    public void setTussenVoegsel(String tussenVoegsel) {
        this.tussenVoegsel = tussenVoegsel;
    }

    public void setTelefoonNummer(String telefoonNummer) {
		// Is deze check echt nodig? Kun je niet altijd nieuwe instantie maken als telefoonNummer != null ipv setTelefoonNummer?
        if ((this.telefoonNummer != null) && (telefoonNummer != null)) {
            this.telefoonNummer.setTelefoonNummer(telefoonNummer);
        } else if ((this.telefoonNummer == null) && (telefoonNummer != null)) {
            this.telefoonNummer = new TelefoonNummer(telefoonNummer);
        } else {
            this.telefoonNummer = null;
        }
    }

    public void setEmail(String email) {
		// Zie opmerking bij setTelefoonNummer
        if ((this.email != null) && (email != null)) {
            this.email.setEmail(email);
        } else if ((this.email == null) && (email != null)) {
            this.email = new Email(email);
        } else {
            this.email = null;
        }
    }

    public void setGeboorteJaar(int geboorteJaar) {
        // geboorte jaar moet kleiner zijn dan huidige datum
        int currentYear = Year.now().getValue();
        if (currentYear > geboorteJaar) {
            this.geboorteJaar = geboorteJaar;
        } else {
            throw new IllegalArgumentException("Geboortejaar moet voor huidige jaar liggen");
        }
    }

    public eGeslacht getGeslacht() {
        return this.geslacht;
    }

    public void setGeslacht(eGeslacht geslacht) {
        if (geslacht.equals(eGeslacht.MIX)) {
            throw new IllegalArgumentException("Een persoon kan geen mix geslacht hebben.");
        }
        this.geslacht = geslacht;
    }
}
