package br.artemisconsumer.consumer;

import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArtemisConsumer {

    @JmsListener(destination = "address.foo::q1")
    public void consume(final String message) throws Exception {
        log.info(String.format("Recebido q1 -> %s", message));
        try {
//            Thread.sleep(1000);
            Thread.sleep(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(ArtemisConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
        final String lastCharacter = message.substring(message.length() - 1);
        if (lastCharacter.equals("1")) {
            throw new Exception("Ocorreu alguma falha");
        }
        log.info(String.format("Concluido"));
    }

    @JmsListener(destination = "address.bar::q2")
    public void consumeQ2(final String message) throws Exception {
        log.info(String.format("Recebido q2 -> %s", message));
//        final String lastCharacter = message.substring(message.length() - 1);
//        if (lastCharacter.equals("1")) {
//            throw new Exception("Ocorreu alguma falha");
//        }
    }

    @JmsListener(destination = "address.bar::q3")
    public void consumeQ3(final String message) throws Exception {
        log.info(String.format("Recebido q3 -> %s", message));
//        final String lastCharacter = message.substring(message.length() - 1);
//        if (lastCharacter.equals("1")) {
//            throw new Exception("Ocorreu alguma falha");
//        }
    }

}
