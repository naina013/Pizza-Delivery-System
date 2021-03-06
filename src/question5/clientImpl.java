package question5;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class clientImpl {
	
	public void clientPost(int data,String name1, String base1, String topping1) throws Exception{
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/Lab6/rest/Pizza").build();
		System.out.println(uri.toString());
		
		HttpPost httpPost = new HttpPost(uri);
		httpPost.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
		// POST
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("id",String.valueOf(data) ));
		nameValuePairs.add(new BasicNameValuePair("name", name1));
		nameValuePairs.add(new BasicNameValuePair("base", base1));
		nameValuePairs.add(new BasicNameValuePair("topping",topping1));
		
		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		System.out.println("Sending request...");
		CloseableHttpResponse response = client.execute(httpPost);
		
		//System.out.println("Response: " + response.toString());
		
	}
	public boolean clientDelete(int data) throws Exception {
		boolean res = false;
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/Lab6/rest/Pizza/"+data).build();
		System.out.println(uri.toString());
		
		HttpDelete httpDelete = new HttpDelete(uri);
		httpDelete.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
		System.out.println("Sending DELETE request...");
		CloseableHttpResponse response = client.execute(httpDelete);
		res =true;
		System.out.println("Response: " + response.toString());
		return res;}
	
	public boolean ClientPut(int data, String name1, String base1, String topping1) throws Exception {
		boolean res =false;
		URI uri = new URIBuilder()
				.setScheme("http")
				.setHost("localhost")
				.setPort(8080)
				.setPath("/Lab6/rest/Pizza/"+data).build();
		System.out.println(uri.toString());
		
		HttpPut httpPut = new HttpPut(uri);
		httpPut.setHeader("Accept", "text/html");
		CloseableHttpClient client = HttpClients.createDefault();
		
		// PUT
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		//nameValuePairs.add(new BasicNameValuePair("id", String.valueOf(data)));
		nameValuePairs.add(new BasicNameValuePair("name", name1));
		nameValuePairs.add(new BasicNameValuePair("base", base1));
		nameValuePairs.add(new BasicNameValuePair("topping",topping1));
		
		httpPut.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		System.out.println("Sending PUT request...");
		CloseableHttpResponse response = client.execute(httpPut);
		res=true;
		
		System.out.println("Response: " + response.toString());
		return res;
	}
	public DefaultTableModel Clientget() throws URISyntaxException, ClientProtocolException, IOException {
		CloseableHttpResponse response = null;
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/Lab6/rest/Pizza").build();
			
			System.out.println(uri.toString());
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] { "ID", "Pizza Name", "Pizza Base", "Pizza Topping" });
			List<Pizza> pizzaList = new ParseModules().doParseModules(text);
			for (Pizza Pizzadata : pizzaList) {
				model.addRow(new Object[] { Pizzadata.getId(), Pizzadata.getName(), Pizzadata.getBase(), Pizzadata.getTopping() });
			}
			return model;
		} finally {
			response.close();
		}
	}
	
	public DefaultTableModel Clientgetbyid(int i) throws URISyntaxException, IOException {
		CloseableHttpResponse response = null;
		try {
			URI uri = new URIBuilder()
					.setScheme("http")
					.setHost("localhost")
					.setPort(8080)
					.setPath("/Lab6/rest/Pizza/").build();
			
			System.out.println(uri.toString());
			
			HttpGet httpGet = new HttpGet(uri);
			httpGet.setHeader("Accept", "application/xml");
			
			CloseableHttpClient httpClient = HttpClients.createDefault();
			response = httpClient.execute(httpGet);
			
			HttpEntity entity = response.getEntity();
			String text = EntityUtils.toString(entity);
			System.out.println(text);
			
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(new Object[] { "ID", "Pizza Name", "Pizza Base", "Pizza Topping" });
			List<Pizza> PizzaList = new ParseModules().doParseModules(text);
			for (Pizza pizzadata : PizzaList) {
				if(pizzadata.getId() == i) {
				model.addRow(
						new Object[] { pizzadata.getId(), pizzadata.getName(), pizzadata.getBase(), pizzadata.getTopping() });
			}
			}
			return model;
		} finally {
			response.close();
		}
		
	}
	
		
	
	

}
