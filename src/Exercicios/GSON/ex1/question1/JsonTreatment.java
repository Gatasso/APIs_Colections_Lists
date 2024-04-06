package Exercicios.GSON.ex1.question1;

public class JsonTreatment {
    private Item[] items;
    public Item[] getItems() {
        return items;
    }

    public static class Item {
        private VolumeInfo volumeInfo;

        public VolumeInfo getVolumeInfo() {
            return volumeInfo;
        }
    }


    public static class VolumeInfo {
        private String title;
        private String[] authors;
        private String publisher;
        private String publishedDate;

        public String getTitle() {
            return title;
        }

        public String[] getAuthors() {
            return authors;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getPublishedDate() {
            return publishedDate;
        }
    }

}
