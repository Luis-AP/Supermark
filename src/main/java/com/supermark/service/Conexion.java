package com.supermark.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private String DB_URL = "jdbc:mysql://localhost:3306/";
	//Credenciales de la BDD
	private static final String USER = "root";
	private static final String PASS = "juramentada";
	
	private Connection conn = null;
	private Statement stmt = null;//Objeto para realizar las declaraciones SQL que requiramos
	private ResultSet rs = null;//Conjunto de resultados
	
	public Conexion(String db) {
		this.DB_URL += "Supermark";
	}
	
	public void connect() {
		try {
			Class.forName(JDBC_DRIVER);//Instanciar el driver
			
			System.out.println("Conectando a la base datos...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);//Me conecto a la base datos
			
			System.out.println("Creando sentencias SQL...");
			stmt = conn.createStatement();//Especificamos que crearemos una sentencia SQL sobre la conexion previamente creada
			//String sql = "SELECT persona.id,persona.nombre,persona.apellido1,persona.fecha_nacimiento,persona.sexo FROM universidad.persona";
			//rs = stmt.executeQuery(sql);//Ejecuto la consulta SELECT
			//String sql2 = "INSERT INTO universidad.departamento (departamento.nombre) VALUE ('Ingles')";
			//stmt.executeUpdate(sql2);
			
//			while (rs.next()) {//Mientras exista un fila siguiente/Elementos en el conjunto
//				int id = rs.getInt("id");
//				String nombre = rs.getString("nombre");
//				String apellido1 = rs.getString("apellido1");
//				Date fnac = rs.getDate("fecha_nacimiento");
//				String sexo = rs.getString("sexo");
//				
//				System.out.println("id: "+id);
//				System.out.println("nombre: "+nombre);
//				System.out.println("apellido1: "+apellido1);
//				System.out.println("fecha_nacimiento: "+fnac);
//				System.out.println("sexo: "+sexo);
//			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
}
