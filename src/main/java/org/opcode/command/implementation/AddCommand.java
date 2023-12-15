package org.opcode.command.implementation;

import org.opcode.command.Command;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class AddCommand implements Command {
    @Override
    public RegisterState execute(RegisterState registerState, String instruction) {
        String[] inst = instruction.split(" ");
        int value = Integer.parseInt(inst[2]);
        Register r = registerState.getRegister(inst[1].toCharArray()[0]);
        r.setValue(r.getValue() + value);
        registerState.updateValue(r);
        return registerState;
    }

    @Override
    public boolean validate(String instruction) {
        return instruction.split(" ").length==3;
    }
}
