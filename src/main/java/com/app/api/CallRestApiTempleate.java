package com.app.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.mapper.EmpMapper;
import com.app.mapper.Items;
import com.app.mapper.ItemsCopy;

@RestController
public class CallRestApiTempleate {

	@Autowired
	private RestTemplate restTemplate;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@RequestMapping("/callgetname")
	public String callGetName() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> newName = restTemplate.exchange("http://localhost:5641/getname", HttpMethod.GET, entity,
				String.class);

		return newName.getBody().toString();

	}

	@RequestMapping("/callgetbyone")
	public String callFindByOne(@RequestParam("callname") String name) {

		HttpHeaders httpHeaders = new HttpHeaders();

		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:5641/filter?id=" + name,
				HttpMethod.GET, entity, String.class);

		return exchange.getBody().toString();
	}

	@PostMapping("/calladditem")
	public Items cakkAddItem(@RequestBody Items items) {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Items> entity = new HttpEntity<Items>(items, httpHeaders);

		Items i = new Items();

//       ResponseEntity exchange = restTemplate.exchange("http://localhost:5641/additems",HttpMethod.POST, entity,String.class);
		ResponseEntity<Items> postForEntity = restTemplate.postForEntity("http://localhost:5641/additems", items,
				Items.class);
		;

		Items body = postForEntity.getBody();
//    System.err.println(body);
		System.err.println("!!!!!!!!!!!!!!!!!!!!!!!");
//       items=   exchange.getBody();

		return body;
	}

	@RequestMapping("/getItem")
	public ItemsCopy find() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<ItemsCopy> exchange = restTemplate.exchange("http://localhost:5641/getname", HttpMethod.GET,
				entity, ItemsCopy.class);

		ItemsCopy body = exchange.getBody();
		double price = body.getPrice();

		if (price == 0) {

			throw new Exception("invalid price");

		}
		return body;

	}

	
	@RequestMapping("/checkPrice")
	public ArrayList<ItemsCopy> findAll() throws Exception {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
//		ItemList exchange = restTemplate.getForObject("http://localhost:5641/findall",ItemList.class);
	
//				List<Employee> employees = response.getEmployees();

//		ItemList body = (ItemList) exchange.getLista();
//		Double item = body.getLista().get(1).getPrice();
		
		
//		ResponseEntity<ArrayList<Items>> exchange = restTemplate.exchange("http://localhost:5641/findall", HttpMethod.GET,
//				entity,   new ParameterizedTypeReference<List<Items>>());
		
		
		ResponseEntity<ArrayList<ItemsCopy>> rateResponse =
		        restTemplate.exchange("http://localhost:5641/getPrices",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<ItemsCopy>>() {
		            });
		
		
//		List<ItemsCopy> all=		exchange.getBody().getLista();

	
		ArrayList<ItemsCopy> body = rateResponse.getBody();
		
		for (ItemsCopy itemsCopy : body) {
			
			if (itemsCopy.getPrice()==-100) {
				
				throw new Exception("can not price less than Zero ");
				
			}
			
		}
		
		
		return body;

	}
	
	@GetMapping("/callSoapApi")
	public String callJdeveloper() {
		
		HttpHeaders httpHeaders = new HttpHeaders(); 
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String>  httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> exchange = restTemplate.exchange("http://127.0.0.1:7101/test-SoapExample-context-root/resources/model/jdeveloper" , HttpMethod.GET,httpEntity,String.class);
		
//		restTemplate.exchange(entity, responseType)
		
		return exchange.getBody();
		
	}
	
	
	
}
