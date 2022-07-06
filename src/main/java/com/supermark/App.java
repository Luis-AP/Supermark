package com.supermark;

import static spark.Spark.*;

import java.sql.Timestamp;
import com.supermark.models.*;
import com.supermark.service.CRUDCarrito;
import com.supermark.service.CRUDComprobante;
import com.supermark.service.CRUDUsuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {

	public static void main(String[] args) {
		port(8080);
		get("/user",(request,response)->{
			response.type("application/json");
			//response.header("Access-Control-Allow-Origin", "*");
			//Gson mapper = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
			Gson mapper = new Gson();
			Usuario user = mapper.fromJson(request.body(),Usuario.class);
			
			CRUDUsuario cu = new CRUDUsuario();
			boolean resultado = cu.estaRegistrado(user);
			
			if(resultado==true) {
		    	return mapper
		    			.toJson(new StandardResponse(
		    					StatusResponse.SUCCESS,
		    					"Usuario ya se encuentra registrado")
		    					);
		    }else {
		    	return mapper
		    			.toJson(new StandardResponse(
		    					StatusResponse.SUCCESS,
		    					"El usuario no figura en el sistema")
		    					);
		    }
		});
		
		post("/registrar",(request,response)->{
			response.type("application/json");
			//response.header("Access-Control-Allow-Origin", "*");
			//Gson mapper = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
			Gson mapper = new Gson();
			Usuario user = mapper.fromJson(request.body(),Usuario.class);
			System.out.println(user);
			
			if(user.getContrasenia().length()<8) {
				return mapper
						.toJson(new StandardResponse(StatusResponse.ERROR,"Contrasenia insegura"));
			}else {
				//Ejecutar un servicio
				CRUDUsuario cu = new CRUDUsuario();
				boolean resultado = cu.registrar(user);
				System.out.println(user);

			    if(resultado==true) {
			    	return mapper
			    			.toJson(new StandardResponse(
			    					StatusResponse.SUCCESS,
			    					"Usuario Registrado")
			    					);
			    }else {
			    	return mapper
			    			.toJson(new StandardResponse(
			    					StatusResponse.ERROR,
			    					"Ocurrio un error inesperado")
			    					);
			    }
			}
		});
		
		post("/seleccionar",(request,response)->{
			response.type("application/json");
			response.header("Access-Control-Allow-Origin", "*");
			Gson mapper = new Gson();
			Carrito addition = mapper.fromJson(request.body(), Carrito.class);
			
			CRUDCarrito ccarr = new CRUDCarrito();
			
			if(ccarr.agregar(addition)) {
				return mapper
						.toJson(new StandardResponse(
									StatusResponse.SUCCESS,
									"Producto agregado al carrito"
								));
			}else {
				return mapper
						.toJson(new StandardResponse(
									StatusResponse.ERROR,
									"Hubo un inconveniente agregado el producto"
								));
			}
		});
		
		post("/logear",(request,response)->{
			response.type("application/json");
			response.header("Access-Control-Allow-Origin", "*");
			Gson mapper = new Gson();
			Usuario user = mapper.fromJson(request.body(),Usuario.class);
			
			//Ejecutar un servicio
			CRUDUsuario cu = new CRUDUsuario();
			boolean resultado = cu.iniciarSesion(user);
			
			if(resultado==true) {
				return mapper
						.toJson(new StandardResponse(StatusResponse.SUCCESS,"Logeado con exito"));
			}else {
				return mapper
						.toJson(new StandardResponse(StatusResponse.ERROR,"Contraseña incorrecta"));
			}
		});
		
		post("/comprar",(request,response)->{
			response.type("application/json");
			response.header("Access-Control-Allow-Origin", "*");
			Gson mapper = new Gson();
			System.out.println("Here1");
			//Gson mapper = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
			Comprobante comp = mapper.fromJson(request.body(),Comprobante.class);
			comp.setFecha(new Timestamp(System.currentTimeMillis()));
			
			CRUDComprobante cc = new CRUDComprobante();
			cc.registrarCompra(comp);
			
			
			return mapper
					.toJson(new StandardResponse(StatusResponse.SUCCESS,"Compra Registrada"));
		});

	}

}
