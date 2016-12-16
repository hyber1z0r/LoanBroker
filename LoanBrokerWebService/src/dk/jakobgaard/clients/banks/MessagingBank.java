package dk.jakobgaard.clients.banks;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class MessagingBank extends Bank {
    private String exchangeName;
    private static final String HOST = "datdb.cphbusiness.dk";
    private final String REPLY_QUEUE = new Random().nextInt(1000000) + "_REPLY_QUEUE";
    private Connection connection;
    private Channel chan;

    public MessagingBank(String dataType, String exchangeName, String exchangeType) {
        super(dataType);
        this.exchangeName = exchangeName;
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        try {
            this.connection = factory.newConnection(); // Connect to rabbitMQ
            this.chan = connection.createChannel(); // Create a channel that all communication will go through
            this.chan.exchangeDeclare(this.exchangeName, exchangeType); // Connect to the exchange
            String queueName = this.chan.queueDeclare().getQueue(); // Create autogenerated queue name
            this.chan.queueBind(queueName, this.exchangeName, ""); // Bind the queue to the exchange
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * @param loanRequest XML or JSON representation of a loanrequest
     * @return XML or JSON
     */
    @Override
    public String contact(String loanRequest) {
        System.out.println("Sending message: " + loanRequest);
        QueueingConsumer consumer = new QueueingConsumer(chan);
        QueueingConsumer.Delivery delivery;
        try {
            this.chan.basicPublish(this.exchangeName, "", buildHeaders(REPLY_QUEUE), loanRequest.getBytes()); // Publish the message on the exchange
            delivery = consumer.nextDelivery(TIMEOUT);
            this.chan.close();
            this.connection.close();
        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
            return null;
        }
        if (delivery == null) {
            return null;
        }
        System.out.println("Got this response: " + new String(delivery.getBody()));
        return new String(delivery.getBody());
    }

    private AMQP.BasicProperties buildHeaders(String replyQueue) {
        return new AMQP.BasicProperties().builder()
                .replyTo(replyQueue)
                .build();
    }
}