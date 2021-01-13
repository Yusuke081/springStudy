package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

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
	customers.add(new String[] {"佐藤HTML太郎","35歳","男性","東京"});
	customers.add(new String[] {"鈴木Java五郎","24歳","男性","大阪"});
	customers.add(new String[] {"高橋CSS子","29歳","女性","京都"});
	customers.add(new String[] {"高橋php","50歳","女性","北海道"});
	customers.add(new String[] {"高橋python","19歳","女性","京都"});
	mv.addObject("customers",customers);
	mv.setViewName("day22");
	return mv;
}

@RequestMapping(value="/application" ,method=RequestMethod.GET)
public ModelAndView applicationget(ModelAndView mv) {
	List<String> area = new ArrayList<String>();
	area.add("北海道");
	area.add("東北");
	area.add("関東");
	area.add("信越");
	area.add("北陸");
	area.add("東海");
	area.add("近畿");
	area.add("中国");
	area.add("四国");
	area.add("九州");
	area.add("沖縄");
	mv.addObject("area",area);
	mv.setViewName("application");
	return mv;
}

@RequestMapping(value="/application", method=RequestMethod.POST)
public ModelAndView applicationpost(ModelAndView mv, 
		@RequestParam("myAddress")String myAddress, 
		@RequestParam("shippingAddress")String shippingAddress, 
		@RequestParam("size")int size,
		@RequestParam("weight")int weight){
	System.out.println(myAddress);
	System.out.println(shippingAddress);	
	System.out.println(size);
	System.out.println(weight);
	
	int myAdd = Calculation(myAddress);
	int sipAdd = Calculation(shippingAddress);
	int num = myAdd - sipAdd;
	int sub = Math.abs(num);
	System.out.println(sub + "sub");
	int totalCost = Cost(size, weight, sub);
	
	List<String> area = new ArrayList<String>();
	area.add("北海道");
	area.add("東北");
	area.add("関東");
	area.add("信越");
	area.add("北陸");
	area.add("東海");
	area.add("近畿");
	area.add("中国");
	area.add("四国");
	area.add("九州");
	area.add("沖縄");
	mv.addObject("area",area);
	
	mv.addObject("cost", "送料は" + totalCost + "円です。");
	mv.setViewName("application");
	return mv;
	

}

private static int Calculation(String addres){
	System.out.println(addres);
	int areaNum = 0;
	if(addres.equals("北海道")) {
		areaNum += 1;
	}else if(addres.equals("東北")) {
		areaNum += 2;
	}else if(addres.equals("関東")) {
		areaNum += 3;
	}else if(addres.equals("信越")) {
		areaNum += 4;
	}else if(addres.equals("北陸")) {
		areaNum += 5;
	}else if(addres.equals("東海")) {
		areaNum += 6;
	}else if(addres.equals("近畿")) {
		areaNum += 7;
	}else if(addres.equals("中国")) {
		areaNum += 8;
	}else if(addres.equals("四国")) {
		areaNum += 9;
	}else if(addres.equals("九州")) {
		areaNum += 10;
	}else if(addres.equals("沖縄")) {
		areaNum += 11;
	}
	System.out.println(areaNum);
	
	
	return areaNum;
}
private static int Cost(int size, int weight, int sub) {
	int sizeCost = size*120;
	int weightCost = 0;
	int areaCost = 0;
	
	if(sub <= 2) {
		areaCost += 800;
	}else if(sub <= 4) {
		areaCost += 1000;
	}else if(sub <= 6) {
		areaCost += 1200;
	}else if(sub <= 8) {
		areaCost += 1400;
	}else if(sub <= 10) {
		areaCost += 1600;
	}else if(sub <= 11) {
		areaCost += 1800;
	}
	
	if(weight == 1) {
		weightCost += 0;
	}else if(weight == 2) {
		weightCost += 500;
	}else if(weight == 3) {
		weightCost+= 1000;
	}
	
	int totalCost = sizeCost + weightCost + areaCost;
	return totalCost;
}

@Autowired
UserDataRepository repository;

@RequestMapping(value="/day23", method = RequestMethod.GET)
public ModelAndView day23Get(ModelAndView mv) {
	List<UserData> customers = repository.findAll();
	mv.addObject("customers", customers);
	mv.setViewName("day23");
	return mv;
}

@RequestMapping(value="/day23", method = RequestMethod.POST)
public ModelAndView day23post(@ModelAttribute("formModel") UserData userData, ModelAndView mv) {
    repository.saveAndFlush(userData);
    return new ModelAndView("redirect:/day23");
}


@Autowired
ChatDataRepository ChatRepository;

@RequestMapping(value="/board", method = RequestMethod.GET)
public ModelAndView boardGet(ModelAndView mv) {
	List<ChatData> customers = ChatRepository.findAll();	
	mv.addObject("customers", customers);
	mv.setViewName("board");
	return mv;
}

@RequestMapping(value="/board", method = RequestMethod.POST)
public ModelAndView boardpost(@ModelAttribute("formModel")ChatData chatData, ModelAndView mv) {
	ChatRepository.saveAndFlush(chatData);
	return new ModelAndView("redirect:/board");	
}
  

}

