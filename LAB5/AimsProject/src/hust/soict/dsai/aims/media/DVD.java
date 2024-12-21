package hust.soict.dsai.aims.media;

public class DVD extends Disc implements Playable {
    private static int nbDVDTungNM = 0;

    public DVD(String title) {
        super();
        setTitle(title);
        nbDVDTungNM++;
        setId(nbDVDTungNM);
    }

    public DVD(String title, float cost) {
        super(title, cost);
    }

    public DVD(String title, String category, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
	}

    public DVD(String director, String title, String category, float cost) {
        this(title, category, cost);
        setDirector(director);
	}

    public DVD(String title, String category, float cost, int length, String director) {
       super(title, category, cost, length, director);
       //setLength(length);
    }

    public void play() {
        System.out.println("Plying DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public int compareTo(Media o) {
        // So sánh tiêu đề trước
        int titleCompare = getTitle().compareTo(o.getTitle());
        if (titleCompare != 0) return titleCompare;

        // So sánh giá nếu tiêu đề bằng nhau
        int priceCompare = Double.compare(getCost(), o.getCost());
        if (priceCompare != 0) return priceCompare;

        // So sánh thể loại khi tiêu đề và giá bằng nhau
        return getCategory().compareTo(o.getCategory());
    }

}
