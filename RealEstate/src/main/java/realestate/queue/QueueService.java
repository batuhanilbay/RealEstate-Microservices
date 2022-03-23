package realestate.queue;

import realestate.service.concretes.InventoryService;

public interface QueueService {
	
	void sendMessage(InventoryService message);

}
