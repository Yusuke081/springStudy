package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
}

