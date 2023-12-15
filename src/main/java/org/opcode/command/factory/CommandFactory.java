package org.opcode.command.factory;

import org.opcode.command.*;
import org.opcode.command.implementation.*;
import org.opcode.enums.CommandType;
import org.opcode.exception.InvalidCommandException;

public class CommandFactory {

    public Command getCommand(String commandType){
        CommandType type = CommandType.valueOf(commandType);

        switch (type) {
            case SET:
                return new SetCommand();
            case RST:
                return new RstCommand();
            case ADD:
                return new AddCommand();
            case ADR:
                return new AdrCommand();
            case MOV:
                return new MovCommand();
            case INR:
                return new InrCommand();
            case DCR:
                return new DcrCommand();
            default:
                throw new InvalidCommandException("Invalid Command");
            }
    }
}
