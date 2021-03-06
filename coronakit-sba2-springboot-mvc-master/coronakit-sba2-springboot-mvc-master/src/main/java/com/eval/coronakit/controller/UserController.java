package com.eval.coronakit.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
		
	@RequestMapping("/show-kit")
	public ModelAndView showKit() {
		List<KitDetail> kit = new ArrayList<>();
		kit.addAll(kitDetailService.getAllKitItems());
		return new ModelAndView("show-cart", "kit", kit);
	}

	@RequestMapping("/show-list")
	public ModelAndView showList() {
		ModelAndView mv = new ModelAndView("show-all-item-user");
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	
	@RequestMapping("/add-to-cart")
	public ModelAndView showKit(@RequestParam("productId") int productId, @RequestParam("pcost") int pcost) {
		
		  KitDetail kd = new KitDetail(); 
		  kd.setProductId(productId);
		  kd.setQuantity(1);
		  kd.setAmount(pcost);
		  kitDetailService.addKitItem(kd);
		 
		ModelAndView mv = new ModelAndView("show-all-item-user");
		mv.addObject("products", productService.getAllProducts());
		return mv;
	}
	
	@RequestMapping("/checkout")
	public ModelAndView checkout(@RequestParam("ckitId") int ckitId) {
		ModelAndView mv = new ModelAndView("show-summary");
		String address = coronaKitService.getKitById(ckitId).getDeliveryAddress();
		mv.addObject("address", address);
		kitDetailService.deleteKits();
		return mv;		
	}
	
	@RequestMapping("/finalize")
	public ModelAndView finalizeOrder(@RequestParam("quantity") int[] quantity, @RequestParam("deliveryAddress") String delAdd) {
		List<KitDetail> newkit = new ArrayList<>();
		newkit.addAll(kitDetailService.getAllKitItems());
		int counter=0;
		for(KitDetail item: newkit) {
			item.setQuantity(quantity[counter]);
			item.setAmount(item.getAmount()*item.getQuantity());
			counter++;
		}
			
		CoronaKit ckit = new CoronaKit();
		ckit.setDeliveryAddress(delAdd);
		ckit.setOrderDate((LocalDate.now()).toString());
		int totalAmount = 0;
		for(KitDetail item: newkit) {
			totalAmount+=item.getAmount();
		}
		ckit.setTotalAmount(totalAmount);
		coronaKitService.saveKit(ckit);
		return new ModelAndView("checkout-address", "ckit", ckit);
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteItem(@RequestParam("itemId") int itemId) {
		kitDetailService.deleteKitById(itemId);
		List<KitDetail> kit = new ArrayList<>();
		kit.addAll(kitDetailService.getAllKitItems());
		return new ModelAndView("show-cart", "kit", kit);
	}
}
