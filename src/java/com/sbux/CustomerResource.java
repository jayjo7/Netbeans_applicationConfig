/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sbux;

import entity.Customer;
import entity.CustomerTable;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * REST Web Service
 *
 * @author jmounagu
 */
@Path("customer")
public class CustomerResource {

    @GET
    public List<Customer> getCustomer() {
        //Comment
        return CustomerTable.getAll();
    }

    @POST
    public boolean update(@FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("creditLimit") Integer creditLimit,
            @FormParam("id") String id) {
        System.out.println("in the method update");
        boolean result = false;
        Customer customer = CustomerTable.findByPrimaryKey(id);
        if (customer != null) {

            customer.setCreditLimit(creditLimit);
            customer.setName(name);
            customer.setAddress(address);
            result = true;
        }
        else
        {
            throw new WebApplicationException(
            
                        Response.ok()
                         .status(Response.Status.NOT_FOUND).entity("Could not find the given is " + id).build()
                       
            );
        }
        return result;
    }

    @DELETE
    @Path("/{id}")
    public boolean remove(@PathParam("id") String id) {
                System.out.println("in the method remove");

        return CustomerTable.removeByPrimaryKey(id);
    }

}
