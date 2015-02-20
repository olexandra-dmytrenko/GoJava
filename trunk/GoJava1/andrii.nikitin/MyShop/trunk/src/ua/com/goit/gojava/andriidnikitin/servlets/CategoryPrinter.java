package ua.com.goit.gojava.andriidnikitin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalog;
import ua.com.goit.gojava.andriidnikitin.service.GoodCatalogImpl;

public class CategoryPrinter extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    public CategoryPrinter() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();   
    	printCategories(null, out, GoodCatalogImpl.getInstance(), request);
     }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	PrintWriter out = response.getWriter();   
    	Enumeration<String> paramNames = request.getParameterNames(); 
    	if (paramNames.hasMoreElements()){    		
    		Integer id = Integer.parseInt(paramNames.nextElement());
    		GoodCatalog catalog = GoodCatalogImpl.getInstance();
    	   	List<GoodType> list = catalog.getGoodTypesFromRoot();
    	   	GoodType calledType = null;
    	   	for (GoodType type: list) {
    	   		if (id.equals(type.getId())) {
    	   			calledType = type;
    	   		}
    	   	}
    	   	printCategories(calledType, out, catalog, request);	
    	}
    	   	
    } 
    private void printCategories(GoodType root, PrintWriter out, GoodCatalog catalog,
    		HttpServletRequest request){
    	if (catalog.hasChildren(root)){
	    	//out.println("<head><link href=\"css/navbar.css\" rel=\"stylesheet\" type=\"text/css\"/></head>");
	    	out.println("<table>\n<form action=\"" + request.getContextPath() + "/print-categories\"" + 
	    			" method=\"post\">");
	    	out.println("<ul id=\"navbar\">\n");
		   	List<GoodType> list = catalog.getChildren(root);
		   	for (GoodType type: list) { //TODO: redo - returns XML with data; JS builds table  	
		   		String name =  type.getName();
		   		Integer id = type.getId();
		   		out.println("    <li><input type=\"submit\"  name=\"" + id + "\" value=\"" + name + "\">");
		   	}   
		   	out.println("</ul>\n");  		   
	    	out.println("</form></table>\n");
    	}
    	else {
    		String radiobutton = "<input type=\"radio\" name=\"radio-good\" value=\"";
    		out.println("<table><ul>");
    	   	for (Good good: catalog.getGoodsInType(root)){  
    	   		String name = good.getName();  
    	   		out.println("<li>" + name + radiobutton + name + "\"></li>" );    	   		
    	   	}
    		out.println("<input type=\"submit\">");
    	   	out.println("</ul></table>");
    		
    	}
    }	
   
 }