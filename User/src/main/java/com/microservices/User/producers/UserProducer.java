package com.microservices.User.producers;

import com.microservices.User.dtos.EmailDto;
import com.microservices.User.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
  final RabbitTemplate rabbitTemplate;

  public UserProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Value(value = "${broker.queue.email.name}")
  private String routingKey;

  public void publishEmailMessage(UserModel userModel) {
    EmailDto newEmail = new EmailDto();
    newEmail.setUserId(userModel.getUserID());
    newEmail.setEmailTo(userModel.getEmail());
    newEmail.setSubject("Cadastro realizado com sucesso!");
    newEmail.setText(userModel.getName() + " seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

    rabbitTemplate.convertAndSend("", routingKey, newEmail);
  }
}
