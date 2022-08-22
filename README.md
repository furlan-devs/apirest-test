#APIRest Spring + JPA e PostgreSQL

##Requisitos para rodar a aplicação:

Clonar o repositorio ou baixar os arquivos.
-https://github.com/furlan-devs/apirest-test.git

Aguardar a IDE baixar as dependencias:
	-Spring Web
	-Lombok
	-PostgreSQL Driver
	-Spring Data jpa
	-modelMapper

Criar um banco no PostgreSQL com o nome 'senior-apirest' ou alterar o nome no arquivo 
'application.properties' na linha abaixo:
-spring.datasource.url= jdbc:postgresql://localhost:5432/{nome do BD Aqui}
	
Feito isso, só acessar o Arquivo "ApirestApplication" e rodar a aplicação em 
"public class ApirestApplication"

A Aplicação conssite em:
	-Cadastro de Itens - Concluído
	-Cadastro de Ordens - 80%
	-Implementar Itens do pedido - Em construção
	-Fechar o carrinho - Em construção
	
## Endpoints
	No email também disponibilizarei a biblioteca do Postman.
	
	Cadastro de Itens:
	POST [url base]/api/items
	
		Entrada:
			{
				"description":"celular",
				"value" :"800.00",
				"type": "p"
			}
		Retorno:
			{
				"id": "7b70591b-5f15-4d76-bff6-a1bb91ca9cd4",
				"description": "celular",
				"value": 800.0,
				"type": "p"
			}
			
	GET  [url base]/api/items
		Retorno:
		[
			{
				"id": "7b70591b-5f15-4d76-bff6-a1bb91ca9cd4",
				"description": "celular",
				"value": 800.0,
				"type": "p"
			}
		]
	
	GET  [url base]/api/items/{id}
		localhost:8080/api/items/b7c1b7e0-2c6b-4d15-be10-ab7e4bee2404
		
		Retorno: 
		{
			"id": "7b70591b-5f15-4d76-bff6-a1bb91ca9cd4",
			"description": "celular",
			"value": 800.0,
			"type": "p"
		}
		

	PUT  [url base]/api/items/{id}
		localhost:8080/api/items/7b70591b-5f15-4d76-bff6-a1bb91ca9cd4
		
		Entrada:
		{
			"description": "b",
			"value": 1800,
			"type": "p"
		}

		Retorno:
		{
			"id": "7b70591b-5f15-4d76-bff6-a1bb91ca9cd4",
			"description": "b",
			"value": 1800.0,
			"type": "p"
		}
	
	
	DEL [ url base]/api/items/{id}
		localhost:8080/api/items/3f422148-6369-4898-ba32-f65cfcdae35
		Sem retorno.


Cadastro de Ordens:
POST [url base]/api/orders
	
		Entrada:
			{
				"number":10,
				"percentualDiscount": "10",
				"totalValue": "450.60"
			}
		Retorno:
			{
    "id": "706615fe-5f07-4975-80dc-475e994b435a",
    "number": 10,
    "date": "2022-08-22T15:29:40.487+00:00",
    "percentualDiscount": 10.0,
    "totalValue": 450.6
}
			
	GET  [url base]/api/orders
		Retorno:
		[
    {
        "id": "706615fe-5f07-4975-80dc-475e994b435a",
        "number": 10,
        "date": "2022-08-22T15:29:40.487+00:00",
        "percentualDiscount": 10.0,
        "totalValue": 450.6
    }
]
	
	GET  [url base]/api/orders/{id}
		localhost:8080/api/items/706615fe-5f07-4975-80dc-475e994b435a
		
		Retorno: 
		{
    "id": "706615fe-5f07-4975-80dc-475e994b435a",
    "number": 10,
    "date": "2022-08-22T15:29:40.487+00:00",
    "percentualDiscount": 10.0,
    "totalValue": 450.6
}
		

	PUT  [url base]/api/orders/{id}
		localhost:8080/api/items/7b70591b-5f15-4d76-bff6-a1bb91ca9cd4
		
		Entrada:
		{
			{
    "number":"2",
    "date" :"2022-08-21T19:40:34.717+00:00",
    "percentualDiscount": "20",
    "totalValue": "450.60"
}
		}

		Retorno:
{
    "id": "706615fe-5f07-4975-80dc-475e994b435a",
    "number": 2,
    "date": "2022-08-21T19:40:34.717+00:00",
    "percentualDiscount": 20.0,
    "totalValue": 450.6
}
	
	
	DEL [ url base]/api/orders/{id}
		localhost:8080/api/orders/706615fe-5f07-4975-80dc-475e994b435a
		Sem retorno.
