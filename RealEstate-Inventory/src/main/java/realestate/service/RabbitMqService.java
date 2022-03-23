package realestate.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import realestate.dto.Inventory;

@Service
@Slf4j
public class RabbitMqService {

	@Autowired
	private InventoryService inventoryService;
	
	
	@RabbitListener(queues = "${realestate.rabbitmq.queue}")
	public void receiveMessage(Inventory message) throws AddressException, MessagingException {
		log.info(message.toString());
		inventoryService.send(message.getMessage());
	}
}
