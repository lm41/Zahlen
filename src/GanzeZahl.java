
public class GanzeZahl implements ZahlMitVorzeichen {

    public static final GanzeZahl NULL = new GanzeZahl(0);
    public static final GanzeZahl EINS = new GanzeZahl(1);
    private int vorzeichen;
    private NatuerlicheZahl betrag;

    private GanzeZahl() {
    }

    public GanzeZahl(int wert) {
        if (wert > 0) {
            vorzeichen = 1;
        } else if (wert == 0) {
            vorzeichen = 0;
        } else {
            vorzeichen = -1;
        }
        betrag = new NatuerlicheZahl(wert * vorzeichen);
    }

    public GanzeZahl(NatuerlicheZahl betrag, boolean nichtNegativ) {
        // Falls diese Zahl gleich 0 ist, dann ist nicht nur
        // der Wert, sondern auch das Vorzeichen gleich 0,
        // so dass dann folgendes Produkt den Wert 0 hat.
        this(betrag.getWert() * (nichtNegativ ? 1 : -1));
    }

    public GanzeZahl(NatuerlicheZahl natZahl){
        this.betrag = natZahl;
    }

    public GanzeZahl(GanzeZahl andere){
        vorzeichen = andere.vorzeichen;
        betrag = andere.betrag;
    }

    @Override
    public boolean nichtNegativ() {
        if(vorzeichen == -1){
            return false;
        } else{
            return true;
        }
    }

    private int ermitteleVorzeichen(int wert){
        if (wert > 0) {
            vorzeichen = 1;
        } else if (wert == 0) {
            vorzeichen = 0;
        } else {
            vorzeichen = -1;
        }
        return vorzeichen;
    }

    public GanzeZahl addiere(GanzeZahl andere){
        return new GanzeZahl(this.betrag.getWert() + andere.betrag.getWert());
    }

    public GanzeZahl addiere(NatuerlicheZahl andere){
        return new GanzeZahl(this.betrag.getWert() + andere.getWert());
    }

    public GanzeZahl multipliziere(GanzeZahl andere){
        return new GanzeZahl(this.betrag.getWert() + andere.betrag.getWert());
    }

    public GanzeZahl multipliziere(NatuerlicheZahl andere){
        return new GanzeZahl(this.betrag.getWert() * andere.getWert());
    }

    public int getVorzeichen() {
        return vorzeichen;
    }

    public NatuerlicheZahl getBetrag() {
        return betrag;
    }

    public int getWert() {
        return betrag.getWert();
    }

    public GanzeZahl additivInvertierbar(){
        return new GanzeZahl(this.betrag.getWert()*-1);
    }



    public boolean equals(GanzeZahl andere){
        if (this.betrag.getWert() == andere.betrag.getWert()){
            return true;
        } else return false;
    }

    public String toString(){
        return Integer.toString(this.getWert());
    }

    public static void main(String[] args) {
        GanzeZahl n = new GanzeZahl(-5);
        n = n.addiere(new GanzeZahl(5));
        System.out.println(n);
        n = n.multipliziere(new GanzeZahl(5));
        System.out.println(n);
        System.out.println(n.getWert());
        System.out.println(n.equals(new GanzeZahl(15)));
    }


}