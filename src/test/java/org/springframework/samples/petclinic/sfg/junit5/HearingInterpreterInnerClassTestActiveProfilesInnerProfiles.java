package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.samples.petclinic.sfg.WordProducer;
import org.springframework.samples.petclinic.sfg.YannyWordProducer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {HearingInterpreterInnerClassTestActiveProfilesInnerProfiles.TestConfig.class})
@ActiveProfiles("inner-class")
public class HearingInterpreterInnerClassTestActiveProfilesInnerProfiles {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard(){
        String word = hearingInterpreter.whatIheard();
        assertEquals("Yanny", word);
    }

    @Configuration
    @Profile("inner-class")
    static class TestConfig{
        @Bean
        public HearingInterpreter hearingInterpreter(WordProducer wordProducer){
            return new HearingInterpreter(wordProducer);
        }

        @Bean
        public WordProducer yannyWordProducer() {
            return new YannyWordProducer();
        }
    }
}
