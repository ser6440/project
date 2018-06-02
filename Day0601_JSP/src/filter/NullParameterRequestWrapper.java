package filter;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class NullParameterRequestWrapper extends HttpServletRequestWrapper{
	//원래 요청이 Map 형태로 파라미터를 가지고 있음
	//파라미터를 달라고 할 때 내가 가지고 있는 Map을 주면 됨
	//파라미터는 문자열이나 문자열 배열을 가진다.
	private Map<String, String[]> parameterMap;
	
	
	public NullParameterRequestWrapper(HttpServletRequest request) {
		super(request);
		
		//기존 요청에 있는 파라미터를 조작해야함...
		//jsp페이지에서 파라미터 내놔라 라고 하면, 내가 가지는 파라미터를 줘야함
		//원래 요청 객체가 가지고 있던 파라미터도 당연히 있어야 하니까, 요청이 가지고 있는 파라미터를 생성자에 넘겨준다.
		//넘겨주는 이유가 원래 가지고 있던 파라미터 유지하기위해
		parameterMap = new HashMap<String, String[]>(request.getParameterMap());
	}
	//우리가 만든 요청객체가 원래 요청객체가 하는 일을 해야함
	//파라미터를 조작할거기 때문에 파라미터 관련 메서드를 오버라이딩 해야함
	//getParameter,getParameterNames,getParameterMap,getParameterValues 메소드 만들기
	
	//우리가 만들어야 할 메서드
	public void checkNull(String[] parameterNames) {
		//우리가 지정한 파라미터가 없으면 파라미터를 추가 해준다.
		//id와 name이라는 파라미터가 없으면 추가해주기
		
//		if(!parameterMap.containsKey("id")) {
//			//파라미터 만들어주기
//			String[] values = new String[] {"아이디 없음"};
//			parameterMap.put("id", values);
//		}
//		if(!parameterMap.containsKey("name")) {
//			String[] values = new String[] {"이름 없음"};
//			parameterMap.put("name", values);
//		}
		
		for(String pName:parameterNames) {
			if(!parameterMap.containsKey("pName")) {
				//파라미터 만들어주기
				String[] values = new String[]{"없음"};
				parameterMap.put(pName,values);
			}
		}
	}
	
	
	@Override
	public String getParameter(String name) {
		//문자열 배열에서 첫 번째 요소를 꺼내서 주면 됨
		String[] values = getParameterValues(name);
		if(values != null && values.length>0) {
			return values[0];
		}
		return null;
	}


	@Override
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}


	@Override
	public Enumeration<String> getParameterNames() {
		//map의 key set을 Enumeration으로 만들어서 반환
		return Collections.enumeration(parameterMap.keySet());
	}


	@Override
	public String[] getParameterValues(String name) {
		//우리가 가지고 있는 Map에서 해당하는 이름의 파라미터를 반환
		return parameterMap.get(name);
		
	}
	
	
	
}
