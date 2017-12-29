package com.et.lesson01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@SpringBootApplication
public class Demo {
	@Autowired
	JdbcTemplate jdbc;

	@RequestMapping("/demo")
	@ResponseBody
	public Map demo() {
		Map map = new HashMap();
		map.put("id", "1");
		map.put("name", "zs");
		map.put("sex", "��");
		return map;
	}

	@RequestMapping("/emp/{id}")
	@ResponseBody
	public Map query(@PathVariable int id) {
		List<Map<String, Object>> map = jdbc.queryForList("select * from emp where id =" + id);
		return map.get(0);
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}
}
