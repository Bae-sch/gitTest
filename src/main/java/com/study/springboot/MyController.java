package com.study.springboot;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.springboot.service.BuyAndLogService;

@Controller
public class MyController {
//	@Autowired
//	IBuyTicketServeice buyTicketService;
	
	@Autowired
	BuyAndLogService buyTicketLogService;
	
	@RequestMapping("/")
	public @ResponseBody String root() throws Exception{
		return "Transaction X(1)";
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket() {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(@RequestParam("consumerId") String consumerId, 
			@RequestParam("amount") String amount, @RequestParam("error") String error, Model model) {
		
		//int nResult = buyTicketService.buy(consumerId, Integer.parseInt(amount), error);
		int nResult = buyTicketLogService.buy(consumerId, Integer.parseInt(amount), error);
		
		model.addAttribute("consumerId", consumerId);
		model.addAttribute("amount", amount);
		
		if(nResult==1) {
			return "buy_ticket_end";
		} else {
			return "buy_ticket_error";
		}
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Map<String, Object> jsonTest(@RequestBody Map<String, Object> param, Model mv) {
		System.out.println(param);
		param.get("consumerId");
		mv.addAttribute("result", param);
		return param;
	}
}
