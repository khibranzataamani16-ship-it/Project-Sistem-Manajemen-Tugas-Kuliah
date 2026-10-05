package com.mycompany.project_sistemmanajementugaskuliah;

import java.util.ArrayList;
import java.util.Scanner;

interface KelolaTugas {
    void prosesTugas();
}

abstract class Tugas {
    protected String namaTugas;
    protected String mataKuliah;
    protected String deadline;
    protected String status;

    public Tugas(String namaTugas, String mataKuliah, String deadline, String status) {
        this.namaTugas = namaTugas;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
        this.status = status;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getStatus() {
        return status;
    }

    public abstract void tampilkanTugas();
}

public class Pertemuan7_PboPrak extends Tugas implements KelolaTugas {

    public Pertemuan7_PboPrak(String namaTugas, String mataKuliah, String deadline, String status) {
        super(namaTugas, mataKuliah, deadline, status);
    }

    @Override
    public void tampilkanTugas() {
        System.out.println("Nama Tugas  : " + getNamaTugas());
        System.out.println("Mata Kuliah : " + getMataKuliah());
        System.out.println("Deadline    : " + getDeadline());
        System.out.println("Status      : " + getStatus());
        System.out.println("-----------------------------");
    }

    public void tampilkanTugas(String keterangan) {
        tampilkanTugas();
        System.out.println("Keterangan  : " + keterangan);
    }

    @Override
    public void prosesTugas() {
        System.out.println("Tugas sedang diproses.");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Pertemuan7_PboPrak> daftarTugas = new ArrayList<>();

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

                Pertemuan7_PboPrak tugas = new Pertemuan7_PboPrak(
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

        Tugas tugas = new Pertemuan7_PboPrak(
                "Membuat Program Java",
                "PBO",
                "2026-10-10",
                "Sedang Dikerjakan"
        );

        tugas.tampilkanTugas();

        KelolaTugas kelola = new Pertemuan7_PboPrak(
                "Membuat Laporan",
                "PBO",
                "2026-10-11",
                "Belum Dikerjakan"
        );

        kelola.prosesTugas();

        input.close();
    }
}