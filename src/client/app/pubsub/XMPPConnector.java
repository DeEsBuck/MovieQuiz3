package client.app.pubsub;

import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.pubsub.*;
import org.jivesoftware.smackx.pubsub.listener.ItemEventListener;
import org.jivesoftware.smackx.pubsub.listener.NodeConfigListener;


public class XMPPConnector {
	
	public static void userVerbinden(String usr, String pwd, Connection con) throws XMPPException{
		con.connect();
		con.login(usr, pwd);
		
		if (con.isConnected()){
			System.out.println("Erfolgreich");
			System.out.println("Conn-ID: "+con.getConnectionID());
			System.out.println("Host: "+con.getHost());
			System.out.println("Port: "+con.getPort());
			System.out.println("User: "+con.getUser());
		}
		
	}
	
	public static void makePubSub (Connection con)  throws XMPPException{
	      PubSubManager mgr = new PubSubManager(con);

	      ConfigureForm form = new ConfigureForm(FormType.submit);
	      form.setAccessModel(AccessModel.open);
	      form.setDeliverPayloads(false);
	      form.setNotifyRetract(true);
	      form.setPersistentItems(true);
	      form.setPublishModel(PublishModel.open);
	      LeafNode node = (LeafNode) mgr.createNode("testNode", form);
	     
	      PayloadItem payload= new PayloadItem("test" + System.currentTimeMillis(), new SimplePayload("quizgame", "moviequiz:zapto:org", ""));
	      node.send(payload);
	}
	
	public static void subscribeToNode(Connection con, LeafNode mgr)  throws XMPPException{
		
	}
	
	class ItemEventCoordinator  implements ItemEventListener
    {
        @Override
        public void handlePublishedItems(ItemPublishEvent items)
        {
            System.out.println("Item count: " + items.getItems().size());
            System.out.println(items);
		}
	}
	
	public static void main(String[] args) throws XMPPException {
		Connection con = new XMPPConnection("moviequiz.zapto.org");
		userVerbinden("Julia", "julia", con);
		PubSubManager mgr = new PubSubManager(con);

	      ConfigureForm form = new ConfigureForm(FormType.submit);
	      form.setAccessModel(AccessModel.open);
	      form.setDeliverPayloads(false);
	      form.setNotifyRetract(true);
	      form.setPersistentItems(true);
	      form.setPublishModel(PublishModel.open);
	      LeafNode node = (LeafNode) mgr.createNode("testNode", form);
	     
	      PayloadItem payload= new PayloadItem("test" + System.currentTimeMillis(), new SimplePayload("quizgame", "moviequiz:zapto:org", ""));
	      node.send(payload);
		
	   // Create a pubsub manager using an existing Connection

	      // Get the node
	      mgr.getNode("testNode");
	      
	      node.addItemEventListener(new ItemEventCoordinator<Item>());
	      node.subscribe(con.getUser());
	      
	      
		con.disconnect();
	}
	
}
