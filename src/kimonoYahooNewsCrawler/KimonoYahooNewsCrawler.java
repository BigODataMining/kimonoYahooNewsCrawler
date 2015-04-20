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
			// Ū�ɶi ArrayList
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
	 * TVBS �V 2015�~4��20�� �U��12:06
	 * => TVBS\t2015�~4��20�� �U��12:06
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
	 * �� tab ���j��
	 * �s�D�� (1) ���Y (2) ���e (3) �o�G��� (4) ���a�����o�G
	 * ��p
	 * �a�_�̨�w�I�֦a+���Ӯ����@�_���_�ש�j  �W�ȳo���W��6.3�a�_�A�x�_���u�_��3�šv���P���o�ܱj�P�C �D�n�O�]���֦a�a�ΡA�_�i�X�{��j�����A�[�W�\�h�H�b�j�ӤW�Z�A���Ӽh���_�׸�۩�j�A���C�ȷ�ɦb�x�_101��89���[���ӡA�Q�n���Y���A�٦��H����í�A�o�ߵ�����ۤU�ӡC�٦����֤H��U���Ӥ������p�A�����B�����Q�O��ۼ@�P�̰ʡA�T�פ��j�A�Q�O�����٥���Ѫ�O�I �W��6.3�a�_�A�b23�Ӧ��h�̡A�ݬݳo�����Q�O�A���k�n�\�T�׶V�n�V�j�A�ݰ_�ӴN���O�C�ֶ餺�����s��A��Ӥ�V�A��Τ����O�̪��]���Y���I�����G�u���I�ѰڡI�v �٦������a�̤��ڽc��ۼ@�P�n�̡A���Y���������̥X�����x��a�O�W�A���Ӽh�P����`�C�줽�Ǹ̤@�}�y�s�A�ܦh�H���_��ë�ְ��U�ӡA�o�O�b�x�_����10�Ӫ����p�A�q�쥻���k�̨��Ӥj�W�Ҽ@�P�n�ʡA�Ѫ�O�W���O�l�B���������b�̡A�Ʀܵo�X�n�T�A��H�����x�_���_��3�šA���]���֦a�����[�W��B���Ӫ��_�׷|��j�A�]���P�����藍�u�T�šI �o�s�j���C�ȡA�a��½���ɭ�n�b�x�_101�A89���[���x�A�n�̷P���ܲ`��C�j���C�ȡG�u��ɴN�O�̡A�̱o�ܤj�A���D�������F�A�ڭ̪����ۤU�ӡA�ڭ̤]�O�b89�h�A�n�_�ӷPı���Y�w�A���ӵΪA�A���ۦ��I������A�o�ߵ���C�v �ݬݰ����W�A����O��]����n�̡A�a�_�@�}�l���\�������٨S����Pı�A��Ӧ��H�}�l�ֶ]�A�n�k����m�a�軷���ؿv���A�a�_�@�P�̡A����̪����s�M�ϫܺG�A�~�~�����q�f�[�W�Q�ϥX�ӡA���a���O�����H���M���������G��A�M��H�����ۥ����A�g�@�W�Z��\�h�H�줽�q�~�觤�U�ӡA�N�I��j�_�١C  TVBS �V 2015�~4��20�� �U��12:06 
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
 
		// �ץ��s�X
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		// �s�� ArrayList ��
		while ((inputLine = in.readLine()) != null) {
			YahooNews news = new YahooNews();
			// ���ƨ� YahooNews ��
			news.setTitle("xxxx");
			response.append(inputLine);
		}
		in.close();
 
//		
		return list;
	}
}