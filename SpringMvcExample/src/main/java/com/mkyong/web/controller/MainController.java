package com.mkyong.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.web.domain.ExpedienteBean;
import com.mkyong.web.domain.Requisito;
import com.mkyong.web.domain.Tag;


@Controller
public class MainController {

	List<Tag> data = new ArrayList<Tag>();

	MainController() {
		// init data for testing
		data.add(new Tag(1, "ruby"));
		data.add(new Tag(2, "rails"));
		data.add(new Tag(3, "c / c++"));
		data.add(new Tag(4, ".net"));
		data.add(new Tag(5, "python"));
		data.add(new Tag(6, "java"));
		data.add(new Tag(7, "javascript"));
		data.add(new Tag(8, "jscript"));

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("example");
		return model;

	}

	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Tag> getTags(@RequestParam String tagName) {

		return simulateSearchResult(tagName);

	}

	private List<Tag> simulateSearchResult(String tagName) {

		List<Tag> result = new ArrayList<Tag>();

		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
	
	
	@RequestMapping(value = "/expedi", method = RequestMethod.POST)
	public String expedi(@RequestBody ExpedienteBean search) {

		List<Requisito> listaDetail = new ArrayList<Requisito>();
		
		ExpedienteBean bean = new ExpedienteBean();
		bean.setCodTramite("0001");
		bean.setDescTramite("CORTA DESCRIP 1");
		
		Requisito beanDetail = new Requisito();
		beanDetail.setCodRequisito("999");
		beanDetail.setDescRequisito("descripcion requisito 1");
		listaDetail.add(beanDetail);
		
		Requisito beanDetail2 = new Requisito();
		beanDetail2.setCodRequisito("998");
		beanDetail2.setDescRequisito("descripcion requisito 2");
		listaDetail.add(beanDetail2);
		
		bean.setRequisito(listaDetail);
		
		
		
		for (Requisito requisito : bean.getRequisito()) {
			System.out.println(requisito.getCodRequisito()); 
			System.out.println(requisito.getDescRequisito());
		}
		
		
		
		
		
		
		
		
		return "welcome";
	}

	public void generarReporte(){
		//Connection connection = null;
		JRDataSource vacio = new JREmptyDataSource(1);
		try {
			 String reportName = "Refrendo.pdf";
			 
			 
			InputStream input1 = new FileInputStream(new File("D:\\proyecto\\classic.jasper"));
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("codDerivado","2154");

			JasperPrint print = JasperFillManager.fillReport(input1, parameters, vacio);


			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName)); // your output goes here
			
			exporter.exportReport();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
