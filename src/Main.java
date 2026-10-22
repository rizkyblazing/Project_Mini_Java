//
// -- CLASS 1 : MODEL DATA -- //

// NIM 1003260036 -> domain Laundry, nilai dasar 32
class Layanan0036 {

    // -- 3 Atributed PRIVATE -- //
    private String namaLayanan;
    private double tarifPerKilo;  //diisi 32000 sesuai NIM
    private int  estimasiHari;


    // -- Construtor Berparameter -- //
    public Layanan0036(String namaLayanan , double tarifPerKilo , int estimasiHari) {
        setnamaLayanan(namaLayanan);
        settarifPerKilo(tarifPerKilo);
        setestimasiHari(estimasiHari);

    }

    // -- Getter -- //
    public String getnamaLayanan() { return namaLayanan; }
    public double gettarifPerKilo() { return tarifPerKilo; }
    public int getestimasiHari() { return estimasiHari; }


    // -- Setter dengan VALIDASI -- //
    public void setnamaLayanan(String namaLayanan) {
        if (namaLayanan == null || namaLayanan.trim().isEmpty()) {
            System.out.println("[ERROR]Nama layanan tidak boleh kosong!");
        } else {
            this.namaLayanan = namaLayanan;
        }
    }

    public void settarifPerKilo(double tarifPerKilo) {
        if (tarifPerKilo <= 0) {
            System.out.println("[ERROR] Tarif per kg harus leboih dari 0 !");
        } else {
            this.tarifPerKilo = tarifPerKilo;
        }
    }

    public void setestimasiHari(int estimasiHari) {
        if (estimasiHari <=0) {
            System.out.println("[ERROR] Hari harus lebih dari 0 !");
        } else {
            this.estimasiHari = estimasiHari;
        }
    }

    // -- METHOD PERHITUNGAN BIAYA BERDASARKAN BERAT -- //

    public double hitungBiaya (double beratKg) {
        return tarifPerKilo * beratKg;
    }
}

// CLASS 2 : PESANAN

class Pesanan {
        private String namaPelanggan;
        private double beratKg;
        private Layanan0036 layanan;

// -- Construtor berparameter -- //

    public Pesanan (String namaPelanggan , double beratKg , Layanan0036 layanan) {
        setnamaPelanggan(namaPelanggan);
        setberatKg(beratKg);
        this.layanan = layanan;
}

// -- GETTER -- //

    public String getnamaPelanggan() {return namaPelanggan; }
    public double getberatKg() { return beratKg; }
    public Layanan0036 getLayanan0036() {return layanan; } 




// -- Setter & VALIDASI -- //

    public void setnamaPelanggan(String namaPelanggan) {
        if (namaPelanggan == null || namaPelanggan.trim().isEmpty()) {
            System.out.println("[ERROR] Nama Pelanggan tidak boleh kosong!");
        } else{
            this.namaPelanggan = namaPelanggan;
        }
    }

    public void setberatKg(double beratKg) {
        if(beratKg <= 0) {
            System.out.println("[ERROR] berat tidak boleh dibawah 0 !");
        } else {
            this.beratKg = beratKg;
        }
    }


    // -- METHOD PERHITUNGAN Total Bayar (+ diskon jika berat >= 5KG) -- //


    public double hitungTotalBayar() {
        double biaya = layanan.hitungBiaya(beratKg);
        // -- diskon 10% jika berat >= 5KG -- //
        if (beratKg >= 5){
            biaya = biaya - (biaya * 0.10);
        }
        return biaya;
    }

// -- Method STruk -- //

public void tampilkanStruk() {
    double subTotal = layanan.hitungBiaya(beratKg);
    double total = hitungTotalBayar();
    double diskon = subTotal - total;

    System.out.println("============== STRUK LAUNDRY ==============");
    System.out.println("pelanggan          : " + namaPelanggan);
    System.out.println("Layanan            : " + layanan.getnamaLayanan());
    System.out.println("Tarif/KG           : " + layanan.gettarifPerKilo());
    System.out.println("Berat              : " + beratKg + "kg");
    System.out.println("Estimasi           : " + layanan.getestimasiHari() + " hari");
    System.out.println("SubTotal           : " + subTotal);
    if (diskon > 0) {
        System.out.println("Diskon (10%)       : Rp " + diskon);
    }
    System.out.println("Total Bayar        : Rp " + total);
    System.out.println("===========================================");
    }

}

// -- Class Main -- //

public class Main {
    public static void main(String[] ARgs) {

        // -- Object Layanan -- //

        Layanan0036 cuciKering = new Layanan0036("Cuci Kering", 32000, 2);

        // -- Object Pesanan -- // 

        Pesanan pesanan1 = new Pesanan("Rizky", 10, cuciKering);
        Pesanan pesanan2 = new Pesanan("budi", 5, cuciKering);
        
        // -- tampilkan hasil -- //

        pesanan1.tampilkanStruk();
            }
        }
