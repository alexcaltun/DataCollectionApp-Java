// backend/src/main/java/com/example/servlet/UserServlet.java
package com.ssn.practica.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ssn.practica.dao.OrderDAO;
import com.ssn.practica.model.Order;
import com.ssn.practica.model.OrderState;

@Path("/orders")
public class OrderServlet {
	private OrderDAO orderDAO = new OrderDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Order> getUsers() {
		return orderDAO.getOrders();
	}

	@GET
	@Path("/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrdersByState(@PathParam("state") String state) {
		List<Order> orders = orderDAO.getOrdersByState(OrderState.valueOf(state));
		return Response.ok(orders).build();
	}

	@GET
	@Path("/id/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderByOrderId(@PathParam("id") String orderId) {
		Order user = orderDAO.getOrderByOrderId(orderId);
		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Path("/{id}/finish")
	public Response finishOrder(@PathParam("id") int id) {
		orderDAO.finishOrder(id);
		return Response.status(Response.Status.OK).build();
	}

	@POST
	@Path("/{id}/cancel")
	public Response cancelOrder(@PathParam("id") int id) {
		orderDAO.cancelOrder(id);
		return Response.status(Response.Status.OK).build();
	}
}
