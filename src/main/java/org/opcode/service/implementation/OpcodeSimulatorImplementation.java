package org.opcode.service.implementation;

import org.opcode.command.Command;
import org.opcode.command.factory.CommandFactory;
import org.opcode.exception.InvalidInstructionException;
import org.opcode.model.RegisterState;
import org.opcode.service.OpcodeSimulator;

import java.util.List;

public class OpcodeSimulatorImplementation implements OpcodeSimulator {

    private RegisterState registerState;

    public OpcodeSimulatorImplementation(RegisterState registerState) {
        this.registerState = registerState;
    }
    @Override
    public RegisterState execute(List<String> instructions) {

        for(String instruction : instructions) {
            Command command = new CommandFactory().getCommand(instruction.split(" ")[0]);
            if(!(command.validate(instruction))) throw  new InvalidInstructionException("Invalid Instruction");
            this.registerState = command.execute(registerState, instruction);
        }
        return this.registerState;
    }
}
