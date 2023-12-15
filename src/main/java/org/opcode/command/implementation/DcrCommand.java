package org.opcode.command.implementation;

import org.opcode.command.Command;
import org.opcode.model.Register;
import org.opcode.model.RegisterState;

public class DcrCommand implements Command {
    @Override
    public RegisterState execute(RegisterState registerState, String instruction) {
        String instr[]=instruction.split(" ");
        Register register = registerState.getRegister(instr[1].toCharArray()[0]);
        register.setValue(register.getValue() - 1);
        registerState.updateValue(register);
        return registerState;
    }

    @Override
    public boolean validate(String instruction) {
        return instruction.split(" ").length==2;
    }
}
