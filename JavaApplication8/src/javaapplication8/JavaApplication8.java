/*/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 *//*
package javaapplication8;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JavaApplication8 {
    
    public static void main(String[] args) {
        try {
            Connection connection = null;
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
                    ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("amqmsg");
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            TextMessage message = session.createTextMessage("THIS IS THE TEST MESSAGE 2!");
            
            Destination tempDest = session.createTemporaryQueue();
            MessageConsumer consumer = session.createConsumer(destination);
            message.setJMSReplyTo(tempDest);
            
            producer.send(message);
            
            Message msg = consumer.receive();
            
            if (msg instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Read Message: " + txtMsg.getText());
                session.createProducer(tempDest).send(message);
            }
            
            consumer = session.createConsumer(tempDest);
            
            msg = consumer.receive();
            
            if (msg instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) msg;
                System.out.println("Read Message from temporary: " + txtMsg.getText());
            }
            
            connection.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }*/

 /*    @Override
    public void onMessage(Message message) {
    try {
    TextMessage textMessage = (TextMessage) message;
    String text = textMessage.getText();
    System.out.println(text);
    } catch (JMSException jmse) {
    jmse.printStackTrace();
    }
    }
}*/
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JavaApplication8 {

    public static void main(String[] args) {

        List<Integer> predmetList = new ArrayList<>();
        List<Integer> predmetList2 = new ArrayList<>();
        //List<Rating> ratingList = new ArrayList<>();

        predmetList.add(2);
        predmetList.add(2);
        predmetList.add(2);
        predmetList.add(5);
        predmetList.add(5);
        predmetList.add(1);

        predmetList2.add(1);
        predmetList2.add(2);
        predmetList2.add(3);
        
        predmetList2.retainAll(predmetList);
       
        for (Integer smth : predmetList2) {
            System.out.println("javaapplication8.JavaApplication8.main()" + smth);            
        }
        //int k = 1000;

        /*for (Predmet predmet : predmetList) {
        Rating rating = new Rating(predmet, k);
        ratingList.add(rating);
        k++;
        }
        
        Collections.sort(ratingList, (o1, o2)
        -> o2.getRating() - o1.getRating());
        
        for (Rating rating : ratingList) {
        System.out.println("predmet" + rating.getPredmet().getName());
        System.out.println("rating" + rating.getRating());
        System.out.println("----------------------------------------");
        }*/
    }
}
