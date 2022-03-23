package realestate.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import realestate.config.RabbitMqConfig;
import realestate.service.concretes.InventoryService;

@Service
public class RabbitMqService implements QueueService{


	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Autowired
	private RabbitMqConfig config;
	
	@Override
	public void sendMessage(InventoryService message) {
		rabbitTemplate.convertAndSend(config.getExchange(),config.getRoutingkey(),message);
		
	}
}
