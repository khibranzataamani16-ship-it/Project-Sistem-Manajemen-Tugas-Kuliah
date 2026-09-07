import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemenTugasKuliah2 {

    String namaTugas;
    String mataKuliah;
    String deadline;
    String status;

    public SistemManajemenTugasKuliah2(String namaTugas, String mataKuliah, String deadline, String status) {
        this.namaTugas = namaTugas;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
        this.status = status;
    }

    public void tampilkanTugas() {
        System.out.println("Nama Tugas  : " + namaTugas);
        System.out.println("Mata Kuliah : " + mataKuliah);
        System.out.println("Deadline    : " + deadline);
        System.out.println("Status      : " + status);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<SistemManajemenTugasKuliah2> daftarTugas = new ArrayList<>();

        int pilihan;

        do {
            System.out.println();
            System.out.println("================================");
            System.out.println("   SISTEM MANAJEMEN TUGAS KULIAH");
            System.out.println("================================");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Lihat Data Tugas");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu : ");

            pilihan = input.nextInt();
            input.nextLine();

            if (pilihan == 1) {

                System.out.println();
                System.out.println("===== TAMBAH TUGAS =====");

                System.out.print("Nama Tugas  : ");
                String namaTugas = input.nextLine();

                System.out.print("Mata Kuliah : ");
                String mataKuliah = input.nextLine();

                System.out.print("Deadline    : ");
                String deadline = input.nextLine();

                System.out.println();
                System.out.println("Pilih Status:");
                System.out.println("1. Belum Dikerjakan");
                System.out.println("2. Sedang Dikerjakan");
                System.out.println("3. Selesai");
                System.out.print("Pilihan     : ");

                int pilihanStatus = input.nextInt();
                input.nextLine();

                String status;

                if (pilihanStatus == 1) {
                    status = "Belum Dikerjakan";
                } else if (pilihanStatus == 2) {
                    status = "Sedang Dikerjakan";
                } else if (pilihanStatus == 3) {
                    status = "Selesai";
                } else {
                    status = "Belum Dikerjakan";
                }

                SistemManajemenTugasKuliah2 tugas =
                        new SistemManajemenTugasKuliah2(
                                namaTugas,
                                mataKuliah,
                                deadline,
                                status
                        );

                daftarTugas.add(tugas);

                System.out.println();
                System.out.println("Tugas berhasil ditambahkan.");

            } else if (pilihan == 2) {

                System.out.println();
                System.out.println("===== DATA TUGAS KULIAH =====");

                if (daftarTugas.isEmpty()) {
                    System.out.println("Belum ada data tugas.");
                } else {

                    for (int i = 0; i < daftarTugas.size(); i++) {
                        System.out.println();
                        System.out.println("Tugas ke-" + (i + 1));
                        daftarTugas.get(i).tampilkanTugas();
                    }
                }

            } else if (pilihan == 3) {

                System.out.println();
                System.out.println("Program selesai. Terima kasih.");

            } else {

                System.out.println();
                System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 3);

        input.close();
    }
}