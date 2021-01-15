public class RationaleZahl implements ZahlMitVorzeichen, AdditivInvertierbar,
        MultiplikativInvertierbar {
    public static final RationaleZahl NULL = new RationaleZahl(0, 1);
    public static final RationaleZahl EINS = new RationaleZahl(1, 1);
    private GanzeZahl zaehler;
    private NatuerlicheZahl nenner;

    public RationaleZahl(int zaehler, int nenner) {
        if (nenner < 0) {
            zaehler *= -1;
            nenner *= -1;
        }
        if (nenner == 0) nenner = 1;
        this.zaehler = new GanzeZahl(zaehler);
        this.nenner = new NatuerlicheZahl(nenner);
        selbstKuerzen();
    }
    
    public RationaleZahl(GanzeZahl zaehler, NatuerlicheZahl nenner){
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public RationaleZahl(RationaleZahl andere){
        this.zaehler = andere.getZaehler();
        this.nenner = andere.getNenner();
    }

    public RationaleZahl(GanzeZahl zaehler){
        this.zaehler = zaehler;
        this.nenner = new NatuerlicheZahl(1);
    }

    public RationaleZahl(NatuerlicheZahl zaehler){
        this.zaehler = new GanzeZahl(zaehler);
        this.nenner = new NatuerlicheZahl(1);
    }

    @Override
    public RationaleZahl additivesInverses() {
        return new RationaleZahl(this.zaehler.getWert()*-1, this.nenner.getWert()*-1);
    }

    @Override
    public boolean istInvertierbar() {
        return false;
    }

    private int ggT(int a, int b) {
        if (a < 0) a *= -1;
        if (b < 0) b *= -1;
        if (b == 0) return a;
        else return ggT(b, a % b);
    }

    private void selbstKuerzen(){
        this.zaehler = new GanzeZahl(this.zaehler.getWert()*ggT(this.zaehler.getWert(),this.nenner.getWert()));
        this.nenner = new NatuerlicheZahl(this.nenner.getWert()*ggT(this.zaehler.getWert(),this.nenner.getWert()));
    }

    @Override
    public RationaleZahl multiplikativesInverses() {
        return new RationaleZahl(this.nenner.getWert(), this.zaehler.getWert());
    }

    @Override
    public boolean nichtNegativ() {
        if(this.zaehler.getVorzeichen() == -1){
            return false;
        } else{
            return true;
        }
    }

    public RationaleZahl addiere(RationaleZahl andere){
        if (this.nenner.getWert()==andere.nenner.getWert()){
            return new RationaleZahl(this.zaehler.getWert()+andere.zaehler.getWert(), this.nenner.getWert());
        }else{
            RationaleZahl a = new RationaleZahl(this.zaehler, this.nenner);
            RationaleZahl b = new RationaleZahl(andere.zaehler, andere.nenner);
            int ggt = ggT(a.nenner.getWert(), b.nenner.getWert());
            return new RationaleZahl((a.zaehler.getWert()*ggt)+(b.zaehler.getWert()*ggt), ggt);
        }

    }

    public RationaleZahl subtrahiere(RationaleZahl andere){
        if (this.nenner.getWert()==andere.nenner.getWert()){
            return new RationaleZahl(this.zaehler.getWert()-andere.zaehler.getWert(), this.nenner.getWert());
        }else{
            RationaleZahl a = new RationaleZahl(this.zaehler, this.nenner);
            RationaleZahl b = new RationaleZahl(andere.zaehler, andere.nenner);
            int ggt = ggT(a.nenner.getWert(), b.nenner.getWert());
            return new RationaleZahl((a.zaehler.getWert()*ggt)-(b.zaehler.getWert()*ggt), ggt);
        }
    }

    public RationaleZahl multipliziere(RationaleZahl andere){
        return new RationaleZahl(this.zaehler.getWert()*andere.zaehler.getWert(), this.nenner.getWert()*andere.nenner.getWert());
    }

    public RationaleZahl dividiere(RationaleZahl andere){
        RationaleZahl kerwehrt = andere.multiplikativesInverses();
        return new RationaleZahl(this.zaehler.getWert()*kerwehrt.zaehler.getWert(), this.nenner.getWert()*kerwehrt.nenner.getWert());
    }

    public String toString(){
        return this.zaehler.toString() +  "/" + this.nenner.toString();
    }



    public GanzeZahl getZaehler() {
        return zaehler;
    }

    public NatuerlicheZahl getNenner() {
        return nenner;

    }

    public static void main(String[] args) {
        RationaleZahl n = new RationaleZahl(10, 5);
        n = n.addiere(new RationaleZahl(5,6));
        System.out.println(n);
        n = n.multipliziere(new RationaleZahl(10, 50));
        System.out.println(n);
    }

}
