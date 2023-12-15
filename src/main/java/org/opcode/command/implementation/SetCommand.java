package org.opcode.command.implementation;

import org.opcode.command.Command;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class SetCommand implements Command {
    @Override
    public RegisterState execute(RegisterState registerState, String instruction) {

        String[] inst = instruction.split(" ");
        Register register = registerState.getRegister(inst[1].toCharArray()[0]);
        int value = Integer.parseInt(inst[2]);
        register.setValue(value);
        registerState.updateValue(register);
        return registerState;

    }

    @Override
    public boolean validate(String instruction) {
        return true;
    }
}
