package org.jspiders.springmvcdemo1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    List<Store> storeList = new ArrayList<>();
    {
        storeList.add(new Store("TABLE", 1500.25, 1700.50));
        storeList.add(new Store("IRON", 1000.25, 900.50));
        storeList.add(new Store("AC", 15000.25, 17000.50));
    }
    @GetMapping("/")
    public String getMessage(){
        return "welcome";
    }

    @GetMapping("/aboutus")
    public String getStoreInfo(Model model){
        model.addAttribute("records", storeList);
        return "aboutus";
    }

    //this method will show product form
    @GetMapping("/addproduct")
    public String getProductForm(Model model){
        model.addAttribute("store", new Store());
        return "productForm";
    }

    //this method will add new object into list
    @PostMapping("/saveproduct")
    public String insertProduct(Store store){
    storeList.add(store);
    return "redirect:/aboutus";
    }

    @GetMapping("/portfolio")
    public String getPortfolio(Model model){
        List<Project> projectList = new ArrayList<Project>();
        projectList.add(new Project(1, "ECOMMERCE", "SPRING"));
        projectList.add(new Project(2, "STATIC", "SPRING"));
        projectList.add(new Project(3, "DYNAMIC", "SPRING"));

        model.addAttribute("projects",projectList);
        return "portfolio";
    }
}



