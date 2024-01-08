import * as readlineSync from 'readline-sync';
import chalk from 'chalk';
import { Commands } from "./commands";
import { CommandManager } from "./commandManager";

class App {
    commands: Commands;
    commandsFunc: CommandManager;

    constructor() {
        this.commands = new Commands();
        this.commandsFunc = new CommandManager();
    }

    async run() {
        const commandsCount = this.commands.names.length;

        while (true) {
            await this.delay(1000);
            console.log(chalk.bold.green("\nThe avaliable commands are:"));
            this.commands.printCommandsChoices();
            const commandIndex = readlineSync.question(chalk.bold.cyan('\nEnter the number of the command: '));
            const parsedIndex = parseInt(commandIndex, 10);

            if (parsedIndex === commandsCount) {
                console.log(chalk.bold.green('\nExiting the program.'));
                break;
            } else if (this.isValidCommand(parsedIndex, commandsCount)) {
                this.executeCommand(parsedIndex);
            } else {
                console.log(chalk.bold.red('Invalid command. Please enter a valid number.\n'));
            }
        }
    }

    
    isValidCommand(commandIndex: number, commandsCount: number) {
        return !isNaN(commandIndex) && commandIndex > 0 && commandIndex <= commandsCount;
    }

    executeCommand(commandIndex: number) {
        switch (commandIndex) {
            case 1:
                this.commandsFunc.checkPalindrome();
                break;
            case 2:
                this.commandsFunc.checkLowercase();
                break;
            case 3:
                this.commandsFunc.checkDigits();
                break;
            case 4:
                this.commandsFunc.checkArmstrong();
                break;
            case 5:
                this.commandsFunc.checkNationality();
                break;
            default:
                console.log(chalk.bold.red('Invalid command. Please enter a valid number.'));
        }
    }

    delay(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }
}

const app = new App();
app.run();
