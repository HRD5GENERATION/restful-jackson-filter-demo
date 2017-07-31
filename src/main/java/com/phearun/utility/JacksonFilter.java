package com.phearun.utility;

import java.util.Collection;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * 
 * @author Phearun
 *
 */
public class JacksonFilter{
	
	/**
	 * 
	 * @param beanFilters
	 * @param obj
	 * @return
	 */
	public static MappingJacksonValue filterOut(Collection<JacksonBeanFilter> beanFilters, Object obj) {
		
		SimpleFilterProvider filters = new SimpleFilterProvider();
		for(JacksonBeanFilter bFilter: beanFilters){
			filters.addFilter(bFilter.getId(), SimpleBeanPropertyFilter.filterOutAllExcept(bFilter.getFields()));
		}
		MappingJacksonValue mapping = new MappingJacksonValue(obj);
		mapping.setFilters(filters);

		return mapping;
	}
}

