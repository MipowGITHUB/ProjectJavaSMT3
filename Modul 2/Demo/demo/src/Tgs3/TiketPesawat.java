package Tgs3;

public class TiketPesawat extends Pemesanan {

    public TiketPesawat(info info){
        super(info.tiket());
    }

    @Override
    public double hitungBiayaTiket(){
        return Tiket - (Tiket * (diskon / 100));
    }

    @Override
    public double Diskon(){
        return Tiket * (diskon / 100);
    }

    @Override
    public void tampilkanInformasi(){
        System.out.println("Nama Penumpang : "+ nama);
        System.out.println("Asal : "+ asal);
        System.out.println("Tujuan : "+ tujuan);
        System.out.println("Harga Tiket : "+ Tiket);
        System.out.println("diskon : "+ diskon + "%");
        System.out.println("Biaya Tiket Setelah disk : "+ hitungBiayaTiket());
        System.out.println("Jumlah disk : "+ Diskon());
    }
}

