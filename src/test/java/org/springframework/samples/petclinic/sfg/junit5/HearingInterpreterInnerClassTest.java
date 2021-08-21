package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.samples.petclinic.sfg.WordProducer;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {HearingInterpreterInnerClassTest.TestConfig.class})
public class HearingInterpreterInnerClassTest {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard(){
        String word = hearingInterpreter.whatIheard();
        assertEquals("Laurel", word);
    }

    @Configuration
    static class TestConfig{
        @Bean
        public HearingInterpreter hearingInterpreter(WordProducer wordProducer){
            return new HearingInterpreter(wordProducer);
        }

        @Bean
        public WordProducer yannyWordProducer() {
            return new LaurelWordProducer();
        }
    }
}
