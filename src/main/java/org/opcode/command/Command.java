package org.opcode.command;

import org.opcode.model.RegisterState;

public interface Command {
    public RegisterState execute(RegisterState registerState, String inst);
    public boolean validate(String instruction);
}
