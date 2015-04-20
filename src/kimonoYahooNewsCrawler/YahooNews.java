package kimonoYahooNewsCrawler;

/**
 * 新聞的 (1) 抬頭 (2) 內容 (3) 發佈日期 (4) 哪家報社發佈
 * @author admin
 *
 */
public class YahooNews {
	private String title;
	private String content;
	private String date;
	private String publisher;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
}
