package util;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/**
 * Processo para realizar chamadas de API Rest 
 * @author ddspp/ ultradp
 *
 */
public class ExecutorRestAPI {
	
	/**
	 *Chamada post
	 * 
	 * @param p_url			URL de chamda de API
	 * @param p_body		Body de chamadas
	 * @param p_Property	Array de parametro
	 * @return retorna o resoltado da chamada em String.
	 */
	public static String Post(String p_url, String p_body, String[] p_Property) {
		String wOutputReturn ="";
		String wReadLine;
		
		try {
			URL oUrl = new URL(p_url);
			HttpURLConnection oConn = (HttpURLConnection) oUrl.openConnection();
			
			oConn.setDoOutput(true);
			oConn.setRequestMethod("POST");
			oConn.setRequestProperty("", "");
			
			for (int i = 0; i < p_Property.length; i++) {
				String[] oParameter = p_Property[i].split("\\|");
				oConn.setRequestProperty(oParameter[0], oParameter[1]);
			}
			String input = p_body;
			OutputStream os = oConn.getOutputStream();
			
			os.write(input.getBytes());
			os.flush();
			
			if(oConn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("ERROR: "+oConn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((oConn.getInputStream())));
			while((wReadLine = br.readLine()) != null) {
				wOutputReturn= wOutputReturn +wReadLine;
			}
			oConn.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return wOutputReturn;
	}
	
	/**
	 *Chamada get
	 * 
	 * @param p_url			URL de chamda de API
	 * @param p_body		Body de chamadas
	 * @param p_Property	Array de parametro
	 * @return retorna o resoltado da chamada em String.
	 */
	public static String Get(String p_url, String p_body, String[] p_Property) {
		String wOutputReturn ="";
		String wReadLine;
		
		try {
			URL oUrl = new URL(p_url);
			HttpURLConnection oConn = (HttpURLConnection) oUrl.openConnection();
			
			oConn.setDoOutput(true);
			oConn.setRequestMethod("POST");
			oConn.setRequestProperty("", "");
			
			for (int i = 0; i < p_Property.length; i++) {
				String[] oParameter = p_Property[i].split("\\|");
				oConn.setRequestProperty(oParameter[0], oParameter[1]);
			}
			
			if(oConn.getResponseCode() != 200) {
				throw new RuntimeException("ERROR: "+oConn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((oConn.getInputStream())));
			while((wReadLine = br.readLine()) != null) {
				wOutputReturn= wOutputReturn +wReadLine;
			}
			oConn.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return wOutputReturn;
	}
	
	/**
	 *Chamada delete
	 * 
	 * @param p_url			URL de chamda de API
	 * @param p_body		Body de chamadas
	 * @param p_Property	Array de parametro
	 * @return retorna o resoltado da chamada em String.
	 */
	public static String Delete(String p_url, String p_body, String[] p_Property) {
		String wOutputReturn ="";
		String wReadLine;
		
		try {
			URL oUrl = new URL(p_url);
			HttpURLConnection oConn = (HttpURLConnection) oUrl.openConnection();
			
			oConn.setDoOutput(true);
			oConn.setRequestMethod("POST");
			oConn.setRequestProperty("", "");
			
			for (int i = 0; i < p_Property.length; i++) {
				String[] oParameter = p_Property[i].split("\\|");
				oConn.setRequestProperty(oParameter[0], oParameter[1]);
			}

			if(oConn.getResponseCode() != 204) {
				throw new RuntimeException("ERROR: "+oConn.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader((oConn.getInputStream())));
			while((wReadLine = br.readLine()) != null) {
				wOutputReturn= wOutputReturn +wReadLine;
			}
			oConn.disconnect();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return wOutputReturn;
	}

}
