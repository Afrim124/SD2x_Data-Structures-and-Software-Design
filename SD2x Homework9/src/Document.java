import java.util.Date;


public abstract class Document {

	private String title;
	private String author;
	private Date date;
	protected PublishingLocation addressData = new PublishingLocation();
	

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author=author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public String getCity() {
		return addressData.getCity();
	}
	
	public String getState() {
		return addressData.getState();
	}
	
	public String getPostCode() {
		return addressData.getPostCode();
	}
	public boolean sameAuthor(Document document) {
		return this.author.equals(document.author);
	}

	public int compareDates(Document document) {
		return this.date.compareTo(document.date);
	}
	
	public int compareWithGeneralDate(Date date) {
		return this.date.compareTo(date);
	}

	public Document() {
		super();
	}

}