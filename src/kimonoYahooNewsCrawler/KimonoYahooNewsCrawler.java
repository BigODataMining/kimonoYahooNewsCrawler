package kimonoYahooNewsCrawler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class KimonoYahooNewsCrawler {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		KimonoYahooNewsCrawler http = new KimonoYahooNewsCrawler();

		System.out.println("Testing 1 - Send Http GET request");
		
		String url = "https://www.kimonolabs.com/api/csv/88bg0pgg?apikey=2TDrs1qpNRiDdO8W6I1eq0AYiPl7j2eQ";		
		//ArrayList<String> results = http.requestKimono(url);
		
		ArrayList<YahooNews> results = new ArrayList<YahooNews>(); 
		BufferedReader in;
		try {
			in = new BufferedReader(
			        new InputStreamReader(new FileInputStream("input_text.txt")));
			// 讀檔進 ArrayList
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		results = http.Postprocess(results);
		
		//print result
//		System.out.println(response.toString());
//		BufferedWriter out = new BufferedWriter(
//		        new OutputStreamWriter(new FileOutputStream("test.txt")));
//		out.write(response.toString());
//		out.close();

	}

	
	/**
	 * TVBS – 2015年4月20日 下午12:06
	 * => TVBS\t2015年4月20日 下午12:06
	 * @param results
	 * @return
	 */
	private ArrayList<YahooNews> Postprocess(ArrayList<YahooNews> results) {
		
		String inputLine;
		StringBuffer response = new StringBuffer();
		for (int i = 0; i < results.size(); i++) {
			
		}
		
		return null;
	}

	// HTTP GET request
	/**
	 * 
	 * @param apiUrl
	 * @return 
	 * 用 tab 分隔的
	 * 新聞的 (1) 抬頭 (2) 內容 (3) 發佈日期 (4) 哪家報社發佈
	 * 比如
	 * 地震晃到暈！盆地+高樓效應　北市震度放大  上午這場規模6.3地震，台北市「震度3級」但感受卻很強烈。 主要是因為盆地地形，震波出現放大效應，加上許多人在大樓上班，高樓層的震度跟著放大，有遊客當時在台北101的89樓觀景樓，被搖到頭昏，還有人站不穩，得扶著牆壁蹲下來。還有不少人拍下高樓內的情況，魚缸、水晶吊燈跟著劇烈晃動，幅度之大，吊燈兩邊還打到天花板！ 規模6.3地震，在23樓有多晃，看看這水晶吊燈，左右搖擺幅度越搖越大，看起來就像是遊樂園內的海盜船，轉個方向，圓形水晶燈晃的也很嚴重！民眾：「不！天啊！」 還有民眾家裡水族箱跟著劇烈搖晃，裡頭滿滿的水晃出魚缸灑到地板上，高樓層感受更深。辦公室裡一陣尖叫，很多人不斷祈禱快停下來，這是在台北內湖10樓的情況，從原本左右晃到後來大規模劇烈搖動，天花板上的板子、玻璃門都在晃，甚至發出聲響，氣象局說台北市震度3級，但因為盆地效應加上位處高樓的震度會放大，因此感受絕對不只三級！ 這群大陸遊客，地牛翻身時剛好在台北101，89樓觀景台，搖晃感受很深刻。大陸遊客：「當時就是晃，晃得很大，走道都走不了，我們直接蹲下來，我們也是在89層，搖起來感覺到頭暈，不太舒服，站著有點站不住，得扶著牆。」 看看馬路上，紅綠燈桿也明顯搖晃，地震一開始早餐店民眾還沒什麼感覺，後來有人開始快跑，要逃到空曠地方遠離建築物，地震劇烈晃，賣場裡的紅酒專區很慘，瓶瓶罐罐從貨架上被甩出來，滿地都是玻璃碎片和整片的紅色液體，清潔人員忙著打掃，週一上班日許多人到公司才剛坐下來，就碰到大震撼。  TVBS – 2015年4月20日 下午12:06 
	 * 
	 * @throws Exception
	 */
	public ArrayList<YahooNews> requestKimono(String apiUrl) throws Exception 
	{	
		ArrayList<YahooNews> list = new ArrayList<YahooNews>();	
		URL obj = new URL(apiUrl);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + apiUrl);
		System.out.println("Response Code : " + responseCode);
 
		// 修正編碼
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		// 存到 ArrayList 裡
		while ((inputLine = in.readLine()) != null) {
			YahooNews news = new YahooNews();
			// 塞資料到 YahooNews 裡
			news.setTitle("xxxx");
			response.append(inputLine);
		}
		in.close();
 
//		
		return list;
	}
}