package br.al.infnet.model;

import lombok.Data;

@Data
public class Advice {
    private Slip slip;

    public void getbyID(){
        String id = slip.getId();
        String advice = slip.getAdvice();
        System.out.println("Id: " + id);
        System.out.println("Advice: " + advice);

    }
}
