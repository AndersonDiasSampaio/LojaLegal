# LojaLegal

Projeto proposto no bootcamp da Educ360 feito em parceria com a Foursys Tecnologia

-----------------------------------------------------------------------------------------------------------------------------------------------------
Uma nova loja, que já possui todo o sistema de PDV e Fiscal, precisa de um sistema auxiliar para controlar seus produtos, estoque, vendas e pagamentos.
	Por definição, o sistema deverá ser capaz de cadastrar novos produtos, classificando por tipo, tamanho, cor, categoria e departamento.
	Ao validar uma venda, este deverá verificar disponibilidade de estoque, se disponível a quantidade informada na venda, 
	deverá abater da quantidade em estoque, somando seu valor unitário e total à venda. 
	Ao finalizar a venda deverão ser coletados CPF do comprador, se assim ele desejar e método de pagamento.
	Ao finalizar a venda, deverá ser computada no caixa o valor da compra, bem como os itens comprados e dados de pagamento. 
	A princípio, a loja aceitará métodos de pagamento crédito, débito, dinheiro e PIX. 
	Em caso de débito e crédito, informar os dados do cartão à venda, em caso de PIX, por questão de controle, armazenar a chave PIX que quem efetuou pagamento.
	
	Observar estrutura de responsabilidade de package, entidade, clean code e padrões Java de convencionamento.
	Por padrão os projetos, packages, classes, objetos, atributos e métodos, seguirão o padrão inglês, que é a convenção internacional para desenvolvimento.
	O desacoplamento de código deverá seguir os padrões estabelecidos de acordo com sua responsabilidade e função.

**************************************************************************************************************************************************************
Acima temos a lógica inicial do projeto, o mesmo projeto foi modificado para o padrão rest, onde todos seu acesso é feito atualmente.

SKU:
O SKU é composto por 12 letra sendo, sendo cada 3 representando uma catactéristica do produto.
As 3  primeiras são a categória:
SIMPLES("SIM"),
BORDADA("BOR"),
CAMISA("POL"),
SOCIAL("SOC");
As 3 seguintes são a cor: 
AZUL("azu"),
VERDE("ver"),
AMARELO("ama"),
PRETO("pre");
As 3 seguintes são o departamento:
MASCULINO("MAS"),
FEMININO("FEM"),
INFANTIL("INF");
As 3 últimas o tamanho:
PEQUENO("PEQ"),
MEDIO("MED"),
GRANDE("GRA");

Exemplo:SIMazuMASPEQ
**************************************************************************************************************************************************************
Explicações:
O pacote Data foi mantido mesmo com o uso de JPA, pois caso exista alguma alteração futura no código, 
haverá apenas um local que deverá ser modificado desde que mantedo-se as assinaturas e retornos dos métodos.

