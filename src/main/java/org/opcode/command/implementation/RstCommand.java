package org.opcode.command.implementation;

import org.opcode.command.Command;
import org.opcode.model.RegisterState;

public class RstCommand implements Command {
    @Override
    public RegisterState execute(RegisterState registerState, String instruction) {
        registerState.reset();
        return registerState;
    }

    @Override
    public boolean validate(String instruction) {
        return instruction.split(" ").length==1;
        }
}
