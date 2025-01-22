package com.example.api;

import java.io.IOException;


import com.example.api.servico.ApiServico;

public class ApiApplication {

	public static void main(String[] args)  throws IOException, InterruptedException{
		ApiServico apiServico = new ApiServico();
		try {
			System.out.println(apiServico.getEndereco("75701100"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

	}

}
