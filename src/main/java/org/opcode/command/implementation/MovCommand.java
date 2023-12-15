package org.opcode.command.implementation;

import org.opcode.command.Command;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class MovCommand implements Command {
    @Override
    public RegisterState execute(RegisterState registerState, String instruction) {
        String[] inst = instruction.split(" ");
        Register register1 = registerState.getRegister(inst[1].toCharArray()[0]);
        Register register2 = registerState.getRegister(inst[2].toCharArray()[0]);
        register1.setValue(register2.getValue());
        registerState.updateValue(register1);
        return registerState;
    }

    @Override
    public boolean validate(String instruction) {
        return instruction.split(" ").length==3;
    }
}
