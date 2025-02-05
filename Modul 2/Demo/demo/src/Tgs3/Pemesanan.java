package Tgs3;

public abstract class Pemesanan implements Tiket {
    protected String nama;
    protected String asal;
    protected String tujuan;
    protected double Tiket;
    protected double diskon;

    public Pemesanan(double Tiket) {
        this.nama = nama;
        this.asal = asal;
        this.tujuan = tujuan;
        this.Tiket = Tiket;
        this.diskon = diskon;
    }
}
