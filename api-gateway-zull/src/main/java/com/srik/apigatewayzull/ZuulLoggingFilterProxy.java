package com.srik.apigatewayzull;


import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.RequestContentDataExtractor;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/*
 * Api gateway can be used as centralised action layer before calling any 
 * micro services so in order to demonstrate it 
 * we use a simple logging for gateway layer simlarly we can add authentication or authorization via this layer
 */
@Component
public class ZuulLoggingFilterProxy extends ZuulFilter{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request =RequestContext.getCurrentContext().getRequest();
		logger.info("request url is:"+request.getRequestURI());
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 * to specifuy whteher we need this filter or not
	 */
	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 * here we can set filter priority from 1 to 10
	 */
	@Override
	public int filterOrder() {
		
		return 1;
	}

	/*
	 * (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 * here we can specify filter type i.e. when to call the filter i.e before callng micro after
	 *  calling micro or only in error case
	 *  
	 */
	@Override
	public String filterType() {
		
		return "pre";
	}

}
