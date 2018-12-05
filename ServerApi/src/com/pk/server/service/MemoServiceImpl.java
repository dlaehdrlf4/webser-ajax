package com.pk.server.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.server.dao.MemoDAO;

@Service
public class MemoServiceImpl implements MemoService {

	@Autowired
	private MemoDAO memoDao;

	@Override
	public Map<String, Object> memolist(HttpServletRequest request) {
		
		//전체 데이터 개수 가져오기
		int totalCount = memoDao.totalcount();
		
		List<Map<String, Object>> list = memoDao.memolist();
		
		Map<String, Object> map = new HashMap<>();
		map.put("totalcount", totalCount);
		map.put("memos",list);
		return map;
	}

	@Override
	public Map<String, Object> memodetail(
			HttpServletRequest request) {
		//num 이라는 파라미터를 읽어서 정수로 변경
		int num = Integer.parseInt(request.getParameter("num"));
		Map<String,Object> map = memoDao.memodetail(num);
		return map;
	}
	

}
