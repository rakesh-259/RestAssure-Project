package com.restAPI.filters;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    private static final Logger logger= LogManager.getLogger(LoggingFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification,
                           FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext)
    {
        logRequestDetails(filterableRequestSpecification);
        Response response=filterContext.next(filterableRequestSpecification,filterableResponseSpecification);
        logResponseDetails(response);
        return response;
    }
    public void logRequestDetails(FilterableRequestSpecification requestSpec)
    {
        logger.info("Request Method: "+ requestSpec.getMethod());
        logger.info("Request URI: "+ requestSpec.getURI());
        logger.info("Request Headers: "+requestSpec.getHeaders());
    }
    public  void  logResponseDetails(Response response)
    {
        logger.info("Response Status Code: "+ response.getStatusCode());
        logger.info("Response  Body: "+ response.getBody().asPrettyString());
    }
}
