package com.mycompany.pertemuan4_pboprak;

import java.util.ArrayList;
import java.util.Scanner;

public class Pertemuan4_PboPrak {

    private String namaTugas;
    private String mataKuliah;
    private String deadline;
    private String status;

    public Pertemuan4_PboPrak(String namaTugas, String mataKuliah, String deadline, String status) {
        this.namaTugas = namaTugas;
        this.mataKuliah = mataKuliah;
        this.deadline = deadline;
        this.status = status;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public void setNamaTugas(String namaTugas) {
        this.namaTugas = namaTugas;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status.equals("Belum Dikerjakan")
                || status.equals("Sedang Dikerjakan")
                || status.equals("Selesai")) {
            this.status = status;
        } else {
            System.out.println("Status tidak valid.");
            System.out.println("Status tidak diubah.");
        }
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

        ArrayList<Pertemuan4_PboPrak> daftarTugas = new ArrayList<>();

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

                Pertemuan4_PboPrak tugas =
                        new Pertemuan4_PboPrak(
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

        if (!daftarTugas.isEmpty()) {

            Pertemuan4_PboPrak tugas = daftarTugas.get(0);

            System.out.println();
            System.out.println("===== SIMULASI GETTER DAN SETTER =====");

            System.out.println("Data sebelum diubah:");
            System.out.println("Nama Tugas  : " + tugas.getNamaTugas());
            System.out.println("Mata Kuliah : " + tugas.getMataKuliah());
            System.out.println("Deadline    : " + tugas.getDeadline());
            System.out.println("Status      : " + tugas.getStatus());

            tugas.setNamaTugas("Tugas Pemrograman Java");
            tugas.setMataKuliah("Pemrograman Berorientasi Objek");
            tugas.setDeadline("20 September 2026");
            tugas.setStatus("Sedang Dikerjakan");

            System.out.println();
            System.out.println("Data setelah diubah:");
            System.out.println("Nama Tugas  : " + tugas.getNamaTugas());
            System.out.println("Mata Kuliah : " + tugas.getMataKuliah());
            System.out.println("Deadline    : " + tugas.getDeadline());
            System.out.println("Status      : " + tugas.getStatus());

            System.out.println();
            System.out.println("Mencoba memasukkan status yang tidak valid:");
            tugas.setStatus("Belum Mulai");

            System.out.println();
            System.out.println("Status sekarang: " + tugas.getStatus());
        }

        input.close();
    }
}