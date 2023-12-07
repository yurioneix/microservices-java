# 👥 Microsserviço de cadastro de usuários 

Projeto de estudo de microsserviços em Java, baseado no vídeo da Michelli Brito [Microsserviços na prática com Java Spring](https://www.youtube.com/watch?v=ZnECi2gatMs&t=4335s).

Esse microsserviço realiza o cadastro de usuários e utiliza RabbitMQ para publicar mensagens no Broker a fim de um outro [Microsserviço de Email](https://github.com/yurioneix/microservices-java-email), consumí-las conforme elas entram na fila. 

## Instalação e configuração
- Baixe o repositório na sua máquina:
```bash
  git clone git@github.com:yurioneix/microservices-java-user.git
```

- Abra sua IDE no repositório baixado

- Insira as variáveis de ambiente no application.properties.
  - Insira os dados de login do Postgre.
  - Será necessário abrir uma conta gratuita na [ClouAMQP](https://www.cloudamqp.com/) para obter o RABBIT_MQ_ADDRESS.
    - Crie uma instância no plano gratuito.
    - Após criada, entre na instância e copie a URL presente em AMQP Details.
- Inicie a aplicação e comece a cadastrar usuários.


## Endpoints

- **`POST /users`**
  - Corpo da requisição:
      ```json
    {
      "name": "German Cano",
      "email": "fazol@gmail.com"
    }
      ```
  - Resposta da requisição:
    ```json
    {
    	"userID": "a62674aa-3d14-4a72-a992-955aa8e26506",
    	"name": "German Cano",
    	"email": "fazol@gmail.com"
    }
    ```
