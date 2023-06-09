package com.lgy.spring_15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring_15.domain.MemberVO;
import com.lgy.spring_15.domain.SampleVO;
import com.lgy.spring_15.domain.Ticket;

//import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@RestController// json 테이터로 다운로드
//@Controller //getSample.jsp를 찾음
@RequestMapping("/sample")
//@Log4j : 보안이슈
@Slf4j //로그 가독성이 좋고, 권한설정 가능
public class SampleController {
//	getSample.jsp를 찾아감
	@GetMapping(value = "/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
												  MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	
	@GetMapping(value = "/getSample2", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
//		text/plain : MINE TYPE = MediaType.TEXT_PLAIN_VALUE
		System.out.println("MiME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		
//		INFO : com.lgy.spring_15.SampleController - MiME TYPE : text/plain
		log.info("MiME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		
//		DEBUG: com.lgy.spring_15.SampleController - MiME TYPE : text/plain
//		<level value="debug" /> 설정되어있어야 출력(운영서버에서 info 로 바꾸면 수많은 로그 출력되서 안됨)
		log.debug("MiME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		
		
//		뷰가 아니고 String 출력
		return "안녕하세요";
	}
	
	
	@GetMapping(value = "/getList")
	public List<SampleVO> getList(){
//		스트림, 람다식은 프로젝스 설정에서 java compiler 1.8로 변경
		return IntStream.range(1,10).mapToObj(i->new SampleVO(i, i+"First", i+"Last"))
				.collect(Collectors.toList());
	}
	
	
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap(){
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	
//	ResponseEntity : 데이터+http 상태코드를 전달
	@GetMapping(value = "/getcheck", params = {"height","weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result= null;
		
		if (height <150) {
//			HttpStatus.BAD_GATEWAY : http 오류 상태
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
//			HttpStatus.OK : http 정상 상태
			result = ResponseEntity.status(HttpStatus.OK).body(vo);			
		}
		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid")int pid) {
		return new String[] {"category: "+cat, "productid: "+pid};
	}
	
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.debug("@# ticket ===>"+ticket);
		return ticket;
	}
	
	
	@PostMapping("/info")
//	public void convert(@RequestBody MemberVO vo) {
	public MemberVO convert(@RequestBody MemberVO vo) {
		log.debug("@# vo ===>"+vo);
		return vo;
	}
}
