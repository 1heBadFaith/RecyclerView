package com.haritsdeveloper.recyclerview;

    public class ModelMovie {
        private String id;
        private String judul;
        private String subJudul;
        private String gambar;


        public ModelMovie(String id, String judul, String subJudul, String gambar) {
            this.id = id;
            this.judul = judul;
            this.subJudul = subJudul;
            this.gambar = gambar;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {

            this.id = id;
        }

        public String getJudul() {

            return judul;
        }

        public void setJudul(String judul) {

            this.judul = judul;
        }

        public String getSubJudul() {
            return subJudul;
        }

        public void setSubJudul(String subJudul) {
            this.subJudul = subJudul;
        }

        public String getGambar() {
            return gambar;
        }

        public void setGambar(String gambar) {
            this.gambar = gambar;
        }

    }
