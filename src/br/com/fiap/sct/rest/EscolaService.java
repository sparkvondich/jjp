package br.com.fiap.sct.rest;
 
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.com.fiap.sct.entity.Escola;
 
@Path("/escola")
public class EscolaService {
 
	@GET
	@Path("/getEscolas")
	public Response getEscolas(@PathParam("param") String msg) {
		
		Escola escola = new Escola();
		List <Escola> escolaList = new ArrayList <Escola>();
		
		
		escola.setEndereco("rua x");
		escola.setId(1);
		escola.setNome("ecola estadual y");
		
		escolaList.addAll(escolaList);
		
		//List<Escola> yourList = new Gson().fromJson(yourJson, listType);
		
		//pegar dado da base
		
		//retornar o objeto do banco
		return Response.status(200).entity(escola.toString()).build();
 
	}
	
	@GET
	@Path("/setEscolas")
	public Response setEscolas(@PathParam("param") String msg) {
		String output = "Jersey say : " + "teste";
		
		return Response.status(200).entity(output).build();
 
	}
	
}