package com.supermark.service;

import java.util.ArrayList;

import com.supermark.models.Comprobante;
import com.supermark.models.Detalle;
import com.supermark.models.TarjetaCredito;
import com.supermark.models.Usuario;

public class Test {

	public static void main(String[] args) {
//		CRUDCarrito ccarr = new CRUDCarrito();
//		ArrayList<Detalle> detalles = ccarr.getListado(new Usuario(1));
//		
//		for(Detalle detalle:detalles) {
//			System.out.println(detalle);
//		}
		CRUDComprobante cc = new CRUDComprobante();
		cc.registrarCompra(new Comprobante(
					"C",
					new Usuario(1),
					new TarjetaCredito(123456)
				));
	}

}
