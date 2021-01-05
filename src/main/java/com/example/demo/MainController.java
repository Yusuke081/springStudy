package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;

@Controller
public class MainController{
//@RequestMapping("/")
//public ModelAndView index(ModelAndView mv) {
//mv.addObject("name","鈴木Java五郎");
//mv.setViewName("index");
//return mv;
//}
@RequestMapping(value="/", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
mv.addObject("name", "名前がここに入ります");
mv.addObject("age", "年齢がここに入ります");
mv.addObject("height", "身長がここに入ります");
mv.addObject("from", "出身地がここに入ります");
mv.setViewName("index");
return mv;
}

@RequestMapping("/test")
public ModelAndView test(ModelAndView mv) {
mv.addObject("name","鈴木test五");
mv.setViewName("index");
return mv;
}
@RequestMapping(value="/", method=RequestMethod.POST)
public ModelAndView indexPost(ModelAndView mv, @RequestParam("nameVal")String name,
@RequestParam("ageVal")int age, @RequestParam("heightVal")String height,
@RequestParam("fromVal")String from){
System.out.println(from);
mv.addObject("name", name);
age -= 3;
mv.addObject("age", age);
mv.addObject("height", height);
mv.addObject("from", from);
mv.setViewName("index");
return mv;
}

@RequestMapping(value="/day20", method=RequestMethod.GET)
public ModelAndView day20Get(ModelAndView mv) {
mv.addObject("nam", "階乗の計算をします" );
mv.setViewName("day20");
return mv;
}

@RequestMapping(value="/day20", method=RequestMethod.POST)
public ModelAndView day20Post(ModelAndView mv, @RequestParam("namVal")int nam){
System.out.println(nam);
int ans = 1;
for(int i = 1; i <= nam; i++) {
    ans *= i;
}
mv.addObject("nam", nam + "の階乗は" + ans + "です");
mv.setViewName("day20");
return mv;
}

@RequestMapping(value="/day21",method=RequestMethod.GET)
public ModelAndView day21get(ModelAndView mv) {
	mv.addObject("suzuki", 0);
	mv.setViewName("day21");
	return mv;
}
@RequestMapping(value="/day21", method=RequestMethod.POST)
public ModelAndView day21post(ModelAndView mv) {
	mv.addObject("suzuki", "こんにちは");
	mv.setViewName("day21");
	return mv;
}

@RequestMapping("/day21_{prime}")
public ModelAndView day21_2(@PathVariable int prime, ModelAndView mv) {
	if(prime == 1) {
		mv.addObject("prime", prime + "は素数ではありません...");
	}else if(prime == 2) {
		mv.addObject("prime", prime + "は素数です！");
	}else{
		for(int i = 2; i < prime; i++) {
			if(prime % i == 0) {
				mv.addObject("prime", prime + "は素数ではありません...");
				break;
			}else {
				mv.addObject("prime", prime + "は素数です！");
			}
		}
	}
	mv.setViewName("day21_2");
	return mv;
}

@RequestMapping(value="/day22")
public ModelAndView indexPost(ModelAndView mv) {
	ArrayList<String[]>customers = new ArrayList<String[]>();
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性"});
	customers.add(new String[] {"鈴木Java五郎","24歳","男性"});
	customers.add(new String[] {"高橋CSS子","29歳","女性"});
	mv.addObject("customers",customers);
	mv.setViewName("day22");
	return mv;
}
}

